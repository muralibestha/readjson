package com.basics.readjson.util;

import com.basics.readjson.pojo.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    public static Customer readJsonString() throws JsonProcessingException {

        String jsonStr="{\n" +
                "  \"name\":\"John\",\n" +
                "  \"age\":30,\n" +
                "  \"cars\": [\n" +
                "    { \"name\":\"Ford\", \"models\":[ \"Fiesta\", \"Focus\", \"Mustang\" ] },\n" +
                "    { \"name\":\"BMW\", \"models\":[ \"320\", \"X3\", \"X5\" ] },\n" +
                "    { \"name\":\"Fiat\", \"models\":[ \"500\", \"Panda\" ] }\n" +
                "  ]\n" +
                " }";
        ObjectMapper mapper = new ObjectMapper();
        Customer customer = mapper.readValue(jsonStr, Customer.class);
        return customer;

    }
}
