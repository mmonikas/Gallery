package com.example.monika.gallery;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SlidingImage_Adapter extends PagerAdapter {


    private Integer[] IMAGES;
    private LayoutInflater inflater;
    private Context context;
    long animationDuration = 1000; // miliseconds


    public SlidingImage_Adapter(Context context, Integer[] IMAGES) {
        this.context = context;
        this.IMAGES=IMAGES;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return IMAGES.length;
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.image_details, view, false);

        assert imageLayout != null;
        final ImageView imageView = imageLayout
                .findViewById(R.id.imageView_details);


        imageView.setImageResource(IMAGES[position]);
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(imageView, View.ALPHA, 0.0f, 1.0f);
        alphaAnimation.setDuration(animationDuration);
        alphaAnimation.start();
        view.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

}
