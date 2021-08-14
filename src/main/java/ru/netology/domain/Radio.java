package ru.netology.domain;

public class Radio {

    private final int amountStations;
    private int currentRadio;
    private int volume; //0-100

    public Radio() {this(10);}

    public Radio(int amountStations) {
        this.amountStations = Math.max(amountStations, 10);
    }

    public int getAmountStations() {
        return amountStations;
    }

    public int getCurrentRadio() {
        return currentRadio;
    }

    public void setCurrentRadio(int currentRadio) {
        if (currentRadio < 0 || currentRadio > amountStations) {
            return;
        }
        this.currentRadio = currentRadio;
    }

    public int getVolume() {
        return volume;
    }

    //only for testing
    public void setVolume(int volume) {
        this.volume = volume;
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
