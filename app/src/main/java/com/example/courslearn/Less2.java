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

public class Less2 extends AppCompatActivity {
    private Handler handler = new Handler();
    private int index = 0;

    private static final long DELAY = 10;
    private TextView textView;  // Исправлено имя переменной
    private String textParts =
   "Введение в разветвляющиеся алгоритмы\n"+
"\n"+
   "Разветвляющиеся алгоритмы представляют собой важную категорию алгоритмов, в которых выбор дальнейших действий зависит от выполнения определённых условий. Эти алгоритмы позволяют программе принимать различные решения в зависимости от входных данных, что делает их крайне полезными при разработке программного обеспечения.\n"+
           "\n"+
           "Определение и структура\n"+
           "\n"+
   "Разветвляющийся алгоритм — это алгоритм, содержащий хотя бы одно условие, по которому происходит разделение на несколько ветвей. Каждая ветвь представляет собой отдельный путь выполнения программы в зависимости от истинности или ложности условия.\n"+
           "\n"+
   "Принципы работы\n"+
           "\n"+
   "Условия: Условия могут быть простыми (например, сравнения) или составными (состоящими из нескольких логических выражений).\n"+
           "\n"+
   "Логический блок: в графическом представлении разветвляющегося алгоритма ромб используется для обозначения логического блока, содержащего условие проверки. У этого блока два выхода: «Да» и «Нет», которые определяют дальнейший путь выполнения.\n"+
          "\n"+
          "Ветви: каждая ветвь может содержать набор операций, которые выполняются только при выполнении соответствующего условия.\n"+
          "\n"+
          "Виды разветвляющихся алгоритмов\n"+
          "\n"+
          " Существует несколько типов разветвляющихся алгоритмов:\n"+
          "\n"+
   "Простое ветвление: выполняется одно действие, если условие истинно, и другое — если ложно.\n"+
          "\n"+
   "Множественное ветвление: позволяет выбирать между несколькими ветвями в зависимости от значения переменной или выражения.\n"+
          "\n"+
   "Обход: одна из ветвей не содержит операторов и просто переходит к другой ветви.\n"+
          "\n"+
   "Разветвляющиеся алгоритмы являются основой для создания более сложных программ и систем, позволяя эффективно обрабатывать различные сценарии и принимать решения на основе входных данных.\n"
            ;



    private int currentIndex = 0;
    private ActivityLess1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityLess1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Обработчик нажатия кнопки
        binding.backToLess2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Less2.this, MainActivity.class));
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