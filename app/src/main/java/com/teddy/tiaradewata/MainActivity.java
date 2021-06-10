package com.teddy.tiaradewata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    //Memanggil Variabel Widget Drawer supaya bisa dicoding
    //Inisialiasi Variabel
    DrawerLayout drawerLayout;
    WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //buka webnya
        webView = (WebView) findViewById(R.id.beranda_webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://toko.yuk-kunjungi.com/tiaradewatanews/");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //assign variabelnya
        drawerLayout = findViewById(R.id.drawer_layout);

    }

    public void ClickMenu(View view){
        //Open drawer
        openDrawer (drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //Open Drawer Layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        //Close Drawernya
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //Close Drawer Layout
        //Check Condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            //Jika drawernya masih terbuka
            //maka tutup Drawer-nya
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        //Recreate activity
        recreate();
    }

    public void ClickTentangTiara (View view){
        //Redirect activity ke info Tentang Tiara Dewata
        redirectActivity(this,AboutTiaraActivity.class);
    }

    public void ClickFasilitas (View view){
        //Redirect activity ke Fasilitas Tiara Dewata
        redirectActivity(this,FasilitasActivity.class);
    }

    public void ClickTenant (View view){
        //Redirect activity ke info Tenant
        redirectActivity(this,TenantActivity.class);
    }

    public void ClickPromoTiara (View view){
        //Redirect activity ke Promo Tiara Dewata
        redirectActivity(this,PromoTiaraActivity.class);
    }

    public void ClickPromoTenant (View view){
        //Redirect activity ke Promo dari Tenant
        redirectActivity(this,PromoTenantActivity.class);
    }

    public void ClickPoinBelanja (View view){
        //Redirect activity ke Poin Belanja dan Hadiah
        redirectActivity(this,PoinBelanjaTiaraActivity.class);
    }

    public void ClickPartnership (View view){
        //Redirect activity ke Partnership
        redirectActivity(this,PartnershipActivity.class);
    }

    public void ClickKontak (View view){
        //Redirect activity ke Kontak Kami
        redirectActivity(this,KontakActivity.class);
    }

    public void ClickAplikasi (View view){
        //Redirect activity ke Tentang Aplikasi
        redirectActivity(this,AplikasiActivity.class);
    }

    public void ClickLogout (View view){
        //Menutup Aplikasi
        logout(this);
    }

    public static void logout(Activity activity) {
        //Inisialisasi Kotak Dialog Peringatan
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //Set Title
        builder.setTitle("LOGOUT APLIKASI");
        //Berikan Pesan
        builder.setMessage("Apakah Anda ingin keluar dari aplikasi?");
        //Positif Tombol Yes
        builder.setPositiveButton("IYA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Finish Activivy
                activity.finishAffinity();
                //Exit Aplikasi
                System.exit(0);
            }
        });
        //Negative Tombol No
        builder.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Dismiss Dialog atau batalin aktivitas
                dialog.dismiss();
            }
        });
        //Show Dialog
        builder.show();
    }

    public static void redirectActivity(Activity activity,Class aClass) {
        //Inisialisasi intent
        Intent intent = new Intent(activity,aClass);
        //Set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //Start Acitivity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close Drawer
        closeDrawer(drawerLayout);
    }
}
