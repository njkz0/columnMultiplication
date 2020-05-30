package info.sjd.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionsTest {



    @Test
    void columnMultiplication() {
        String result=Actions.columnMultiplication(123,12);
        assertEquals(" 123\n" +
                "  12\n" +
                " ___\n" +
                " 246\n" +
                "123\n" +
                "____\n" +
                "1476", result);
    }
}