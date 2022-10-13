package it.bitrock.pubsubdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("db-not-so-nice-controller")
public class DbNotSoNiceController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/getAll")
    public List<String> getTAll() {
        return this.jdbcTemplate.queryForList("select * from fantastic_table").stream()
                .map(m -> m.values().toString()).toList();
    }
}
