package com.example.monika.gallery;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends FragmentActivity {

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

        mPagerAdapter = new SlidingImage_Adapter(DetailsActivity.this, ImagesSource.getInstance().images);
        mPager.setAdapter(mPagerAdapter);
        mPager.setCurrentItem(imgPosition);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            float sumPositionAndPositionOffset;
            boolean leftToRight;

            @Override
            public void onPageScrolled(int i, float v, int i1) {
                if(i + v > sumPositionAndPositionOffset)
                    //swipe from right to left
                    leftToRight = false;
                else
                    leftToRight = true;
                        //swipe from left to right

                sumPositionAndPositionOffset = i + v;
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if (i == ViewPager.SCROLL_STATE_DRAGGING) {
                    int index = mPager.getCurrentItem();
                    if(leftToRight) {
                        if (index == mPagerAdapter.getCount() - 1) {
                            mPager.setCurrentItem(0, false);

                        }
                        else if (index == 0) {
                            mPager.setCurrentItem(mPagerAdapter.getCount() - 1, false);
                        }
                    }
//                    else {
//                        if (index == 0) {
//                            mPager.setCurrentItem(mPagerAdapter.getCount() - 1, false);
//
//                        }
//                    }
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


