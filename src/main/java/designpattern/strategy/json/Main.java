package designpattern.strategy.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String json = "{\n" +
                "  \"age\": 25,\n" +
                "  \"name\": {\n" +
                "    \"firstName\": \"길동\",\n" +
                "    \"lastName\": \" 홍\"\n" +
                "  }\n" +
                "} ";

        ObjectMapper objectMapper = new ObjectMapper();

        Person p = objectMapper.readValue(json, Person.class);

        System.out.println(p.getAge());



    }
}
