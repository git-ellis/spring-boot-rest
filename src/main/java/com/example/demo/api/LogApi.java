package com.example.demo.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogApi {
    private final Logger logger = LoggerFactory.getLogger(LogApi.class);

    @GetMapping("/log")
    public String log() {
        logger.debug("-----debug-----");
        logger.info("-----info-----");
        logger.warn("-----warn-----");
        logger.error("-----error-----");

        return "log test";
    }
}
