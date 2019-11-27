package com.example.android.stanzobanksb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText usernam, passwor;
    Button bt1;
    LinearLayout linearLayout2;
    String nsma, pasd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final SharedPreferences Pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final SharedPreferences.Editor done = Pref.edit();
        done.putBoolean("pos", true);
        boolean check = Pref.getBoolean("pos", false);
        done.apply();
        getSupportActionBar().setTitle("Login");
        bt1 = (Button) findViewById(R.id.sign);
        usernam = (EditText) findViewById(R.id.tin);
        passwor = (EditText) findViewById(R.id.pin);
        linearLayout2 = (LinearLayout) findViewById(R.id.Newuser);
        final String usn = Pref.getString("username", null);
        final String pas = Pref.getString("password", null);
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent welcome = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(welcome);
            }
        });
        System.out.println(usn + " and " + pas + " here");
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String text1 = usernam.getText().toString();
                String text2= passwor.getText().toString();
                if (text1.equals(usn) && text2.equals(pas)) {
                    Intent welcome = new Intent(LoginActivity.this, SelectAct.class);
                    startActivity(welcome);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect input", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}
