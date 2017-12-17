package com.e.s.wordplay;

/**
 * Created by Kunnu on 12/17/2017.
 */

public class Round {

    private int id;
    private String word;

    public Round(){};

    public Round(int id, String word) {
        this.id = id;
        this.word = word;

    }



    public void setId(int id) {
        this.id = id;
    }


    public void setWord(String word) {
        this.word = word;
    }

}
