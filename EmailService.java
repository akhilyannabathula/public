package com.orm.project.Threads;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.json.simple.parser.JSONParser;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmailService {
    //using rest template as web client to consume webservices
    private static RestTemplate restTemplate = new RestTemplate();
    private static JSONParser jsonParser  = new JSONParser();

    //return list of emails for given list of urls
    public static List<String> getAllEmails(List<String> urls ) throws ParseException {
        List<String> emails = new ArrayList<>();
        ResponseEntity<String> response;
        JSONObject jsonObject;

        for (String url : urls){
             response = restTemplate.getForEntity(url,String.class);
             jsonObject = (JSONObject) jsonParser.parse(response.getBody());
             emails.add( ((JSONObject)jsonObject.get("data")).get("email").toString() );
        }
        return emails;
    }

    public static void main(String[] args) throws ParseException {
        List<String> urls = Arrays.asList("https://reqres.in/api/users/1","https://reqres.in/api/users/3","https://reqres.in/api/users/10");
        List<String> emails = getAllEmails(urls);
        System.out.println(emails);
    }
}
