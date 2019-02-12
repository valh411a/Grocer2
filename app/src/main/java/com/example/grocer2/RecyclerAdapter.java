package com.example.grocer2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.grocer2.Database.Food;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtViewTitle;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.textView);
        }
    }

    private List<Food> foodDataSet;

    RecyclerAdapter() {
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View itemLayoutView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclerview_item, null);

        // create ViewHolder

        return new ViewHolder(itemLayoutView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder foodViewHolder, int i) {
        if(foodDataSet != null) {
            Food current = foodDataSet.get(i);
            foodViewHolder.txtViewTitle.setText(current.getFood());
        } else {
            foodViewHolder.txtViewTitle.setText("No Food");
        }
    }

    void setFoods(List<Food> foods) {
        foodDataSet = foods;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (foodDataSet != null)
            return foodDataSet.size();
        return 0;
    }




}