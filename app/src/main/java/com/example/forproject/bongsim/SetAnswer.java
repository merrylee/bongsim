package com.example.forproject.bongsim;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by forProject on 2015-07-21. 해시테이블 이용하면?
 */
public class SetAnswer {

    String getString;
    Context context;
    static String IS_IMG = "bongsim has to send img msg";

    public SQLiteDatabase db;
    public static String TABLE_NAME = "chatting";
    public List<String> keyList = new ArrayList<String>();
    String keyword;

    public SetAnswer(Context context, SQLiteDatabase db) {
        this.context = context;
        this.db = db;
    }

    MyMessage setAnswer(String get) {

        executeRawQueryKey();
        getString = get.replaceAll(" ", "");

        String msg = executeRawQueryParam(getString);

        if (executeRawQuerySelect().equals("false")) {
            return new MyMessage(msg, false);
        } else {
            MyMessage MyMessage = new MyMessage(true);
            MyMessage.setId(Integer.parseInt(msg));
            return MyMessage;
        }

    }

    private void executeRawQueryKey() {
//        println("\nexecuteRawQueryKey called.\n");

        String SQL = "select distinct (key) "
                + " from " + TABLE_NAME;
        String[] args = {};

        Cursor c1 = db.rawQuery(SQL, args);
        int recordCount = c1.getCount();
//        println("key cursor count: " + recordCount + "\n");

        for (int i = 0; i < recordCount; i++) {
            c1.moveToNext();
            String key = c1.getString(0);
            keyList.add(key);
        }
        c1.close();
    }

    private String executeRawQueryParam(String getString) {

        String SQL = "select answer from " + TABLE_NAME
                + " where key like '%'||?||'%'";

        keyword = " ";
        Iterator it = keyList.iterator();
        while (it.hasNext()) {
            String str = it.next().toString();
            if (getString.contains(str)) {
                keyword = str;
            }
        }
        String[] args = {keyword};

        Cursor c1 = db.rawQuery(SQL, args);

        int recordCount = c1.getCount();
        int index;
        List<String> answerList = new ArrayList<String>();

        if (recordCount == 0) {
            return "무슨말인지 모르겠어ㅠㅠ";
        } else {

            for (int i = 0; i < recordCount; i++) {
                c1.moveToNext();
                String answer = c1.getString(0);
                answerList.add(answer);
            }
            index = (int) (Math.random() * recordCount);
        }
        c1.close();

        return answerList.get(index);
    }

    private String executeRawQuerySelect() {  // 먼저 keyList에 keyword가 무조건 존재해야함. true인지 false인지.

        String select = "false";

        String SQL = "select image from " + TABLE_NAME
                + " where key = ?";
        String[] args = {keyword};

        Cursor c1 = db.rawQuery(SQL, args);
        int recordCount = c1.getCount();

        if (recordCount != 0) {
            c1.moveToNext();
            select = c1.getString(0);
        }

        c1.close();
        return select;
    }

}
