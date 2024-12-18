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

import com.example.courslearn.databinding.ActivityTest1Binding;


public class test1 extends AppCompatActivity implements View.OnClickListener{

    public static String question[] ={
            "Вопрос 1:  Что такое алгоритм и какова его основная цель?",
            "Вопрос 2:  Как можно классифицировать алгоритмы?",
            "Вопрос 3:  В каких областях не применяются алгоритмы?",
            "Вопрос 4:  Каково значение понимания алгоритмов?"
    };

    public static String choices[][] = {
            {"Это четко определенная последовательность действий, предназначенная для решения конкретной задачи.\n", "Это случайная последовательность действий.", "это набор данных без инструкций", " это только математическая формула"},
            {"На простые и сложные", "На линейные, разветвляющиеся и циклические.\n","На алгоритмы поиска и сортировки.\n","На статические и динамические.\n"},
            {"В программировании.\n","В медицине.\n","В исскустве.\n","В финансовом секторе.\n"},
            {"Понимание алгоритмов не имеет значения.\n","Понимание алгоритмов помогает развивать логическое мышление и умение анализировать задачи.\n","Понимание алгоритмов требуется только для математиков.\n","Понимание алгоритмов нужно только в программировании.\n"}
    };

    public static String correctAnswers[] = {
            "Это четко определенная последовательность действий, предназначенная для решения конкретной задачи.\n",
            "На линейные, разветвляющиеся и циклические.\n",
            "В исскустве.\n",
            "Понимание алгоритмов помогает развивать логическое мышление и умение анализировать задачи.\n"
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
                startActivity(new Intent(test1.this, Less1.class));
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