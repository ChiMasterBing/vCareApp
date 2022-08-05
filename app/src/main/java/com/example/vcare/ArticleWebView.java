package com.example.vcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

public class ArticleWebView extends AppCompatActivity {

    private WebView webView;
    private String weblink;
    private ImageButton back, favorite;
    boolean isChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_web_view);

        weblink = getIntent().getStringExtra("article-url");
        webView = findViewById(R.id.webView);

        webView.setWebViewClient(new Callback());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(weblink);

        back = findViewById(R.id.backAboutUs);
        favorite = findViewById(R.id.favBtn);
        isChecked = false;

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Return to Mindfulness
                finish();
            }
        });

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // need to implement saved webpages to firebase
                if (isChecked) {
                    favorite.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24);
                    isChecked = false;
                    System.out.println("Unsave the webpage");
                } else {
                    favorite.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
                    isChecked = true;
                    System.out.println("Save the webpage");
                }
            }
        });
    }

    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return false;
        }
    }
}