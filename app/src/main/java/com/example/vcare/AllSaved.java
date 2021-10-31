package com.example.vcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class AllSaved extends AppCompatActivity {

    private RecyclerView articlesRecView;
    private ImageButton btnBack;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_saved);

        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseDatabase.getInstance().getReference("UserData")
                .child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                user = snapshot.getValue(User.class);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(AllSaved.this, "Something went wrong.", Toast.LENGTH_LONG).show();
            }
        });

        ArrayList<Integer> codes = new ArrayList<Integer>();
        /**codes.addAll(user.getMind());
        codes.addAll(user.getQuote());
        codes.addAll(user.getQuote());**/

        articlesRecView = findViewById(R.id.savedRecView);

        ArrayList<SavedItem> items = new ArrayList<>();
        for(int i = 0; i < 12; i++){
            if(i < codes.size()){
                //items.add(new SavedItem(FirebaseDatabase.getInstance().getReference("Codes").child(""+codes.get(i)).child("Title")));
            }
            else{
                items.add(new SavedItem("null"));
            }
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