package com.salim3dd.countdowntimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private int time = 0;
    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        anim = AnimationUtils.loadAnimation(this,R.anim.start);
        Time();

    }

    public void Time() {


        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {
                time++;
                textView.setText(time + "");
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "انتهى الوقت", Toast.LENGTH_SHORT).show();
                time = 0;
                textView.startAnimation(anim);
                Time();

            }
        }.start();
    }


}




