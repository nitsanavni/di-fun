package com.meirco.chaser.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import javax.inject.Inject;

public class GroupGoalView extends RelativeLayout {
    @Inject
    GroupGoal goal;

    public GroupGoalView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ((GroupGoalViewInjector) ((HasComponent) context).getComponent()).inject(this);
    }

    public GroupGoal getCurrentGoal() {
        return this.goal;
    }
}
