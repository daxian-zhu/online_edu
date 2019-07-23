package com.clark.online.edu.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;

import sun.misc.BASE64Encoder;

public class CertUtil {

	private File keystoreFile;

	private String keyStoreType;

	private char[] password;

	private String alias;

    private File exportedFile;

    public KeyPair getPrivateKey(KeyStore keystore, String alias, char[] password) {
		try {
			Key key = keystore.getKey(alias, password);
	            if (key instanceof PrivateKey) {
	                Certificate cert = keystore.getCertificate(alias);
	                PublicKey publicKey = cert.getPublicKey();
	                return new KeyPair(publicKey, (PrivateKey) key);
	            }
		}catch (UnrecoverableKeyException e) {
		}catch (NoSuchAlgorithmException e) {
		}catch (KeyStoreException e) {
		}
		return null;
    }

	public void export() throws Exception {
		KeyStore keystore = KeyStore.getInstance(keyStoreType);
		BASE64Encoder encoder = new BASE64Encoder();
		keystore.load(new FileInputStream(keystoreFile), password);
		KeyPair keyPair = getPrivateKey(keystore, alias, password);
		PrivateKey privateKey = keyPair.getPrivate();
		String encoded = encoder.encode(privateKey.getEncoded());
		FileWriter fw = new FileWriter(exportedFile);
		fw.write("----BEGIN PRIVATE KEY----\n");
		fw.write(encoded);
		fw.write("\n");
		fw.write("----END PRIVATE KEY----\n");
		Certificate cert = keystore.getCertificate(alias);
		PublicKey publicKey = cert.getPublicKey();
		String encoded2 = encoder.encode(publicKey.getEncoded());
		fw.write("----BEGIN CERTIFICATE----\n");
		fw.write(encoded2);
		fw.write("\n");
		fw.write("----END CERTIFICATE----\n");
		fw.close();
	}

	public static void main(String args[]) throws Exception {
		CertUtil export = new CertUtil();
		export.keystoreFile = new File("C:\\work\\MyWorkspace\\online_edu\\online_edu_oauth\\src\\main\\resources\\kevin_key.jks");
		export.keyStoreType = "JKS";
		export.password = "daxianzuishuai".toCharArray();
		export.alias = "kevin_key";
		export.exportedFile = new File("output");
		export.export();
	}
}