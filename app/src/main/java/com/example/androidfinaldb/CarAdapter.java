package com.example.androidfinaldb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CarAdapter extends ArrayAdapter<Car> {
    private Context mContext;
    private ArrayList<Car> mData;

    public CarAdapter(Context context,ArrayList<Car> data){
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
            holder.tvVariant = convertView.findViewById(R.id.tv_variant);
            holder.tvPrice = convertView.findViewById(R.id.tv_price);

            convertView.setTag(holder);
        } else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvModel.setText(data.getModel());
        holder.tvVariant.setText(data.getVariant());
        holder.tvPrice.setText(Double.toString(data.getPrice()));

        return convertView;
    }

    private class ViewHolder{
        TextView tvModel,tvVariant,tvPrice;
    }

    public void updateData(ArrayList<Car> newData){
        mData.clear();
        mData.addAll(newData);
        notifyDataSetChanged();
    }
}
