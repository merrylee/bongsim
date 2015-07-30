package com.example.forproject.bongsim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by forProject on 2015-07-24.
 */
public class FirstScreen extends Activity {

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_screen);
        layout = (LinearLayout) findViewById(R.id.layout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = new Intent(this, StartLogo.class);
        startActivity(intent);
    }


    /*@Override
    public boolean onTouchEvent(MotionEvent event) {

        //Intent intent = new Intent(this, MainActivity.class);
        Intent intent = new Intent(FirstScreen.this, MainActivity.class);
        startActivity(intent);

        return super.onTouchEvent(event);
    }*/

}
