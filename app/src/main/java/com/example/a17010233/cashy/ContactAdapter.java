package com.example.a17010233.cashy;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private ArrayList<Contact> mContactList;

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView name;
        public TextView phone;

        public RelativeLayout foreBackground;


        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.tvname);
            phone = itemView.findViewById(R.id.tvphone);

            foreBackground = itemView.findViewById(R.id.view_forebackground);

        }
    }

    public ContactAdapter(ArrayList<Contact> contactsList) {
        mContactList = contactsList;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact, parent, false);
        ContactViewHolder cvh = new ContactViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int position) {
        Contact currentItem = mContactList.get(position);
        contactViewHolder.mImageView.setImageResource(currentItem.getmImageResource());
        contactViewHolder.name.setText(currentItem.getName());
        contactViewHolder.phone.setText(currentItem.getPhone());

    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }

    public void removeItem(int position) {
        mContactList.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(Contact contact, int position) {
        mContactList.add(position, contact);
        notifyItemInserted(position);
    }
}
