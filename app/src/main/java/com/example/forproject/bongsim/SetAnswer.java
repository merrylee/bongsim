package com.example.forproject.bongsim;

import android.content.Context;

/**
 * Created by forProject on 2015-07-21. 해시테이블 이용하면?
 */
public class SetAnswer {

    String getString;
    Context context;
    static String IS_IMG = "bongsim has to send img msg";

    public SetAnswer(Context context){
        this.context = context;
    }

    Message setAnswer(String get){
        getString = get.replaceAll(" ", "");
        if(getString.contains("안녕")){
            return new Message(context.getResources().getString(R.string.hello), false);
        }
        else if(getString.contains("누구")&&getString.contains("너")){
            return new Message(context.getResources().getString(R.string.introduce), false);
        }
        else if(getString.contains("배고파")){
            return new Message(context.getResources().getString(R.string.hungry), false);
        }
        else if(getString.contains("반가워")){
            return new Message(context.getResources().getString(R.string.glad), false);
        }
        else if(getString.contains("잘가")){
            return new Message(context.getResources().getString(R.string.seeUNext), false);
        }
        else if(getString.contains("오늘점심")){
            Message message = new Message(true);
            message.setId(R.drawable.meatsteak);
            return message;
        }
        else if((getString.contains("너")||getString.contains("니")&&getString.contains("사진"))){
            Message message = new Message(true);
            message.setId(R.drawable.bonbon);
            return message;
        }
        else{
            return new Message(context.getResources().getString(R.string.dontknow), false);
        }
    }
}
