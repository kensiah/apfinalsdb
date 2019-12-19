package com.example.androidfinaldb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    private void findViews(){
        editId = findViewById(R.id.edit_id);
        editPassword = findViewById(R.id.edit_password);
        btnLogin = findViewById(R.id.btn_login);
    }

    private void setListeners(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Request request = new Request.Builder()
                        .url("https://api.myjson.com/bins/tr904")
                        .build();

                okHttpClient.newCall(request)
                        .enqueue(new Callback(){
                            @Override
                            public void onFailure(@NotNull Call call, @NotNull IOException e) {

                            }

                            @Override
                            public void onResponse(@NotNull Call call, @NotNull final Response response) throws IOException {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        String data = null;
                                        try{
                                            data = response.body().string();
                                            if(validateAccounts(data)){
                                                Intent i = new Intent(LoginActivity.this,CarListActivity.class);
                                                startActivity(i);
                                                finish();
                                            }else{
                                                Toast.makeText(LoginActivity.this,"Login Invalid!",Toast.LENGTH_SHORT).show();
                                            }
                                        }catch(IOException e){
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                        });
            }
        });

    }

    private boolean validateAccounts(String data){
        try {
            JSONObject dataObject = new JSONObject(data);
            JSONArray accountArray = dataObject.getJSONArray("accounts");

            String inputId = editId.getText().toString();
            String inputPassword = editPassword.getText().toString();


            for (int i=0; i < accountArray.length(); i++){
                JSONObject accountObject = accountArray.getJSONObject(i);

                String validationUsername = accountObject.getString("username");
                String validationPassword = accountObject.getString("password");

                if(inputId.equals(validationUsername) && inputPassword.equals(validationPassword)){
                    return true;
                }
            }

            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
