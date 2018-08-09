package com.spring;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class TencentCloudAPIDemo {
    private final static String CHARSET = "UTF-8";

    public static String sign(String s, String key, String method) throws Exception {
        Mac mac = Mac.getInstance(method);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(CHARSET), mac.getAlgorithm());
        mac.init(secretKeySpec);
        byte[] hash = mac.doFinal(s.getBytes(CHARSET));
        return DatatypeConverter.printBase64Binary(hash);
    }

    public static String getStringToSign(TreeMap<String, Object> params) {
        StringBuilder s2s = new StringBuilder("GETcvm.tencentcloudapi.com/?");
        // 签名时要求对参数进行字典排序，此处用TreeMap保证顺序
        for (String k : params.keySet()) {
            s2s.append(k).append("=").append(params.get(k).toString()).append("&");
        }
        return s2s.toString().substring(0, s2s.length() - 1);
    }

    public static String getUrl(TreeMap<String, Object> params) throws UnsupportedEncodingException {
        StringBuilder url = new StringBuilder("http://aai.qcloud.com/asr/v1/1257220479/?");
        // 实际请求的url中对参数顺序没有要求
        for (String k : params.keySet()) {
            // 需要对请求串进行urlencode，由于key都是英文字母，故此处仅对其value进行urlencode
            url.append(k).append("=").append(URLEncoder.encode(params.get(k).toString(), CHARSET)).append("&");
        }
        return url.toString().substring(0, url.length() - 1);
    }

    public static void main(String[] args) throws Exception {
        TreeMap<String, Object> params = new TreeMap<String, Object>(); // TreeMap可以自动排序
        // 实际调用时应当使用随机数，例如：params.put("Nonce", new Random().nextInt(java.lang.Integer.MAX_VALUE));
        params.put("nonce", 11886); // 公共参数
        // 实际调用时应当使用系统当前时间，例如：   params.put("Timestamp", System.currentTimeMillis() / 1000);
        params.put("timestamp", 1533046208); // 公共参数
        params.put("secretId", "AKIDnTzMciENxMaeWFjALSO9iARXSCoA2QK4"); // 公共参数
        params.put("projectid", 0); // 公共参数
        params.put("sub_service_type", 0); // 公共参数
        params.put("engine_model_type", "16k_0"); // 公共参数
        params.put("url", "http://test.qq.com/rec_callback"); // 业务参数
        params.put("res_text_format", 0); // 业务参数
        params.put("res_type", 1); // 业务参数
        params.put("source_type", 1); // 业务参数
        params.put("expired", "1533146208"); // 业务参数
        params.put("signature", sign(getStringToSign(params), "iFbnncGm7SCtPkMuKZkjZEl8MPI0EIBt", "HmacSHA1")); // 公共参数
        System.out.println(getUrl(params));
    }
}