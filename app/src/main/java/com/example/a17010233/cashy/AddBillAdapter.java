package com.example.a17010233.cashy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AddBillAdapter extends ArrayAdapter<Contact> {

    private ArrayList<Contact> contacts;
    private Context context;
    private TextView tvName;

    public AddBillAdapter(Context context, int resource, ArrayList<Contact> objects) {
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        contacts = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.oweyou, parent, false);

        // Get the TextView object
        tvName = rowView.findViewById(R.id.name);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Contact currentName = contacts.get(position);

        // Set the TextView to show the name
        tvName.setText(currentName.getName());

        // Return the nicely done up View to the ListView
        return rowView;
    }
}
