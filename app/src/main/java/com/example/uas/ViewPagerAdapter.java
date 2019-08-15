package com.example.uas;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

//Tanggal :13 Agustus 2019
//Nim     :10116557
//Nama    :Hari Darmawan
//Kelas   :IF-13

public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    public int[] img_item = {
            R.drawable.pict_slide1,
            R.drawable.pict_slide2,
            R.drawable.pict_slide3
    };

    public String[] title_slide = {
            "My Profile",
            "My Contact",
            "My Friends"
    };

    @Override
    public int getCount() {
        return img_item.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_slide, container, false);

        ImageView imageView = view.findViewById(R.id.img_item_slide);
        TextView textView = view.findViewById(R.id.text_item_slide);

        imageView.setBackgroundResource(img_item[position]);
        textView.setText(title_slide[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
