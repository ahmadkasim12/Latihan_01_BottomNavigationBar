package com.akbar08.latihan_bottomnavigationbar.activities.bangun_ruang;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.akbar08.latihan_bottomnavigationbar.R;

public class br_balok extends AppCompatActivity {

    private Button btnBack, btnCalculate;
    private EditText et_input, et_input_1, et_input_2, et_output, et_output_1;
    double input, input_1, input_2, output, output_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_br_balok);
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        et_input = findViewById(R.id.et_br_balok_input);
        et_input_1 = findViewById(R.id.et_br_balok_input_1);
        et_input_2 = findViewById(R.id.et_br_balok_input_2);

        et_output = findViewById(R.id.et_br_balok_output);
        et_output_1 = findViewById(R.id.et_br_balok_output_1);

        btnBack = findViewById(R.id.btn_br_balok_back);
        btnCalculate = findViewById(R.id.btn_br_balok_calculate);

        btnBack.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.R)
            @Override
            public void onClick(View view) {
                view.performHapticFeedback(HapticFeedbackConstants.CONFIRM);
                finish();
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.R)
            @Override
            public void onClick(View view) {
                view.performHapticFeedback(HapticFeedbackConstants.CONFIRM);
                if (et_input.getText().toString().isEmpty() || et_input_1.getText().toString().isEmpty() || et_input_2.getText().toString().isEmpty()){
                    Toast.makeText(br_balok.this, "Input tidak valid!", Toast.LENGTH_SHORT).show();
                    v.vibrate(VibrationEffect.createOneShot(250, VibrationEffect.DEFAULT_AMPLITUDE));

                    return;
                }
                else {
                    input = Double.parseDouble(et_input.getText().toString());
                    input_1 = Double.parseDouble(et_input.getText().toString());
                    input_2 = Double.parseDouble(et_input.getText().toString());

                    output = input * input_1 * input_2;
                    output_1 = 2 * ((input * input_1) + (input * input_2) + (input_1 * input_2));

                    et_output.setText(String.valueOf(output), TextView.BufferType.NORMAL);
                    et_output_1.setText(String.valueOf(output_1), TextView.BufferType.NORMAL);
                }
            }
        });
    }
}