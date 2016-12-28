package com.example.dd.ilgitur;


import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class
hakkimizda extends AppCompatActivity {

    TextView txt;
    TextView txt2;
    TextView txt3;
    float metinBoyutu = 18f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hakkimizda);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar ab=getSupportActionBar();


        txt=(TextView)findViewById(R.id.textView3);
        txt2=(TextView)findViewById(R.id.textView6);
        txt3=(TextView)findViewById(R.id.textView4);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_buyut:
                metinBoyutu += 0.5f;
                txt.setTextSize(metinBoyutu);
                txt2.setTextSize(metinBoyutu);
                txt3.setTextSize(metinBoyutu);
                return true;
            case R.id.action_kucult:
                metinBoyutu -= 0.5f;
                txt.setTextSize(metinBoyutu);
                txt2.setTextSize(metinBoyutu);
                txt3.setTextSize(metinBoyutu);
                return true;
            case android.R.id.home:
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                NavUtils.navigateUpTo(this,i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




}
