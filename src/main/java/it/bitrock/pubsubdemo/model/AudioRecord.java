package it.bitrock.pubsubdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AudioRecord {
    private String title;
    private String author;
    private byte[] audioBytes;
}
