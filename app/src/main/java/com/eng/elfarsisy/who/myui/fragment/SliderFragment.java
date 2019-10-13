package com.eng.elfarsisy.who.myui.fragment;


import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.eng.elfarsisy.who.R;
import com.eng.elfarsisy.who.adapter.SliderAdapter;
import com.eng.elfarsisy.who.model.Slider;
import com.eng.elfarsisy.who.myui.activity.Start;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SliderFragment extends Fragment {
    ViewPager sliderPager;
    List<Slider> sliderList;
    TableLayout indicator;
    ViewGroup container;

    @BindView(R.id.skipbtn)
    Button skipbtn;

    public SliderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slider, container, false);
        sliderList = new ArrayList<>();
        sliderList.add(new Slider(R.drawable.alone, "don’ّt be alone more"));
        sliderList.add(new Slider(R.drawable.unityphoto, "let’s be unit"));
        sliderList.add(new Slider(R.drawable.pexelsphoto, " become friends "));
        sliderList.add(new Slider(R.drawable.celebratingphoto, "and celebrating togther"));

        sliderPager = view.findViewById(R.id.sliderPager);
        skipbtn = view.findViewById(R.id.skipbtn);
        SliderAdapter sliderAdapter = new SliderAdapter(container.getContext(), sliderList);

        sliderPager.setAdapter(sliderAdapter);

        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Start().moveToSignInFragment();
            }
        });
        return view;
    }





}
