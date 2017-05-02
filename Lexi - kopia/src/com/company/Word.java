package com.company;

/**
 * Created by Laptop on 2017-02-06.
 */
public class Word {
    static int counter;
    String word;
    String synonym;
    double level;
    int id;

    public Word(String word, String synonym, double level) {
        this.word = word;
        this.synonym = synonym;
        this.level = level;
        this.id = counter++;
    }

    public String getWord() {
        return word;
    }

    public String getSynonym() {
        return synonym;
    }

    public double getLevel() {
        return level;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", synonym='" + synonym + '\'' +
                ", level=" + level +
                ", id=" + id +
                '}';
    }
}
