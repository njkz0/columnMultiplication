package actoins;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionsTest {

    @Test
    void getSpaces(int i) {
        StringBuilder result = new StringBuilder("");
        result.append(Actions.getSpaces(4));
        assertEquals("    ", result);
    }

    @Test
    void getLines() {
        StringBuilder result = new StringBuilder("");
        result.append(Actions.getLines(4));
        assertEquals("____", result);
    }
}