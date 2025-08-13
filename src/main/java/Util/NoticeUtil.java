package Util;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class NoticeUtil {

    private static final OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();

    private static final com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper();

    //配置
    private static final String PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDNrg52MfraQkFc" +
            "4VLAIqJ48SdXIpaQoooezUpyqMXEvYyWiLFXlKSxdODRzVR/SIz3NbcJNUSQUTRN" +
            "uwnC/2YqmrGfX9tP0Y5un0y+3EhH2vgMQvwaqrxIipfN0RjD1sSb/iuk62n50vD2" +
            "7gO54chhIrbqXl/nOdzR9h2K824pBdnPX9B+ySsp7gbtmDsptUug4E75v4nf/VCe" +
            "2pcNxKPudNZLvyrFa+SoW2/FINf/PyQaXFoZPy8tY9DMCpTpZrJ7nGSqANc83rs4" +
            "EQesWNxLer9LUFkBeCx9wVJhq1l4voIUj/cMe2T0xlbSDUUWxkAJA994zHwuwNJM" +
            "HGiwhfp3AgMBAAECggEARgObDqcC0ms9XsWg6qCfl/XXQ3UVtdRumf+d+Rv0fn1b" +
            "rx6G595EldfIdAKmYdGrkrdpQCwu08WgvVkPAJ76A0S3dB4oRKp8BrIZaNsJi9RB" +
            "HcNrmBRIlZUACeLEwF2KfeNurewpHg6tUhFBmXP/RvmPNIa9tLNgtORHuDYXaMTk" +
            "8plAU4IoVaIG/l7JnpNiAPxUxcn02Ld4OUxUPYoEJV//TvEccuYcmLI/w2JmTf5N" +
            "oaVLbylfoGZQZn5AfNwT17J/owjGiWf/MVKbaO62tyK4BP2aQkKxSICDw89LuLSe" +
            "Mqj8conqeekV5GYSxzHH2lN7Qs/phgnJBVsfyTiZeQKBgQD/28v/Dh2CZUkNpJPg" +
            "ZqqGJojEyFFk2yww7lw4bekO2WsNyuigNSkHxh+dT9iePDEXlyUDTPThGIIew4OI" +
            "8EXhcYP1uJvOGEvIpwqn2k5/6rfU4tQ2fS475gyRjx8AHz3V3Bkfp4OUmx+tKuNd" +
            "UprcQ2d8Vzrbft8Zb6Qv2Y0ybQKBgQDNyyjV9s9ZUPtaD/nyWE+yOtKr3xNv+n8/" +
            "vgcrsAX5rkDYRViKCRmXpQbb3EsEhiYpnT4klrzdP6Z8WsYx6KqRck8nm2gGMRB6" +
            "rnj39ryY9/zo0/FirRVsUNxOHNxh4xv0w3YJcXLodikRq4ZQIUu0DRYEevtGoVyw" +
            "h1JxrxFx8wKBgG/Gv0UrDntD8nlSWAQl9gNrXD7T4LM2CQVLbOB+K93/4AQDjENJ" +
            "ViZ+SJt6IYFnfG746gOaIDUidt4nvhQaG/1UkTjNMMwF0z3StBYGilrZ2PvZKKqx" +
            "X3xtkToaE4oDHAmNATDSBurqJhmJ7hB8IQlvLQumNCFmOOMs4cbBvSy1AoGAaV0E" +
            "0VeGHcKajifz3qJcW3JGfny+JOzpzabrYPDEfms7A/+tLy8tjTiO5G5LckuEqnW5" +
            "ZV5P4C9AfBa1tsPa4JDX+f1VKyZfu5AsmzgWo3MEZ+hrhAv+FfDoeo3IP83ZeF3C" +
            "x17waBhnOobJQ6loawzwIuccU7M2E6OVEGOD2QUCgYAxQWB7xnM3esUtZT+c0Z7R" +
            "XM6j0bG4hF5zMXIENT32LyA+8DtRBJ5jnWnjUg0I0b411QyH0NRxIJ9hoi4uqmSD" +
            "gxuGW0gUz5Jj1f6B081TcFX9wlLYj2ELHxfz3omOXT3BpFijmTZFkbawjawuDpZ5" +
            "p7pzRMm+A1l8UeE7RyfXug==";                                       //私钥
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
            System.out.println("待签名字符串" + signContent);

            String sign = SignUtil.rsaSign(signContent, PRIVATE_KEY, SIGN_ALGORITHM, CHARSET);
            if (sign == null || sign.trim().isEmpty()) {
                System.err.println("签名失败，检查私钥格式");
                result = false;
            }
            System.out.println("签名" + sign);

            paramMap.put("sign", sign);

            String json = mapper.writeValueAsString(paramMap);
            System.out.println("请求JSON为 ： " + json);

            //构造请求
            Request request = new Request.Builder()
                    .url(BASE_URL + API_PATH)
                    .post(RequestBody.create(json, MediaType.get("application/json;charset=utf-8")))
                    .build();

            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful()) {
                    String responseBody = response.body().string();
                    System.out.println("通知成功，响应： " + responseBody);
                    result = true;
                } else {
                    String errorMsg = response.body() != null ? response.body().string() : "未知错误";
                    System.out.println("请求失败，状态码： " + response.code() + "；响应： " + errorMsg);
                    result = false;
                }
            }
        }catch (IOException e) {
            System.err.println("请求异常" + e.getMessage());
            e.printStackTrace();
            result = false;
        }
        return result;
    }
}

