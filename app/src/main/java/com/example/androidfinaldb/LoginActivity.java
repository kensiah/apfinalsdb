package com.example.androidfinaldb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.datatype.Duration;

public class LoginActivity extends AppCompatActivity {
    private EditText editId,editPassword;
    private Button btnLogin,btnRegister;
    private DBHelper dbHelper;
    private ArrayList<User> ListUser = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();
        setListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void findViews(){
        editId = findViewById(R.id.edit_id);
        editPassword = findViewById(R.id.edit_password);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
    }

    private void setListeners(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database();
                String inputId = editId.getText().toString();
                String inputPassword = editPassword.getText().toString();

                for (int i = 0 ; i<ListUser.size();i++) {
                    if(inputId.equals(ListUser.get(i).getUsername()) && inputPassword.equals(ListUser.get(i).getPassword())){
                        Intent intent = new Intent (LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        System.exit(0);
                    }
                    else{
                        Toast.makeText(LoginActivity.this,"Invalid Login",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });
    }

private void Database(){
    dbHelper = new DBHelper(this);
    ListUser = dbHelper.getAllUser();
}

}
