package com.qac.controller;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.qac.model.Queue;

public class ConfigReader {

    public static List<Queue> readConfig(String filePath) {

        try {

            final Logger logger = LogManager.getLogger();

            List<Queue> queuesList = new ArrayList<Queue>();

            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("queues");

            logger.debug(jsonArray.size() + " Queues to read");

            for (int i = 0; i < jsonArray.size(); ++i) {
                JSONObject rec = (JSONObject) jsonArray.get(i);

                String name = (String) rec.get("name");

                logger.debug("Adding " + name);

                queuesList.add(
                        new Queue(name, (boolean) rec.get("fifo"), (boolean) rec.get("encrypted"),
                                (boolean) rec.get("dlq"), (String) rec.get("dlqName"),
                                (long) rec.get("maxDelivery"), (String) rec.get("orgId"), (String) rec.get("envId")));

            }

            return queuesList;

        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;

    }

}
