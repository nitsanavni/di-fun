package com.meirco.chaser;

import android.content.Context;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class ChaserParseInitializer {
    private static final String TAG = "parseinit";
    static final String PARSE_APP_ID = "vPhFNJIHJoj0uYHFuIjq6KkzGxj4HPohD27BFilX";
    static final String PARSE_CLIENT_KEY = "hy6HcfxH10bcbbZBUtSNDVjqJvuGcrn9QdxKSFO8";
    private final Context context;

    public ChaserParseInitializer(Context context) {
        this.context = context;
    }

    void init() {
        try {
            Parse.initialize(context, PARSE_APP_ID, PARSE_CLIENT_KEY);
        } catch (Exception e) {
            Log.e(TAG, e.getClass().getSimpleName()+ " " + e.getMessage());
        }
        ParseObject parseObject = new ParseObject("testObj");
        parseObject.put("key1", 3);
        parseObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                Log.d(TAG, "done " + ((null == e) ? "" : e.getMessage()));
            }
        });
    }
}