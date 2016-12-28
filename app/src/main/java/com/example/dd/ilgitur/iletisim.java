package com.example.dd.ilgitur;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class iletisim extends AppCompatActivity {
    final String mailAdres="ilgiturizm@gmail.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iletisim);


        TextView txtWeb=(TextView)findViewById(R.id.txtWeb);
        TextView txtBaslik=(TextView)findViewById(R.id.txtBaslik);
        TextView txtAmasyaAdres=(TextView)findViewById(R.id.txtMerkezAdres);
        TextView txtAmasyaMerkez=(TextView)findViewById(R.id.txtMerkezTel);
        TextView txtAntalya=(TextView)findViewById(R.id.txtAntalyaTel);
        TextView txtAntalyaAdres=(TextView)findViewById(R.id.txtAntalyaAdres1);
        TextView txtAntalyaTel=(TextView)findViewById(R.id.txtAntalyaAdres);
        TextView txtVezirkopru=(TextView)findViewById(R.id.txtVezirkopru);
        TextView txtVezirkopruAdres=(TextView)findViewById(R.id.txtVezirkopruAdres);
        TextView txtVezirkopruTel=(TextView)findViewById(R.id.txtVezirkopruTel);


        Typeface face= Typeface.createFromAsset(getAssets(), "fonts/Exo-Medium.otf");

        txtWeb.setTypeface(face);
        txtBaslik.setTypeface(face);
        txtAmasyaAdres.setTypeface(face);
        txtAmasyaMerkez.setTypeface(face);
        txtAntalya.setTypeface(face);
        txtAntalyaAdres.setTypeface(face);
        txtAntalyaTel.setTypeface(face);
        txtVezirkopru.setTypeface(face);
        txtVezirkopruAdres.setTypeface(face);
        txtVezirkopruTel.setTypeface(face);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final EditText konu=(EditText)findViewById(R.id.txtKonu);
        final EditText mesaj=(EditText)findViewById(R.id.txtMesaj);
        final EditText telNo=(EditText)findViewById(R.id.txtIletisim);
        final EditText adSoyad=(EditText)findViewById(R.id.txtAdSoyad);
        Button gonder=(Button)findViewById(R.id.btnGonder);

        gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mailGonder(mailAdres,konu.getText().toString(),mesaj.getText().toString()+" Ad Soyad: "+adSoyad.getText().toString()+" Telefon: "+telNo.getText().toString());
            }
        });
    }

    private void mailGonder(String mail,String konu,String mesaj){


        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL,new String[]{mail});
        i.putExtra(Intent.EXTRA_SUBJECT,konu);
        i.putExtra(Intent.EXTRA_TEXT,mesaj);
        try{
            startActivity(i);
        }
        catch (ActivityNotFoundException e){
            Toast.makeText(this, "Mail Gönderilemedi!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId()==android.R.id.home){
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            NavUtils.navigateUpTo(this,i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
