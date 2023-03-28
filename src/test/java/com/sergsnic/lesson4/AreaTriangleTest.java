package com.sergsnic.lesson4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AreaTriangleTest {
    AreaTriangle triangle;
    private static final Logger logger = LoggerFactory.getLogger("AreaTriangleTest");

    @BeforeEach
    void beforeEach() {
        triangle = new AreaTriangle();
        logger.info("Выполняется перед каждым тестом");
        //System.out.println("Выполняется перед всеми тестами");
    }

    @Test
    void areaTriangleTest() throws AreaTriangleException {
        double result = triangle.areaTriangle(25, 25, 30);
        Assertions.assertEquals(300, result);
    }

    @ParameterizedTest
    @CsvSource({"25, 25, 30"})
    void areaTriangleTest2(double a, double b, double c) throws AreaTriangleException {
        double result = triangle.areaTriangle(a, b, c);
        Assertions.assertEquals(300, result);
    }

    @ParameterizedTest
    @CsvSource({"25, 25, 0", "1, 1, 3", "1, 1, 2"})
    void areaTriangleTest3(double a, double b, double c) {
        Assertions.assertThrows(AreaTriangleException.class, () -> triangle.areaTriangle(a, b, c));
        logger.error("Проверка на корректность данных.");
    }
    @AfterEach
    void afterEach() {
        triangle = new AreaTriangle();
        logger.info("Выполняется после каждого теста");
        //System.out.println("Выполняется перед всеми тестами");
    }
}
