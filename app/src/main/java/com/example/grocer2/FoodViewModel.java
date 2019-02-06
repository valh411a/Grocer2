package com.example.grocer2;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.grocer2.Database.AppDatabase;
import com.example.grocer2.Database.Food;
import com.example.grocer2.Database.FoodDao;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FoodViewModel extends AndroidViewModel {

    private FoodDao foodDao;
    private ExecutorService executorService;

    public FoodViewModel(@NonNull Application application) {
        super(application);
        foodDao = AppDatabase.getDatabase(application).foodDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    LiveData<List<Food>> getAllFoods() {
        return foodDao.getAllFoods();
    }

    void saveFood(final Food food) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                foodDao.insert(food);
            }
        });
    }

    void deleteFood(final Food food) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                foodDao.delete(food);
            }
        });
    }
}
