package it.bitrock.pubsubdemo.service.gcp_storage;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
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
    private Storage myStorage;

    public void uploadInMemoryObject(String bucketName, String objectName, String content) {
        try {
            val blobInfo = getBlobInfo(bucketName, objectName);

            val contentsBytes = content.getBytes(StandardCharsets.UTF_8);

            myStorage.createFrom(blobInfo, new ByteArrayInputStream(contentsBytes));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    private static BlobInfo getBlobInfo(String bucketName, String objectName) {
        return BlobInfo.newBuilder(BlobId.of(bucketName, objectName)).build();
    }
}
