package com.example.android.stanzobanksb;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DepositActivity extends AppCompatActivity {
    EditText editText1;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);
        getSupportActionBar().setTitle("DEPOSIT");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        editText1 = (EditText) findViewById(R.id.send);
        button1 = (Button)findViewById(R.id.dep);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SharedPreferences Pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                final SharedPreferences.Editor done = Pref.edit();
                int bal = Pref.getInt("balance",0);
                String is = Pref.getString("history",null);

                int dep_amount = Integer.parseInt(editText1.getText().toString());
                int sum = bal+dep_amount;
                String date = new SimpleDateFormat("dd-mm-yyy", Locale.getDefault()).format(new Date());
                String his = " Deposited Money\n"+date+"\n Amount: "+dep_amount;
                is+= "\n"+his;
                done.putInt("balance",sum);
                done.putString("history",is);
                done.apply();
                Toast.makeText(getApplicationContext(), "Transaction Completed", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
