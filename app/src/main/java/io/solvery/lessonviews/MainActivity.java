package io.solvery.lessonviews;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView wvLogin = findViewById(R.id.wvLogin);
        wvLogin.setWebViewClient(client);
        wvLogin.loadUrl("https://example.com");
        // if you need js enabled wvLogin.getSettings().setJavaScriptEnabled(true);
    }

    WebViewClient client = new WebViewClient() {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.contains("test.com")) { //check redirect to test.com
                Uri uri = Uri.parse(url);
                String token = uri.getQueryParameter("token"); //todo save token
                //todo close webview
                return true;
            }
            return false;
        }
    };
}