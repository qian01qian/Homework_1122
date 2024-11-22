package com.example.homework_1122;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private HashMap<String, String> foodCalories;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 根據系統語言設置
        setAppLocale(Locale.getDefault().getLanguage());

        setContentView(R.layout.activity_main);

        // 初始化美食與熱量資料
        foodCalories = new HashMap<>();
        foodCalories.put(getString(R.string.food_beef_noodles), getString(R.string.calories_beef_noodles));
        foodCalories.put(getString(R.string.food_sushi), getString(R.string.calories_sushi));
        foodCalories.put(getString(R.string.food_hot_pot), getString(R.string.calories_hot_pot));
        foodCalories.put(getString(R.string.food_fried_chicken), getString(R.string.calories_fried_chicken));
        foodCalories.put(getString(R.string.food_pizza), getString(R.string.calories_pizza));
        foodCalories.put(getString(R.string.food_ramen), getString(R.string.calories_ramen));
        foodCalories.put(getString(R.string.food_hamburger), getString(R.string.calories_hamburger));
        foodCalories.put(getString(R.string.food_fried_rice), getString(R.string.calories_fried_rice));
        foodCalories.put(getString(R.string.food_donut), getString(R.string.calories_donut));

        // 設定 ListView
        listView = findViewById(R.id.main_listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, foodCalories.keySet().toArray(new String[0]));
        listView.setAdapter(adapter);

        // 設定點擊事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String foodName = (String) parent.getItemAtPosition(position);
                String calories = foodCalories.get(foodName);
                Toast.makeText(MainActivity.this, foodName + ": " + calories, Toast.LENGTH_SHORT).show();
            }
        });
    }

    // 設定語系
    private void setAppLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }
}
