package webapp.security_config;

public interface IPasswordHash {

    byte[] getSalt();
    byte[] getSaltedHash(String password, byte[] salt);
    byte[] fromHex(String hex);
    String toHex(byte[] array);

}