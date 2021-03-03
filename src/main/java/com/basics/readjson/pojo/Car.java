package com.basics.readjson.pojo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "models"
})
public class Car {

    @JsonProperty("name")
    private String name;
    @JsonProperty("models")
    private List<String> models = null;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("models")
    public List<String> getModels() {
        return models;
    }

    @JsonProperty("models")
    public void setModels(List<String> models) {
        this.models = models;
    }

}
