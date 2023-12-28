package com.st.cam.configuration.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppsConfig {

    @Bean
    @ConfigurationProperties("jasypt.encryptor")
    public SimpleStringPBEConfig jasypConfig() {
            SimpleStringPBEConfig config = new SimpleStringPBEConfig();
            config.setAlgorithm("PBEWithMD5AndDES");
            config.setKeyObtentionIterations("1000");
            config.setPoolSize("1");
            config.setProviderName("SunJCE");
            config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
            config.setStringOutputType("base64");
            return config;
    }

    @Bean
    public StringEncryptor jasyptEncryptor() {
            PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
            encryptor.setConfig(jasypConfig());
            return encryptor;
    }

    private static String mpCryptoPassword = "stcam";

    public static void main(String[] args) {
            String password = "password";

            AES256TextEncryptor encryptor = new AES256TextEncryptor();
            encryptor.setPassword("stcam");
            String myEncryptedText = encryptor.encrypt(password);
            System.out.println("Encrypted: "+myEncryptedText);

            String plainText = encryptor.decrypt(myEncryptedText);
            System.out.println("Decrypted: "+plainText);
    }
}
