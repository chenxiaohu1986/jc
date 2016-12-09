package com.ihandy.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 细体
 */
public class LightTextView extends TextView {
	
	private  static Typeface lightTypeFace;
	
	private static Typeface getLightTypeFace(Context ctx){
    	if(lightTypeFace==null){
    		lightTypeFace = Typeface.createFromAsset(ctx.getAssets(),"fonts/light.ttf");  
    	}
    	return lightTypeFace;
    }
	
	public LightTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if(!isInEditMode()){
        	setTypeface(getLightTypeFace(context));
        }
    }

    public LightTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode()){
        	setTypeface(getLightTypeFace(context));
        }
    }

    public LightTextView(Context context) {
        super(context);
        if(!isInEditMode()){
        	setTypeface(getLightTypeFace(context));
        }
    }
   
}
