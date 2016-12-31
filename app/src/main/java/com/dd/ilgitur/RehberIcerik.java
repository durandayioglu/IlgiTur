package com.dd.ilgitur;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class RehberIcerik extends AppCompatActivity {

    float metinBoyutu = 18f;
    TextView yazi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehber_icerik);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        yazi=(TextView)findViewById(R.id.txtRehberIcerikTxt);

        Intent in=getIntent();
        String rehberBilgi=in.getStringExtra("rehber");
        String baslik=in.getStringExtra("baslik");
        RehberIcerik.this.setTitle(baslik);
        yazi.setText(rehberBilgi);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_buyut:
                metinBoyutu += 0.5f;
                yazi.setTextSize(metinBoyutu);
                return true;
            case R.id.action_kucult:
                metinBoyutu -= 0.5f;
                yazi.setTextSize(metinBoyutu);
                return true;
            case android.R.id.home:
                Intent i=new Intent(getApplicationContext(),rehber.class);
                NavUtils.navigateUpTo(this,i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
