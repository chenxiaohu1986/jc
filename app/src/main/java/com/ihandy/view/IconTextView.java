package com.ihandy.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 图标字体
 */
public class IconTextView extends TextView {
	
	private  static Typeface iconTypeFace ;
	
	private static Typeface getIconTypeFace(Context ctx){
    	if(iconTypeFace==null){
    		iconTypeFace = Typeface.createFromAsset(ctx.getAssets(),"fonts/uik_iconfont.ttf");   //图标字体
    	}
    	return iconTypeFace;
    }
	
	public IconTextView(Context context, AttributeSet attrs,int defStyle) {
        super(context, attrs, defStyle);
        if(!isInEditMode()){
        	setTypeface(getIconTypeFace(context));
        }
    }

    public IconTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode()){
        	setTypeface(getIconTypeFace(context));
        }
    }

    public IconTextView(Context context) {
        super(context);
        if(!isInEditMode()){
        	setTypeface(getIconTypeFace(context));
        }
    }
    
    
    
}
