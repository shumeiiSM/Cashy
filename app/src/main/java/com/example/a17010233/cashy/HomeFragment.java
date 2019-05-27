package com.example.a17010233.cashy;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    Button btnYouOwe, btnOweYou;
    FloatingActionButton fab_add, fab_minus, fab;
    Animation FabOpen, FabClose, FabClock, FabAntiClock;
    boolean isOpen = false;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Inflate the layout for this fragment
        View rootView = getActivity().findViewById(android.R.id.content);
        Snackbar.make(rootView, "Hello Home", Snackbar.LENGTH_LONG).show();

        btnYouOwe = view.findViewById(R.id.btnB);
        btnOweYou = view.findViewById(R.id.btnO);

        fab = view.findViewById(R.id.fab);
        fab_add = view.findViewById(R.id.fab_add);
        fab_minus = view.findViewById(R.id.fab_minus);

        FabOpen = AnimationUtils.loadAnimation(getActivity(), R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getActivity(), R.anim.fab_close);
        FabClock = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_closewise);
        FabAntiClock = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_anticlockwise);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fab.setImageResource(R.drawable.ic_close);
                if (isOpen) {
                    fab_add.startAnimation(FabClose);
                    fab_minus.startAnimation(FabClose);
                    fab.startAnimation(FabAntiClock);
                    fab_add.setClickable(false);
                    fab_minus.setClickable(false);
                    isOpen = false;

                } else {
                    fab_add.startAnimation(FabOpen);
                    fab_minus.startAnimation(FabOpen);
                    fab.startAnimation(FabClock);
                    fab_add.setClickable(true);
                    fab_minus.setClickable(true);
                    isOpen = true;
                }
            }
        });

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddBill.class);
                startActivity(intent);
            }
        });

        fab_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddBill.class);
                startActivity(intent);
            }
        });

        btnYouOwe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), YouOwe.class);
                startActivity(intent);
            }
        });

        btnOweYou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OweYou.class);
                startActivity(intent);
            }
        });



        return view;
    }

}
