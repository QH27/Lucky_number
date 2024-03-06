package com.example.lucky_number_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText_Name);
        textView = findViewById(R.id.textView_Header);
        button = findViewById(R.id.btn_Click);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editText.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                //Passing name to second activity
                intent.putExtra("name", userName);
                startActivity(intent);
            }
        });
    }
}