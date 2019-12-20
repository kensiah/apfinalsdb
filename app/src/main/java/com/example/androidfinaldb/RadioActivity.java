package com.example.androidfinaldb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class RadioActivity extends AppCompatActivity {
    private ImageView img;
    private RadioButton radio1,radio2,radio3,radio4,radio5;
    private TextView textView;
    private Button btnBack;
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
            radio(radio1,"Standard 2WD");
            radio(radio2,"Executive 2WD");
            radio(radio3,"Executive AWD");
            radio(radio4,"Premium 2WD");
            radioHide(radio5);
        }else if(model.equals("SAGA")){
            textView.setText(model);
            img.setImageResource(R.drawable.saga);
            radio(radio1,"Standard MT");
            radio(radio2,"Standard AT");
            radio(radio3,"Premium AT");
            radioHide(radio4);
            radioHide(radio5);
        }else if(model.equals("PERSONA")){
            textView.setText(model);
            img.setImageResource(R.drawable.persona);
            radio(radio1,"Standard MT");
            radio(radio2,"Standard CVT");
            radio(radio3,"Executive CVT");
            radio(radio4,"Premium CVT");
            radioHide(radio5);
        }else if(model.equals("IRIZ")){
            textView.setText(model);
            img.setImageResource(R.drawable.iriz);
            radio(radio1,"1.3L Standard MT");
            radio(radio2,"1.3L Standard CVT");
            radio(radio3,"1.3L Executive CVT");
            radio(radio4,"1.6L Executive CVT");
            radio(radio5,"1.6L Premium CVT");
        }else if(model.equals("EXORA")){
            textView.setText(model);
            img.setImageResource(R.drawable.exora);
            radio(radio1,"Executive");
            radio(radio2,"Premium");
            radioHide(radio3);
            radioHide(radio4);
            radioHide(radio5);
        }else if(model.equals("PERDANA")){
            textView.setText(model);
            img.setImageResource(R.drawable.perdana);
            radio(radio1,"2.0L, Solid");
            radio(radio2,"2.0L, Metallic");
            radio(radio3,"2.4L, Solid");
            radio(radio4,"2.4L, Metallic");
            radioHide(radio5);
        }else if(model.equals("PREVE")){
            textView.setText(model);
            img.setImageResource(R.drawable.preve);
            radio(radio1,"1.6L Executive CVT");
            radio(radio2,"1.6T Premium CVT");
            radioHide(radio3);
            radioHide(radio4);
            radioHide(radio5);
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
        btnBack = findViewById(R.id.btn_back);
    }

    private void setListeners(){
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RadioActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void radio(RadioButton r,String text){
        r.setText(text);
    }

    private void radioHide(RadioButton r){
        r.setVisibility(View.GONE);
    }

}
