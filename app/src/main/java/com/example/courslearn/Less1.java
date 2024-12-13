package com.example.courslearn;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.courslearn.databinding.ActivityLess1Binding;



public class Less1 extends AppCompatActivity {
    private Handler handler = new Handler();
    private int index = 0;

    private static final long DELAY = 10;
    private TextView textView;  // Исправлено имя переменной
    private String textParts =
   "Алгоритм — это четко определенная последовательность действий, предназначенная для решения конкретной задачи. Он представляет собой набор инструкций, которые могут быть выполнены компьютером, человеком или другим устройством. Алгоритмы являются основой программирования, математики и информационных технологий, и их понимание критически важно для эффективного выполнения задач и автоматизации процессов.\n"+
           "\n "+
           "Определение алгоритма\n"+
           "\n "+
   "В информатике алгоритм определяется как последовательность шагов, которая приводит к заранее известному результату. Это может быть как простая инструкция, так и сложный процесс, включающий множество этапов. Например, приготовление яичницы можно рассматривать как алгоритм, состоящий из следующих шагов:\n"+
   "\n"+
           "1.Разогреть сковороду.\n"+
   "2.Добавить масло.\n"+
   "3.Разбить яйца и посолить.\n"+
   "4.Закрыть крышкой и жарить.\n"+
   "Такой подход позволяет разбить любую задачу на более мелкие и управляемые части.\n"+
   "\n "+
           "Виды алгоритмов\n"+
   "Существует множество видов алгоритмов, которые могут быть классифицированы по различным критериям:\n"+
           "\n "+
           "По сложности: простые и сложные алгоритмы.\n"+
           "\n "+
   "По структуре: линейные, разветвляющиеся и циклические алгоритмы.\n"+
           "\n "+
           "По области применения: алгоритмы сортировки, поиска, оптимизации и т.д.\n"+
   "Применение алгоритмов\n"+
           "\n "+
   "Алгоритмы находят применение в самых различных областях:\n"+
           "\n "+
   "Программирование: для автоматизации процессов и упрощения решения задач.\n"+
           "\n "+
   "Наука: в исследованиях и анализе данных.\n"+
           "\n "+
   "Медицина: для диагностики заболеваний и прогнозирования результатов лечения.\n"+

   "Финансовый сектор: для анализа рисков и автоматизации торговли.\n"+
           "\n "+
   "Значение алгоритмов\n"+
           "\n "+

   "Понимание алгоритмов помогает развивать логическое мышление и умение анализировать задачи. Эффективные алгоритмы позволяют оптимизировать процессы, повышать производительность и сокращать время на выполнение задач. Они служат основой для разработки программного обеспечения и решения сложных проблем в различных областях.\n"

;



    private int currentIndex = 0;
    private ActivityLess1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityLess1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Less1.this, test1.class));
            }
        });
        // Обработчик нажатия кнопки
        binding.backToLess2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Less1.this, MainActivity.class));
            }
        });

        // Инициализация textView
        textView = binding.textView;  // Исправлено имя переменной
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
                if (index < textParts.length()) {
                    textView.append(String.valueOf(textParts.charAt(index)));
                    index++;
                    handler.postDelayed(this, DELAY);
                }
            }
        }, DELAY);
    }
}
