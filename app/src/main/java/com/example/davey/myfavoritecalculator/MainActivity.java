package com.example.davey.myfavoritecalculator;

import android.databinding.DataBindingUtil;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.davey.myfavoritecalculator.databinding.ActivityMainBinding;

import static java.lang.Double.NaN;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    //private com.example.davey.myfavoritecalculator.databinding.ActivityMainBinding binding; //had to add davey.myfavor... to get ActivityMainBinding to work
    private double valueOne = NaN;
    private double valueTwo;
    private double lastValue = 0.0;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION ='*';
    private static final char DIVISION = '/';
    private char CURRENT_ACTION; //next operand
    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        decimalFormat = new DecimalFormat("#.##########");//output that can have 10 places
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //for zero
        binding.buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "0");
            }
        });

        //for number

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

        //for three
        binding.buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "3");
            }
        });

        //for four
        binding.buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "4");
            }
        });

        //for five
        binding.buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "5");
            }
        });

        //for six
        binding.buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "6");
            }
        });

        //for seven
        binding.buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "7");
            }
        });

        //for eight
        binding.buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "8");
            }
        });

        //for nine
        binding.buttonNine.setOnClickListener(new View.OnClickListener() { //binding is name in xml file, buttonNine is name in Activity_main.Xml file
            @Override //because of all the methods I have for the onClick view and the built in to java method
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "9"); //need binding.editText.getText() + "9" to keep what was already there
            }
        });
        //end numbers

        //for other functions

        //for the decimal point
        binding.buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + ".");
            }
        });

        //Addition
        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "+");
                binding.editText.setText(null);
            }
        });

        //Subtraction
        binding.buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "-");
                binding.editText.setText(null);
            }
            });

        //Multiplication
        binding.buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                computeCalculation();
                CURRENT_ACTION = MULTIPLICATION;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "*");
                binding.editText.setText(null);
            }
        });

        //Division
        binding.buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                computeCalculation();
                CURRENT_ACTION = DIVISION;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "/");
                binding.editText.setText(null);
            }
        });

        //Equal
        binding.buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                computeCalculation();
                binding.infoTextView.setText(binding.infoTextView.getText().toString() +
                        decimalFormat.format(valueTwo) + " = " +
                        decimalFormat.format(valueOne));
                valueOne = NaN;
                CURRENT_ACTION = '0';
            }
        });

        //Clear
        binding.buttonClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (binding.editText.getText().length() > 0) {
                    CharSequence currentText = binding.editText.getText();
                    binding.editText.setText(currentText.subSequence(0, currentText.length()-1));
                }
                else{
                    valueOne = NaN;
                    valueTwo = NaN;
                    binding.editText.setText("");
                    binding.infoTextView.setText("");
                }
            }
        });
    }

    public void computeCalculation(){
        if (!Double.isNaN(valueOne)){
            valueTwo = Double.parseDouble(binding.editText.getText().toString());
            binding.editText.setText(null);
            if (CURRENT_ACTION == ADDITION) {
                valueOne = this.valueOne + valueTwo;
            }
            else if (CURRENT_ACTION == SUBTRACTION){
                valueOne = this.valueOne - valueTwo;
            }
            else if (CURRENT_ACTION == MULTIPLICATION){
                valueOne = this.valueOne * valueTwo;
            }
            else if (CURRENT_ACTION == DIVISION){
                valueOne = this.valueOne / valueTwo;
            }
        }

        else{
            valueOne = 0.0;//added to keep calculator from displaying NaN
            valueTwo = 0.0;//added to keep calculator from displaying NaN

            try{
                valueOne = Double.parseDouble(binding.editText.getText().toString());
            }
            catch (Exception e){}
        }
    }

}