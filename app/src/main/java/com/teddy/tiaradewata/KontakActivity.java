package com.teddy.tiaradewata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class  KontakActivity extends AppCompatActivity {

    //Memanggil Variabel Widget Drawer supaya bisa dicoding
    //Inisialiasi Variabel
    DrawerLayout drawerLayout;
    WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontak);

        //buka webnya
        webView = (WebView) findViewById(R.id.kontak_webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://toko.yuk-kunjungi.com/tiaradewata/kontak/");

        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.supportZoom();
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);

        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        webView.setWebChromeClient(new WebChromeClient());

        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView wv, String url) {
                if(url.startsWith("tel:") || url.startsWith("whatsapp:") || url.startsWith("tg:") || url.startsWith("facebook:") ) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                    return true;
                }
                return false;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });

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
        //Redirect activity ke Promo dari Tenant
        MainActivity.redirectActivity(this,PromoTenantActivity.class);
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
        //Recreate activity
        recreate();
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