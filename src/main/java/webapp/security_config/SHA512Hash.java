package webapp.security_config;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SHA512Hash implements IPasswordHash{

    private final Logger logger = Logger.getLogger("PasswordHashClass");

    public byte[] getSalt()  {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    public byte[] getSaltedHash(String password, byte[] salt) {
        byte[] byteData = null;
        try {
            byteData = getHashedPassword(password, salt);
        } catch (Exception e){
            logError(e);
        }
        return byteData;
    }

    private byte[] getHashedPassword(String password, byte[] salt) throws NoSuchAlgorithmException {

        // Get a SHA-512 algorithm
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
        // add the salt to the massageDigest and digest the password
        messageDigest.update(salt);
        byte[] byteData = messageDigest.digest(password.getBytes());
        messageDigest.reset();
        return byteData; // Return the Hashed Password
    }

    public byte[] fromHex(String hex){
        byte[] binary = new byte[hex.length()/2];
        for (int i = 0 ; i < binary.length;i++){
            binary[i]= (byte) Integer.parseInt(hex.substring(2*i,2*i+2),16);
        }
        return binary;
    }

    public String toHex(byte[] array){

        BigInteger bi = new BigInteger(1,array);
        String hex = bi.toString(16);
        int paddinglength = (array.length*2) - hex.length();

        if (paddinglength>0)
            return String.format("%0"+paddinglength+"d",0)+hex;
        else return hex;
    }

    private void logError (Exception e){
        logger.log(Level.SEVERE,e.getMessage());
    }


}
