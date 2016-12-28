package com.example.dd.ilgitur;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.TextView;

public class rehber extends AppCompatActivity {
    ExpandableListView rehberler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehber);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rehberler = (ExpandableListView) findViewById(R.id.rehberListe);
        rehberler.setAdapter(new Islemler(this));

        rehberler.setOnChildClickListener(new OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Intent in = new Intent(getApplicationContext(), RehberIcerik.class);


                String b = ((TextView) view).getText().toString();
                in.putExtra("rehber", b);
                startActivity(in);
                return false;
            }
        });

        rehberler.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            public void onGroupExpand(int groupPosition) {
                int len = new Islemler(rehber.this).getGroupCount();
                for (int i = 0; i < len; i++) {
                    if (i != groupPosition) {
                        rehberler.collapseGroup(i);
                    }
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            NavUtils.navigateUpTo(this, i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
