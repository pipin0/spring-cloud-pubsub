package it.bitrock.pubsubdemo.controller;

import it.bitrock.pubsubdemo.service.PubSubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PubSubController {
    @Autowired
    private PubSubService pubSubService;

    @PostMapping("pub-sub")
    public void pubSub(@RequestBody String message) throws Exception {
        pubSubService.publish(message);
    }
}
