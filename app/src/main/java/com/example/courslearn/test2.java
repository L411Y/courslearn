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


public class test2 extends AppCompatActivity implements View.OnClickListener{

    public static String question[] ={
            "Вопрос 1: Что такое разветвляющийся алгоритм?\n",
            "Вопрос 2: Какой блок используется в графическом представлении разветвляющегося алгоритма для обозначения условия?",
            "Вопрос 3: Какой тип разветвляющегося алгоритма позволяет выбирать между несколькими ветвями?",
            "Вопрос 4: Что происходит в случае простого ветвления?"
    };

    public static String choices[][] = {
            {"Алгоритм, который выполняется последовательно без условий.", "Алгоритм, который содержит хотя бы одно условие и разделяется на несколько ветвей.", "Алгоритм, который выполняет только арифметические операции.", "Алгоритм, который не может принимать решения."},
            {"Квадрат", "Овал","Ромб","Прямоугольник"},
            {"Простое ветвление","Множественное ветвление","Циклическое ветвление","Условное ветвление"},
            {"Выполняется одно действие, если условие истинно, и ничего не происходит, если ложно.","Выполняется одно действие, если условие истинно, и другое — если ложно.","Выполняются все действия независимо от условий.","Условия не проверяются."}
    };

    public static String correctAnswers[] = {
            "Алгоритм, который содержит хотя бы одно условие и разделяется на несколько ветвей.",
            "Ромб",
            "Множественное ветвление",
            "Выполняется одно действие, если условие истинно, и другое — если ложно."
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
                startActivity(new Intent(test2.this, Less2.class));
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