package com.basics.readjson.util;

import com.basics.readjson.pojo.Car;
import com.basics.readjson.pojo.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {
    static String jsonStr="{\n" +
            "  \"name\":\"John\",\n" +
            "  \"age\":30,\n" +
            "  \"cars\": [\n" +
            "    { \"name\":\"Ford\", \"models\":[ \"Fiesta\", \"Focus\", \"Mustang\" ] },\n" +
            "    { \"name\":\"BMW\", \"models\":[ \"320\", \"X3\", \"X5\" ] },\n" +
            "    { \"name\":\"Fiat\", \"models\":[ \"500\", \"Panda\" ] }\n" +
            "  ]\n" +
            " }";

    public static Customer readJsonString2Mapper() throws JsonProcessingException {


        ObjectMapper mapper = new ObjectMapper();
        Customer customer = mapper.readValue(jsonStr, Customer.class);
        return customer;

    }
    public static Customer readJsonString2JsonObject() {
        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer = new Customer();
        try {
            JsonNode jsonNode = objectMapper.readValue(jsonStr, JsonNode.class);
            String name = jsonNode.get("name").asText();
            customer.setName(name);
            int age = jsonNode.get("age").asInt();
            customer.setAge(age);
            JsonNode carsObj= jsonNode.get("cars");
            List<Car> cars= new ArrayList<>();
            if(carsObj.isArray()){
                for (final JsonNode carObj : carsObj) {
                    Car car= new Car();
                    String carName = carObj.get("name").asText();
                    car.setName(carName);
                    List<String> modelList= new ArrayList<>();
                    JsonNode models= carObj.get("models");
                    if(models.isArray()){
                        for(final JsonNode modelObj : models){
                            modelList.add(String.valueOf(modelObj));
                        }
                    }

                    car.setModels(modelList);
                    cars.add(car);
                }

               customer.setCars(cars);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return customer;
    }
    }
