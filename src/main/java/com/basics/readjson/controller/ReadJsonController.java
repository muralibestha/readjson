package com.basics.readjson.controller;

import com.basics.readjson.pojo.Customer;
import com.basics.readjson.util.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadJsonController {

    @RequestMapping(value = "/readJson2Mapper")
    public Customer readJson2Mapper() throws JsonProcessingException {
        final Customer customer = JsonUtil.readJsonString2Mapper();
        return customer;
    }
    @RequestMapping(value = "/readJson")
    public Customer read() throws JsonProcessingException {
        final Customer customer = JsonUtil.readJsonString2JsonObject();
        return customer;
    }
}
