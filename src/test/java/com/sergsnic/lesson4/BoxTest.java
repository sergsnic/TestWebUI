package com.sergsnic.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BoxTest {
    Box box;
    @Nested
    class WhenEmptyBox{
        @BeforeEach
        void creatEmptyBox() {
            box = new Box();
        }
        @Test
        void whenDeleteBallThenException(){
            Assertions.assertThrows(BoxIsEmptyException.class, () -> box.deleteBall());
        }
        @Nested
        class WhenOneBall{
            @BeforeEach
            void addBall(){
                box.addBall();
            }
            @Test
            void deleteBall() throws BoxIsEmptyException {
                box.deleteBall();
                Assertions.assertEquals(0, box.getBallCount());
            }

        }
    }
}
