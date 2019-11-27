package com.example.android.stanzobanksb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class SelectAct extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle barDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        drawerLayout = (DrawerLayout) findViewById(R.id.Drawer);
        barDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(barDrawerToggle);
        barDrawerToggle.syncState();
        NavigationView nV = (NavigationView) findViewById(R.id.nav_view);
        nV.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int i = item.getItemId();
                if (i == R.id.hep) {
                    Intent welcome = new Intent(SelectAct.this, HelpActivity.class);
                    startActivity(welcome);
                    return true;
                } else if (i == R.id.balance) {
                    Intent bal = new Intent(SelectAct.this, BalanceActivity.class);
                    startActivity(bal);
                    return true;
                } else if (i == R.id.depo) {
                    Intent dep = new Intent(SelectAct.this, DepositActivity.class);
                    startActivity(dep);
                    return true;
                } else if (i == R.id.logout) {
                    Intent dep = new Intent(SelectAct.this, LoginActivity.class);
                    startActivity(dep);
                    finish();
                    return true;
                } else if (i == R.id.prof) {
                    Intent dep = new Intent(SelectAct.this, ProfileActivity.class);
                    startActivity(dep);
                    return true;
                } else if (i == R.id.with) {
                    Intent wit = new Intent(SelectAct.this, WithdrwalActivity.class);
                    startActivity(wit);
                    return true;
                } else if (i == R.id.trans) {
                    Intent tra = new Intent(SelectAct.this, TransferActivity.class);
                    startActivity(tra);
                    return true;
                } else if (i == R.id.his) {
                    Intent hi = new Intent(SelectAct.this, HistoryActivity.class);
                    startActivity(hi);
                    return true;
                } else {
                    return true;
                }
            }
        });
        getSupportActionBar().setTitle("Home");
        getSupportActionBar().setLogo(R.drawable.logo);
        // set back button to action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (barDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


