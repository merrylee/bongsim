package com.example.forproject.bongsim;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by User on 2015-07-23.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "bongsimDB";
    private static int DATABASE_VERSION = 1;
    private static String TABLE_NAME = "chatting";

    public String TAG;
//    public TextView status;

    public DatabaseHelper(Context context, String tag) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        this.TAG = tag;
//        this.status = status;
    }

    public void onCreate(SQLiteDatabase db) {
//        println("creating table [" + TABLE_NAME + "].");

        try {
            String DROP_SQL = "drop table if exists " + TABLE_NAME;
            db.execSQL(DROP_SQL);
        } catch(Exception ex) {
            Log.e(TAG, "Exception in DROP_SQL", ex);
        }

        String CREATE_SQL = "create table " + TABLE_NAME + "("
                + " _id integer PRIMARY KEY autoincrement, "
                + " key text, " + " answer text, " + " image text)";

        try {
            db.execSQL(CREATE_SQL);
        } catch(Exception ex) {
            Log.e(TAG, "Exception in CREATE_SQL", ex);
        }

//        println("inserting records.");
        try {
            db.execSQL("insert into " + TABLE_NAME + "(key, answer, image) values ('선민', '수진이~', 'false');" );
            db.execSQL("insert into " + TABLE_NAME + "(key, answer, image) values ('선민', '응응?', 'false');");
            db.execSQL("insert into " + TABLE_NAME + "(key, answer, image) values ('선민', '뭐', 'false');" );
            db.execSQL("insert into " + TABLE_NAME + "(key, answer, image) values ('안녕', '봉심: 안녕안녕!', 'false');");
            db.execSQL("insert into " + TABLE_NAME + "(key, answer, image) values ('안녕', '봉심: 안녕하세요', 'false');");
            db.execSQL("insert into " + TABLE_NAME + "(key, answer, image) values ('안녕', '봉심: 반가워', 'false');");
            db.execSQL("insert into " + TABLE_NAME + "(key, answer, image) values ('안녕', '봉심: 누구야?', 'false');");
            db.execSQL("insert into " + TABLE_NAME + "(key, answer, image) values ('잘자', '봉심: 굿나잇', 'false');");
            db.execSQL("insert into " + TABLE_NAME + "(key, answer, image) values ('잘자', '봉심: 내꿈꿔', 'false');");
            db.execSQL("insert into " + TABLE_NAME + "(key, answer, image) values ('잘자', '봉심: 옹야', 'false');");
            db.execSQL("insert into " + TABLE_NAME + "(key, answer, image) values ('사랑해', '봉심: 알라뷰', 'false');");
            db.execSQL("insert into " + TABLE_NAME + "(key, answer, image) values ('사랑해', '봉심: 어머나', 'false');");
            db.execSQL("insert into " + TABLE_NAME + "(key, answer, image) values ('사랑해', '봉심: ...심쿵', 'false');");
            db.execSQL("insert into " + TABLE_NAME + "(key, answer, image) values ('누구', '봉심: 난 봉심이야! 잘부탁해^^', 'false');");
            db.execSQL("insert into " + TABLE_NAME + "(key, answer, image) values ('배고파', '봉심: 우리 밥먹자!', 'false');");
            db.execSQL("insert into " + TABLE_NAME + "(key, answer, image) values ('반가워', '봉심: 나도 반가워 헤헤', 'false');");
            db.execSQL("insert into " + TABLE_NAME + "(key, answer, image) values ('잘가', '봉심: 다음에 또 놀자~', 'false');");
            db.execSQL("insert into " + TABLE_NAME + "(key, answer, image) values ('너사진', '"+R.drawable.bonbon+"', 'true');");
            db.execSQL("insert into " + TABLE_NAME + "(key, answer, image) values ('오늘점심', '"+R.drawable.meatsteak+"', 'true');");

        } catch(Exception ex) {
            Log.e(TAG, "Exception in insert SQL", ex);
        }
    }


//    private void println(String msg) {
//        Log.d(TAG, msg);
//        status.append("\n" + msg);
//    }

    public void onOpen(SQLiteDatabase db) {
//            println("opened database [" + DATABASE_NAME + "].");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion + ".");
    }

}
