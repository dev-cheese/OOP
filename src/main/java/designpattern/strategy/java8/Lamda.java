package designpattern.strategy.java8;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Lamda {

    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        final String result = numbers.stream()
                .map(String::valueOf)
                .collect(joining(" : "));
        System.out.println(result);
    }
}

interface Say {
    int something(int a, int b);
}

class Person {
    public void greeting(Say line) {
        int num = line.something(3, 5);
        System.out.println("number is " + num);
    }
}

class Main {

    public static void main(String[] args) {

        Person p = new Person();
        p.greeting(new Say() {
            @Override
            public int something(int a, int b) {
                System.out.println("xxx ");
                System.out.println("parameter is value are " + a + "" + "" + b);
                return 10;
            }
        });

        p.greeting((a, b) -> {
            System.out.println("lamda");
            System.out.println("parameter is value are " + a + "" + "" + b);
            return 7;
        });
    }

}
