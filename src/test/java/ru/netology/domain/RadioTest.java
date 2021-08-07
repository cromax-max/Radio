package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {
    Radio radio = new Radio();

    @ParameterizedTest
    @CsvFileSource(resources = "/radioStation.csv")
    void shouldSetCurrentRadioWithin(int numStation) {
        radio.setCurrentRadio(numStation);
        assertEquals(numStation, radio.getCurrentRadio());
    }

    @ParameterizedTest
    @CsvSource({"-1", "10"})
    void shouldSetCurrentRadioWithout(int numStation) {
        radio.setCurrentRadio(numStation);
        assertEquals(0, radio.getCurrentRadio());
    }

    @Test
    void shouldSwitchNextRadioWithin() {
        radio.nextRadio();
        assertEquals(1, radio.getCurrentRadio());
    }

    @Test
    void shouldSwitchNextRadioWithout() {
        radio.setCurrentRadio(9);
        radio.nextRadio();
        assertEquals(0, radio.getCurrentRadio());
    }

    @Test
    void shouldSwitchPrevRadioWithin() {
        radio.setCurrentRadio(2);
        radio.prevRadio();
        assertEquals(1, radio.getCurrentRadio());
    }

    @Test
    void shouldSwitchPrevRadioWithout() {
        radio.prevRadio();
        assertEquals(9, radio.getCurrentRadio());
    }

    @Test
    void shouldTurnUpVolume() {
        //Увеличиваем "volume" более 10
        for (int i = 0; i < 11; i++) {
            radio.turnUpVolume();
        }
        assertEquals(10, radio.getVolume());
    }

    @Test
    void shouldTurnDownVolumeWithin() {
        radio.turnUpVolume();
        radio.turnUpVolume();

        radio.turnDownVolume();
        assertEquals(1, radio.getVolume());
    }

    @Test
    void shouldTurnDownVolumeWithout() {
        radio.turnDownVolume();
        assertEquals(0, radio.getVolume());
    }
}