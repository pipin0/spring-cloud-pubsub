package it.bitrock.pubsubdemo.service;

import it.bitrock.pubsubdemo.model.AudioRecordRequest;
import it.bitrock.pubsubdemo.service.gcp_storage.GcpStorageObjectMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageService {
    @Autowired
    private GcpStorageObjectMethods gcpStorageObjectMethods;

    public void uploadAudioRecord(AudioRecordRequest audioRecordRequest) {
        gcpStorageObjectMethods.uploadInMemoryObject(
                audioRecordRequest.getBucketName(),
                audioRecordRequest.getFileName(),
                audioRecordRequest.getAudioRecord().toString()
        );
    }
}
