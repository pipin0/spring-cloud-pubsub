package it.bitrock.pubsubdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AudioRecordRequest {
    private String fileName;
    private AudioRecord audioRecord;
    private String bucketName;
}
