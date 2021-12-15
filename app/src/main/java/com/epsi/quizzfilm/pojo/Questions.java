package com.epsi.quizzfilm.pojo;

import java.io.Serializable;
import java.util.List;

public class Questions implements Serializable {
    private int id;
    private  String text;
    private boolean answer;

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean GetAnswer() {
        return answer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
    public Questions(){

    }

    public Questions(int Id, String Text, boolean Answer){
        this.id = Id;
        this.text = Text;
        this.answer = Answer;
    }



}
