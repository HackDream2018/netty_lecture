package test.encrypt;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/4
 */
public class EncryptAndDecrypt {

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

       /* KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGOGRITHM);
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey pubKey = (RSAPublicKey)keyPair.getPublic();
        PrivateKey priKey = (RSAPrivateKey)keyPair.getPrivate();

        System.out.println("公钥: "+ new BASE64Encoder().encodeBuffer(pubKey.getEncoded()));
        System.out.println("私钥: "+ new BASE64Encoder().encodeBuffer(priKey.getEncoded()));*/


        // 明文加密
        String message = "hackdream";
        String ciphertext = encrypt(message, readToString(PUBLIC_KEY_PATH));
        System.out.println("信息密文为:" + ciphertext);
        String cleartext = decrypt(ciphertext, readToString(PRIVATE_KEY_PATH));
        System.out.println("密文解密后:" + cleartext);
    }


    /**
     * RSA公钥加密
     */
    public static String encrypt( String str, String publicKey ) throws Exception{
        //base64解码公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance(ALGOGRITHM).generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance(ALGOGRITHM);
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }


    /**
     * RSA私钥解密
     */
    public static String decrypt(String str, String privateKey) throws Exception{
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance(ALGOGRITHM).generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance(ALGOGRITHM);
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }

}
