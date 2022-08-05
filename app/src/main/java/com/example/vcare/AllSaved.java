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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_saved);

        articlesRecView = findViewById(R.id.savedRecView);

        ArrayList<SavedItem> items = new ArrayList<>();
        items.add(new SavedItem("Saved 1"));
        items.add(new SavedItem("Saved 2"));
        items.add(new SavedItem("Saved 3"));
        items.add(new SavedItem("Saved 4"));
        items.add(new SavedItem("Saved 5"));
        items.add(new SavedItem("Saved 6"));
        items.add(new SavedItem("Saved 7"));
        items.add(new SavedItem("Saved 8"));
        items.add(new SavedItem("Saved 9"));
        items.add(new SavedItem("Saved 10"));
        items.add(new SavedItem("Saved 11"));
        items.add(new SavedItem("Saved 12"));

        SavedRecViewAdapter adapter = new SavedRecViewAdapter(this);
        adapter.setItem(items);

        articlesRecView.setAdapter(adapter);
        articlesRecView.setLayoutManager(new GridLayoutManager(this,3));

        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Return to SavedScreen
                finish();
            }
        });
    }
}