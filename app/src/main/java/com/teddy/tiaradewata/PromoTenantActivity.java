package com.teddy.tiaradewata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class  PromoTenantActivity extends AppCompatActivity {

    //Memanggil Variabel Widget Drawer supaya bisa dicoding
    //Inisialiasi Variabel
    DrawerLayout drawerLayout;
    WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo_tenant);

        //buka webnya
        webView = (WebView) findViewById(R.id.promo_tenant_webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://toko.yuk-kunjungi.com/tiaradewatanews/category/promo-tenant/");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //assign variabelnya
        drawerLayout = findViewById(R.id.drawer_layout);

    }

    public void ClickMenu(View view){
        //Open drawer
        MainActivity.openDrawer (drawerLayout);
    }

    public void ClickLogo(View view){
        //Close Drawernya
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        //Redirect activity ke Beranda
        MainActivity.redirectActivity(this,MainActivity.class);
    }

    public void ClickTentangTiara (View view){
        //Redirect activity ke info Tentang Tiara Dewata
        MainActivity.redirectActivity(this,AboutTiaraActivity.class);
    }

    public void ClickFasilitas (View view){
        //Redirect activity ke Fasilitas Tiara Dewata
        MainActivity.redirectActivity(this,FasilitasActivity.class);
    }

    public void ClickTenant (View view){
        //Redirect activity ke info Tenant
        MainActivity.redirectActivity(this,TenantActivity.class);
    }

    public void ClickPromoTiara (View view){
        //Redirect activity ke Promo Tiara Dewata
        MainActivity.redirectActivity(this,PromoTiaraActivity.class);
    }

    public void ClickPromoTenant (View view){
        //Recreate activity
        recreate();
    }

    public void ClickPoinBelanja (View view){
        //Redirect activity ke Poin Belanja dan Hadiah
        MainActivity.redirectActivity(this,PoinBelanjaTiaraActivity.class);
    }

    public void ClickPartnership (View view){
        //Redirect activity ke Partnership
        MainActivity.redirectActivity(this,PartnershipActivity.class);
    }

    public void ClickKontak (View view){
        //Redirect activity ke Kontak Kami
        MainActivity.redirectActivity(this,KontakActivity.class);
    }

    public void ClickAplikasi (View view){
        //Redirect activity ke Info Tentang Aplikasi
        MainActivity.redirectActivity(this,AplikasiActivity.class);
    }

    public void ClickLogout (View view){
        //Menutup Aplikasi
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close Drawer
        MainActivity.closeDrawer(drawerLayout);
    }

}