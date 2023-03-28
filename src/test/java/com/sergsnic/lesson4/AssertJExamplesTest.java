package com.sergsnic.lesson4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJExamplesTest {
    @Test
    void assertExample(){
        assertThat(Functions.isPalindrome("123456")).isFalse();
    }
}
