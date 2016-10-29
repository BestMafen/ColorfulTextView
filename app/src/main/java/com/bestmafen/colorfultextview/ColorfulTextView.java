package com.bestmafen.colorfultextview;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class ColorfulTextView extends TextView {
    private int mPosition = 0;

    public ColorfulTextView(Context context) {
        this(context, null);
    }

    public ColorfulTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorfulTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setHighlightColor(Color.TRANSPARENT);
        setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void appendText(Text text, OnTextClickListener onTextClickListener) {
        if (text != null && !TextUtils.isEmpty(text.text)) {
            SpannableString ss = new SpannableString(text.text);
            ss.setSpan(new ForegroundColorSpan(text.color), 0, text.text.length(), Spannable
                    .SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(new AbsoluteSizeSpan(sp2px(text.textSize), false), 0, text.text.length(), Spannable
                    .SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(new Clickable(onTextClickListener, mPosition, text.text), 0, text.text.length(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            append(ss);
            mPosition++;
        }
    }

    public void clear() {
        mPosition = 0;
        setText("");
    }

    public int sp2px(int sp) {
        final float fontScale = getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (sp * fontScale + 0.5f);
    }

    class Clickable extends ClickableSpan {
        private final OnTextClickListener textClickListener;
        private int position;
        private String s;

        Clickable(OnTextClickListener clickListener, int position, String s) {
            this.textClickListener = clickListener;
            this.position = position;
            this.s = s;
        }

        @Override
        public void onClick(View widget) {
            if (textClickListener != null) {
                textClickListener.onTextClick(ColorfulTextView.this, position, s);
            }
        }

        @Override
        public void updateDrawState(TextPaint ds) {
        }
    }

}
