package com.test.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void imgClick(View view) {
        Toast.makeText(this, "imgClicked", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, FloatBtnActivity.class));
    }

    public void btnClick(View view) {
        View imageView = findViewById(R.id.imageView);
//        TranslateAnimation animation = new TranslateAnimation(0, 200, 0, 0);
//        animation.setDuration(1000);
//        animation.setFillAfter(true);
//        imageView.startAnimation(animation);

//        ObjectAnimator.ofFloat(imageView, "translationX", 0, 200).setDuration(1000).start();
//        ObjectAnimator.ofFloat(imageView, "x", 0, 200).setDuration(1000).start();
//        ObjectAnimator.ofFloat(imageView, "y", 0, 200).setDuration(1000).start();
//        ObjectAnimator.ofFloat(imageView, "rotation", 0, 360).setDuration(1000).start();

//        PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("x", 0, 200);
//        PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("y", 0, 200);
//        PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("rotation", 0, 360);
//        ObjectAnimator.ofPropertyValuesHolder(imageView, p1, p2, p3).setDuration(1000).start();

//        ObjectAnimator oa1 = ObjectAnimator.ofFloat(imageView, "x", 0, 200).setDuration(1000);
//        ObjectAnimator oa2 = ObjectAnimator.ofFloat(imageView, "y", 0, 200).setDuration(1000);
//        ObjectAnimator oa3 = ObjectAnimator.ofFloat(imageView, "rotation", 0, 360).setDuration(1000);
//        AnimatorSet set = new AnimatorSet();
//        set.setDuration(1000);
////        set.playTogether(oa1, oa2, oa3);
////        set.playSequentially(oa1, oa2, oa3);
//        set.play(oa1).with(oa2);
//        set.play(oa3).after(oa1);
//        set.start();

        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "rotation", 0, 360).setDuration(1000);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(MainActivity.this, "onAnimationEnd", Toast.LENGTH_SHORT).show();
            }
        });
//        animator.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animator) {
//                Toast.makeText(MainActivity.this, "onAnimationEnd", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animator) {
//
//            }
//        });
        animator.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
