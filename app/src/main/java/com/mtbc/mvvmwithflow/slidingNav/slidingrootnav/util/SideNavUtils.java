package com.mtbc.mvvmwithflow.slidingNav.slidingrootnav.util;


public abstract class SideNavUtils {

    public static float evaluate(float fraction, float startValue, float endValue) {
        return startValue + fraction * (endValue - startValue);
    }
}
