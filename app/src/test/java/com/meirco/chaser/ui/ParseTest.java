package com.meirco.chaser.ui;

import android.os.Build;

import com.meirco.chaser.BuildConfig;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.fail;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class,
        sdk = Build.VERSION_CODES.KITKAT)
public class ParseTest {

    @Test
    public void shouldCreateObject() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        ParseObject parseObject = new ParseObject("testObj");
        parseObject.put("key1", 3);
        parseObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    fail(e.getMessage());
                }
            }
        });
    }

}
