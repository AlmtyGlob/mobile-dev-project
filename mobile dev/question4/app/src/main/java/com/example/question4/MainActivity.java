package com.example.question4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etWord1, etWord2, etWord3;
    private TextView tvResults;
    private Button btnManipulate, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWord1 = findViewById(R.id.etWord1);
        etWord2 = findViewById(R.id.etWord2);
        etWord3 = findViewById(R.id.etWord3);
        tvResults = findViewById(R.id.tvResultsDisplay);
        btnManipulate = findViewById(R.id.btnManipulate);
        btnReset = findViewById(R.id.btnReset);

        btnManipulate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processWords();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFields();
            }
        });
    }

    private void processWords() {
        String w1 = etWord1.getText().toString().trim();
        String w2 = etWord2.getText().toString().trim();
        String w3 = etWord3.getText().toString().trim();

        if (w1.isEmpty() || w2.isEmpty() || w3.isEmpty()) {
            Toast.makeText(this, "Please enter all three words", Toast.LENGTH_SHORT).show();
            return;
        }

        // 1. Manipulations
        String manipulated1 = w1.toUpperCase();
        String manipulated2 = w2.toLowerCase();
        String manipulated3 = new StringBuilder(w3).reverse().toString();

        // 2. Acronym Generation (First letter of each original word)
        String acronym = "" + w1.charAt(0) + w2.charAt(0) + w3.charAt(0);

        // 3. Display Results
        String output = "**Original:** " + w1 + ", " + w2 + ", " + w3 + "\n" +
                "**Manipulated:** " + manipulated1 + ", " + manipulated2 + ", " + manipulated3 + "\n" +
                "**Acronym:** " + acronym;

        tvResults.setText(output);
    }

    private void resetFields() {
        etWord1.setText("");
        etWord2.setText("");
        etWord3.setText("");
        tvResults.setText("");
    }
}