package com.example.lucky_number_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView textView1, textView2;
    Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        textView1 = findViewById(R.id.textView_Header2);
        textView2 = findViewById(R.id.textView_LuckyNumber);
        button = findViewById(R.id.btn_share);

        //Receiving data from Main Activity
        Intent intent = getIntent();
        String userName = intent.getStringExtra("name");

        //Generate random number
        int randum_num = RandomNumber();
        textView2.setText(""+randum_num);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName, randum_num);
            }
        });

    }

    private void shareData(String userName, int randumNum) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plaintext");
        //Additional info
        intent.putExtra(Intent.EXTRA_SUBJECT, userName + " got lucky today!");
        intent.putExtra(Intent.EXTRA_TEXT, "His lucky number is " + randumNum);
        startActivity(Intent.createChooser(intent, "Chooser a Platform"));
    }

    public int RandomNumber(){
        Random random = new Random();
        int upper_limit = 1000;
        int random_number_generated = random.nextInt(upper_limit);
        return random_number_generated;
    }
}
