package it.bitrock.pubsubdemo.controller;

import it.bitrock.pubsubdemo.model.AudioRecord;
import it.bitrock.pubsubdemo.service.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("audio")
public class AudioController {
    @Autowired
    AudioService audioService;

    @GetMapping("/getAll")
    public List<AudioRecord> getAll() {
        return audioService.getAll();
    }

    @PostMapping("save")
    public AudioRecord save(@RequestBody AudioRecord audioRecord) {
        return audioService.save(audioRecord);
    }

    @GetMapping("/delete")
    public void delete(@RequestParam Long id) {
        audioService.delete(id);
    }
}
