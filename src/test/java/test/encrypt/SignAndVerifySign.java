package test.encrypt;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 签名和验签
 * @date: 2019/6/26
 */
@SuppressWarnings("all")
public class SignAndVerifySign {
    private static final String ALGOGRITHM = "RSA";
    private static final String PUBLIC_KEY_PATH = "C:\\Users\\alw\\Desktop\\pub.key";
    private static final String PRIVATE_KEY_PATH = "C:\\Users\\alw\\Desktop\\pri.key";

    public static String readToString(String fileName) {
        String fileContent = "";
        FileInputStream fis = null;
        File file = new File(fileName);
        byte[] by = new byte[Long.valueOf(file.length()).intValue()];
        try {
            fis = new FileInputStream(file);
            fis.read(by);
            fileContent = new String(by, "UTF-8");
        }catch (Exception e) {

        }finally {
            try {
                fis.close();
            } catch (IOException e) {}
        }
        return fileContent;
    }

    public static void main(String[] args)throws Exception {
        // 私钥签名 -> 拿着签名内容与公钥验签的值去对比, 能匹配说明内容在传输途中没被修改
        String signFlag = "hackdream";
        String sign = signByPrivateKey(signFlag, readToString(PRIVATE_KEY_PATH));
        System.out.println("sign："+sign);
        // 公钥验签
        System.out.println("验签："+verifySignByPublicKey(signFlag, readToString(PUBLIC_KEY_PATH), sign));
    }

    /**
     * 私钥签名
     * @param content 报文
     * @param privateKey 私钥
     * @return 签名值
     */
    public static String signByPrivateKey(String content,String privateKey)throws Exception{
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decode(privateKey));
        KeyFactory keyFactory = KeyFactory.getInstance(ALGOGRITHM);
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Signature signature = Signature.getInstance("SHA256withRSA");//MD5withRSA
        signature.initSign(priKey);
        signature.update(content.getBytes());
        byte[] sign = signature.sign();
        return Base64.encode(sign);
    }

    /**
     * 公钥验签
     * @param content 报文
     * @param publicKey 公钥
     * @param sign 签名值
     * @return 验签是否通过
     */
    public static boolean verifySignByPublicKey(String content,String publicKey,String sign)throws Exception{
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode(publicKey));
        KeyFactory keyFactory = KeyFactory.getInstance(ALGOGRITHM);
        PublicKey pubKey = keyFactory.generatePublic(x509EncodedKeySpec);
        Signature signature = Signature.getInstance("SHA256withRSA");//MD5withRSA
        signature.initVerify(pubKey);
        signature.update(content.getBytes());
        return signature.verify(Base64.decode(sign));
    }


}
