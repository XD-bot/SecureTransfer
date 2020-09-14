package sec.crypto;

import javax.crypto.*;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

public class RsaClass {
    public Map<Integer, Key> keyMap = new HashMap<>();

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
    /**
     * 生成密钥对
     */
    public void generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024,new SecureRandom());
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        //获取RSA公、私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        //转化为字符串
        String publicKeyString = new String(publicKey.toString());
        String privateKeyString = new String(privateKey.toString());
        System.out.println("RSA私钥："+privateKeyString);
        System.out.println("RSA公钥："+publicKeyString);
        //以键值对存储，0为公钥，1为私钥
        keyMap.put(0,publicKey);
        keyMap.put(1,privateKey);
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




}
