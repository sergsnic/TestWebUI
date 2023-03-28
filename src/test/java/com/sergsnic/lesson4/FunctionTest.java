package com.sergsnic.lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static com.sergsnic.lesson4.Functions.isPalindrome;

public class FunctionTest {
    private static Logger logger = LoggerFactory.getLogger("FunctionTest");

    @BeforeAll
    static void beforeAll() {
        logger.info("Выполняется один раз перед всеми тестами");
        //System.out.println("Выполняется один раз перед всеми тестами");
    }
    @BeforeEach
    void beforeEach(){
//        System.out.println("Выполняется один раз перед каждым тестом");
        logger.error("Выполняется один раз перед каждым тестом");
    }

    @Test
    @DisplayName("Метод проверки палиндрома, переданного в метод isPalindrom")
    void givenPalindromeWhenCallisPalindromeMethodThenTrue() {
        Object Palindrome;
        boolean result = isPalindrome("123321");
        Assertions.assertTrue(result);
        Assertions.assertEquals(true, result);
    }


    @Test
    @DisplayName("Метод проверки палиндрома, переданного в метод isPalindrom")
    void givenPalindromeWhenCallisPalindromeMethodThenTrue2() {
        Object Palindrome;
        boolean result = isPalindrome("123321");
        Assertions.assertTrue(result);
        Assertions.assertEquals(true, result);
    }
    @ParameterizedTest
    @ValueSource(strings = {"121","123321"})
    void isPalindromeMethodThenTrue(String word) {
        boolean result = isPalindrome(word);
        Assertions.assertTrue(result);
    }
    @ParameterizedTest
    @Tag("smoke")
    @CsvSource({"123, false","123321, true"})
    void csvSourcePalindrom(String word, boolean expectedResult){
        boolean actualResult = isPalindrome(word);
        Assertions.assertEquals(expectedResult, actualResult);
    }
    @ParameterizedTest
    @MethodSource("catAndAgeDataProvaider")
    void catEqualAgeTest(Cat cat, Integer age){
        Assertions.assertEquals(cat.getAge(), age);
    }
    private static Stream<Arguments> catAndAgeDataProvaider() {
        return Stream.of(
                Arguments.of(new Cat("Test1", 10), 10),
                Arguments.of(new Cat("Test2", 11), 11)
        );
    }
    @AfterEach
    void afterEach(){
        System.out.println("Выполняется один раз после каждого теста");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Выполняется один раз после всех тестов");
    }
}
