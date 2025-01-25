package com.frobledo.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder;

public class EmailUtil {
	
	private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public static String encryptEmail(String rawEmail) { 
		return passwordEncoder.encode(rawEmail);
	}
		
		public static void main(String[] args) { 
			// Ejemplo de uso para encriptar correos electrónicos existentes 
			String[] rawEmails = {"jioh@email.com", "frobledo@email.com"}; 
			for (String rawEmail : rawEmails) { 
				String encryptedEmail = encryptEmail(rawEmail); 
				System.out.println("Original: " + rawEmail + " - Encrypted: " + encryptedEmail);
				//actualizar la base de datos con el correo electrónico encriptado 
			
		}
	}

}
