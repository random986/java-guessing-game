package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button nameButton;
    EditText editText;
    String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_entry);

        nameButton = findViewById(R.id.nameBtn);
        editText = findViewById(R.id.editTextTextPersonName);

        editText.addTextChangedListener(nameInputWatcher);

        nameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGreetings();
            }
        });
    }

    private TextWatcher nameInputWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String nameInput = editText.getText().toString().trim();
            nameButton.setEnabled(!nameInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public void openGreetings(){
        Intent intent = new Intent(MainActivity.this, Greetings.class);
        string=editText.getText().toString();
        intent.putExtra("value",string);
        startActivity(intent);
    }
}

/*making input compulsory
        if(editText.getText().toString().length()==0)
            editText.setError("Name required!");*/
