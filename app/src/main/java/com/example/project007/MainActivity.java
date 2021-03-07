package com.example.project007;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project007.LoginSignup.Sign;


public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIMER = 3000;

    ImageView bgImage;
    TextView textView,pwdLine;

    //Animation
    Animation side,bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        bgImage=findViewById(R.id.imageView);
        textView=findViewById(R.id.textView);
        pwdLine=findViewById(R.id.pw);

        //Animation
        side= AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottom= AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        //Set Animation
        bgImage.setAnimation(side);
        textView.setAnimation(bottom);
        pwdLine.setAnimation(bottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this, Sign.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIMER);


    }
}