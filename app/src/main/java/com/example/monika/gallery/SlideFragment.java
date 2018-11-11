package com.example.monika.gallery;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SlideFragment extends Fragment {

    long animationDuration = 1000; // miliseconds


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //View root = inflater.inflate(R.layout.fragment_slide, container, false);

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_slide, container, false);


        ImageView detailsView = rootView.findViewById(R.id.detailsView);

        int imgPosition = getActivity().getIntent().getExtras().getInt("imgId");

        Integer[] mThumbIds = {
                R.drawable.img1, R.drawable.img2, R.drawable.img3,
                R.drawable.img4, R.drawable.img5, R.drawable.img6,
                R.drawable.img7, R.drawable.img8, R.drawable.img9,
                R.drawable.img10, R.drawable.img11, R.drawable.img12
        };



        detailsView.setImageResource(mThumbIds[imgPosition]);
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(detailsView, View.ALPHA, 0.0f, 1.0f);
        alphaAnimation.setDuration(animationDuration);
        alphaAnimation.start();
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.playTogether(alphaAnimation);
//        animatorSet.start();

        return rootView ;


    }


}
