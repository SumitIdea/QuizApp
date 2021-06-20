package com.example.quizapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity {
    TextView tv,score,userView,quesionTextView,totalcount;
    Button nexttbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    ImageView quizImage;

    private ImageView mQuizImage;
    private int QuestionNum=0;

    String questions[] = {
            "In 1632 the emperor, Shah Jahan instructed to build a tomb for his favorite wife, Mumtaz Mahal. They used 20,000 workers and 1000 elephants.",
            "What is the name of this historical structure which is located in Piazza del Duomo, Italy?",
            "This famous statue located in New York City is referred to as:",
            "The structure below located in the Middle East was built thousands of years ago, and still stands today.",
            "The highest mountain in the world, standing at 8,848 meters and 29,029 feet, with 145 attempts to climb it",
            "This is longest wall in the world and has a main-line length of 3,460 km (2,150 miles – nearly three times the length of Britain – plus 3,530 km (2,193 miles) of branches and spurs.",
            "This famed area is located in the mountains, at more than 2,400 metres/8,000 feet above sea level. This ruin site has more than 200 different buildings and structures.",
            "This famous American made car became the most popular car in the US in 1965",
            "Michelangelo created this masterpiece some time between 1508 and 1512 and it lives in the Sistene Chapel",
            "The opera house was designed by Jørn Utzon from Denmark and it was built between 1959 and 1973, with over 1 million roof tiles."
    };
    String answers[] = {
            "The Taj Mahal",
            "Leaning Tower of Pisa",
            "Statue of Liberty",
            "Egyptian Pyramid",
            "Mount Everest",
            "Great Wall of China",
            "Machu Picchu",
            "Ford Mustang",
            "Creation of Adam",
            "Sydney Opera House"
    };

    String opt[] = {
            "The Red Taj","Mizo Taj","Bibi Ka Maqbara","The Taj Mahal",
            "Colosseum","Leaning Tower of Pisa","Milan Cathedral","Ponte Vecchio",
            "Spring Temple Buddha","Christ the Redeemer","Lion-man","Statue of Liberty",
            "Pharaoh’s Tomb","Joseph’s Tomb","Egyptian Pyramid","Mecca Temple",
            "Makalu","Nanga Parbat","Himalayan Mountains","Mount Everest",
            "Kumbhalgarh Fort","Great Wall of China","Amer Fort Jaipur","Ancient Walls of Mesopotamia",
            "Machu Picchu","Nazca Lines","Choquequirao","Chichen Itza",
            "Ford F-Series","Ford Mustang","Chevrolet Silverado","Chevrolet Tahoe",
            "Creation of Adam","David","Genesis","Birth from Heaven",
            "Teatro di San Carlo","Guangzhou Drama Arts Center","Sydney Opera House","Bunkamura Orchard Hall"
    };

    String mImage[]={
            "q1","q2","q3","q4","q5","q6","q7","q8","q9","q10"
    };

    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    private String[] mImages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        totalcount=findViewById(R.id.totalcount);
        quizImage=findViewById(R.id.quizimage);
        score =findViewById(R.id.textView4);
        userView=findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("sumit");

        if (name.trim().equals(""))
            userView.setText("Hello User");
        else
            userView.setText("Hello " + name);

        nexttbutton=findViewById(R.id.button3);
        quitbutton=findViewById(R.id.buttonquit);
        tv=findViewById(R.id.tvque);

        radio_g=findViewById(R.id.answersgrp);
        rb1=findViewById(R.id.radioButton);
        rb2=findViewById(R.id.radioButton2);
        rb3=findViewById(R.id.radioButton3);
        rb4=findViewById(R.id.radioButton4);

        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);

        nexttbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();


                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                totalcount.setText(flag+"/10");
                if (score != null)
                    score.setText(""+correct);


                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
               // showMainImage();
                updateQuestion();

            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });

    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void updateQuestion()
    {
        // setting the textview with new question
        switch (flag) {
            case 0:
                // setting up image for each
                // question
                quizImage.setImageResource(R.drawable.q1);
                break;
            case 1:
                quizImage.setImageResource(R.drawable.q2);
                break;
            case 2:
                quizImage.setImageResource(R.drawable.q3);
                break;
            case 3:
                quizImage.setImageResource(R.drawable.q4);
                break;
            case 4:
                quizImage.setImageResource(R.drawable.q5);
                break;
            case 5:
                quizImage.setImageResource(R.drawable.q6);
                break;
            case 6:
                    quizImage.setImageResource(R.drawable.q7);
                break;
            case 7:
             quizImage.setImageResource(R.drawable.q8);
                break;
            case 8:
                quizImage.setImageResource(R.drawable.q9);
                break;
            case 9:
                quizImage.setImageResource(R.drawable.q10);
                break;
        }
    }
   

}