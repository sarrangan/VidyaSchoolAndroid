package devi.vidyaschool.widget;

import devi.vidyaschool.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class RobotoTextView extends TextView {

	public RobotoTextView(Context context, AttributeSet attrs){
		super(context, attrs);
        TypedArray styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.RobotoTextTypeFace);
        String fontName = styledAttrs.getString(R.styleable.RobotoTextTypeFace_typeface);
        styledAttrs.recycle();

        if (fontName != null) {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), fontName);
            setTypeface(typeface);
        }
	}

}
