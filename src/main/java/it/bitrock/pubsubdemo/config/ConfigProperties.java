package it.bitrock.pubsubdemo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Data
@Component
@ConfigurationProperties
public class ConfigProperties {
    @NotBlank
    @Value("${TF_VAR_demo_subscription_name}")
    private String TF_VAR_demo_subscription_name;
    @NotBlank
    @Value("${TF_VAR_demo_topic_name}")
    private String TF_VAR_demo_topic_name;
    @NotBlank
    @Value("${TF_VAR_audio_subscription_name}")
    private String TF_VAR_audio_subscription_name;
    @NotBlank
    @Value("${TF_VAR_audio_topic_name}")
    private String TF_VAR_audio_topic_name;
}
