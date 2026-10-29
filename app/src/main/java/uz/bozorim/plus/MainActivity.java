package uz.bozorim.plus;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.content.Intent;
import android.net.Uri;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Tepadagi status bar rangi (yashil)
        Window w = getWindow();
        w.setStatusBarColor(Color.parseColor("#0F7A3D"));

        web = new WebView(this);
        setContentView(web);

        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true);   // sayt JavaScript'i ishlashi uchun
        s.setDomStorageEnabled(true);   // localStorage (akkaunt, koin, buyurtmalar) uchun
        s.setAllowFileAccess(true);

        // Havolalar ilova ichida ochilsin
        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, android.webkit.WebResourceRequest req) {
                Uri u = req.getUrl();
                // Kuryerga qo'ng'iroq: telefon terish oynasini ochadi
                if ("tel".equals(u.getScheme())) {
                    try { startActivity(new Intent(Intent.ACTION_DIAL, u)); } catch (Exception e) { }
                    return true;
                }
                return false;
            }
        });

        // Joylashuv: sayt "Joylashuvni aniqlash" bosganda ruxsat so'raladi
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }
        web.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback cb) {
                cb.invoke(origin, true, false);
            }
        });

        // Sayt fayli: app/src/main/assets/index.html
        if (savedInstanceState == null) {
            web.loadUrl("file:///android_asset/index.html");
        } else {
            web.restoreState(savedInstanceState);
        }
    }

    // "Orqaga" tugmasi: avval sayt ichida orqaga, bo'lmasa ilovadan chiqish
    @Override
    public void onBackPressed() {
        if (web.canGoBack()) web.goBack();
        else super.onBackPressed();
    }

    @Override
    protected void onSaveInstanceState(Bundle out) {
        super.onSaveInstanceState(out);
        web.saveState(out);
    }
}
