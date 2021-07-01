package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;

    TextView mcurrentHeight;
    TextView mcurrentAge,mcurrentWeight;
    ImageView mincrementage,mincrementweight,mdecrementweight,mdecrementage;
    SeekBar mseekbarforheight;
    RelativeLayout mmale,mfemale;

    int weight=55;
    int age=18;
    int currentprogress;
    String mprogress="170";
    String typeofuser="0";
    String weight2="55";
    String age2="18";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        button = findViewById(R.id.calculate);
        mcurrentAge = findViewById(R.id.age);
        mcurrentWeight = findViewById(R.id.currentweight);
        mcurrentHeight = findViewById(R.id.currentHeight);
        mincrementage = findViewById(R.id.incrementAge);
        mdecrementage = findViewById(R.id.decrementAge);
        mincrementweight = findViewById(R.id.incrementWeight);
        mdecrementweight = findViewById(R.id.decrementWeight);
        mmale = findViewById(R.id.male);
        mfemale = findViewById(R.id.female);
        mseekbarforheight = findViewById(R.id.seekbar);

        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser="Male";
            }
        });

        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser="Female ";
            }
        });

        mseekbarforheight.setMax(300);
        mseekbarforheight.setProgress(170);
        mseekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                 currentprogress=progress;
                 mprogress=String.valueOf(currentprogress);
                 mcurrentHeight.setText(mprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mincrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age=age+1;
                age2=String.valueOf(age);
                mcurrentAge.setText(age2);
            }
        });


        mincrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight=weight+1;
                weight2=String.valueOf(weight);
                mcurrentWeight.setText(weight2 );
            }
        });

        mdecrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age=age-1;
                age2=String.valueOf(age);
                mcurrentAge.setText(age2);
            }
        });


        mdecrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight=weight-1;
                weight2=String.valueOf(weight);
                mcurrentWeight.setText(weight2 );
            }
        });




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(typeofuser.equals("0"))
                {
                    Toast.makeText(getApplicationContext(),"Select your gender first",Toast.LENGTH_SHORT).show();
                }
                else if(mprogress.equals("0"))
                {
                    Toast.makeText(getApplicationContext(),"Select your Height first",Toast.LENGTH_SHORT).show();
                }
                else if(age==0|| age<0)
                {
                    Toast.makeText(getApplicationContext(),"Age is incorrect",Toast.LENGTH_SHORT).show();
                }
                else if(weight<=0)
                {
                    Toast.makeText(getApplicationContext(),"Weight is incorrect",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this,bmiActivity.class);
                    intent.putExtra("gender",typeofuser);
                    intent.putExtra("height",mprogress);
                    intent.putExtra("weight",weight2);
                    intent.putExtra("age",age2);
                    startActivity(intent);
                }

            }
        });


    }
}