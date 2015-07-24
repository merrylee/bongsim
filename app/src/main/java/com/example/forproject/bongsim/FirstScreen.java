package com.example.forproject.bongsim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by forProject on 2015-07-24.
 */
public class FirstScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_screen);
    }

    public void goToChat(View v){
        Intent intent = new Intent(FirstScreen.this, MainActivity.class);
        startActivity(intent);
    }


}
