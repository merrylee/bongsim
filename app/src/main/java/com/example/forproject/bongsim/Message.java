package com.example.forproject.bongsim;

/**
 * Created by forProject on 2015-07-20.
 */
public class Message {

    String message;
    boolean isMine;
    int isImgAsw; // 0:text, 1:img
    int id;

    public Message(){
        super();
        isMine = false;
        isImgAsw = 0;
    }

    public Message(String message, boolean isMine){
        super();
        this.message = message;
        this.isMine = isMine;
        this.isImgAsw = 0;
    }

    public Message(boolean isImgAsw){
        super();
        this.isMine = false;
        this.isImgAsw = 1;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public boolean isMine(){
        return  isMine;
    }

    public void setMine(boolean isMine){
        this.isMine = isMine;
    }

    public int IsImgAsw(){
        return isImgAsw;
    }
    /*
    public void setStatusMessage(boolean isStatusMessage){
        this.isStatusMessage = isStatusMessage;
    }*/

}
