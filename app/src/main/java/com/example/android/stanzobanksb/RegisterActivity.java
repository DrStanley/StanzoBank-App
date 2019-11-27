package com.example.android.stanzobanksb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity {
    String gen;
    Button bt2;
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8,ed9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        identify();
        getSupportActionBar().setTitle("Registration");
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

    }


    void register(){
        String nam,phn,ema,coun,concode,usern,pass,cpass;
        nam = ed1.getText().toString();
        phn= ed3.getText().toString();
        ema = ed2.getText().toString();
        coun = ed5.getText().toString();
        concode = ed4.getText().toString();
        usern = ed6.getText().toString();
        pass = ed7.getText().toString();
        cpass = ed8.getText().toString();
        int ego = Integer.parseInt(ed9.getText().toString());

//                ed9.getText().toString();

        if (nam.isEmpty()|| phn.isEmpty()||ema.isEmpty() ||
                concode.isEmpty()||coun.isEmpty()
                ||usern.isEmpty()||pass.isEmpty()||cpass.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please Fill all boxes",Toast.LENGTH_SHORT).show();
        } else  {
            if (pass.equals(cpass)){
            final SharedPreferences Pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            final SharedPreferences.Editor done = Pref.edit();
                String date = new SimpleDateFormat("dd-mm-yyy", Locale.getDefault()).format(new Date());
                String his = " Opened Account\n"+date;

                done.putString("username",usern);
            done.putString("password",pass);
            done.putString("history",his);
            done.putInt("balance",ego);
            done.apply();
                Intent welcome = new Intent(RegisterActivity.this, SelectAct.class);
                startActivity(welcome);
                finish();
            }
            else {
                Toast.makeText(getApplicationContext(),"Passwords do not match",Toast.LENGTH_SHORT).show();

            }

        }




        final SharedPreferences Pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final SharedPreferences.Editor done = Pref.edit();
        done.putBoolean("pos",true);

        done.apply();

    }
    void identify(){
        ed1 = (EditText)findViewById(R.id.name);
        ed2 = (EditText)findViewById(R.id.email);
        ed3 = (EditText)findViewById(R.id.numb);
        ed4 = (EditText)findViewById(R.id.code);
        ed5 = (EditText)findViewById(R.id.country);
        ed6 = (EditText)findViewById(R.id.usn);
        ed7 = (EditText)findViewById(R.id.pwd);
        ed8 = (EditText)findViewById(R.id.cpwd);
        ed9 = (EditText)findViewById(R.id.amot);
        bt2 = (Button)findViewById(R.id.register);

    }
    public void radio(View view) {
        boolean ticked = ((RadioButton) view).isChecked();

        int i = view.getId();
        switch (i) {
            case R.id.m:
                if (ticked) {
                    gen = "Male";
                    Toast.makeText(getApplicationContext(),gen,Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.f:
                if (ticked) {
                    gen = "Female";
                    Toast.makeText(getApplicationContext(),gen,Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
