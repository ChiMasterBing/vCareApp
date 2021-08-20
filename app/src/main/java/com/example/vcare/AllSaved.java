package com.example.vcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class AllSaved extends AppCompatActivity {

    private RecyclerView articlesRecView;
    private ImageButton btnBack;
    ArrayList<SavedItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_saved);

        articlesRecView = findViewById(R.id.savedRecView);

        items = new ArrayList<>();
        for (int i=1; i<=12; i++){
            items.add(new SavedItem("Saved " + i));
        }

        SavedRecViewAdapter adapter = new SavedRecViewAdapter(this);
        adapter.setItem(items);

        articlesRecView.setAdapter(adapter);
        articlesRecView.setLayoutManager(new GridLayoutManager(this,3));

        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(AllSaved.this, SavedScreen.class));
                finish();
            }
        });
    }
}