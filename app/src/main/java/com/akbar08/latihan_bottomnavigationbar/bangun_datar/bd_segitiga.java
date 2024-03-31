package com.akbar08.latihan_bottomnavigationbar.bangun_datar;

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

public class bd_segitiga extends AppCompatActivity {

    private EditText et_input, et_input_1, et_output;
    double input, input_1, output;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bd_segitiga);
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        et_input = findViewById(R.id.et_bd_segitiga_input);
        et_input_1 = findViewById(R.id.et_bd_segitiga_input_1);
        et_output = findViewById(R.id.et_bd_segitiga_output);

        Button btnBack = findViewById(R.id.btn_bd_segitiga_back);
        Button btnCalculate = findViewById(R.id.btn_bd_segitiga_calculate);

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
                if (et_input.getText().toString().isEmpty() || et_input_1.getText().toString().isEmpty()){
                    Toast.makeText(bd_segitiga.this, "Input tidak valid!", Toast.LENGTH_SHORT).show();
                    v.vibrate(VibrationEffect.createOneShot(250, VibrationEffect.DEFAULT_AMPLITUDE));
                }
                else {
                    input = Double.parseDouble(et_input.getText().toString());
                    input_1 = Double.parseDouble(et_input_1.getText().toString());


                    output = (input * input_1) / 2;

                    et_output.setText(String.valueOf(output), TextView.BufferType.NORMAL);
                }
            }
        });
    }
}