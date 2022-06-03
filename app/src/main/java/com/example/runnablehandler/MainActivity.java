package com.example.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ServiceConnection;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    TextView textView, textView1, textView2, textView3, textView4, textView5;
    Button button;
    Button button1;
    int number,number1;
    int counter;
    Runnable runnable; 
    Handler handler; 
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView1 = findViewById(R.id.textView4);
        textView2 = findViewById(R.id.textView6);
        textView3 = findViewById(R.id.textView5);
        textView4 = findViewById(R.id.textView7);
        textView5 = findViewById(R.id.textView8);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button2);
        number = 0;
        number1 = 0;
        counter = 0;
    }

    public void start(View view){
        handler = new Handler();
        button.setEnabled(false);
        runnable = new Runnable() { 
            @Override
            public void run() {
                number++;
                number1++;
                textView.setText("Time(s): " + number);
                handler.postDelayed(runnable,1000); 
                updateTotalTime();
                updateTime();
            }
        };
        handler.post(runnable);

    }
    public void stop(View view){
        button.setEnabled(true);
        handler.removeCallbacks(runnable);
        textView.setText("Time(s): " + number);
    }
    public void reset(View view){
        button.setEnabled(true);
        handler.removeCallbacks(runnable);
        number = 0;
        textView.setText("Time(s): " + number);
        textView5.setText("Time = 00 : 00 : 00");
    }
    public void save(View view){

        String sHour = "00", sMin = "00", sSec = "00";

        int numberTemp = number;
        int min = 0,sec = 0,hour = 0;

        sec = numberTemp;
        min = sec / 60;
        sec = sec % 60;
        hour = min / 60;
        min = min % 60;

        if (hour == 0)
            sHour = "00";
        else {
            sHour = String.valueOf(hour);

            if (sHour.length() == 1)
                sHour = "0" + sHour;
        }
        if (min == 0)
            sMin = "00";
        else {
            sMin = String.valueOf(min);

            if (sMin.length() == 1)
                sMin = "0" + sMin;
        }
        if (sec == 0)
            sSec = "00";
        else {
            sSec = String.valueOf(sec);

            if (sSec.length() == 1)
                sSec = "0" + sSec;
        }

        if(counter == 0){
            textView1.setText("Save 1 = " + sHour + " : " + sMin + " : " + sSec);
            textView1.setTextColor(Color.rgb(255,0,0));
            textView2.setTextColor(Color.rgb(0,0,0));
            textView3.setTextColor(Color.rgb(0,0,0));
            counter++;
        }else if(counter == 1){
            textView2.setText("Save 2 = " + sHour + " : " + sMin + " : " + sSec);
            textView2.setTextColor(Color.rgb(255,0,0));
            textView1.setTextColor(Color.rgb(0,0,0));
            textView3.setTextColor(Color.rgb(0,0,0));
            counter++;
        }else{
            textView3.setText("Save 3 = " + sHour + " : " + sMin + " : " + sSec);
            textView3.setTextColor(Color.rgb(255,0,0));
            textView1.setTextColor(Color.rgb(0,0,0));
            textView2.setTextColor(Color.rgb(0,0,0));
            counter = 0;
        }
    }


    public void updateTotalTime(){
        String sHour = "00", sMin = "00", sSec = "00";

        int numberTemp = number1;
        int min = 0,sec = 0,hour = 0;

        sec = numberTemp;
        min = sec / 60;
        sec = sec % 60;
        hour = min / 60;
        min = min % 60;

        if (hour == 0)
            sHour = "00";
        else {
            sHour = String.valueOf(hour);

            if (sHour.length() == 1)
                sHour = "0" + sHour;
        }
        if (min == 0)
            sMin = "00";
        else {
            sMin = String.valueOf(min);

            if (sMin.length() == 1)
                sMin = "0" + sMin;
        }
        if (sec == 0)
            sSec = "00";
        else {
            sSec = String.valueOf(sec);

            if (sSec.length() == 1)
                sSec = "0" + sSec;
        }

        textView4.setText("Total Time = " + sHour + " : " + sMin + " : " + sSec);

    }
    public void updateTime(){
        String sHour = "00", sMin = "00", sSec = "00";

        int numberTemp = number;
        int min = 0,sec = 0,hour = 0;

        sec = numberTemp;
        min = sec / 60;
        sec = sec % 60;
        hour = min / 60;
        min = min % 60;

        if (hour == 0)
            sHour = "00";
        else {
            sHour = String.valueOf(hour);

            if (sHour.length() == 1)
                sHour = "0" + sHour;
        }
        if (min == 0)
            sMin = "00";
        else {
            sMin = String.valueOf(min);

            if (sMin.length() == 1)
                sMin = "0" + sMin;
        }
        if (sec == 0)
            sSec = "00";
        else {
            sSec = String.valueOf(sec);

            if (sSec.length() == 1)
                sSec = "0" + sSec;
        }

        textView5.setText("Time = " + sHour + " : " + sMin + " : " + sSec);

    }
}
