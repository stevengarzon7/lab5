package edu.eci.cvds.servlet.model;

/**
 *
 */
public class Todo {
    private int userId; 
    private int id; 
    private String title;
    private boolean completed;
    public Todo(){
    }
    public int getUserId(){
        return userId;
    }
    public void setUserId(int user){
        userId = user;
    }
    public int getId(){
        return id;
    }
    public void setId(int Id){
        id = Id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String titulo){
        title = titulo;
    }
    public boolean getCompleted(){
        return completed; 
    }
    public void setCompleted(boolean state){
        completed = state; 
    }
    

    

    }