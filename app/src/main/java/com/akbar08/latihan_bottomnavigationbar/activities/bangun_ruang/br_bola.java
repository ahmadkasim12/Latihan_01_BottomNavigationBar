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

public class br_bola extends AppCompatActivity {

    private Button btnBack, btnCalculate;
    private EditText et_input, et_output, et_output_1;
    double input, output, output_1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_br_bola);
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        et_input = findViewById(R.id.et_br_bola_input1);
        et_output = findViewById(R.id.et_br_bola_output);
        et_output_1 = findViewById(R.id.et_br_bola_output_1);

        btnBack = findViewById(R.id.btn_br_bola_back);
        btnCalculate = findViewById(R.id.btn_br_bola_calculate);

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
                if (et_input.getText().toString().isEmpty()){
                    Toast.makeText(br_bola.this, "Input tidak valid!", Toast.LENGTH_SHORT).show();
                    v.vibrate(VibrationEffect.createOneShot(250, VibrationEffect.DEFAULT_AMPLITUDE));

                    return;
                }
                else {
                    input = Double.parseDouble(et_input.getText().toString());
                    output = (4/3) * Math.PI * Math.pow(input, 3);
                    output_1 = 4 * Math.PI * Math.pow(input, 2);

                    et_output.setText(String.valueOf(output), TextView.BufferType.NORMAL);
                    et_output_1.setText(String.valueOf(output_1), TextView.BufferType.NORMAL);
                }
            }
        });
    }
}