package designpattern.strategy.json;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    private int age;
    private boolean man;
    private Name name;

    @Getter
    @Setter
    static class Name {
        private String firstName;
        private String lastName;

    }
}





