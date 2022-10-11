package it.bitrock.pubsubdemo.controller;

import it.bitrock.pubsubdemo.model.AudioRecordRequest;
import it.bitrock.pubsubdemo.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;

    @PostMapping("upload")
    public void upload(@RequestBody AudioRecordRequest audioRecordRequest) {
        storageService.uploadAudioRecord(audioRecordRequest);
    }
}
