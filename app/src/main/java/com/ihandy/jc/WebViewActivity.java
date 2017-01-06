package com.ihandy.jc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cxh on 1/6/17.
 */

public class WebViewActivity extends Activity {


    @Bind(R.id.webView)
    WebView webView;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ButterKnife.bind(this);
        WebSettings settings = webView.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setBuiltInZoomControls(false);
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        settings.setAppCacheEnabled(false);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);


        WebChromeClient webChromeClient = new WebChromeClient() {


            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                    if (newProgress == 100) {
                        progressBar.setVisibility(View.GONE);
                    } else {
                        if (progressBar.getVisibility() == View.GONE) {
                            progressBar.setVisibility(View.VISIBLE);
                        }
                        progressBar.setProgress(newProgress);
                    }

                super.onProgressChanged(view, newProgress);
            }

        };

        webView.setWebChromeClient(webChromeClient);


        webView.loadUrl("https://mobile.536488.com");
    }


}
