package com.example.aaron.weekendprojectone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;


public class EMI_Calculator extends AppCompatActivity {

    SeekBar sbAdjustInterestRate;
    SeekBar sbAdjustDuration;
    SeekBar sbAdjustPrinciple;

    TextView tvDisplayInterestRate;
    TextView tvDisplayDuration;
    TextView tvDisplayPrinciple;
    TextView tvDisplayEMi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        sbAdjustDuration = (SeekBar) findViewById(R.id.timeOfLoan);
        sbAdjustInterestRate = (SeekBar) findViewById(R.id.interestRate);
        sbAdjustPrinciple = (SeekBar) findViewById(R.id.amtOfLoan);

        tvDisplayDuration = (TextView) findViewById(R.id.tvLoanDuration);
        tvDisplayInterestRate = (TextView) findViewById(R.id.tvIRLabel);
        tvDisplayPrinciple = (TextView) findViewById(R.id.tvAMPLabel);
        tvDisplayEMi = (TextView) findViewById(R.id.tvEMIDisplay);

        //sbAdjustDuration.setOnSeekBarChangeListener(customSeekBarListener);
        //sbAdjustDuration.setOnSeekBarChangeListener(customSeekBarListener);
        //sbAdjustDuration.setOnSeekBarChangeListener(customSeekBarListener);


    }

    private SeekBar.OnSeekBarChangeListener customSeekBarListener =
            new SeekBar.OnSeekBarChangeListener() {
                // update currentCustomRate, then call updateCustomRate
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    // get currentCustomRate from the position of the SeekBar's thumb
                    String iRate = sbAdjustInterestRate.getProgress() + "";
                    String duration = sbAdjustDuration.getProgress() + "";
                    String principle = sbAdjustPrinciple.getProgress() + "";

                    tvDisplayInterestRate.setText(iRate);
                    tvDisplayPrinciple.setText(principle);
                    tvDisplayDuration.setText(duration);
                    tvDisplayEMi.setText(duration);

                    // update EditTexts for custom rate and monthly
                    updateCustomRate();
                }


                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }

                private void updateCustomRate() {

                }
            };
}

