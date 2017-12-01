package general.definition;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class Encryption {


	/**
	 * Encrypt the given value string, with the given key and initVector.
	 * @param key used to encrypt the value. Must be 16 bytes.
	 * @param initVector used to specify the encryption. Must be 16 bytes.
	 * @param value the text that will be encrypted.
	 * @return the encrypted text.
	 */
	public static String encrypt(String key, String initVector, String value) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			
			// generate SecretKeySpec from the given key 
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);


			// return the encrypted text
			return Base64.encodeBase64String(cipher.doFinal(value.getBytes()));

		} catch (Exception ex) {
		}

		return null;
	}

	/**
	 * Decrypt the given encrypted string.
	 * @param key used to encrypt the value. Must be 16 bytes.
	 * @param initVector used to specify the encryption. Must be 16 bytes.
	 * @param encrypted the encrypted text.
	 * @return the original text after decryption.
	 */
	public static String decrypt(String key, String initVector, String encrypted) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			
			// generate SecretKeySpec from the given key 
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

			// return the the original value of the string
			return new String(cipher.doFinal(Base64.decodeBase64(encrypted)));
		} catch (Exception ex) {
			
		}

		return null;
	}
	
	
	/**
	 * This method will encode the given text to base 64.
	 * @param text the text that will be decoded.
	 * @return the decoded message.
	 */
	public static String encodeBase64(String text) {
		
		
		try {
			return java.util.Base64.getEncoder().encodeToString(text.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			
		}
		
		return null;
	}

	/**
	 * This method will decode the given text from base 64.
	 * @param text the decoded text.
	 * @return the original text after decode.
	 */
	public static String decodeBase64(String text) {
		
        try {
        	byte[] decodedText = java.util.Base64.getDecoder().decode(text);
			return new String(decodedText, "utf-8");
		} catch (UnsupportedEncodingException e) {
			
		}
        
        return null;
	}


}
