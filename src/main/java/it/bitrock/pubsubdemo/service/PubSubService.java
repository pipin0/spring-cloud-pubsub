package it.bitrock.pubsubdemo.service;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import it.bitrock.pubsubdemo.config.ConfigProperties;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class PubSubService {
    @Autowired
    private ConfigProperties configProperties;
    @Autowired
    private PubSubTemplate pubSubTemplate;

    @PostConstruct
    private void postConstruct() {
        readTheString();
    }

    public void publishAString(String message) throws Exception {
        val data = ByteString.copyFromUtf8(message);
        val pubsubMessage = PubsubMessage.newBuilder().setData(data).build();

        val listenableFuture = pubSubTemplate.publish(configProperties.getTF_VAR_demo_topic_name(), pubsubMessage);

        String messageId = listenableFuture.get();
        log.info("Send\n{} - {} - {}", message, messageId, System.currentTimeMillis());
    }

    private void readTheString() {
        pubSubTemplate.subscribe(configProperties.getTF_VAR_demo_subscription_name(), (message) -> {
            log.info("Read\n{} - {} - {}", message.getPubsubMessage().getData().toStringUtf8(),
                    message.getPubsubMessage().getMessageId(), System.currentTimeMillis());

            message.ack();
        });
    }
}
