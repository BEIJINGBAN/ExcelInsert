package Util;

import Config.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class NoticeUtil {

    private static final Logger log = LogManager.getLogger(NoticeUtil.class);

    private static final OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();

    private static final com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper();

    //配置
    private static final String PRIVATE_KEY = Constants.PRIVATE_KEY;                                   //私钥
    private static final String SALT_KEY = "test_api_secret_123456";          //盐值
    private static final String SIGN_ALGORITHM = "SHA256withRSA";             //签名算法
    private static final String CHARSET = "UTF-8";                            //字符集

    //Json格式
    public static class RequestBodyJson {
        public String interfaceVersion;
        public String transSeqNo;
        public String type;
        public String filePath;
        public String fileName;
    }

    public static boolean noticeAudit(String BASE_URL, String API_PATH,
                                      String interfaceVersion, String transSeqNo,
                                      String type, String filePath, String fileName) {


        boolean result = false;
        RequestBodyJson requestBodyJson = new RequestBodyJson();
        requestBodyJson.interfaceVersion = interfaceVersion;
        requestBodyJson.transSeqNo = transSeqNo;
        requestBodyJson.type = type;
        requestBodyJson.filePath = filePath;
        requestBodyJson.fileName = fileName;

        //
        try {
            TreeMap<String, Object> paramMap = new TreeMap<>();
            paramMap.put("interfaceVersion", requestBodyJson.interfaceVersion);
            paramMap.put("transSeqNo", requestBodyJson.transSeqNo);
            paramMap.put("type", requestBodyJson.type);
            paramMap.put("filePath", requestBodyJson.filePath);
            paramMap.put("fileName", requestBodyJson.fileName);

            String signContent = SignUtil.genSignContentWithSalt(paramMap, SALT_KEY);
            log.info("待签名字符串： " + signContent);
            //            System.out.println("待签名字符串： " + signContent);

            String sign = SignUtil.rsaSign(signContent, PRIVATE_KEY, SIGN_ALGORITHM, CHARSET);
            if (sign == null || sign.trim().isEmpty()) {
                log.info("签名失败，检查私钥格式");
//                System.err.println("签名失败，检查私钥格式");
                result = false;
            }
            log.info("签名" + sign);
//            System.out.println("签名" + sign);

            paramMap.put("sign", sign);

            String json = mapper.writeValueAsString(paramMap);
            log.info("请求JSON为 ： " + json);
//            System.out.println("请求JSON为 ： " + json);

            //构造请求
            Request request = new Request.Builder()
                    .url(BASE_URL + API_PATH)
                    .post(RequestBody.create(json, MediaType.get("application/json;charset=utf-8")))
                    .build();

            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful()) {
                    String responseBody = response.body().string();
                    log.info("通知成功，响应： " + responseBody);
//                    System.out.println("通知成功，响应： " + responseBody);
                    result = true;
                } else {
                    String errorMsg = response.body() != null ? response.body().string() : "未知错误";
                    log.error("请求失败，状态码： " + response.code() + "；响应： " + errorMsg);
//                    System.out.println("请求失败，状态码： " + response.code() + "；响应： " + errorMsg);
                    result = false;
                }
            }
        }catch (IOException e) {
            log.error("请求异常" + e.getMessage());
//            System.err.println("请求异常" + e.getMessage());
            e.printStackTrace();
            result = false;
        }
        return result;
    }
}

