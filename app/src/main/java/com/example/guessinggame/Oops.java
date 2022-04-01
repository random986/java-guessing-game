package com.example.guessinggame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Oops extends AppCompatActivity {

    TextView textView;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oops);

        Button button = findViewById(R.id.tryAgainBtn);
        textView = findViewById(R.id.answer);

        //textView settings
        number = getIntent().getExtras().getInt("value");
        textView.setInputType(number);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGuess();
            }

            private void openGuess() {
                Intent intent = new Intent(Oops.this, Guess.class);
                startActivity(intent);
            }
        });

    }
}
