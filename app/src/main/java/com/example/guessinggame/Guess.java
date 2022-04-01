package com.example.guessinggame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Guess extends AppCompatActivity {

    public EditText editText;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guess);

        Button button = findViewById(R.id.enterBtn);
        editText = findViewById(R.id.editTextNumber);

        Random random = new Random();
        int x = random.nextInt(20) + 1;
        editText.getInputType();



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int timesTried = 0;
                boolean hasWon = false;
                boolean shouldFinish = false;


                while (!shouldFinish){
                    timesTried++;

                    if (timesTried <= 5){
                        if (editText.getInputType()== x){
                            hasWon = true;
                            shouldFinish = true;
                        }
                        else if (editText.getInputType() > x){
                            guessLowerToast();
                        }
                        else {
                            guessHigherToast();
                        }
                    }
                    else {
                        shouldFinish = true;
                    }
                }
                if (hasWon){
                openCongratulations();
                }
                else {
                    openOops();
                }
            }

            private void guessLowerToast() {
                Toast.makeText(Guess.this, "Guess Lower", Toast.LENGTH_SHORT).show();
            }

            private void guessHigherToast() {
                Toast.makeText(Guess.this, "Guess Higher", Toast.LENGTH_SHORT).show();
            }

            private void openCongratulations() {
                Intent intent = new Intent(Guess.this, Congratulations.class);
                number=editText.getInputType();
                intent.putExtra("value",number);
                startActivity(intent);
            }
            private void openOops() {
                Intent intent = new Intent(Guess.this, Oops.class);
                number=editText.getInputType();
                intent.putExtra("value",number);
                startActivity(intent);
            }
        });
    }
}
