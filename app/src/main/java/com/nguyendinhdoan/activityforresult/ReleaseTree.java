package com.nguyendinhdoan.activityforresult;

import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import timber.log.Timber;

public class ReleaseTree extends Timber.Tree {
    @Override
    protected void log(int priority, @Nullable String tag, @NotNull String message, @Nullable Throwable t) {
        if (priority == Log.DEBUG || priority == Log.VERBOSE) {
            return;
        }

        // firebase crashlytics
    }
}
