package com.example.lifetips_gr1;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DBHelper dbHelper;
    ArrayList<String> titles = new ArrayList<>();
    ArrayList<String> descriptions = new ArrayList<>();
    ArrayList<String> imageUrls = new ArrayList<>();
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        recyclerView = findViewById(R.id.recyclerView);
        dbHelper = new DBHelper(this);

        loadFoodTips();

        adapter = new ItemAdapter(this, titles, descriptions, imageUrls);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void loadFoodTips() {
        Cursor cursor = dbHelper.getReadableDatabase().rawQuery("SELECT * FROM food", null);
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Không có dữ liệu", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                titles.add(cursor.getString(1));
                descriptions.add(cursor.getString(2));
                imageUrls.add(cursor.getString(3));
            }
        }
        cursor.close();
    }
}
