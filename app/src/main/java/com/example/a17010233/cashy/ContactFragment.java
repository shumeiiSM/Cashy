package com.example.a17010233.cashy;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;


import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ContactAdapter adapter;
    private ArrayList<Contact> contacts;

    FloatingActionButton fab;



    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_contact, container, false);

        //final ArrayList<Contact> contacts = new ArrayList<>();
        contacts = new ArrayList<>();
        contacts.add(new Contact(R.drawable.ic_female, "Vanessa", "91234567"));
        contacts.add(new Contact(R.drawable.ic_male, "Shao Jie", "92345678"));
        contacts.add(new Contact(R.drawable.ic_male, "Jerome", "93456789"));
        contacts.add(new Contact(R.drawable.ic_female, "Alvina", "94567890"));
        contacts.add(new Contact(R.drawable.ic_male, "Norman", "95678901"));


        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());

        adapter = new ContactAdapter(contacts);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(adapter);

        //View root = getActivity().findViewById(android.R.id.content);
        ItemTouchHelper.SimpleCallback simpleCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this);

        new ItemTouchHelper(simpleCallback).attachToRecyclerView(mRecyclerView);

        fab = view.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.add_friend, null);

                final EditText etName = viewDialog.findViewById(R.id.editTextN);
                final EditText etNum = viewDialog.findViewById(R.id.editTextNum);
                final RadioButton etMale = viewDialog.findViewById(R.id.radioButtonM);
                final RadioButton etFemale = viewDialog.findViewById(R.id.radioButtonF);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(view.getContext());
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Add New Friend");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Extract the text entered by the user
                        String theName = etName.getText().toString();
                        String theNum = etNum.getText().toString();

//                        String theMale = etMale.getText().toString();
//                        String theFemale = etFemale.getText().toString();


                        if (etMale.isChecked()) {
                            contacts.add(new Contact(R.drawable.ic_male, theName, theNum));
                        } else {
                            contacts.add(new Contact(R.drawable.ic_female, theName, theNum));
                        }
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });



        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onSwipe(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof ContactAdapter.ContactViewHolder) {

            String name = contacts.get(viewHolder.getAdapterPosition()).getText1();
            final Contact contact = contacts.get(viewHolder.getAdapterPosition());
            final int deletedIndex = viewHolder.getAdapterPosition();

            adapter.removeItem(viewHolder.getAdapterPosition());

            undoItem(viewHolder, name, contact,deletedIndex);

        }
    }

    private void undoItem(RecyclerView.ViewHolder viewHolder, String name, final Contact contact, final int deletedIndex) {

        Snackbar snackbar = Snackbar.make(((ContactAdapter.ContactViewHolder)viewHolder).foreBackground,name + " is deleted", Snackbar.LENGTH_LONG);
        snackbar.setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.restoreItem(contact, deletedIndex);
            }
        });

        snackbar.setActionTextColor(Color.YELLOW);
        snackbar.show();
    }
}
