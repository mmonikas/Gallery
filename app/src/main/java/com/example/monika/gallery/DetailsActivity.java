package com.example.monika.gallery;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends FragmentActivity {

    private static final int NUM_PAGES = 12;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    public Integer[] mResources = {
            R.drawable.img1, R.drawable.img2, R.drawable.img3,
            R.drawable.img4, R.drawable.img5, R.drawable.img6,
            R.drawable.img7, R.drawable.img8, R.drawable.img9,
            R.drawable.img10, R.drawable.img11, R.drawable.img12
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new SlidingImage_Adapter(DetailsActivity.this, mResources);

        int imgPosition = getIntent().getExtras().getInt("imgId");

        //PagerAdapter = new CustomPagerAdapter(this, mResources);
        mPager.setAdapter(mPagerAdapter);
        mPager.setCurrentItem(imgPosition);


    }

    @Override
    public void finish() {
        super.finish();

        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}

    //@Override
//    public void onBackPressed() {
//        if (mPager.getCurrentItem() == 0) {
//            // If the user is currently looking at the first step, allow the system to handle the
//            // Back button. This calls finish() on this activity and pops the back stack.
//            super.onBackPressed();
//        } else {
//            // Otherwise, select the previous step.
//            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
//        }
//    }





    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
//     */
//    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
//
//        public ScreenSlidePagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return new SlideFragment();
//        }
//
//        @Override
//        public int getCount() {
//            return NUM_PAGES;
//        }
//
//        @NonNull
//        @Override
//        public Object instantiateItem(@NonNull ViewGroup container, int position) {
//            return super.instantiateItem(container, position);
//        }
//    }








//
//    @BindView(R.id.detailsView) ImageView detailsView;
//
//    long animationDuration = 1000; // miliseconds
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.view_pager);
//
//        ButterKnife.bind(this);
//
////        int imgPosition = getIntent().getExtras().getInt("imgId");
////
////        Integer[] mThumbIds = {
////                R.drawable.img1, R.drawable.img2, R.drawable.img3,
////                R.drawable.img4, R.drawable.img5, R.drawable.img6,
////                R.drawable.img7, R.drawable.img8, R.drawable.img9,
////                R.drawable.img10, R.drawable.img11, R.drawable.img12
////        };
////
////
////        detailsView.setImageResource(mThumbIds[imgPosition]);
////        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(detailsView, View.ALPHA, 0.0f, 1.0f);
////        alphaAnimation.setDuration(animationDuration);
////        alphaAnimation.start();
//////        AnimatorSet animatorSet = new AnimatorSet();
//////        animatorSet.playTogether(alphaAnimation);
//////        animatorSet.start();
//
//    }

