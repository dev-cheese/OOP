package designpattern.strategy.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.List;
import java.util.TimeZone;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void jsonToObject() throws IOException {


        String json = "{\n" +
                "  \"age\": 25,\n" +
                "  \"name\": {\n" +
                "    \"firstName\": \"길동\",\n" +
                "    \"lastName\": \"홍\"\n" +
                "  }\n" +
                "} ";

        ObjectMapper objectMapper = new ObjectMapper();
        Person p = objectMapper.readValue(json, Person.class);

        assertThat(p.getAge(), is(25));
        assertThat(p.getName().getFirstName(), is("길동"));
        assertThat(p.getName().getLastName(), is("홍"));

    }

    @Test
    public void rootPathTest() {
        String rootPath = System.getProperty("user.dir");
    }

    @Test
    public void name() {

        File f = new File("/Users/yun/yun/proejct/cheese/ref/OOP/src/main/temp/test.png");

        if (f.delete())
            assertThat(true, is(true));
        else
            assertThat(true, is(false));
    }

    @Test
    public void test2() {

        String rootPath = System.getProperty("user.dir");
        File file = new File("/src/main/temp/test.json");

    }

    @Test
    public void time() {
        LocalDateTime now = LocalDateTime.now();

        System.out.println("Before : " + now);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        String formatDateTime = now.format(formatter);

        System.out.println("After : " + formatDateTime);

    }

    @Test
    public void timestampToLocalDateTime() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        now.toLocalDateTime().format(formatter);
    }

    @Test
    public void boolean_ModelMappber_() {

        ModelMapper modelMapper = new ModelMapper();

        Yun yun = new Yun();
        yun.setAge(10);
//        yun.setMan(true);

        Person p = modelMapper.map(yun, Person.class);

        System.out.println(p);


    }

    @Test
    public void name1() {
        // Use of getInstance() method to 'AUD' instance
        Currency c1 = Currency.getInstance("AUD"); //Australian Dollar
        Currency c2 = Currency.getInstance("JPY");  //Japan Yen
        Currency c3 = Currency.getInstance("USD");  //Japan Yen

        // Use of getCurrencyCode() method
        String cCode1 = c1.getCurrencyCode();
        String cCode2 = c2.getCurrencyCode();
        System.out.println("Australian Dollar code : " + cCode1);
        System.out.println("Japan Yen code : " + cCode2);
        System.out.println("");

        // Use of getDefaultFractionDigits() method
        int D1 = c1.getDefaultFractionDigits();
        System.out.println("AUD Fraction digits : " + D1);

        int D2 = c2.getDefaultFractionDigits();
        System.out.println("JPY fraction digits : " + D2);
        System.out.println("");

        // Use of getDisplayName() method
        System.out.println("AUD Display : " + c1.getDisplayName());
        System.out.println("JPY Display : " + c2.getSymbol());
        System.out.println("");

        // Use of getSymbol() method
        System.out.println("JPY Symbol : " + c2.getSymbol());
        System.out.println("USD Symbol : " + c3.getSymbol());
    }

    public class Yun {
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    }

    @Test
    public void ttttt() throws IOException {

        String json = "{\n" +
                "    \"results\": [\n" +
                "        {\n" +
                "            \"id\": 27,\n" +
                "            \"name\": \"ShinHyup Bank\",\n" +
                "            \"country\": \"Republic Of Korea\",\n" +
                "            \"branches\": [\n" +
                "                {\n" +
                "                    \"id\": 28,\n" +
                "                    \"name\": \"ShinHyup Bank\",\n" +
                "                    \"address\": \"\",\n" +
                "                    \"city\": \"\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 29,\n" +
                "            \"name\": \"VietinBank\",\n" +
                "            \"country\": \"Vietnam\",\n" +
                "            \"branches\": [\n" +
                "                {\n" +
                "                    \"id\": 30,\n" +
                "                    \"name\": \"VietinBank\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 30,\n" +
                "            \"name\": \"MB Bank\",\n" +
                "            \"country\": \"Vietnam\",\n" +
                "            \"branches\": [\n" +
                "                {\n" +
                "                    \"id\": 31,\n" +
                "                    \"name\": \"MB Bank\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"paging\": {\n" +
                "        \"total_count\": 29\n" +
                "    }\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        Dto dto = objectMapper.readValue(json, Dto.class);


        System.out.println(objectMapper.writeValueAsString(dto));


    }
}