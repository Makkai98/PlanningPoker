package com.example.planningpoker;
public class User
{
    public static final String TABLE_NAME = "Users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";


    public static final String CREATE_TABLE =
            "CREATE TABLE" + TABLE_NAME + "("
                    + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NAME + "TEXT"
                    + ")";
    public String name;
    public int id;

    public User()
    {

    }

    public  User(int id,String name)
    {
        this.id=id;
        this.name=name;
    }

    public String getName()
    {
        return name;
    }

    public Integer getId()
    {
        return id;
    }


    public void setName(String name)
    {
        this.name=name;
    }

    public void setId(int id)
    {
        this.id=id;
    }

}
