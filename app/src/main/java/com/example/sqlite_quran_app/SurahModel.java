package com.example.sqlite_quran_app;

public class SurahModel {
    String surahNameE;
    int surahID;

    public SurahModel(String surahNameE, int surahID) {
        this.surahID = surahID;
        this.surahNameE = surahNameE;
    }

    public String getSurahNameE() {
        return surahNameE;
    }

    public void setSurahNameE(String surahNameE) {
        this.surahNameE = surahNameE;
    }

    public int getSurahID() {
        return surahID;
    }

    public void setSurahID(int surahID) {
        this.surahID = surahID;
    }
}
