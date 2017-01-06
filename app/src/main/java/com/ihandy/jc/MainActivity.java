package com.ihandy.jc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.ihandy.view.LightTextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


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
       // MobUtils.initSDK(this,MobUtils.SIT);

    }

    @OnClick(R.id.txt365)
    public void txt365(View view) {
//        Intent intent = new Intent(this,WebViewActivity.class);
//        intent.putExtra("id",R.id.txt365);
//        startActivity(intent);
       // MobUtils.shareMessage(this,"ceshi","很好很强大","https://www.baidu.com");
    }


    @OnClick(R.id.cmp)
    public void cmp(View view) {
//        Intent intent = new Intent(this,WebViewActivity.class);
//        intent.putExtra("id",R.id.cmp);
//        startActivity(intent);
        //MobUtils.shareMessage(this,"ceshi","很好很强大","https://www.baidu.com","https://www.baidu.com/img/bd_logo1.png");
    }

    @OnClick(R.id.generate)
    public void generate(View view) {
//
    }

}
