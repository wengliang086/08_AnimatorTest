package com.test.animator;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/5/12.
 */
public class FloatBtnActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float);
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.imageView:
                startAnim();
                break;
            default:
                Toast.makeText(this, "" + view.getId(), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void startAnim() {
        for (int i = 0; i < 7; i++) {
            int id = getResources().getIdentifier(('b' + i) + "", "drawable", getPackageName());
            View target = findViewById(id);
            ObjectAnimator.ofFloat(target, "y", 0, i * 100 + 100).setDuration(1000).start();
        }
    }
}
