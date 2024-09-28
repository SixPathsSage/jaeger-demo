package org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@RestController
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.host}")
    private String serviceHost;

    @Value("${service.port}")
    private String servicePort;


    Logger logger = Logger.getLogger(ClientController.class.getName());

    @GetMapping("/ping")
    public String pong() {
        return "pong";
    }

    @GetMapping("/call")
    public String call() {
        String url = "http://" + serviceHost + ":" + servicePort + "/ping";
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/call/{id}")
    public String call(@PathVariable("id") int id) {
        String url = "http://" + serviceHost + ":" + servicePort + "/call/"+ id;
        logger.info("Client API Called " + id);
        return restTemplate.getForObject(url, String.class);
    }
}
