package net.minecraft.server;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Charsets;

public class MinecraftEncryption {

	private static final Logger logger = LogManager.getLogger();

	public static KeyPair generateKeyPair() {
		try {
			KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
			generator.initialize(1024);
			return generator.generateKeyPair();
		} catch (NoSuchAlgorithmException var1) {
			var1.printStackTrace();
			logger.error("Key pair generation failed!");
			return null;
		}
	}

	public static byte[] hashKeys(String serverId, PublicKey publickey, SecretKey secretkey) {
		return digest("SHA-1", new byte[][] { serverId.getBytes(Charsets.ISO_8859_1), secretkey.getEncoded(), publickey.getEncoded() });
	}

	private static byte[] digest(String algo, byte[]... data) {
		try {
			MessageDigest mdigest = MessageDigest.getInstance(algo);
			for (int i = 0; i < data.length; ++i) {
				byte[] part = data[i];
				mdigest.update(part);
			}

			return mdigest.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static PublicKey generatePublicKey(byte[] data) {
		try {
			X509EncodedKeySpec keyspec = new X509EncodedKeySpec(data);
			KeyFactory factory = KeyFactory.getInstance("RSA");
			return factory.generatePublic(keyspec);
		} catch (NoSuchAlgorithmException var3) {
		} catch (InvalidKeySpecException var4) {
		}

		logger.error("Public key reconstitute failed!");
		return null;
	}

	public static SecretKey getSecretKey(PrivateKey key, byte[] daya) {
		return new SecretKeySpec(decrypt(key, daya), "AES");
	}

	public static byte[] decrypt(Key key, byte[] daya) {
		return doCipher(Cipher.DECRYPT_MODE, key, daya);
	}

	private static byte[] doCipher(int mode, Key key, byte[] data) {
		try {
			return getCipher(mode, key.getAlgorithm(), key).doFinal(data);
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}

		logger.error("Cipher data failed!");
		return null;
	}

	private static Cipher getCipher(int mode, String name, Key key) {
		try {
			Cipher cipher = Cipher.getInstance(name);
			cipher.init(mode, key);
			return cipher;
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}

		logger.error("Cipher creation failed!");
		return null;
	}

	public static Cipher getCipher(int mode, Key key) {
		try {
			Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding");
			cipher.init(mode, key, new IvParameterSpec(key.getEncoded()));
			return cipher;
		} catch (GeneralSecurityException var3) {
			throw new RuntimeException(var3);
		}
	}

}
