package com.example.courslearn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.courslearn.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
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
        binding.regBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.mail.getText().toString().isEmpty()|| binding.Group.getText().toString().isEmpty() || binding.name.getText().toString().isEmpty() || binding.pass.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Поля пустые" , Toast.LENGTH_SHORT ).show();
                }else {
                    //  Toast.makeText(getApplicationContext(), "Чето было но хз" , Toast.LENGTH_SHORT ).show();

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(binding.mail.getText().toString(),binding.pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                HashMap<String, String> userInfo = new HashMap<>();
                                userInfo.put("Электронная почта", binding.mail.getText().toString());
                                userInfo.put("ФИО", binding.name.getText().toString());
                                userInfo.put("Группа", binding.mail.getText().toString());
                                FirebaseDatabase.getInstance().getReference().child("Пользователи").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(userInfo);
                                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                            }
                        }
                    });

                }
            }
        });

    }
}