package com.example.monika.gallery;

public class ImagesSource {

    public Integer[] images =  new Integer[]{
        R.drawable.img1, R.drawable.img2, R.drawable.img3,
                R.drawable.img4, R.drawable.img5, R.drawable.img6,
                R.drawable.img7, R.drawable.img8, R.drawable.img9,
                R.drawable.img10, R.drawable.img11, R.drawable.img12};

    private static ImagesSource imagesSource_instance = null;

    private ImagesSource() {
    }

    public static ImagesSource getInstance()
    {
        if (imagesSource_instance == null)
            imagesSource_instance = new ImagesSource();

        return imagesSource_instance;
    }
}
