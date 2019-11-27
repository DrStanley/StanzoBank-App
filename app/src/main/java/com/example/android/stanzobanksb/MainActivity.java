package com.example.android.stanzobanksb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Animation uptodown, downtoup;
    LinearLayout li3;
    Button b1;
    private static int timeout = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences Pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final SharedPreferences.Editor done = Pref.edit();
        boolean check = Pref.getBoolean("pos", false);
        System.out.println(check+"this is check");
        done.apply();
        if (check) {
            finish();
            Intent n = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(n);
        }else {
            li3 = (LinearLayout) findViewById(R.id.first);
            uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
            downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);
            li3.setAnimation(downtoup);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent welcome = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(welcome);
                    finish();
                }
            }, timeout);
        }

    }
}
