package it.bitrock.pubsubdemo.service;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import it.bitrock.pubsubdemo.config.ConfigProperties;
import it.bitrock.pubsubdemo.model.AudioRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class AudioConsumerService {
    @Autowired
    private ConfigProperties configProperties;
    @Autowired
    private PubSubTemplate pubSubTemplate;
    @Autowired
    private AudioService audioService;

    @PostConstruct
    private void postConstruct() {
        read();
    }

    private void read() {
        pubSubTemplate.subscribeAndConvert(
                configProperties.getTF_VAR_audio_subscription_name(),
                message -> {
                    audioService.save(message.getPayload());
                    message.ack();
                },
                AudioRecord.class
        );
    }
}
