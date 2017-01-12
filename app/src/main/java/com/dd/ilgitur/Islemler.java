package com.dd.ilgitur;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

/**
 * Created by DD on 24.11.2016.
 */
public class Islemler extends BaseExpandableListAdapter {

    private Context c;

    Typeface ozelyazi;

    String[] liste={"DUALAR","HAC","UMRE","MEKKE ZİYARET YERLERİ","MEDİNE ZİYARET YERLERİ"};
    String[][] listeicerik={
            {"Tavaf Duaları","Say Duaları","Zemzem İçerken Okunacak Dua","Kabeyi Görünce Okunacak Dua","Mekkeye Girince Okunacak Dua","İhrama Girerken Okunacak Dua","Vasıtaya Binince Okunacak Dua","Evden Ayrılırken Okunacak Dua"},
            {"Hac Nedir?","Hac Nasıl Yapılır?","Umre ile Hac Arasındaki Farklar","Hac İçin İhrama Giriş ve Arafata Çıkış","Arafat Vakfesi"},
            {"Umre Nedir?","Umreye Niyet","Umre Nasıl Yapılır?","Umrenin Manası","Umre Yolculuğu Hakkında Tavsiyeler","İhram Yasakları Nelerdir?"},
            {"Mekke Hakkında Genel Bilgiler","Mescid-i Haram","Cebel-i Nur","Cin Mescidi","Cennet'ul Mualla Kabristanı","Zemzem","Hecer-i Esved","Rasulullah'ın Doğduğu Ev","Mina","Müzdelife","Arafat","Cebel-i Sevr"},
            {"Ravza-i Mutahhara","Mescid-i Nebevi","Cennet-ül Baki","Kuba Mescidi","Kıbleteyn Mescidi","Uhud","Cuma Mescidi","Yedi Mescidler"}
    };


    public Islemler(Context c){
        this.c=c;
        ozelyazi = Typeface.createFromAsset(c.getAssets(), "fonts/Exo-Medium.otf");
    }



    @Override
    public int getGroupCount() {
        return liste.length;
    }

    @Override
    public int getChildrenCount(int i) {
        return listeicerik[i].length;
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        TextView tv1=new TextView(c);
        tv1.setText(liste[i]);
        tv1.setTypeface(ozelyazi);
        tv1.setTextSize(30);
        tv1.setPadding(80,10,10,10);
        tv1.setTextColor(Color.WHITE);
        tv1.setBackgroundColor(Color.rgb(255,21,30));
        return tv1;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        TextView tv2=new TextView(c);
        tv2.setText(listeicerik[i][i1]);
        tv2.setTypeface(ozelyazi);
        tv2.setTextColor(Color.BLACK);
        tv2.setTextSize(20);
        tv2.setPadding(100,15,15,15);
        return tv2;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

}
