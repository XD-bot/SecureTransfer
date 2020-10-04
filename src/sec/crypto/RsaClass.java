package sec.crypto;

import sun.misc.BASE64Decoder;

import javax.crypto.*;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.apache.commons.codec.binary.Base64;
import java.util.HashMap;
import java.util.Map;

public class RsaClass {

//    public static void main(String[] args) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
//        RsaClass rsaClass = new RsaClass();
//        rsaClass.generateKeyPair();
//        Key pubKey = rsaClass.keyMap.get(0);
//        Key priKey = rsaClass.keyMap.get(1);
//
//        String message = "yeyaowen";
//        byte[] encryptMessage = rsaClass.encrypt(message.getBytes(),pubKey);
//        System.out.println(new String(encryptMessage));
//
//        byte[] decryptMessage = rsaClass.decrypt(encryptMessage, priKey);
//        System.out.println(new String(decryptMessage));
//
//    }
    public static final String CHARSET = "UTF-8";
    public static final String RSA_ALGORITHM = "RSA";
    /**
     * 生成密钥对
     */
    public static Map<Integer, String> generateKeyPair(int keySize){
        //为RSA算法创建一个KeyPairGenerator对象
        KeyPairGenerator kpg;
        try{
            kpg = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        }catch(NoSuchAlgorithmException e){
            throw new IllegalArgumentException("No such algorithm-->[" + RSA_ALGORITHM + "]");
        }

        //初始化KeyPairGenerator对象,密钥长度
        kpg.initialize(keySize);
        //生成密匙对
        KeyPair keyPair = kpg.generateKeyPair();
        //得到公钥
        Key publicKey = keyPair.getPublic();
        String publicKeyStr = Base64.encodeBase64URLSafeString(publicKey.getEncoded());
        //得到私钥
        Key privateKey = keyPair.getPrivate();
        String privateKeyStr = Base64.encodeBase64URLSafeString(privateKey.getEncoded());
        Map<Integer, String> keyPairMap = new HashMap<Integer, String>();
        keyPairMap.put(0, publicKeyStr);
        keyPairMap.put(1, privateKeyStr);

        return keyPairMap;
    }

    /**
     * 加密
     */
    public byte[] encrypt(byte[] message,Key key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,key);
        return cipher.doFinal(message);
    }

    /**
     * 解密
     */
    public byte[] decrypt(byte[] enMessage,Key key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE,key);
        return cipher.doFinal(enMessage);
    }

    /**
     * 字符串转化为公钥
     * @param publicKey
     * @return
     * @throws Exception
     */
    /**
     * 得到公钥
     * @param publicKey 密钥字符串（经过base64编码）
     * @throws Exception
     */
    public  RSAPublicKey getPublicKey(String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //通过X509编码的Key指令获得公钥对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKey));
        RSAPublicKey key = (RSAPublicKey) keyFactory.generatePublic(x509KeySpec);
        return key;
    }

    /**
     * 字符串转化为私钥
     * @param privateKey
     * @return
     * @throws Exception
     */
    public  RSAPrivateKey getPrivateKey(String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //通过PKCS#8编码的Key指令获得私钥对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
        RSAPrivateKey key = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
        return key;
    }

}
