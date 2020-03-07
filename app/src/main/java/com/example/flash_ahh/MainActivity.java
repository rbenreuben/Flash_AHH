package com.example.flash_ahh;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView question;
    TextView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          question = findViewById(R.id.flashcard_question);
          answer = findViewById(R.id.flashcard_answer);
          question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // show the answer
                // hide the question
                question.setVisibility(View.INVISIBLE);
                answer.setVisibility(View.VISIBLE);

                question.setBackgroundColor(getResources().getColor(R.color.RED));


            }

        });
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setVisibility(View.INVISIBLE);
                question.setVisibility(View.VISIBLE);
                answer.setBackgroundColor(getResources().getColor(R.color.BLUE));
            }
        });

        final ImageButton addbutton = findViewById(R.id.addbutton);
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode == RESULT_OK){
            String newQuestion = data.getExtras().getString("question");
            String newAnswer = data.getExtras().getString("answer");

            question.setText(newQuestion);
            answer.setText(newAnswer);

        }

    }
}
