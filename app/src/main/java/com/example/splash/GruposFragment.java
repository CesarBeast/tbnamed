package com.example.splash;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class GruposFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public GruposFragment() {
        // Required empty public constructor
    }

    public static GruposFragment newInstance(String param1, String param2) {
        GruposFragment fragment = new GruposFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grupos, container, false);

        ImageView backgroundOne = view.findViewById(R.id.background_one);
        ImageView backgroundTwo = view.findViewById(R.id.background_two);
        startBackgroundAnimation(backgroundOne, backgroundTwo);

        Button grupo1 = view.findViewById(R.id.boton1);
        Button grupo2 = view.findViewById(R.id.boton2);
        Button grupo3 = view.findViewById(R.id.boton3);

        grupo1.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), chatGroup.class);
            startActivity(intent);
        });

        grupo2.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), chatGroup2.class);
            startActivity(intent);
        });

        grupo3.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), chatGroup3.class);
            startActivity(intent);
        });

        return view;
    }

    private void startBackgroundAnimation(ImageView backgroundOne, ImageView backgroundTwo) {
        final ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(10000L);
        animator.addUpdateListener(animation -> {
            final float progress = (float) animation.getAnimatedValue();
            final float width = backgroundOne.getWidth();
            final float translationX = width * progress;
            backgroundOne.setTranslationX(translationX);
            backgroundTwo.setTranslationX(translationX - width);
        });
        animator.start();
    }
}