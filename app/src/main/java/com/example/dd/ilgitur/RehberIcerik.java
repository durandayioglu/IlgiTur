package com.example.dd.ilgitur;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class RehberIcerik extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehber_icerik);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView yazi=(TextView)findViewById(R.id.txtRehberIcerikTxt);

        Intent in=getIntent();
        String rehberBilgi=in.getStringExtra("rehber");
        yazi.setText(rehberBilgi);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            Intent i = new Intent(getApplicationContext(), rehber.class);
            NavUtils.navigateUpTo(this, i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
