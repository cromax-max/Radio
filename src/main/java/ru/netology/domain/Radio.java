package ru.netology.domain;

public class Radio {

    private int currentRadio; //0-9
    private int volume; //0-10

    public int getCurrentRadio() {
        return currentRadio;
    }

    public void setCurrentRadio(int currentRadio) {
        if (currentRadio >= 0 && currentRadio <= 9) {
            this.currentRadio = currentRadio;
        }
    }

    public int getVolume() {
        return volume;
    }

    public void nextRadio() {
        if (currentRadio == 9) {
            currentRadio = 0;
        } else {
            currentRadio++;
        }
    }

    public void prevRadio() {
        if (currentRadio == 0) {
            currentRadio = 9;
        } else {
            currentRadio--;
        }
    }

    public void turnUpVolume() {
        if (volume < 10) {
            volume++;
        }
    }

    public void turnDownVolume() {
        if (volume > 0) {
            volume--;
        }
    }
}
