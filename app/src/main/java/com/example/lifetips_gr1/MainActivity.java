package com.example.lifetips_gr1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layoutHealth = findViewById(R.id.layout_health);
        LinearLayout layoutExercise = findViewById(R.id.layout_exercise);
        LinearLayout layoutFood = findViewById(R.id.layout_food);
        LinearLayout layoutMedication = findViewById(R.id.layout_medication);

        layoutHealth.setOnClickListener(v -> {
            // TODO: Chuyển sang màn hình Health Tips
        });

        layoutExercise.setOnClickListener(v -> {
            // TODO: Chuyển sang màn hình Exercise Tips
        });

        layoutFood.setOnClickListener(v -> {
            // TODO: Chuyển sang màn hình Food Tips
        });

        layoutMedication.setOnClickListener(v -> {
            // TODO: Chuyển sang màn hình Medication
        });
    }
}