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
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    Button btnYouOwe, btnOweYou;
    FloatingActionButton fab_add, fab_minus, fab;
    LinearLayout addL, minusL;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Inflate the layout for this fragment
        View rootView = getActivity().findViewById(android.R.id.content);
        //String myName = getActivity().getIntent().getExtras().getString("name");

        //Snackbar.make(rootView, "Hello " + myName, Snackbar.LENGTH_LONG).show();
        Snackbar.make(rootView, "Hello ", Snackbar.LENGTH_LONG).show();


        btnYouOwe = view.findViewById(R.id.btnB);
        btnOweYou = view.findViewById(R.id.btnO);

        fab = view.findViewById(R.id.fab);
        fab_add = view.findViewById(R.id.fab_add);
        fab_minus = view.findViewById(R.id.fab_minus);

        addL = view.findViewById(R.id.addLayout);
        minusL = view.findViewById(R.id.minusLayout);

        final Animation showBtn = AnimationUtils.loadAnimation(getActivity(), R.anim.show_btn);
        final Animation hideBtn = AnimationUtils.loadAnimation(getActivity(), R.anim.hide_btn);
        final Animation showLay = AnimationUtils.loadAnimation(getActivity(), R.anim.show_layout);
        final Animation hideLay = AnimationUtils.loadAnimation(getActivity(), R.anim.hide_layout);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addL.getVisibility() == View.VISIBLE && minusL.getVisibility() == View.VISIBLE) {
                    addL.setVisibility(View.GONE);
                    minusL.setVisibility(View.GONE);
                    fab.startAnimation(hideBtn);
                    addL.startAnimation(hideLay);
                    minusL.startAnimation(hideLay);
                    fab.setImageResource(R.drawable.ic_close);

                } else {
                    addL.setVisibility(View.VISIBLE);
                    minusL.setVisibility(View.VISIBLE);
                    fab.startAnimation(showBtn);
                    addL.startAnimation(showLay);
                    minusL.startAnimation(showLay);
                    fab.setImageResource(R.drawable.ic_add);
                }

            }
        });


        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddBill.class);
                startActivity(intent);

                addL.setVisibility(View.GONE);
                minusL.setVisibility(View.GONE);
                fab.startAnimation(hideBtn);
                addL.startAnimation(hideLay);
                minusL.startAnimation(hideLay);
                fab.setImageResource(R.drawable.ic_close);

            }
        });

        fab_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddOweBill.class);
                startActivity(intent);

                addL.setVisibility(View.GONE);
                minusL.setVisibility(View.GONE);
                fab.startAnimation(hideBtn);
                addL.startAnimation(hideLay);
                minusL.startAnimation(hideLay);
                fab.setImageResource(R.drawable.ic_close);
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
