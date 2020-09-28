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
        private Map keyPair;


        public JTextArea getjTextArea() {
            return jTextArea;
        }

        public void setjTextArea(JTextArea jTextArea) {
            this.jTextArea = jTextArea;
        }

        public Map getKeyPair() {
            return keyPair;
        }


        public void generateRsaKey(){
            rsaClass = new RsaClass();
            try {
                keyPair = rsaClass.generateKeyPair();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            generateRsaKey();
            this.jTextArea.append("----RSA生成密钥对----\n");
            this.jTextArea.append("公钥："+this.keyPair.get(0).toString()+"\n");
            this.jTextArea.append("私钥："+this.keyPair.get(1).toString()+"\n");

        }

}
