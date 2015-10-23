package com.meirco.chaser.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class GroupGoalView extends RelativeLayout {
    public GroupGoalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public GroupGoalView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GroupGoal getCurrentGoal() {
        return null;
    }
}
