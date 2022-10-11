package it.bitrock.pubsubdemo.service.gcp_storage;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.*;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Vittorio Rispoli
 * <p>
 * <a href="https://github.com/googleapis/java-storage/tree/main/samples/snippets/src/main/java/com/example/storage/object">github</a>
 */
@Slf4j
@Component
public class GcpStorageObjectMethods {
    @Autowired
    private Environment environment;

    public void uploadInMemoryObject(String bucketName, String objectName, String content) {
        try {
            val storage = getStorage();

            val blobInfo = getBlobInfo(bucketName, objectName);

            val contentsBytes = content.getBytes(StandardCharsets.UTF_8);

            storage.createFrom(blobInfo, new ByteArrayInputStream(contentsBytes));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void createBucket(String bucketName) {
        try {
            val storage = getStorage();

            storage.create(BucketInfo.of(bucketName));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    private Storage getStorage() throws IOException {
        val aaa = environment.getProperty("spring.cloud.gcp.credentials.location");
        log.warn("ZZZ credentials.location: " + aaa);

        val accessTokenFilePath = (aaa != null && aaa.startsWith("file:")) ?
                aaa.split(":")[1] : null;
        log.warn("ZZZ accessTokenFilePath: " + accessTokenFilePath);
        log.warn("ZZZ defaultInstanceProjectId: " + StorageOptions.getDefaultInstance().getProjectId());

        return accessTokenFilePath != null ?
                StorageOptions.newBuilder()
                        .setCredentials(ServiceAccountCredentials.fromStream(new FileInputStream(accessTokenFilePath)))
                        .build().getService() :
                StorageOptions.getDefaultInstance().getService();
    }

    private static BlobInfo getBlobInfo(String bucketName, String objectName) {
        return BlobInfo.newBuilder(BlobId.of(bucketName, objectName)).build();
    }
}
