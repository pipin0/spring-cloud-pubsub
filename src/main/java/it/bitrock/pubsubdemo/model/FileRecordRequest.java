package it.bitrock.pubsubdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileRecordRequest {
    private String fileName;
    private String bucketName;
    private String fileContent;
}
