package it.bitrock.pubsubdemo.service;

import it.bitrock.pubsubdemo.model.FileRecordRequest;
import it.bitrock.pubsubdemo.service.gcp_storage.GcpStorageObjectMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageService {
    @Autowired
    private GcpStorageObjectMethods gcpStorageObjectMethods;

    public void uploadFileRecord(FileRecordRequest fileRecordRequest) {
        gcpStorageObjectMethods.uploadInMemoryObject(
                fileRecordRequest.getBucketName(),
                fileRecordRequest.getFileName(),
                fileRecordRequest.getFileContent()
        );
    }
}
