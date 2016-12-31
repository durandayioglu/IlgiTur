package com.example.dd.ilgitur;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

/**
 * Created by DD on 24.11.2016.
 */
public class Islemler extends BaseExpandableListAdapter {

    private Context c;

    Typeface ozelyazi;

    String[] liste={"DUALAR","HAC","UMRE","MEKKE ZİYARET YERLERİ","MEDİNE ZİYARET YERLERİ"};
    String[][] listeicerik={
            {"TAVAF DUALARI","SAY DUALARI","ZEMZEM İÇERKEN OKUNACAK DUA","KABEYİ GÖRÜNCE OKUNACAK DUA","MEKKEYE GİRİNCE OKUNACAK DUA","İHRAMA GİRERKEN OKUNACAK DUA","VASITAYA BİNİNCE OKUNACAK DUA","EVDEN AYRILIRKEN OKUNACAK DUA"},
            {"HAC NEDİR","HACCIN YAPILIŞI","UMRE İLE HAC ARASINDAKİ FARKLAR","HAC İÇİN İHRAMA GİRİŞ VE ARAFATA ÇIKIŞ","ARAFAT VAKFESİ"},
            {"UMRE NEDİR","UMREYE NİYET","UMRE NASIL YAPILIR","UMRENİN MANASI","UMRE YOLCULUĞU HAKKINDA TAVSİYELER","İHRAM YASAKLARI"},
            {"MEKKE GENEL BİLGİLER","MESCİDİ HARAM","CEBELİ NUR","CİN MESCİDİ","CENNET'UL MUALLA KABRİSTANI","ZEMZEM","HECER-İ ESVED","RASULULLAH'IN DOĞDUĞU EV","MİNA","MÜZDELİFE","ARAFAT","CEBEL-İ SEVR"},
            {"RAVZA-İ MUTAHHARA","MESCİDİ NEBEVİ","CENNETÜL BAKİ","KUBA MESCİDİ","KIBLETEYN MESCİDİ","UHUD","CUMA MESCİDİ","YEDİ MESCİDLER"}
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
        tv1.setTextSize(40);
        tv1.setPadding(80,10,10,10);
        tv1.setTextColor(Color.WHITE);
        tv1.setBackgroundColor(Color.rgb(202,73,153));
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
