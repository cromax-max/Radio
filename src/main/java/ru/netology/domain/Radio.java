package ru.netology.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Radio {

    private final int amountStations;
    private int currentRadio;
    @Setter
    private int volume; //0-100, the @Setter only for testing

    public Radio() {this(10);}

    public Radio(int amountStations) {
        this.amountStations = Math.max(amountStations, 10);
    }

    public void setCurrentRadio(int currentRadio) {
        if (currentRadio < 0 || currentRadio > amountStations) {
            return;
        }
        this.currentRadio = currentRadio;
    }

    public void nextRadio() {
        if (currentRadio == amountStations) {
            currentRadio = 0;
        } else {
            currentRadio++;
        }
    }

    public void prevRadio() {
        if (currentRadio == 0) {
            currentRadio = amountStations;
        } else {
            currentRadio--;
        }
    }

    public void turnUpVolume() {
        if (volume < 100) {
            volume++;
        }
    }

    public void turnDownVolume() {
        if (volume > 0) {
            volume--;
        }
    }
}
