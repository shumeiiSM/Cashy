package com.example.a17010233.cashy;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddBillAdapter extends BaseAdapter {

    Activity activity;
    List<Friend> users;
    LayoutInflater inflater;


    public AddBillAdapter(Activity activity) {
        this.activity = activity;
    }

    public AddBillAdapter(Activity activity, List<Friend> users) {
        this.activity = activity;
        this.users = users;
        inflater = activity.getLayoutInflater();
    }


    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = null;

        if (view == null){
            view = inflater.inflate(R.layout.oweyou, viewGroup, false);

            holder = new ViewHolder();

            holder.tvUserName = view.findViewById(R.id.name);
            holder.ivCheckBox = view.findViewById(R.id.ivCheck);

            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        Friend model = users.get(i);
        holder.tvUserName.setText(model.getName());

        if (model.isSelected()) {
            holder.ivCheckBox.setBackgroundResource(R.drawable.checked);
        } else {
            holder.ivCheckBox.setBackgroundResource(R.drawable.check);
        }

        return view;

    }

    public void updateRecords(List<Friend> users){
        this.users = users;

        notifyDataSetChanged();
    }

    class ViewHolder{

        TextView tvUserName;
        ImageView ivCheckBox;

    }
}