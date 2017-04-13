package org.widget.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Nick on 2017/4/12
 */
public class ViewUtil {
    public static View loadView(int layoutRes, Context context) {
        return LayoutInflater.from(context).inflate(layoutRes, null);
    }

    public static View loadView(int layoutRes, ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(layoutRes, parent, false);
    }
}
