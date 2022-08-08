package com.example.vcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

public class Mindfulness extends AppCompatActivity {

    private RecyclerView sbRecView;
    private RecyclerView mindfulRecView;
    private ImageButton back;
    private FirebaseDatabase mAuth;
    private DatabaseReference myRef;
    private ArrayList<Article> sbArticles;
    private ArrayList<Article> mindfulArticles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mindfulness);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        sbRecView = findViewById(R.id.sbArticlesRecView);
        mindfulRecView = findViewById(R.id.mArticlesRecView);

        back = findViewById(R.id.backMindfulness);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Return to HomeScreen
                finish();
            }
        });

        mAuth = FirebaseDatabase.getInstance();
        myRef = mAuth.getReference("Articles");

        sbArticles = new ArrayList<>();
        mindfulArticles = new ArrayList<>();

        //Rest should work for firebase
        articleRecViewAdapter sbAdapter = new articleRecViewAdapter(this);
        sbAdapter.setArticles(sbArticles);
        sbRecView.setAdapter(sbAdapter);
        sbRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        articleRecViewAdapter mindfulAdapter = new articleRecViewAdapter(this);
        mindfulAdapter.setArticles(mindfulArticles);
        mindfulRecView.setAdapter(mindfulAdapter);
        mindfulRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Retrieve Article data from firebase
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.child("Science of the Brain").getChildren()) {
                    Article article = snapshot.getValue(Article.class);
                    sbArticles.add(article);
                }

                for (DataSnapshot snapshot : dataSnapshot.child("Mindfulness").getChildren()) {
                    Article article = snapshot.getValue(Article.class);
                    mindfulArticles.add(article);
                }

                // shuffle Articles at random
                Collections.shuffle(sbArticles);
                Collections.shuffle(mindfulArticles);

                // update dataset
                sbAdapter.setArticles(sbArticles);
                mindfulAdapter.setArticles(mindfulArticles);

            }
            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(Mindfulness.this, error.toException().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}