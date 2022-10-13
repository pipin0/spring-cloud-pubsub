package it.bitrock.pubsubdemo.service.gcp_storage;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
@Configuration
public class GcpStorageConfig {
    @Autowired
    private Environment environment;

    @Bean
    public Storage getMyStorage() throws IOException {
        val credentialLocation = environment.getProperty("spring.cloud.gcp.credentials.location");

        val accessTokenFilePath = (credentialLocation != null && credentialLocation.startsWith("file:")) ?
                credentialLocation.split(":")[1] : null;

        return accessTokenFilePath != null ?
                StorageOptions.newBuilder()
                        .setCredentials(ServiceAccountCredentials.fromStream(new FileInputStream(accessTokenFilePath)))
                        .build().getService() :
                StorageOptions.getDefaultInstance().getService();
    }
}
