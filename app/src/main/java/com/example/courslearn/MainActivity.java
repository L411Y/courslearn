package com.example.courslearn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.courslearn.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        if(FirebaseAuth.getInstance().getCurrentUser()==null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
        binding.ExitBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));

            }
        });
        binding.less1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ExitBttn.setVisibility(View.GONE);
                binding.less1.setVisibility(View.GONE);
                binding.less2.setVisibility(View.GONE);
                binding.less3.setVisibility(View.GONE);
                binding.less4.setVisibility(View.GONE);
                binding.less5.setVisibility(View.GONE);
                binding.less6.setVisibility(View.GONE);
                binding.less7.setVisibility(View.GONE);
                binding.less6.setVisibility(View.GONE);
                binding.less7.setVisibility(View.GONE);
                binding.less8.setVisibility(View.GONE);
                binding.test1.setVisibility(View.VISIBLE);
                binding.backToLess.setVisibility(View.VISIBLE);

                //startActivity(new Intent(MainActivity.this,Lessons.class));
            }
        });
        binding.less2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ExitBttn.setVisibility(View.GONE);
                binding.less1.setVisibility(View.GONE);
                binding.less2.setVisibility(View.GONE);
                binding.less3.setVisibility(View.GONE);
                binding.less4.setVisibility(View.GONE);
                binding.less5.setVisibility(View.GONE);
                binding.less6.setVisibility(View.GONE);
                binding.less7.setVisibility(View.GONE);
                binding.less6.setVisibility(View.GONE);
                binding.less7.setVisibility(View.GONE);
                binding.less8.setVisibility(View.GONE);
                binding.test2.setVisibility(View.VISIBLE);
                binding.backToLess.setVisibility(View.VISIBLE);

                //startActivity(new Intent(MainActivity.this,Lessons.class));
            }
        });
        binding.less3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ExitBttn.setVisibility(View.GONE);
                binding.less1.setVisibility(View.GONE);
                binding.less2.setVisibility(View.GONE);
                binding.less3.setVisibility(View.GONE);
                binding.less4.setVisibility(View.GONE);
                binding.less5.setVisibility(View.GONE);
                binding.less6.setVisibility(View.GONE);
                binding.less7.setVisibility(View.GONE);
                binding.less6.setVisibility(View.GONE);
                binding.less7.setVisibility(View.GONE);
                binding.less8.setVisibility(View.GONE);
                binding.test3.setVisibility(View.VISIBLE);
                binding.backToLess.setVisibility(View.VISIBLE);

                //startActivity(new Intent(MainActivity.this,Lessons.class));
            }
        });
        binding.less4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ExitBttn.setVisibility(View.GONE);
                binding.less1.setVisibility(View.GONE);
                binding.less2.setVisibility(View.GONE);
                binding.less3.setVisibility(View.GONE);
                binding.less4.setVisibility(View.GONE);
                binding.less5.setVisibility(View.GONE);
                binding.less6.setVisibility(View.GONE);
                binding.less7.setVisibility(View.GONE);
                binding.less6.setVisibility(View.GONE);
                binding.less7.setVisibility(View.GONE);
                binding.less8.setVisibility(View.GONE);
                binding.test4.setVisibility(View.VISIBLE);
                binding.backToLess.setVisibility(View.VISIBLE);

                //startActivity(new Intent(MainActivity.this,Lessons.class));
            }
        });
        binding.less5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ExitBttn.setVisibility(View.GONE);
                binding.less1.setVisibility(View.GONE);
                binding.less2.setVisibility(View.GONE);
                binding.less3.setVisibility(View.GONE);
                binding.less4.setVisibility(View.GONE);
                binding.less5.setVisibility(View.GONE);
                binding.less6.setVisibility(View.GONE);
                binding.less7.setVisibility(View.GONE);
                binding.less6.setVisibility(View.GONE);
                binding.less7.setVisibility(View.GONE);
                binding.less8.setVisibility(View.GONE);
                binding.test5.setVisibility(View.VISIBLE);
                binding.backToLess.setVisibility(View.VISIBLE);

                //startActivity(new Intent(MainActivity.this,Lessons.class));
            }
        });
        binding.less6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ExitBttn.setVisibility(View.GONE);
                binding.less1.setVisibility(View.GONE);
                binding.less2.setVisibility(View.GONE);
                binding.less3.setVisibility(View.GONE);
                binding.less4.setVisibility(View.GONE);
                binding.less5.setVisibility(View.GONE);
                binding.less6.setVisibility(View.GONE);
                binding.less7.setVisibility(View.GONE);
                binding.less6.setVisibility(View.GONE);
                binding.less7.setVisibility(View.GONE);
                binding.less8.setVisibility(View.GONE);
                binding.test6.setVisibility(View.VISIBLE);
                binding.backToLess.setVisibility(View.VISIBLE);

                //startActivity(new Intent(MainActivity.this,Lessons.class));
            }
        });
        binding.less7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ExitBttn.setVisibility(View.GONE);
                binding.less1.setVisibility(View.GONE);
                binding.less2.setVisibility(View.GONE);
                binding.less3.setVisibility(View.GONE);
                binding.less4.setVisibility(View.GONE);
                binding.less5.setVisibility(View.GONE);
                binding.less6.setVisibility(View.GONE);
                binding.less7.setVisibility(View.GONE);
                binding.less6.setVisibility(View.GONE);
                binding.less7.setVisibility(View.GONE);
                binding.less8.setVisibility(View.GONE);
                binding.test7.setVisibility(View.VISIBLE);
                binding.backToLess.setVisibility(View.VISIBLE);

                //startActivity(new Intent(MainActivity.this,Lessons.class));
            }
        });
        binding.less8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ExitBttn.setVisibility(View.GONE);
                binding.less1.setVisibility(View.GONE);
                binding.less2.setVisibility(View.GONE);
                binding.less3.setVisibility(View.GONE);
                binding.less4.setVisibility(View.GONE);
                binding.less5.setVisibility(View.GONE);
                binding.less6.setVisibility(View.GONE);
                binding.less7.setVisibility(View.GONE);
                binding.less6.setVisibility(View.GONE);
                binding.less7.setVisibility(View.GONE);
                binding.less8.setVisibility(View.GONE);
                binding.test8.setVisibility(View.VISIBLE);
                binding.backToLess.setVisibility(View.VISIBLE);

                //startActivity(new Intent(MainActivity.this,Lessons.class));
            }
        });
        binding.backToLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.backToLess.setVisibility(View.GONE);
                binding.test1.setVisibility(View.GONE);
                binding.test2.setVisibility(View.GONE);
                binding.test3.setVisibility(View.GONE);
                binding.test4.setVisibility(View.GONE);
                binding.test5.setVisibility(View.GONE);
                binding.test6.setVisibility(View.GONE);
                binding.test7.setVisibility(View.GONE);
                binding.test8.setVisibility(View.GONE);
                binding.less1.setVisibility(View.VISIBLE);
                binding.less2.setVisibility(View.VISIBLE);
                binding.less3.setVisibility(View.VISIBLE);
                binding.less4.setVisibility(View.VISIBLE);
                binding.less5.setVisibility(View.VISIBLE);
                binding.less6.setVisibility(View.VISIBLE);
                binding.less7.setVisibility(View.VISIBLE);
                binding.less6.setVisibility(View.VISIBLE);
                binding.less7.setVisibility(View.VISIBLE);
                binding.less8.setVisibility(View.VISIBLE);
                binding.ExitBttn.setVisibility(View.VISIBLE);
            }
        });







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}