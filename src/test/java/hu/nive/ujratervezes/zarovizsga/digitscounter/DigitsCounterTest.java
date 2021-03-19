package hu.nive.ujratervezes.zarovizsga.digitscounter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DigitsCounterTest {

    @Test
    void getCountOfDigits() {
        DigitsCounter digitsCounter = new DigitsCounter();

        assertEquals(0, digitsCounter.getCountOfDigits(null));
        assertEquals(0, digitsCounter.getCountOfDigits(""));
        assertEquals(1, digitsCounter.getCountOfDigits("1"));
        assertEquals(2, digitsCounter.getCountOfDigits("111112222"));
        assertEquals(3, digitsCounter.getCountOfDigits("1212123123123123"));
        assertEquals(3, digitsCounter.getCountOfDigits("12asd 12ewr1q2breg31 rw23123123"));
    }

    @Test
    void getCountOfDigitsWithoutSplit() {
        DigitsCounter digitsCounter = new DigitsCounter();

        assertEquals(0, digitsCounter.getCountOfDigitsWithoutSplit(null));
        assertEquals(0, digitsCounter.getCountOfDigitsWithoutSplit(""));
        assertEquals(1, digitsCounter.getCountOfDigitsWithoutSplit("1"));
        assertEquals(2, digitsCounter.getCountOfDigitsWithoutSplit("111112222"));
        assertEquals(3, digitsCounter.getCountOfDigitsWithoutSplit("1212123123123123"));
        assertEquals(3, digitsCounter.getCountOfDigitsWithoutSplit("12asd 12ewr1q2breg31 rw23123123"));
    }
}