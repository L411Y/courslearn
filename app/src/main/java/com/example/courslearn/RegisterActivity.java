package com.example.courslearn;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.example.courslearn.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.regBttn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.mail.getText().toString().isEmpty()|| binding.Group.getText().toString().isEmpty() || binding.name.getText().toString().isEmpty() || binding.pass.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Поля пустые" , Toast.LENGTH_SHORT ).show();
                }else {

                    //    Toast.makeText(getApplicationContext(), "Чето было но хз" , Toast.LENGTH_SHORT ).show();

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(binding.mail.getText().toString(),binding.pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //Toast.makeText(getApplicationContext(), "Чето было но хз" , Toast.LENGTH_SHORT ).show();

                            if (task.isSuccessful()){
                                String user = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                if(user!=null){
                                    // String userId = user.getUid();
                                    HashMap<String, String> userInfo = new HashMap<>();
                                    userInfo.put("mail", binding.mail.getText().toString());
                                    userInfo.put("login", binding.name.getText().toString());
                                    userInfo.put("group", binding.mail.getText().toString());
                                    FirebaseDatabase.getInstance().getReference().child("users").child(user).setValue(userInfo).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                                            }
                                            else{
                                                Toast.makeText(getApplicationContext(), "Ошибка при сохранении данных", Toast.LENGTH_SHORT).show();

                                            }
                                        }
                                    });

//                                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                                }
                                else {
                                    Log.d("Ошибка аутентификации","Ошибка аутентификации");
                                    Toast.makeText(getApplicationContext(), "Ошибка аутентификации", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Log.d("Ошибка регистрации","Ошибка регистрации");
                                Toast.makeText(getApplicationContext(), "Ошибка регистрации: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();}
                        }
                    });
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,0,0,"Лекция 1");
        menu.add(0,1,1 ,"Лекция 2");
        return super.onCreateOptionsMenu(menu);

    }
}