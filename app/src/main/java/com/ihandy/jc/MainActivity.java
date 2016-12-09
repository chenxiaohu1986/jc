package com.ihandy.jc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Toast;

import com.ihandy.share.MobUtils;
import com.ihandy.share.ShareCallBack;
import com.ihandy.view.LightTextView;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sharesdk.framework.Platform;


public class MainActivity extends Activity {


    @Bind(R.id.txt365)
    LightTextView txt365;


    @Bind(R.id.generate)
    LightTextView generate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MobUtils.initSDK(this,MobUtils.SIT);

    }

    @OnClick(R.id.txt365)
    public void txt365(View view) {
//        Intent intent = new Intent(this,WebViewActivity.class);
//        intent.putExtra("id",R.id.txt365);
//        startActivity(intent);
        MobUtils.shareMessage(this,"ceshi","很好很强大","https://www.baidu.com");
    }


    @OnClick(R.id.cmp)
    public void cmp(View view) {
//        Intent intent = new Intent(this,WebViewActivity.class);
//        intent.putExtra("id",R.id.cmp);
//        startActivity(intent);
        MobUtils.shareMessage(this,"ceshi","很好很强大","https://www.baidu.com","https://www.baidu.com/img/bd_logo1.png");
    }

    @OnClick(R.id.generate)
    public void generate(View view) {
//        Intent intent = new Intent(this,GenerateActivity.class);
//        startActivity(intent);
        MobUtils.shareMessage(this, "ceshi", "很好很强大", "https://www.baidu.com", "", new ShareCallBack() {
            @Override
            public void onError(Platform arg0, int arg1, Throwable arg2) {
                try {
                    Thread.sleep(3000l);
                }catch (Exception e){

                }

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this,"error",Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
                try {
                    Thread.sleep(3000l);
                }catch (Exception e){

                }

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this,"ok",Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onCancel(Platform arg0, int arg1) {

                try {
                    Thread.sleep(3000l);
                }catch (Exception e){

                }


                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this,"error",Toast.LENGTH_LONG).show();
                    }
                });

//

            }
        });
    }

}
