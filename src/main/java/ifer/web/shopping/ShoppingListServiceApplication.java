package ifer.web.shopping;



import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import ifer.web.shopping.util.ShoppingListConstants;


@SpringBootApplication
public class ShoppingListServiceApplication {
	
	// Set the following system property or turn it into an environment variable for this app to run
	static {
		System.setProperty("jasypt.encryptor.password", ShoppingListConstants.enckey);
	}
	

	//This bean is defined in app.properties as jasypt.encryptor.bean
    @Bean("encryptorBean")
    StandardPBEStringEncryptor encryptorBean(Environment environment) {
    	StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setAlgorithm("PBEWithMD5AndDES");
		encryptor.setPassword(environment.getProperty("jasypt.encryptor.password"));
		return (encryptor);
    	
    }

    // SpringApplicationBuilder needed to decrypt entries in *.properties using encryptorBean
	public static void main(String[] args) {
		new SpringApplicationBuilder().sources(ShoppingListServiceApplication.class).run(args);		
		System.out.println ("Started!");
	}

}
