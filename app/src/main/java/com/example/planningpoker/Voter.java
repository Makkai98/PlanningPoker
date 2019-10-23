package com.example.planningpoker;

public class Voter {

    int id;
    String name;
    String question;
    String answer;

    public Voter(String name, String question, String answer)
    {
        this.name=name;
        this.question = question;
        this.answer = answer;
    }

    public Voter()
    {

    }

    //getting id
    public int getId() {
        return id;
    }
    //setting id
    public void setId(int id) {
        this.id = id;
    }
    //getting name
    public String getName() {
        return name;
    }
    //setting name
    public void setName(String name) {
        this.name = name;
    }

    public String getQuestion() {
        return question;
    }
    //setting name
    public void setQuestion (String question) {
        this.question = question;
    }
    //getting password
    public String getAnswer() {
        return answer;
    }
    //setting password
    public void setAnswer (String answer) {
        this.answer = answer;
    }

}