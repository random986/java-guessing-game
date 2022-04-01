package com.example.guessinggame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Greetings extends AppCompatActivity {

    TextView textView;
    String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.greetings);

        Button button = findViewById(R.id.proceedBtn);
        textView = findViewById(R.id.personName);

        //textView settings
        string = getIntent().getExtras().getString("value");
        textView.setText(string);

        //button settings
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGuess();
            }

            private void openGuess() {
                Intent intent = new Intent(Greetings.this, Guess.class);
                startActivity(intent);
            }
        });

    }


}
