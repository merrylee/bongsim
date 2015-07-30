package com.example.forproject.bongsim;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by User on 2015-07-27.
 */
public class StartLogo extends Activity {

    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_logo);

        animation = AnimationUtils.loadAnimation(this, R.anim.alpha);

        ImageView startImg = (ImageView) findViewById(R.id.startImg);
        startImg.startAnimation(animation);

        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                finish();
            }
        };
        handler.sendMessageDelayed(handler.obtainMessage(), 4000);
    }
}
