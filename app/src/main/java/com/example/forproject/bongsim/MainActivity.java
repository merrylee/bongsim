package com.example.forproject.bongsim;

import android.app.ListActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends ListActivity {

    ArrayList<MyMessage> MyMessages;
    MsgAdapter adapter;
    EditText text;
    static Random rand = new Random();
    static String sender;
    SetAnswer setAnswer;
    TextView typing;

    public static final String TAG = "MainActivity";
    public DatabaseHelper dbHelper;
    public SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isOpen = openDatabase();
        if (isOpen) {

            typing = (TextView) findViewById(R.id.typing);
            text = (EditText) findViewById(R.id.text);
            //sender = Utility.sender[rand.nextInt(Utility.sender.length-1)]; //sender중 하나의 메시지 가져오기

            this.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.bg));

            MyMessages = new ArrayList<MyMessage>();
            setAnswer = new SetAnswer(this, db);

            adapter = new MsgAdapter(this, MyMessages);
            setListAdapter(adapter); // main_activity.xml의 리스트뷰(default)에 어댑터 연결
        }
    }

    public void sendMessage(View v) {      // SEND버튼 눌렀을 때
        String newMessage = text.getText().toString().trim();


        if (newMessage.length() > 0) {
            text.setText("");
            addNewMessage(new MyMessage(newMessage, true)); //---ok
            new SendMessage().execute(newMessage);
        }
    }

    private class SendMessage extends AsyncTask<String, String, MyMessage> {    // doInBg -> onProgressUd(on main thread) -> onPostexe(on main thread)
        @Override
        protected MyMessage doInBackground(String... params) {  // on another thread
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.publishProgress(String.format("Bongsim started writing"));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.publishProgress(String.format("Bongsim has entered text"));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.publishProgress(String.format(""));

            return setAnswer.setAnswer(params[0]);
        }

        @Override
        protected void onPostExecute(MyMessage s) {   // 봉심이가 보내는 메시지 추가하기
/*            if (messages.get(messages.size() - 1).isStatusMessage) {  // status message delete : Bongsim has entered text
                messages.remove(messages.size() - 1);
            }*/

            addNewMessage(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {  // on main thread * (doInBackground).publishProgress()의 매개변수를 values[]에 저장
           /* if (messages.get(messages.size() - 1).isStatusMessage) {      // "Bongsim started writing"이 status이므로, 가장 최근의 message는 status.
                messages.get(messages.size() - 1).setMessage(values[0]); // Bongsim started writing -> Bongsim has entered text
                adapter.notifyDataSetChanged();
                getListView().setSelection(messages.size() - 1);
            } else {
                addNewMessage(new Message(true, values[0]));  // 첫 publishProgress() : Bongsim started writing(status message)
            }*/

            typing.setText(values[0]);
            typing.setTextSize(15);
            if (values[0].equals("")) {
                typing.setBackgroundColor(getResources().getColor(R.color.trsprt));
            } else {
                typing.setTextColor(getResources().getColor(R.color.bontext));
                typing.setBackgroundColor(getResources().getColor(R.color.bontextBg));
            }


        }
    }


    void addNewMessage(MyMessage m) {

        MyMessages.add(m);
        adapter.notifyDataSetChanged(); // 화면에 출력 , adapter.getView()
        getListView().setSelection(MyMessages.size() - 1); // 위치설정

    }

    private boolean openDatabase() {
//        println("opening database [" + DATABASE_NAME + "].");
        dbHelper = new DatabaseHelper(this, TAG);
        db = dbHelper.getWritableDatabase();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
