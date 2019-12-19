package com.example.androidfinaldb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class RadioActivity extends AppCompatActivity {
    private ImageView img;
    private RadioButton radio1,radio2,radio3,radio4,radio5;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        findViews();
        initialize();
        setListeners();
    }

    private void initialize(){
        Bundle bundle = getIntent().getExtras();
        String model = bundle.getString("model");
        String[] variant = {};

        if(model.equals("X70")){
            textView.setText(model);
            img.setImageResource(R.drawable.x70);
        }else if(model.equals("SAGA")){
            textView.setText(model);
            img.setImageResource(R.drawable.saga);
        }else if(model.equals("PERSONA")){
            textView.setText(model);
            img.setImageResource(R.drawable.persona);
        }else if(model.equals("IRIZ")){
            textView.setText(model);
            img.setImageResource(R.drawable.iriz);
        }else if(model.equals("EXORA")){
            textView.setText(model);
            img.setImageResource(R.drawable.exora);
        }else if(model.equals("PERDANA")){
            textView.setText(model);
            img.setImageResource(R.drawable.perdana);
        }else if(model.equals("PREVE")){
            textView.setText(model);
            img.setImageResource(R.drawable.preve);
        }
    }

    private void findViews(){
        img = findViewById(R.id.img_radio);
        textView = findViewById(R.id.tv_model_radio);
        radio1 = findViewById(R.id.variant1);
        radio2 = findViewById(R.id.variant2);
        radio3 = findViewById(R.id.variant3);
        radio4 = findViewById(R.id.variant4);
        radio5 = findViewById(R.id.variant5);
    }

    private void setListeners(){

    }

    private void radio(RadioButton r){

    }

}
