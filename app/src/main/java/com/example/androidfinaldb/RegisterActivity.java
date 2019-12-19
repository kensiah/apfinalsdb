package com.example.androidfinaldb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {
    private Button btnConfirm;
    private EditText editId,editPassword,editConfirmPassword;
    private DBHelper dbHelper;
    private ArrayList<User> ListUser = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViews();
        setListeners();
    }

    private void findViews(){
        btnConfirm = findViewById(R.id.btn_confirm);
        editId = findViewById(R.id.edit_register_id);
        editPassword = findViewById(R.id.edit_register_password);
        editConfirmPassword = findViewById(R.id.edit_confirm_password);
    }

    private void setListeners(){
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database();
                String inputId = editId.getText().toString();
                String inputPassword = editPassword.getText().toString();
                String inputConfirmPassword = editConfirmPassword.getText().toString();
                for(int i = 0; i < ListUser.size(); i++){
                    if(!inputId.equals(ListUser.get(i).getUsername())){
                        if(inputPassword.equals(inputConfirmPassword)){
                            User user = new User(inputId,inputPassword);
                            dbHelper.insertUser(user);
                            Toast.makeText(RegisterActivity.this,"Registration Success!",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(RegisterActivity.this,"Password and Confirm Password do not match.",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this,"Username existed. Please enter another username.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void Database(){
        dbHelper = new DBHelper(this);
        ListUser = dbHelper.getAllUser();
    }
}
