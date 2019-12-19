package com.example.androidfinaldb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnLogout;
    private ListView listView;
    private ArrayList<Car> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setUpAdapter();
        setListeners();
    }

    private void findViews(){
        btnLogout = findViewById(R.id.btn_logout);
        listView = findViewById(R.id.list_view_home);
    }

    private void setListeners(){
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Car car = (Car)parent.getAdapter().getItem(position);

                Intent i = new Intent(MainActivity.this,RadioActivity.class);
                i.putExtra("model",car.getModel());
                startActivity(i);
            }
        });
    }

    private void setUpAdapter(){
        arrayList.add(new Car("X70",R.drawable.x70));
        arrayList.add(new Car("SAGA",R.drawable.saga));
        arrayList.add(new Car("PERSONA",R.drawable.persona));
        arrayList.add(new Car("IRIZ",R.drawable.iriz));
        arrayList.add(new Car("EXORA",R.drawable.exora));
        arrayList.add(new Car("PERDANA",R.drawable.perdana));
        arrayList.add(new Car("PREVE",R.drawable.preve));


        HomePageAdapter adapter = new HomePageAdapter(this,arrayList);

        listView.setAdapter(adapter);
    }
}
