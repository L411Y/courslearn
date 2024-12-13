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

import com.example.courslearn.databinding.ActivityLess3Binding;
import com.example.courslearn.databinding.ActivityLess4Binding;

public class Less4 extends AppCompatActivity {
    private Handler handler = new Handler();
    private int index = 0;

    private static final long DELAY = 10;
    private TextView textView;
    private String textParts =
  "Введение в массивы.\n"+
        "\n"+
  "Массивы — это один из основных типов данных в программировании, позволяющий хранить и управлять коллекцией элементов одного типа. Они широко используются для организации данных и являются важным инструментом для решения множества задач.\n"+
        "\n"+
  "Определение массива.\n"+
        "\n"+
  "Массив представляет собой структуру данных, состоящую из фиксированного числа элементов, каждый из которых имеет одинаковый тип. Элементы массива располагаются в памяти последовательно, что позволяет эффективно обращаться к ним по индексу.\n"+
        "\n"+
  "Основные характеристики массивов.\n"+
        "\n"+
  "Фиксированный размер: размер массива задаётся при его создании и не может быть изменён в процессе выполнения программы. Это означает, что необходимо заранее знать, сколько элементов будет храниться в массиве..\n"+
        "\n"+
  "Однотипность: все элементы массива имеют один и тот же тип данных, что обеспечивает удобство работы с ними и позволяет избежать ошибок, связанных с несовместимостью типов..\n"+
        "\n"+
  "Индексация: каждый элемент массива имеет свой индекс, который обычно начинается с нуля. Это позволяет быстро получать доступ к элементам и изменять их значения..\n"+
        "\n"+
  "Типы массивов.\n"+
        "\n"+
  "Существует несколько видов массивов:.\n"+
        "\n"+
  "Одномерные массивы: представляют собой простую последовательность элементов. Например, одномерный массив может хранить список чисел или строк..\n"+
        "\n"+
  "Многомерные массивы: могут быть представлены как таблицы или матрицы. Например, двумерный массив может использоваться для хранения данных в виде строк и столбцов, что удобно для представления таблиц или изображений..\n"+
        "\n"+
  "Ассоциативные массивы: также известны как хэш-таблицы, позволяют хранить пары ключ-значение, где ключи могут быть строками или другими типами данных. Это позволяет быстро находить значения по заданному ключу..\n"+
        "\n"+
  "Применение массивов.\n"+
        "\n"+
  "Массивы находят широкое применение в различных областях программирования:.\n"+
        "\n"+
  "Хранение данных: массивы используются для хранения списков значений, таких как числа, строки или объекты. Это позволяет организовать данные в удобном для обработки формате..\n"+
        "\n"+
  "Алгоритмы сортировки и поиска: многие алгоритмы, такие как сортировка пузырьком или бинарный поиск, работают с массивами. Массивы позволяют эффективно выполнять такие операции благодаря своей структуре..\n"+
        "\n"+
  "Моделирование и симуляции: массивы могут использоваться для представления сложных структур данных, таких как графы или деревья. Это упрощает работу с такими структурами и делает код более понятным..\n"+
        "\n"+
  "Заключение.\n"+
        "\n"+
  "Массивы являются мощным инструментом для хранения и обработки данных в программировании. Понимание их структуры и принципов работы позволяет разработчикам эффективно решать задачи различной сложности. Используя массивы, можно значительно упростить работу с данными и улучшить производительность программ.\n."
         ;



    private int currentIndex = 0;
    private ActivityLess4Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityLess4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.test7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Less4.this,test4.class));
            }
        });
        binding.backToLess5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Less4.this, MainActivity.class));
            }
        });
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