package com.example.davey.myfavoritecalculator;

import android.databinding.DataBindingUtil;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.davey.myfavoritecalculator.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private com.example.davey.myfavoritecalculator.databinding.ActivityMainBinding binding; //had to add davey.myfavor... to get ActivityMainBinding to work

    private double valueOne = Double.NaN;
    private double valueTwo;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION ='*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION; //next operand

    private DecimalFormat decimalFormat = new DecimalFormat("#.##########");//output that can have 10 places


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //for zero
        binding.buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "0");
            }
        });

        //for one
        binding.buttonOne.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "1");
            }
        });

        //for two
        binding.buttonTwo.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View view){
              binding.editText.setText(binding.editText.getText() + "2");
          }
        });

        //end numbers

    }
}
