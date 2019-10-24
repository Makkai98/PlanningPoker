package com.example.planningpoker;

public class Voter {

    public static final String TABLE_NAME = "Voters";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_QUESTION = "question";
    public static final String COLUMN_ANSWER = "answer";


    public static final String CREATE_TABLE =
            "CREATE TABLE" + TABLE_NAME + "("
                    + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NAME + "TEXT"
                    + COLUMN_QUESTION + "TEXT"
                    + COLUMN_ANSWER + "TEXT"
                    + ")";

    private int id;
    private String name;
    private String question;
    private String answer;


    public Voter(Integer id, String name, String question, String answer)
    {
        this.id=id;
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