package com.example.question2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etWaterInput;
    private TextView tvFeedback;
    private Button btnTrack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWaterInput = findViewById(R.id.etWaterInput);
        tvFeedback = findViewById(R.id.tvFeedback);
        btnTrack = findViewById(R.id.btnTrack);

        btnTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provideFeedback();
            }
        });
    }

    private void provideFeedback() {
        String input = etWaterInput.getText().toString();

        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter an amount", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double waterAmount = Double.parseDouble(input);
            String message;

            // Feedback Logic based on criteria
            if (waterAmount < 1500) {
                message = "Drink more water";
            } else if (waterAmount >= 1500 && waterAmount <= 2500) {
                message = "Good Job! You're staying hydrated";
            } else {
                // waterAmount > 2500
                message = "You're Drinking enough water";
            }

            tvFeedback.setText(message);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
        }
    }
}