package it.bitrock.pubsubdemo.mapper;

import it.bitrock.pubsubdemo.entity.AudioEntity;
import it.bitrock.pubsubdemo.model.AudioRecord;
import org.springframework.stereotype.Component;

@Component
public class AudioMapper {
    public AudioRecord mapToModel(AudioEntity audioEntity) {
        return new AudioRecord(
                audioEntity.getId(),
                audioEntity.getTitle(),
                audioEntity.getAuthor(),
                audioEntity.getBytes()
        );
    }

    public AudioEntity mapToEntity(AudioRecord audioRecord) {
        return new AudioEntity(
                audioRecord.getId(),
                audioRecord.getTitle(),
                audioRecord.getAuthor(),
                audioRecord.getBytes(),
                null);
    }
}
