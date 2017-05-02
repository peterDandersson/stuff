package com.example.project;

import java.util.Map;

/**
 * Created by Elev1 on 2017-03-13.
 */
public class Synonyms {
    private Map<String, String> words;

    public Synonyms() {
        // loading the words
    }

    public void setWords(Map<String, String> words) {
        this.words = words;
    }

    public String getSynonyms(String word){
        return words.containsKey(word) ? words.get(word): "No synonym for " + word;
    }
}
