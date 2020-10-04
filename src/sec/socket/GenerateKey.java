package sec.socket;

import sec.crypto.RsaClass;

import javax.swing.*;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class GenerateKey implements Runnable{


        private Socket socket;
        private JTextArea jTextArea;
        private RsaClass rsaClass;
        private String publicKey;
        private String privateKey;
        private Map<Integer,String> keyPair;

        public JTextArea getjTextArea() {
            return jTextArea;
        }

        public void setjTextArea(JTextArea jTextArea) {
            this.jTextArea = jTextArea;
        }

        public Map getKeyPair() {
            return keyPair;
        }


        public void generateRsaKeyPair(){
            rsaClass = new RsaClass();
            keyPair = rsaClass.generateKeyPair(1024);

        }

    public String getPublicKey() {
        return publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    @Override
        public void run() {
            generateRsaKeyPair();
            publicKey = this.keyPair.get(0);
            privateKey = this.keyPair.get(1);
            this.jTextArea.append("----RSA生成密钥对----\n");
            this.jTextArea.append("公钥："+publicKey+"\n");
            this.jTextArea.append("私钥："+privateKey+"\n");

        }

}
