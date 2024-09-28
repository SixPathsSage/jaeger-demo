package org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@RestController
public class ServerController {

    @Autowired
    private RestTemplate restTemplate;

    Logger logger = Logger.getLogger(ServerController.class.getName());

    @GetMapping("/ping")
    public String pong() {
        return "call-pong";
    }

    @GetMapping("/call/{id}")
    public String call(@PathVariable("id") int id) {
        String url = "http://numbersapi.com/"+ id;
        logger.info("Client API Called " + id + " url " + url);
        return restTemplate.getForObject(url, String.class);
    }
}
