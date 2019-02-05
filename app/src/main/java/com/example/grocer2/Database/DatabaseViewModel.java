package com.example.grocer2.Database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class DatabaseViewModel extends AndroidViewModel {

    private AppRepository appRepository;
    private LiveData<List<Food>> allFoods;

    public DatabaseViewModel(@NonNull Application application) {
        super(application);
        appRepository = new AppRepository(application);
        allFoods = appRepository.getAllFoods();
    }

    LiveData<List<Food>> getAllFoods() {
        return allFoods;
    }

    public void insert(Food food) {
        appRepository.insert(food);
    }
}
