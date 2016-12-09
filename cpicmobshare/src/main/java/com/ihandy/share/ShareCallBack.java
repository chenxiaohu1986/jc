package com.ihandy.share;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;

public interface ShareCallBack {

    void onError(Platform arg0, int arg1, Throwable arg2);
    void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2);
    void onCancel(Platform arg0, int arg1);
}
