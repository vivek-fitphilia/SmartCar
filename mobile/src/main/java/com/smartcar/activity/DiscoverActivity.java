package com.smartcar.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.smartcar.R;
import com.smartcar.common.view.HoloCircularProgressBar;
import com.smartcar.common.view.HueShiftImageView;
import com.smartcar.core.MessageId;
import com.smartcar.core.SmartCarActivity;

public class DiscoverActivity extends SmartCarActivity {

    @Override
    protected void onResume() {
        super.onResume();
        reset();
    }

    public void reset() {
        _runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // change button text on done
                ((TextView) findViewById(R.id.calibrate_next_button_left)).setText("next");
                ((TextView) findViewById(R.id.calibrate_next_button_right)).setText("position");
                ((TextView) findViewById(R.id.progress_value)).setText(Integer.toString(0));
            }
        });
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override
    protected void onThemeChange(final int appColor, final float hue) {
        super.onThemeChange(appColor, hue);
        _runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((HueShiftImageView) findViewById(R.id.logo)).shiftHue(hue);
                findViewById(R.id.discover_next_button).setBackground(createBigButtonStateList(appColor));
                ((TextView) findViewById(R.id.progress_label)).setTextColor(appColor);
                ((HoloCircularProgressBar) findViewById(R.id.progress)).setProgressColor(appColor);
            }
        });
    }

    @Override
    protected int getContentViewId() {
        return R.layout.discover_activity;
    }

    @Override
    public void onMessageReceived(MessageId id, String message) {

    }
}
