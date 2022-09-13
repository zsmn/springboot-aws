package com.zsmn.springbootaws.controller;

import com.zsmn.springbootaws.adapter.dto.Request;
import com.zsmn.springbootaws.service.SpringBootAwsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("request")
public class SpringBootAwsController {
    private SpringBootAwsService service;

    @Autowired
    SpringBootAwsController(SpringBootAwsService service) {
        this.service = service;
    }

    @PostMapping("/test")
    public ResponseEntity<String> test(@RequestBody Request request) {
        try {
            this.service.teste(request.getText());
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok("success");
    }
}
