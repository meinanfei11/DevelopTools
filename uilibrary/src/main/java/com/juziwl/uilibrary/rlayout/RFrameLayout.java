package com.juziwl.uilibrary.rlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.juziwl.uilibrary.rlayout.helper.RBaseHelper;
import com.juziwl.uilibrary.rlayout.iface.RHelper;


/**
 * RFrameLayout
 *
 * @author ZhongDaFeng
 */
public class RFrameLayout extends FrameLayout implements RHelper<RBaseHelper> {

    private RBaseHelper mHelper;

    public RFrameLayout(Context context) {
        this(context, null);
    }

    public RFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mHelper = new RBaseHelper(context, this, attrs);
    }

    @Override
    public RBaseHelper getHelper() {
        return mHelper;
    }
}
