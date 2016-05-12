package com.test.animator;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/5/12.
 */
public class FloatBtnActivity extends Activity {

    private boolean opened = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float);
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.imageView_a:
                if (!opened) {
                    startAnim();
                } else {
                    closeAnim();
                }
                opened = !opened;
                break;
            default:
                Toast.makeText(this, "" + view.getId(), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void closeAnim() {
        for (int i = 0; i < 7; i++) {
            char c = (char) ('b' + i);
            int id = getResources().getIdentifier("imageView_" + c, "id", getPackageName());
            View target = findViewById(id);
            ObjectAnimator animator = ObjectAnimator.ofFloat(target, "y", i * 100 + 100, 0);
            animator.setDuration(500);
            animator.setInterpolator(new BounceInterpolator());
            animator.setStartDelay(i * 200);
            animator.start();
        }
    }

    private void startAnim() {
        for (int i = 0; i < 7; i++) {
            char c = (char) ('b' + i);
            int id = getResources().getIdentifier("imageView_" + c, "id", getPackageName());
            View target = findViewById(id);
            ObjectAnimator animator = ObjectAnimator.ofFloat(target, "y", 0, i * 100 + 100);
            animator.setDuration(500);
            animator.setInterpolator(new BounceInterpolator());
            animator.setStartDelay(i * 200);
            animator.start();
        }
    }
}
