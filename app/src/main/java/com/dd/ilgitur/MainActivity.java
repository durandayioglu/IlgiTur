package com.dd.ilgitur;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView hakkimizdaView;
    ImageView rehberView;
    ImageView programlarView;
    ImageView iletisimView;
    ImageView facebookView;
    ImageView instagramView;
    ImageView webView;
    ImageView araView;
    String telNo="05426887000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hakkimizdaView=(ImageView)findViewById(R.id.hakkimizdaView);
        rehberView=(ImageView)findViewById(R.id.rehberView);
        programlarView=(ImageView)findViewById(R.id.programlarView);
        iletisimView=(ImageView)findViewById(R.id.iletisimView);
        facebookView=(ImageView)findViewById(R.id.facebookView);
        instagramView=(ImageView)findViewById(R.id.instagramView);
        webView=(ImageView)findViewById(R.id.webView);
        araView=(ImageView)findViewById(R.id.araView);

    }

    private boolean appInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        boolean app_installed;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        }
        catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }

    public static Intent getOpenInstagramIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.instagram.android", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/ilgitur"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/ilgitur"));
        }
    }

    public void yonlendirme(View view){
        if (view.getId()==hakkimizdaView.getId()){
            Intent i=new Intent(MainActivity.this,hakkimizda.class);
            startActivity(i);
        } else if (view.getId()==rehberView.getId()){
            Intent i=new Intent(MainActivity.this,rehber.class);
            startActivity(i);
        } else if (view.getId()==iletisimView.getId()){
            Intent i=new Intent(MainActivity.this,iletisim.class);
            startActivity(i);
        } else if (view.getId()==webView.getId()){
            Intent i=new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("http://www.ilgiturizm.com"));
            startActivity(i);
        } else if (view.getId()==araView.getId()){
            Intent i=new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:"+telNo));
            startActivity(i);
        } else if (view.getId()==programlarView.getId()){
            Intent i=new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("http://ilgiturizm.com/package-category/umre/"));
            startActivity(i);
        } else if (view.getId()==facebookView.getId()){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.facebook.com/ilgitour"));
                startActivity(intent);
        } else if (view.getId() == instagramView.getId()) {

            boolean installed = appInstalledOrNot("com.instagram.android");
            if (installed) {
                startActivity(getOpenInstagramIntent(MainActivity.this));
            } else {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.instagram.com/ilgitur"));
                startActivity(intent);
            }
        }
    }
}
