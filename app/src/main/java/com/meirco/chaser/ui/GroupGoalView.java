package com.meirco.chaser.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import javax.inject.Inject;

public class GroupGoalView extends RelativeLayout {
    @Inject
    private GroupGoal goal;

    public GroupGoalView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GroupGoal getCurrentGoal() {
        return this.goal;
    }
}
