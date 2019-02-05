package com.example.grocer2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.grocer2.Database.Food;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.FoodViewHolder> {

    class FoodViewHolder extends RecyclerView.ViewHolder {
        private final TextView foodItemView;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater inflater;
    private List<Food> foodDataSet;

    RecyclerAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = inflater.inflate(R.layout.recyclerview_item, viewGroup, false);
        return new FoodViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder foodViewHolder, int i) {
        if(foodDataSet != null) {
            Food current = foodDataSet.get(i);
            foodViewHolder.foodItemView.setText(current.getFood());
        } else {
            foodViewHolder.foodItemView.setText("No Food");
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