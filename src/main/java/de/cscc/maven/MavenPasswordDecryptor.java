package de.cscc.maven;

import org.sonatype.plexus.components.cipher.DefaultPlexusCipher;

public class MavenPasswordDecryptor {
	public static void main(String[] args) throws Exception {
		
		if (args.length < 1 || args.length > 2 ) {
			System.out.println("Usage: java -jar maven-password-decryptor.jar <encrypted-password>");
			System.out.println("Usage: java -jar maven-password-decryptor.jar <encrypted-password> <master-password>");
			return;
		}
		
		DefaultPlexusCipher cipher = new DefaultPlexusCipher();

		String encryptedPassword = args[0];
		String passPhrase = (args.length == 2 && args[1] != null && !args[1].isEmpty()) ? args[1] : "settings.security";
		
		String result = cipher.decryptDecorated(encryptedPassword, passPhrase);

		System.out.println(result);
	}
}
