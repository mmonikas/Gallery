package com.example.monika.gallery;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Binder;
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
    @BindView(R.id.pager) ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private SlidingImage_Adapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);

        int imgPosition = getIntent().getExtras().getInt("imgId");

        mPagerAdapter = new SlidingImage_Adapter(DetailsActivity.this,
                ImagesSource.getInstance().images);
        mPager.setAdapter(mPagerAdapter);
        mPager.setCurrentItem(imgPosition);
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if (i == ViewPager.SCROLL_STATE_IDLE) {
                    int index = mPager.getCurrentItem();
                    if (index == 0)
                        mPager.setCurrentItem(mPagerAdapter.getCount() - 1, false);
                    else if (index == mPagerAdapter.getCount() - 1)
                        mPager.setCurrentItem(0, false);
                }
            }
        });
  }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}


