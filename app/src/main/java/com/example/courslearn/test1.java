package com.example.courslearn;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.courslearn.databinding.ActivityTest1Binding;

public class test1 extends AppCompatActivity {
    private Handler handler = new Handler();
    private int index = 0;

    private static final long DELAY = 10;
    private TextView textView1;
    private TextView textView2;
    private String textParts1 ="Что такое алгоритм?";
    private String textParts2 ="Это четко определенная последовательность действий, предназначенная для решения конкретной задачи.";

    private String textParts3 ="Что такое алгоритм?";

    private String textParts4 ="Что такое алгоритм?";

    private int currentIndex = 0;
    private ActivityTest1Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityTest1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());








        textView1 = binding.textView2;  // Исправлено имя переменной
        textView2 = binding.option1;
        displayText();

        // Установка отступов для системных панелей
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    private void displayText() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (index < textParts1.length()) {
                    textView1.append(String.valueOf(textParts1.charAt(index)));
                    textView2.append(String.valueOf(textParts2.charAt(index)));
                    index++;
                    handler.postDelayed(this, DELAY);
                }
            }
        }, DELAY);
    }
}