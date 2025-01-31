import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DES{
    

    public static void encryptDecrypt(String key, int cipherMode, File in, File out)
    throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException,
    IOException, InvalidAlgorithmParameterException
    {
        FileInputStream fis = new FileInputStream(in);
        FileOutputStream fos = new FileOutputStream(out);

        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = skf.generateSecret(desKeySpec);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        byte[] ivBytes = new byte[8];
        IvParameterSpec iv = new IvParameterSpec(ivBytes);


        if(cipherMode == Cipher.ENCRYPT_MODE){
            try{
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv, SecureRandom.getInstance("SHA1PRNG"));
            CipherInputStream cis = new CipherInputStream(fis, cipher);
            write(cis,fos);
            }
            catch (InvalidAlgorithmParameterException e)
            {
                e.printStackTrace();
            }
        }
        else if(cipherMode == Cipher.DECRYPT_MODE){
            try{
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv, SecureRandom.getInstance("SHA1PRNG"));
            CipherOutputStream cos = new CipherOutputStream(fos, cipher);
            write(fis, cos);
            }catch (InvalidAlgorithmParameterException e){
                e.printStackTrace();

            }
        }
    }

        public static void write (InputStream in, OutputStream out) throws IOException{
            byte[] buffer = new byte[64];
            int numOfBytesRead;
            while((numOfBytesRead = in.read(buffer)) != -1){
                out.write(buffer,0, numOfBytesRead);

            }
            out.close();
            in.close();
        }
        public static void main (String[] args){
            File plaintext = new File("in.txt");
            File encrypted = new File("out.txt");
             if(args[0].equals("1") ){
                try{
                   
                    encryptDecrypt(args[1], Cipher.ENCRYPT_MODE, plaintext, encrypted);
                    System.out.print("COMPLETED EncryPTION" );
                }catch (InvalidAlgorithmParameterException|InvalidKeyException|NoSuchAlgorithmException|InvalidKeySpecException|NoSuchPaddingException| IOException e){
                    e.printStackTrace();
                }
            }else{ 
                try{
                   
                    encryptDecrypt("583101589324412032", Cipher.DECRYPT_MODE, encrypted, plaintext);
                    System.out.println("COMPLETED DECRYPTION");
                }catch (InvalidAlgorithmParameterException|InvalidKeyException|NoSuchAlgorithmException|InvalidKeySpecException|NoSuchPaddingException| IOException e){
                    e.printStackTrace();
                }
            }
        }
     }

