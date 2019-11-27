package com.example.android.stanzobanksb;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class WithdrwalActivity extends AppCompatActivity {
    EditText editText4;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdrwal);
        getSupportActionBar().setTitle("Withdrawal");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        editText4 = (EditText) findViewById(R.id.tt);
        button3 = (Button) findViewById(R.id.withdrw);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SharedPreferences Pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                final SharedPreferences.Editor done = Pref.edit();
                int bal = Pref.getInt("balance", 0);
                String is = Pref.getString("history",null);
                int with_amount = Integer.parseInt(editText4.getText().toString());

                if (with_amount > bal) {
                    Toast.makeText(getApplicationContext(), "Insufficient Fund", Toast.LENGTH_SHORT).show();
                } else {
                    String date = new SimpleDateFormat("dd-mm-yyy", Locale.getDefault()).format(new Date());
                    String his = " Withdrew Money\n"+date+"\n Amount: "+with_amount;
                    is+= "\n"+his;
                    int sum = bal - with_amount;
                    done.putInt("balance", sum);
                    done.putString("history",is);
                    done.apply();
                    Toast.makeText(getApplicationContext(), "Transaction Completed", Toast.LENGTH_SHORT).show();
                    finish();
                }
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
