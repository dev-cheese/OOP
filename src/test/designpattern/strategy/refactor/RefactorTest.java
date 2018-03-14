package designpattern.strategy.refactor;

import org.junit.Test;


class RefactorTest {

    private String kim;
    public static final String YUN = "Yun";

    @Test
    public void printFullName() {
        printFullName(YUN, kim);
    }

    private String printFullName(String firstName, String lastName) {
        return firstName + lastName;
    }

}