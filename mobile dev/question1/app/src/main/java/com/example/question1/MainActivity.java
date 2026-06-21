package com.example.question1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etMath, etScience, etEnglish;
    private TextView tvResult;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        etName = findViewById(R.id.etStudentName);
        etMath = findViewById(R.id.etMath);
        etScience = findViewById(R.id.etScience);
        etEnglish = findViewById(R.id.etEnglish);
        tvResult = findViewById(R.id.tvResult);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateGrade();
            }
        });
    }

    private void calculateGrade() {
        String name = etName.getText().toString().trim();
        String mathStr = etMath.getText().toString();
        String scienceStr = etScience.getText().toString();
        String englishStr = etEnglish.getText().toString();

        // Edge case handling: Empty fields
        if (name.isEmpty() || mathStr.isEmpty() || scienceStr.isEmpty() || englishStr.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double math = Double.parseDouble(mathStr);
            double science = Double.parseDouble(scienceStr);
            double english = Double.parseDouble(englishStr);

            // Calculate average
            double average = (math + science + english) / 3;
            String grade = "";

            // Determine grade logic
            if (average >= 90) {
                grade = "A";
            } else if (average >= 80) {
                grade = "B";
            } else if (average >= 70) {
                grade = "C";
            } else {
                grade = "F";
            }

            // Display the output
            String resultText = String.format("Student: %s\nAverage: %.2f\nGrade: %s", name, average, grade);
            tvResult.setText(resultText);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input. Please enter valid scores.", Toast.LENGTH_SHORT).show();
        }
    }
}