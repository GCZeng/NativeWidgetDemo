package org.widget.utils;

import android.widget.TextView;

/**
 * Created by Nick on 2017/4/12
 */
public class TextUtil {
    public static void setText(TextView textView, String text) {
        if (textView == null) {
            return;
        }
        textView.setText(text);
    }
}
