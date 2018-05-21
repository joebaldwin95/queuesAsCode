package com.qac.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qac.model.Queue;

public class MainController {
    
    public static void main(String[] args) {       
        
        final Logger logger = LogManager.getLogger();
        
        logger.info("Initialising Config");
        
        List<Queue> queuesList = ConfigReader.readConfig("src/main/resources/queues.json");
        
        logger.info("Config Initialised");
        
        logger.info("Creating Queues");
        
        QueueGenerator.createQueues(queuesList);
                
    }

}