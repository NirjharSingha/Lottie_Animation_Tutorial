package com.example.frenbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    TextView greet,greet2;
    SharedPreferences Onboarding;
    Button skip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greet=findViewById(R.id.greet);
        greet2=findViewById(R.id.greet2);
        skip=findViewById(R.id.skip);

        greet.setTranslationY(0);
        greet2.setTranslationY(0);
        float v=0;
        greet.setAlpha(v);
        greet2.setAlpha(v);

        greet.animate().translationY(200).alpha(1).setDuration(1000).setStartDelay(400).start();
        greet2.animate().translationY(-200).alpha(1).setDuration(1000).setStartDelay(400).start();

        // play the  lottie animation here
        LottieAnimationView animationView = findViewById(R.id.lottiesplash);
        animationView.playAnimation();


        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent onBoardingIntent = new Intent(getApplicationContext(), Onboarding.class);
                startActivity(onBoardingIntent);
                Onboarding=getSharedPreferences("Onboarding",MODE_PRIVATE);
                finish();
            }
        });

    }
}