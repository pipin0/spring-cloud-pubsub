package it.bitrock.pubsubdemo.service;

import it.bitrock.pubsubdemo.entity.AudioEntity;
import it.bitrock.pubsubdemo.mapper.AudioMapper;
import it.bitrock.pubsubdemo.model.AudioRecord;
import it.bitrock.pubsubdemo.repository.AudioRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class AudioService {
    @Autowired
    AudioMapper audioMapper;
    @Autowired
    AudioRepository audioRepository;

    public List<AudioRecord> getAll() {
        return audioRepository.findAll().stream()
                .map(audioMapper::mapToModel).toList();
    }

    public AudioRecord save(AudioRecord audioRecord) {
        val audioEntityToSave = getEntityToSave(audioRecord);
        return audioMapper.mapToModel(
                audioRepository.save(audioEntityToSave)
        );
    }

    private AudioEntity getEntityToSave(AudioRecord audioRecord) {
        val actualMillis = ZonedDateTime.now().withZoneSameInstant(ZoneOffset.UTC).toInstant().toEpochMilli();

        return new AudioEntity(
                null,
                audioRecord.getTitle(),
                audioRecord.getAuthor(),
                audioRecord.getBytes(),
                actualMillis);
    }

    public void delete(Long id) {
        audioRepository.deleteById(id);
    }
}
