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
        initDi(context);
    }

    private void initDi(Context context) {
        getInjector((HasComponent) context).inject(this);
    }

    private GroupGoalViewInjector getInjector(HasComponent context) {
        return (GroupGoalViewInjector) context.getComponent();
    }

    public GroupGoal getCurrentGoal() {
        return this.goal;
    }
}
