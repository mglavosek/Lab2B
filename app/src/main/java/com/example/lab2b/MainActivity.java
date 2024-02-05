package com.example.lab2b;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.lab2b.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get inputs from the user
                String fahrenheitStr = binding.fahrenheitInputField.getText().toString().trim();
                String celsiusStr = binding.celsiusInputField.getText().toString().trim();


                if (!fahrenheitStr.isEmpty() && !celsiusStr.isEmpty()) {
                    double fahrenheit = Double.parseDouble(fahrenheitStr);
                    double celsius = (fahrenheit - 32) * 5 / 9;

                    //rounding celsius to two decimal places
                    celsius = (double) Math.round(celsius * 100) / 100;

                    //Doing the default calculation and outputting the calculation in the Celsius field
                    binding.celsiusInputField.setText(String.valueOf(celsius));
                } else if (!fahrenheitStr.isEmpty()) {
                    double fahrenheit = Double.parseDouble(fahrenheitStr);
                    double celsius = (fahrenheit - 32) * 5 / 9;

                    //rounding celsius to two decimal places
                    celsius = (double) Math.round(celsius * 100) / 100;

                    //Converting Fahrenheit to Celsius and outputting it to the Celsius field
                    binding.celsiusInputField.setText(String.valueOf(celsius));
                } else if (!celsiusStr.isEmpty()) {
                    double celsius = Double.parseDouble(celsiusStr);
                    double fahrenheit = (celsius * 9 / 5) + 32;

                    //rounding fahrenheit to two decimal places
                    fahrenheit = (double) Math.round(fahrenheit * 100) / 100;

                    //Converting Celsius to Fahrenheit and outputting it to the Fahrenheit field
                    binding.fahrenheitInputField.setText(String.valueOf(fahrenheit));
                }
            }
        });
    }
}