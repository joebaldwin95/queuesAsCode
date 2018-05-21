package com.qac.controller;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

import com.qac.model.Queue;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIHandler {

    protected final static String username = System.getProperty("username");
    protected final static String password = System.getProperty("password");
    private final static String region = System.getProperty("region");

    private static RequestSpecification request;

    final static Logger logger = LogManager.getLogger();

    @SuppressWarnings("unchecked")
    public static String authorise() {

        try {
            logger.debug("Attempting to Authorise");

            String url = "https://anypoint.mulesoft.com/accounts/login";

            JSONObject requestBody = new JSONObject();

            requestBody.put("username", username);
            requestBody.put("password", password);

            request = given().header("Content-Type", "application/json").body(requestBody);

            Response authResponse = request.when().post(url);

            JsonPath responseBody = new JsonPath(authResponse.getBody().asString());

            String response = responseBody.get("access_token");

            logger.debug("Authorised Successfully");

            return response;

        } catch (Exception e) {
            logger.error(
                    "An error was encountered while trying to authorise your client credentials.");
            logger.error(e.getMessage());
        }
        return null;

    }

    @SuppressWarnings("unchecked")
    public static int createQueue(Queue q, String token) {

        logger.debug("Attempting to Create Queue: " + q.getName());

        String url = "https://anypoint.mulesoft.com/mq/admin/api/v1/organizations/" + q.getOrgId()
                + "/environments/" + q.getEnvId() + "/regions/" + region + "/destinations/queues/"
                + q.getName();

        JSONObject requestBody = new JSONObject();
        requestBody.put("defaultTtl", "120000");
        requestBody.put("defaultLockTtl", "10000");
        requestBody.put("encrypted", q.isEncrypted());
        requestBody.put("fifo", q.isFifo());

        logger.info(requestBody.toJSONString());

        request = given().header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json").body(requestBody.toJSONString());

        Response authResponse = request.when().put(url);

        logger.debug("Status Code: " + authResponse.getStatusCode());

        return 0;

    }

}
