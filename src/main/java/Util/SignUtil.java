package Util;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;


public class SignUtil {



////    // 1. 构造请求对象（如 mchId + bizContent）
//// 2. 转成 JSON 字符串（noSign）
//// 3. 解析成 JSONObject
//// 4. 调用 genSignContentWithSalt 拼接待签名字符串
//// 5. 调用 rsaSign 生成签名
//// 6. 把签名放入 JSON 中
//// 7. 发送 HTTP 请求
//// 8. 接收响应后，提取 sign 字段
//// 9. 重新拼接待验签字符串
//// 10. 调用 rsaVerify 验证签名
////    public static void main(String[] args) {
/////		YqsReceiveEnterpriseBizContent bizContent = new YqsReceiveEnterpriseBizContent();
////        EhtBaseRequest request = new EhtBaseRequest<>(mchId, bizContent);
////        String noSign = JSON.toJSONString(request);
////        JSONObject jsonObject = JSONObject.parseObject(noSign);
////        String signContent = SignUtil.genSignContentWithSalt(jsonObject, this.saltKey);
////        log.info("签名字符串：{}", signContent);
////        String sign = SignUtil.rsaSign(signContent, this.priKey, "SHA256withRSA", "utf-8");
////        jsonObject.put("sign", sign);
////        String requestContent = jsonObject.toJSONString();
////
////        log.info("地址：{} 请求原文：{}", url, requestContent);
////        String response = HttpUtils.doPost(url, "application/json", requestContent.getBytes(StandardCharsets.UTF_8), 5000, 15000, null, 0);
////        log.info("响应原文：{}", response);
////
////        JSONObject respObj = JSON.parseObject(response);
////        String signResult = respObj.getString("sign");
////        String respSignContent = SignUtil.genSignContentWithSalt(respObj, this.saltKey);
////        log.info("验签字符串：{}", signContent);
////        SignUtil.rsaVerify(respSignContent, signResult, pubKey, "SHA256withRSA", "utf-8");
////        log.info("验签成功");
////    }

    //生成签名
    public static String genSignContentWithSalt(Map<String, Object> map, String saltVal) {
        List<String> contentHolder = new ArrayList<>();
        genSignContent(map, contentHolder);

        contentHolder.add(saltVal);
        return String.join("_", contentHolder);
    }

    //签名一致性
    public static void genSignContent(Map<String, Object> map, List<String> contentHolder) {
        Map<String, Object> treeMapTemp = new TreeMap<>(map);

        for (Map.Entry<String, Object> entry : treeMapTemp.entrySet()) {
            if ("sign".equals(entry.getKey())) {
                continue;
            }

            Object value = entry.getValue();

            if (value instanceof Map) {
                genSignContent((Map<String, Object>) value, contentHolder);
            } else if (value instanceof List) {
                List<?> list = (List<?>) value;
                for (Object item : list) {
                    if (item instanceof Map) {
                        genSignContent((Map<String, Object>) item, contentHolder);
                    } else {
                        addIfNotBlank(String.valueOf(item), contentHolder);
                    }
                }
            } else if (value != null) {
                addIfNotBlank(String.valueOf(value), contentHolder);
            }
        }
    }

    //添加到列表
    private static void addIfNotBlank(String val, List<String> list) {
        if (StringUtils.isNotBlank(val)) {
            list.add(val);
        }
    }

    //RSA签名
    public static String rsaSign(String content, String privateKey, String signRsaAlgorithm, String inputCharset) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);

            Signature signature = Signature.getInstance(signRsaAlgorithm);

            signature.initSign(priKey);
            signature.update(content.getBytes(inputCharset));

            byte[] signed = signature.sign();

            return new String(Base64.getEncoder().encode(signed), inputCharset);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //RSA验签
    public static boolean rsaVerify(String content, String sign, String publicKey, String signRsaAlgorithm, String inputCharset) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64.getDecoder().decode(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

            Signature signature =
                    Signature.getInstance(signRsaAlgorithm);

            signature.initVerify(pubKey);
            signature.update(content.getBytes(inputCharset));
            return signature.verify(Base64.getDecoder().decode(sign));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}