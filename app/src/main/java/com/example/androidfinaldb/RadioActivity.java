package com.example.androidfinaldb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class RadioActivity extends AppCompatActivity {
    private ImageView img;
    private RadioGroup radioGroup;
    private RadioButton radio1,radio2,radio3,radio4,radio5;
    private TextView textView,textTotalPrice,textLoanPrice;
    private Button btnBack,btnCalculate;
    private int year;
    private double interest=3.5,totalprice;
    private Spinner spinner;
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
        if(model.equals("X70")){
            textView.setText(model);
            img.setImageResource(R.drawable.x70);
            radio(radio1,"Standard 2WD");
            radio(radio2,"Executive 2WD");
            radio(radio3,"Executive AWD");
            radio(radio4,"Premium 2WD");
            radioHide(radio5);
            radio1.setChecked(true);
            setPrice(textTotalPrice,99800.00);

        }else if(model.equals("SAGA")){
            textView.setText(model);
            img.setImageResource(R.drawable.saga);
            radio(radio1,"Standard MT");
            radio(radio2,"Standard AT");
            radio(radio3,"Premium AT");
            radioHide(radio4);
            radioHide(radio5);
            radio1.setChecked(true);
            setPrice(textTotalPrice,32800.00);
        }else if(model.equals("PERSONA")){
            textView.setText(model);
            img.setImageResource(R.drawable.persona);
            radio(radio1,"Standard MT");
            radio(radio2,"Standard CVT");
            radio(radio3,"Executive CVT");
            radio(radio4,"Premium CVT");
            radioHide(radio5);
            radio1.setChecked(true);
            setPrice(textTotalPrice,42600.00);
        }else if(model.equals("IRIZ")){
            textView.setText(model);
            img.setImageResource(R.drawable.iriz);
            radio(radio1,"1.3L Standard MT");
            radio(radio2,"1.3L Standard CVT");
            radio(radio3,"1.3L Executive CVT");
            radio(radio4,"1.6L Executive CVT");
            radio(radio5,"1.6L Premium CVT");
            radio1.setChecked(true);
            setPrice(textTotalPrice,36700.00);
        }else if(model.equals("EXORA")){
            textView.setText(model);
            img.setImageResource(R.drawable.exora);
            radio(radio1,"Executive");
            radio(radio2,"Premium");
            radioHide(radio3);
            radioHide(radio4);
            radioHide(radio5);
            radio1.setChecked(true);
            setPrice(textTotalPrice,59800.00);
        }else if(model.equals("PERDANA")){
            textView.setText(model);
            img.setImageResource(R.drawable.perdana);
            radio(radio1,"2.0L, Solid");
            radio(radio2,"2.0L, Metallic");
            radio(radio3,"2.4L, Solid");
            radio(radio4,"2.4L, Metallic");
            radioHide(radio5);
            radio1.setChecked(true);
            setPrice(textTotalPrice,103927.68);
        }else if(model.equals("PREVE")){
            textView.setText(model);
            img.setImageResource(R.drawable.preve);
            radio(radio1,"1.6L Executive CVT");
            radio(radio2,"1.6T Premium CVT");
            radioHide(radio3);
            radioHide(radio4);
            radioHide(radio5);
            radio1.setChecked(true);
            setPrice(textTotalPrice,61090.94);
        }
    }

    private void findViews(){
        img = findViewById(R.id.img_radio);
        textView = findViewById(R.id.tv_model_radio);
        textTotalPrice = findViewById(R.id.tv_total_price);
        textLoanPrice = findViewById(R.id.tv_loan_price);
        radioGroup = findViewById(R.id.radio_group);
        radio1 = findViewById(R.id.variant1);
        radio2 = findViewById(R.id.variant2);
        radio3 = findViewById(R.id.variant3);
        radio4 = findViewById(R.id.variant4);
        radio5 = findViewById(R.id.variant5);
        btnBack = findViewById(R.id.btn_back);
        btnCalculate = findViewById(R.id.btn_calculate);
        spinner = findViewById(R.id.spinner);
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

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Bundle bundle = getIntent().getExtras();
                String model = bundle.getString("model");
                if(model.equals("X70")){
                    if(radio1.isChecked()){
                        setPrice(textTotalPrice,99800.00);
                    }if(radio2.isChecked()){
                        setPrice(textTotalPrice,109800.00);
                    }if(radio3.isChecked()){
                        setPrice(textTotalPrice,115800.00);
                    }if(radio4.isChecked()){
                        setPrice(textTotalPrice,123800.00);
                    }
                }else if(model.equals("SAGA")){
                    if(radio1.isChecked()){
                        setPrice(textTotalPrice,32800.00);
                    }if(radio2.isChecked()){
                        setPrice(textTotalPrice,35800.00);
                    }if(radio3.isChecked()){
                        setPrice(textTotalPrice,39800.00);
                    }
                }else if(model.equals("PERSONA")){
                    if(radio1.isChecked()){
                        setPrice(textTotalPrice,42600.00);
                    }if(radio2.isChecked()){
                        setPrice(textTotalPrice,44600.00);
                    }if(radio3.isChecked()){
                        setPrice(textTotalPrice,49600.00);
                    }if(radio4.isChecked()){
                        setPrice(textTotalPrice,54600.00);
                    }
                }else if(model.equals("IRIZ")){
                    if(radio1.isChecked()){
                        setPrice(textTotalPrice,36700.00);
                    }if(radio2.isChecked()){
                        setPrice(textTotalPrice,39700.00);
                    }if(radio3.isChecked()){
                        setPrice(textTotalPrice,44700.00);
                    }if(radio4.isChecked()){
                        setPrice(textTotalPrice,46700.00);
                    }if(radio5.isChecked()){
                        setPrice(textTotalPrice,50700.00);
                    }
                }else if(model.equals("EXORA")){
                    if(radio1.isChecked()){
                        setPrice(textTotalPrice,59800.00);
                    }if(radio2.isChecked()){
                        setPrice(textTotalPrice,66800.00);
                    }
                }else if(model.equals("PERDANA")){
                    if(radio1.isChecked()){
                        setPrice(textTotalPrice,103927.68);
                    }if(radio2.isChecked()){
                        setPrice(textTotalPrice,104326.21);
                    }if(radio3.isChecked()){
                        setPrice(textTotalPrice,126849.21);
                    }if(radio4.isChecked()){
                        setPrice(textTotalPrice,127247.74);
                    }
                }else if(model.equals("PREVE")){
                    if(radio1.isChecked()){
                        setPrice(textTotalPrice,61090.94);
                    }if(radio2.isChecked()){
                        setPrice(textTotalPrice,68430.57);
                    }
                }
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item_position = String.valueOf(position);
                int positionInt = Integer.valueOf(item_position);
                year = positionInt+1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text2 = textTotalPrice.getText().toString();
                System.out.println(text2);
                totalprice = Double.parseDouble(text2);
                    calculateLoan(textLoanPrice,totalprice,interest,year);
                }

        });
    }

    private void radio(RadioButton r,String text){
        r.setText(text);
    }

    private void radioHide(RadioButton r){
        r.setVisibility(View.GONE);
    }

    private void setPrice(TextView tv, double price){
        String p = String.valueOf(price);
        tv.setText(p);
    }

    private void calculateLoan(TextView tvPrice,double totalPrice,double interest,int years){
        double Final;
        int month = (years*12);
        interest = interest(interest);
        double up = upper(interest,month);
        double low = lower(interest,month);
        Final = (totalPrice*up/low);
        tvPrice.setText(String.format("%.2f",Final));
    }

    private double interest(double rate){
        return (rate/100/12); //3.5% = 0.35
    }

    private double upper(double rate,int n){
        return rate*(Math.pow(1+rate,n));
    }

    private double lower(double rate,int n){
        return ((Math.pow(1+rate,n)))-1;
    }
}
