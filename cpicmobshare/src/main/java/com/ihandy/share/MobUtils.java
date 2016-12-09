package com.ihandy.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.onekeyshare.ShareContentCustomizeCallback;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;

public abstract class MobUtils {

    public static final String SIT = "sit";
    public static final String UAT = "uat";
    public static final String PRO = "pro";


    /**
     * 分享微信好友 微信朋友圈
     * @param context
     * @param title  标题
     * @param text   描述
     * @param url    分享的链接
     */
    public static void shareMessage(Context context,final String title, final String text, final String url){

        OnekeyShare oks = new OnekeyShare();
        oks.setDialogMode();
        oks.setSilent(false);
        oks.setTitle(title);
        oks.setText(text);

        final Bitmap imageData = BitmapFactory.decodeResource(context.getResources(), context.getApplicationContext().getApplicationInfo().icon);

        // 为不同平台定义差异化分享内容
        oks.setShareContentCustomizeCallback(new ShareContentCustomizeCallback() {
            @Override
            public void onShare(Platform platform, Platform.ShareParams paramsToShare) {
                if (Wechat.NAME.equals(platform.getName())) {
                    paramsToShare.setTitle(title);
                    paramsToShare.setText(text);
                    paramsToShare.setImageData(imageData);
                    paramsToShare.setImageUrl(url);
                    paramsToShare.setUrl(url);
                    paramsToShare.setShareType(Platform.SHARE_WEBPAGE);
                } else if (WechatMoments.NAME.equals(platform.getName())) {
                    paramsToShare.setTitle(title);
                    paramsToShare.setImageUrl(url);
                    paramsToShare.setImageData(imageData);
                    paramsToShare.setUrl(url);
                    paramsToShare.setShareType(Platform.SHARE_WEBPAGE);
                } /*else if ("ShortMessage".equals(platform.getName())) {//短信分享
					paramsToShare.setText(message + url);
				}*/

            }
        });

        oks.show(context);
    }

    /**
     * 分享微信好友 微信朋友圈
     * @param title：标题
     * @param text：描述
     * @param url：分享的链接
     * @param imageurl：图片的下载地址
     * @param shareCallBack：分享回调
     */
    public static void shareMessage(Context context,String title, String text, String url, String imageurl, ShareCallBack shareCallBack) {
        oneKeyShare(context,title, text, url, imageurl, shareCallBack);
    }

    public static void shareMessage(Context context,String title, String text, String url, String imageurl) {
        shareMessage(context,title, text, url, imageurl,null);
    }

    /**
     * 分享微信好友
     */
    public static void shareWechat(Context context,final String title, final String text,final String url,final String imageurl){
        OnekeyShare oks = new OnekeyShare();
        oks.setPlatform(Wechat.NAME);
        oks.setDialogMode();
        oks.setSilent(false);
        oks.setTitle(title);
        oks.setText(text);
        oks.setShareContentCustomizeCallback(new ShareContentCustomizeCallback() {
            @Override
            public void onShare(Platform platform, Platform.ShareParams paramsToShare) {
                paramsToShare.setTitle(title);
                paramsToShare.setText(text);
                paramsToShare.setImageUrl(imageurl);
                paramsToShare.setUrl(url);
                paramsToShare.setShareType(Platform.SHARE_WEBPAGE);
            }
        });
        oks.show(context);
    }

    /**
     * 分享微信朋友圈
     */
    public static void shareWechatMoments(Context context,final String title, final String text,final String url,final String imageurl){
        OnekeyShare oks = new OnekeyShare();
        oks.setPlatform(WechatMoments.NAME);
        oks.setDialogMode();
        oks.setSilent(false);
        oks.setTitle(title);
        oks.setText(text);
        oks.setShareContentCustomizeCallback(new ShareContentCustomizeCallback() {
            @Override
            public void onShare(Platform platform, Platform.ShareParams paramsToShare) {
                paramsToShare.setTitle(title + text);
                paramsToShare.setImageUrl(imageurl);
                paramsToShare.setUrl(url);
                paramsToShare.setShareType(Platform.SHARE_WEBPAGE);
            }
        });
        oks.show(context);
    }

    /**
     * 一键分享
     *
     * @param title：标题
     * @param text：描述
     * @param url：分享的链接
     * @param imageurl：图片的下载地址
     * @param shareCallBack：分享回调
     */
    private static void oneKeyShare(Context context, final String title,
                            final String text, final String url,
                            final String imageurl,final ShareCallBack shareCallBack) {

        OnekeyShare oks = new OnekeyShare();

        oks.setSilent(false);
        oks.setTitle(title);
        oks.setText(text);

        // 自定义外部回调
        oks.setCallback(new PlatformActionListener() {
            @Override
            public void onError(Platform arg0, int arg1, Throwable arg2) {
                if (null != shareCallBack) {
                    shareCallBack.onError(arg0,arg1,arg2);
                }
            }

            @Override
            public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
                if (null != shareCallBack) {
                    shareCallBack.onComplete(arg0,arg1,arg2);
                }
            }

            @Override
            public void onCancel(Platform arg0, int arg1) {
                if (null != shareCallBack) {
                    shareCallBack.onCancel(arg0,arg1);
                }
            }
        });

        // 为不同平台定义差异化分享内容
        oks.setShareContentCustomizeCallback(new ShareContentCustomizeCallback() {
            @Override
            public void onShare(Platform platform, Platform.ShareParams paramsToShare) {
                if (Wechat.NAME.equals(platform.getName())) {
                    paramsToShare.setTitle(title);
                    paramsToShare.setText(text);
                    paramsToShare.setImageUrl(imageurl);
                    paramsToShare.setUrl(url);
                    paramsToShare.setShareType(Platform.SHARE_WEBPAGE);
                } else if (WechatMoments.NAME.equals(platform.getName())) {
                    paramsToShare.setTitle(title + text);
                    paramsToShare.setImageUrl(imageurl);
                    paramsToShare.setUrl(url);
                    paramsToShare.setShareType(Platform.SHARE_WEBPAGE);
                } /*
                     * else if ("ShortMessage".equals(platform.getName())) {
					 * paramsToShare.setText(title + message + url); }
					 */

            }
        });

        oks.show(context);

    }

    //设置mob分享sdk
    //文档地址: http://wiki.mob.com/android-sharesdk%E5%AE%8C%E6%95%B4%E7%9A%84%E9%9B%86%E6%88%90%E6%96%87%E6%A1%A3/
    public static void initSDK(Context context,String env){

        ShareSDK.initSDK(context, "4f6563a45988");  //app_key

        HashMap<String,Object> hashMap = new HashMap<String, Object>();
        hashMap.put("Enable","true");
        hashMap.put("BypassApproval", "false");

        if(env.toLowerCase().equals(PRO)){
            hashMap.put("AppId","wxb54769d33fe19505");
            hashMap.put("AppSecret", "7d83dd38bc4ae5008be895f2b1774d36");

            hashMap.put("Id","0");
            hashMap.put("SortId","0");
            ShareSDK.setPlatformDevInfo(Wechat.NAME, hashMap);

            hashMap.put("Id","1");
            hashMap.put("SortId","1");
            ShareSDK.setPlatformDevInfo(WechatMoments.NAME,hashMap);
        }else if(env.toLowerCase().equals(UAT)){
            hashMap.put("AppId","wxa3f9c401813ad489");
            hashMap.put("AppSecret","b1769ff2733509cdfdf1dcf233f49d0d");

            hashMap.put("Id","0");
            hashMap.put("SortId","0");
            ShareSDK.setPlatformDevInfo(Wechat.NAME, hashMap);

            hashMap.put("Id","1");
            hashMap.put("SortId","1");
            ShareSDK.setPlatformDevInfo(WechatMoments.NAME,hashMap);
        }else if(env.toLowerCase().equals(SIT)){
            hashMap.put("AppId","wx50cfad9639c1fb94");
            hashMap.put("AppSecret","bcf2fe04dc458cd3d21a44ad99bf3a52");

            hashMap.put("Id","0");
            hashMap.put("SortId","0");
            ShareSDK.setPlatformDevInfo(Wechat.NAME, hashMap);

            hashMap.put("Id","1");
            hashMap.put("SortId","1");
            ShareSDK.setPlatformDevInfo(WechatMoments.NAME,hashMap);
        }
//        else if(Constants.isFt()){
//            hashMap.put("AppId","wx0307965674adaf7e");
//            hashMap.put("AppSecret","b9781ae8f34974c10e2ed0a2cf107b26");
//
//            hashMap.put("Id","0");
//            hashMap.put("SortId","0");
//            ShareSDK.setPlatformDevInfo(Wechat.NAME, hashMap);
//
//            hashMap.put("Id","1");
//            hashMap.put("SortId","1");
//            ShareSDK.setPlatformDevInfo(WechatMoments.NAME,hashMap);
//        }else if(Constants.isDev()){
//            hashMap.put("AppId","wxb7062b0a2b9394d3");
//            hashMap.put("AppSecret","40fdad3d38dcd6074002951e24b02ff8");
//
//            hashMap.put("Id","0");
//            hashMap.put("SortId","0");
//            ShareSDK.setPlatformDevInfo(Wechat.NAME, hashMap);
//
//            hashMap.put("Id","1");
//            hashMap.put("SortId","1");
//            ShareSDK.setPlatformDevInfo(WechatMoments.NAME,hashMap);
//        }


    }




}
