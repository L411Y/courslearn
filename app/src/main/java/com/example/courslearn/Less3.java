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
import com.example.courslearn.databinding.ActivityLess3Binding;

public class Less3 extends AppCompatActivity {
    private Handler handler = new Handler();
    private int index = 0;

    private static final long DELAY = 10;
    private TextView textView;  // Исправлено имя переменной
    private String textParts =
            "Введение в циклические алгоритмы\n"+
                    "\n"+
   "Циклические алгоритмы играют важную роль в алгоритмической структуре, позволяя выполнять одни и те же действия многократно. Они широко используются в программировании и математике для автоматизации процессов, где требуется повторение определённых операций.\n"+
   "Определение циклического алгоритма\n"+
                   "\n"+
   "Циклический алгоритм — это последовательность действий, которые повторяются определённое количество раз или продолжаются до тех пор, пока не будет выполнено заданное условие. Основной элемент циклического алгоритма называется телом цикла, которое включает команды, выполняемые многократно.\n"+
                   "\n"+
                   " Основные элементы циклического алгоритма\n"+
                    "\n"+
   "Настройка цикла: процесс присваивания первоначальных значений переменным, участвующим в работе цикла.\n"+
                    "\n"+
   "Тело цикла: последовательность действий, выполняемых многократно.\n"+
                    "\n"+
   "Условие завершения: определяет момент, когда цикл должен прекратиться.\n"+
                    "\n"+
   "Виды циклических алгоритмов\n"+
                    "\n"+
   "Существует несколько типов циклических алгоритмов:\n"+
                    "\n"+
   "Циклы с явным числом повторений: заранее известно, сколько раз будет выполняться тело цикла. Примером могут служить циклы for в языках программирования.\n"+
                    "\n"+
   "Циклы с неявным числом повторений: выполнение цикла продолжается до тех пор, пока выполняется определённое условие. Это могут быть циклы while и do...while, где проверка условия происходит перед или после выполнения тела цикла соответственно.\n"+
                    "\n"+
                    "Примеры использования циклических алгоритмов\n"+
                    "\n"+
   "Циклические алгоритмы можно увидеть в различных ситуациях:\n"+
                    "\n"+
                    "Чтение книги: открыть книгу и читать по две страницы до тех пор, пока книга не закончится.\n"+
                    "\n"+
   "Перевод текста: прочитать предложение, перевести его, записать результат и повторить процесс для следующего предложения.\n"+
                    "\n"+
   "Структура циклического алгоритма\n"+
                    "\n"+
   "При составлении циклического алгоритма необходимо учитывать следующие шаги:\n"+
                    "\n"+
                    "1.Определить последовательность действий для повторения.\n"+
   "2.Выяснить количество повторений или условие для продолжения выполнения.\n"+
   "3.Записать алгоритм на языке программирования с использованием соответствующих операторов цикла.\n"+
                    "\n"+
                    "Заключение\n"+
                    "\n"+
                    "Циклические алгоритмы являются мощным инструментом для автоматизации процессов и упрощения программирования. Понимание их структуры и принципов работы позволяет разработчикам эффективно решать задачи, требующие многократного выполнения одних и тех же действий.\n"+
    "\n";



    private int currentIndex = 0;
private ActivityLess3Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityLess3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.backToLess4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Less3.this, MainActivity.class));
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