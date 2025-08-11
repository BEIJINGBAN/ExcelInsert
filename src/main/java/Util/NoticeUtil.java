package Util;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class NoticeUtil {

    private static final OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30,TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();

    private static final com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper();
    //Json格式
    private static class RequestBodyJson{
        String interfaceVersion;
        String transSeqNo;
        String type;
        String filePath;
        String fileName;
    }

    public static boolean noticeAudit(String BASE_URL,String API_PATH,
                                      String interfaceVersion,String transSeqNo,
                                      String type,String filePath,String fileName){
        boolean result = false;
        RequestBodyJson requestBodyJson  = new RequestBodyJson();
        requestBodyJson.interfaceVersion = interfaceVersion;
        requestBodyJson.transSeqNo = transSeqNo;
        requestBodyJson.type = type;
        requestBodyJson.filePath = filePath;
        requestBodyJson.fileName = fileName;
        requestBodyJson.filePath = filePath;

        //构造Json
        String json ="";
        try{
            json = mapper.writeValueAsString(requestBodyJson);
            System.out.println("请求Json如下"+json);
        }catch (Exception e){
            System.err.println("JSON序列化失败"+e.getMessage());
            result = false;
        }

        //构造请求
        Request request = new Request.Builder()
                .url(BASE_URL+API_PATH)
                .post(RequestBody.create(json,MediaType.get("application/json;charset=utf-8")))
                .build();


        try(Response response = client.newCall(request).execute()){
            if(response.isSuccessful()){
                String responseBody = response.body().toString();
                System.out.println("通知成功，响应： "+responseBody);
                result = true;
            }else {
                String errorMsg = response.body() !=null ? response.body().toString() : "未知错误";
                System.out.println("请求失败，状态码： "+response.code()+"；响应： "+errorMsg);
                result = false;
            }
        }catch (IOException e){
            System.err.println("请求异常"+e.getMessage());
            e.printStackTrace();
            result = false;
        }

        return  result;
    }

}
