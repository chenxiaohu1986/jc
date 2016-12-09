package com.ihandy.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 粗体
 */
public class BoldTextView extends TextView {

	private static Typeface boldTypeFace;

	private static Typeface getBoldTypeFace(Context ctx) {
		if (boldTypeFace == null) {
			boldTypeFace = Typeface.createFromAsset(ctx.getAssets(),"fonts/bold.ttf");
		}
		return boldTypeFace;
	}

	public BoldTextView(Context context) {
		this(context, null);
	}

	public BoldTextView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public BoldTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		if (!isInEditMode()) {
			setTypeface(getBoldTypeFace(context));
		}
	}

}
