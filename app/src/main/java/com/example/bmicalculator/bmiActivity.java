package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.GenericArrayType;

public class bmiActivity extends AppCompatActivity {

    Button button;


    TextView mbmiDisplay,mgender,mbmiCategory;
    Intent intent;
    ImageView imageView;
    String mbmi;
    float bmi;

    String height;
    String weight;
    float fheight,fweight;
    RelativeLayout mbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Results");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent = getIntent();
        mbmiDisplay=findViewById(R.id.bmidisplay);
        mgender=findViewById(R.id.genderDisplay);
        mbmiCategory=findViewById(R.id.category);
        mbackground=findViewById(R.id.contentLayout);
        imageView=findViewById(R.id.imageFinal);


        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        fheight = Float.parseFloat(height);
        fweight = Float.parseFloat(weight);
        mgender.setText(intent.getStringExtra("gender"));

        fheight=fheight/100;
        bmi=fweight/(fheight*fheight);
        mbmi=Float.toString(bmi);

        if(bmi<16)
        {
            mbmiCategory.setText("Severe Thinness");
            mbackground.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        }
        else if(bmi<16.9 && bmi>=16)
        {
            mbmiCategory.setText("Moderate Thinness");
            mbackground.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        }
        else if(bmi<18.4 && bmi>=16.9)
        {
            mbmiCategory.setText("Mild Thinness");
            mbackground.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        }
        else if(bmi<25 && bmi>=18.4)
        {
            mbmiCategory.setText("Normal");
           // mbackground.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.ok);
        }
        else if(bmi<29.4&&bmi>=25)
        {
            mbmiCategory.setText("Obese class 0");
            mbackground.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        }
        else
        {
            mbmiCategory.setText("Obese class 1");
            mbackground.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);

        }

        mbmiDisplay.setText(mbmi);




        button = findViewById(R.id.recalculate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(bmiActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}