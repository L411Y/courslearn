package com.example.courslearn;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class test3 extends AppCompatActivity implements View.OnClickListener{

    public static String question[] ={
            "Вопрос 1: Что такое циклический алгоритм?",
            "Вопрос 2: Какой элемент циклического алгоритма включает команды, выполняемые многократно?",
            "Вопрос 3: Какой тип циклического алгоритма используется, когда заранее известно, сколько раз будет выполняться тело цикла?",
            "Вопрос 4: Какой из следующих примеров является использованием циклического алгоритма?"
    };

    public static String choices[][] = {
            {"Алгоритм, который выполняется только один раз.", "Алгоритм, который повторяет действия определённое количество раз или до выполнения условия.", "Алгоритм, который не имеет условий.", "Алгоритм, который выполняет случайные действия."},
            {"Условие завершения", "Настройка цикла","Тело цикла","Начальная переменная"},
            {"Циклы с неявным числом повторений","Циклы с явным числом повторений","Бесконечные циклы","Условные циклы"},
            {"Запись одной страницы в дневник.","Чтение книги по две страницы до тех пор, пока книга не закончится.","Принятие решения о том, что делать дальше.","Случайный выбор ответа на вопрос."}
    };

    public static String correctAnswers[] = {
            "Алгоритм, который повторяет действия определённое количество раз или до выполнения условия.",
            "Тело цикла",
            "Циклы с явным числом повторений",
            "Чтение книги по две страницы до тех пор, пока книга не закончится."
    };
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button bindF, ansA, ansB, ansC, ansD;
    Button submitBtn;

    int score=0;
    int totalQuestion = question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.questionText)  ;
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        bindF = findViewById(R.id.backToLess);
        bindF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(test3.this, Less3.class));
            }
        });



        loadNewQuestion();

        totalQuestionsTextView.setText("Всего вопросов: "+totalQuestion);
        // Сначала вызываем метод
        Log.d("EWWWW", "Current Question: " + question[currentQuestionIndex]); // Затем логируем




    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_btn){
            if(selectedAnswer.equals(correctAnswers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();


        }else{
            //choices button clicked
            selectedAnswer  = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);

        }

    }

    private void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion ){
            finishQuiz();
            return;
        }

        questionTextView.setText(question[currentQuestionIndex]);
        ansA.setText(choices[currentQuestionIndex][0]);
        ansB.setText(choices[currentQuestionIndex][1]);
        ansC.setText(choices[currentQuestionIndex][2]);
        ansD.setText(choices[currentQuestionIndex][3]);
        Log.d("QuizApp", "Current Question: " + question[currentQuestionIndex]);
    }

    private void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus = "Успех";
        }else{
            passStatus = "Провал";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Правильных ответов "+ score+" из "+ totalQuestion)
                .setPositiveButton("Заново",(dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();


    }

    private void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }

}