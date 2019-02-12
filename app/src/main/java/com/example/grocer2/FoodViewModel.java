package com.example.grocer2;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.grocer2.Database.AppRepository;
import com.example.grocer2.Database.Food;

import java.util.List;

public class FoodViewModel extends AndroidViewModel {

    private AppRepository mRepository;
    private LiveData<List<Food>> mAllFoods;

    public FoodViewModel(Application application) {
        super(application);
        mRepository = new AppRepository(application);
        mAllFoods = mRepository.getAllFoods();
    }

    LiveData<List<Food>> getAllFoods() {return mAllFoods; }

    void saveFood(final Food food) {
        mRepository.insert(food);
    }

    void deleteFood(final Food food) {
        mRepository.delete(food);
    }
}
