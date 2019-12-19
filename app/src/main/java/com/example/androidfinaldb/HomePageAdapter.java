package com.example.androidfinaldb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class HomePageAdapter extends ArrayAdapter<Car> {
    private Context mContext;
    private ArrayList<Car> mData;

    public HomePageAdapter(Context context, ArrayList<Car> data){
        super(context,R.layout.list_car_item);
        mContext = context;
        mData = data;
    }

    @Nullable
    @Override
    public Car getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Car data = getItem(position);
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_car_item,null);

            holder.tvModel = convertView.findViewById(R.id.tv_model);
            holder.img = convertView.findViewById(R.id.img_model);

            convertView.setTag(holder);
        } else{
            holder = (ViewHolder) convertView.getTag();
        }
        Car model = (Car) getItem(position);

        String carModel = data.getModel();
        holder.tvModel.setText(carModel);
        holder.img.setImageResource(model.getImg());

        return convertView;
    }

    private class ViewHolder{
        TextView tvModel;
        ImageView img;
    }

    public void updateData(ArrayList<Car> newData){
        mData.clear();
        mData.addAll(newData);
        notifyDataSetChanged();
    }
}
