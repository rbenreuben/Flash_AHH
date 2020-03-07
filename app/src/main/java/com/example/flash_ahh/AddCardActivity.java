package com.example.flash_ahh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        final ImageButton closeButton = findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            finish();
            }
        });
        final ImageButton saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String answer = ((EditText)findViewById(R.id.newAnswer)).getText().toString();
            String question = ((EditText)findViewById(R.id.newQuestion)).getText().toString();
            Intent intent = new Intent();
            intent.putExtra("question", question);
            intent.putExtra("answer", answer);
            setResult(RESULT_OK, intent);
            finish();
            }
        });


    }
}
