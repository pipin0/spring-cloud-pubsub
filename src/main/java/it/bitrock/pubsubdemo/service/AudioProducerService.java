package it.bitrock.pubsubdemo.service;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import it.bitrock.pubsubdemo.config.ConfigProperties;
import it.bitrock.pubsubdemo.model.AudioRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

@Slf4j
@Component
public class AudioProducerService {
    @Autowired
    private ConfigProperties configProperties;
    @Autowired
    private PubSubTemplate pubSubTemplate;

    public String publish(AudioRecord audioRecord) {
        try {
            return pubSubTemplate.publish(configProperties.getTF_VAR_audio_topic_name(), audioRecord).get();
        } catch (CancellationException | ExecutionException | InterruptedException e) {
            log.error(e.getMessage());
            return e.getMessage();
        }
    }
}
