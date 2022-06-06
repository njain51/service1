package com.nitin.demo.service1.controller;/**
 * @author : Nitin Jain
 * @mailto : official.nitinjain@gmail.com
 * @created : 6/5/2022, Sunday
 **/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 What this program snippet doing?
 **/
@RestController
public class Service1Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Service1Controller.class);

    @Autowired
    private RestTemplate restTemplate;


    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


    @GetMapping("/home")
    public String Service1Home(){
        LOGGER.info("This is Service1 Controller Homepage");
        return "This is Service1 Controller Home page";
    }

    @GetMapping("/serviceOne")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getServiceTwo(){

        LOGGER.info("I am here is Service1 and calling Service2 now");
        RestTemplate restTemplate = new RestTemplate();
        String sleuthResourceUrl
                = "http://localhost:8082/serviceTwo";  //pointing to service2
        String response
                = restTemplate.getForObject(sleuthResourceUrl, String.class);

        return new ResponseEntity<String>(response,HttpStatus.OK);
    }

}
