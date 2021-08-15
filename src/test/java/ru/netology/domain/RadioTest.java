package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {
    int amountStations = 77;
    Radio radio = new Radio(amountStations);

    @Test
    void shouldSetAmountStations() {
        assertEquals(amountStations, radio.getAmountStations());
    }

    @ParameterizedTest
    @CsvSource({"-5", "3", "10"})
    void shouldSetAmountStationsWithin(int amountStations) {
        Radio radio = new Radio(amountStations);
        assertEquals(10, radio.getAmountStations());
    }

    @Test
    void shouldSetAmountStationsDefault() {
        Radio radio = new Radio();
        assertEquals(10, radio.getAmountStations());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/radioStation.csv")
    void shouldSetCurrentRadioWithin(int numStation) {
        radio.setCurrentRadio(numStation);
        assertEquals(numStation, radio.getCurrentRadio());
    }

    @ParameterizedTest
    @CsvSource({"-1", "0", "11"})
    void shouldSetCurrentRadioWithout(int numStation) {
        Radio radio = new Radio();
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
        radio.setCurrentRadio((amountStations - 1));
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
        assertEquals((amountStations - 1), radio.getCurrentRadio());
    }

    @Test
    void shouldTurnUpVolumeWithin() {
        radio.turnUpVolume();
        assertEquals(1, radio.getVolume());
    }

    @Test
    void shouldTurnUpVolumeWithout() {
        radio.setVolume(100);
        radio.turnUpVolume();
        assertEquals(100, radio.getVolume());
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