package com.qac.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qac.model.Queue;

public class QueueGenerator {
    
    final static Logger logger = LogManager.getLogger();
    protected static String token = APIHandler.authorise();
    
    public static int createQueues(List<Queue> qList) {      
        
        for(Queue q : qList){
            createQueue(q);
        }
        return 200;
    }
    
    private static int createQueue(Queue q){
        
        APIHandler.createQueue(q, token);
        
        logger.info("Queue Created");
        
        return 200;
    }

}
