package com.eng.elfarsisy.who.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.eng.elfarsisy.who.R;
import com.eng.elfarsisy.who.model.Slider;

import java.util.List;

public class SliderAdapter extends PagerAdapter {
    Context mContext;
    List<Slider> mlist;

    public SliderAdapter(Context mContext, List<Slider> mlist) {
        this.mContext = mContext;
        this.mlist = mlist;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sliderLayout = inflater.inflate(R.layout.slider_item, null);
        ImageView slideImage = sliderLayout.findViewById(R.id.sliderImage);
        TextView slideTxt = sliderLayout.findViewById(R.id.sliderTitle);
        slideImage.setImageResource(mlist.get(position).getImage());
        slideTxt.setText(mlist.get(position).getTitle());
        container.addView(sliderLayout);
        return sliderLayout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


}
