package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    void testAdd_positiveNumbers() {
        App app = new App();
        Assertions.assertEquals(5, app.add(2, 3), "2 + 3 should be 5");
    }

    @Test
    void testGreet_withName() {
        App app = new App();
        Assertions.assertEquals("Hello, Asma", app.greet("Asma"));
    }

    @Test
    void testGreet_nullName() {
        App app = new App();
        Assertions.assertEquals("Hello, Guest", app.greet(null));
    }
}

