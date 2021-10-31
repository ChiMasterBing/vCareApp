package com.example.vcare;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class AccountInfo extends AppCompatActivity implements View.OnClickListener {
    private ImageButton back;
    private ImageView pfp;
    private TextView title, name, email, pass;
    private String password;
    private boolean hidePass;
    private FirebaseUser user;
    private DatabaseReference ref;
    private String uid;
    private Button signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);

        init();

        back.setOnClickListener(this);
        pfp.setOnClickListener(this);
        pass.setOnClickListener(this);
        signOut.setOnClickListener(this);
    }

    private void init(){
        back = findViewById(R.id.backInfo);
        pfp = findViewById(R.id.profilePicture);
        title = findViewById(R.id.infoTitle);
        name = findViewById(R.id.showName);
        email = findViewById(R.id.showEmail);
        pass = findViewById(R.id.showPass);
        user = FirebaseAuth.getInstance().getCurrentUser();
        ref = FirebaseDatabase.getInstance().getReference("UserData");
        uid = user.getUid();
        signOut = findViewById(R.id.signOut);
        ref.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                User profile = snapshot.getValue(User.class);
                if(profile != null){
                    name.setText(Html.fromHtml("<b>" + "Name: " + "</b>" + profile.getFirst() + " " + profile.getLast()));
                    email.setText(Html.fromHtml("<b>" + "Email: " + "</b>" + profile.getEmail()));
                    password = profile.getPass();
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(AccountInfo.this, "Something went wrong.", Toast.LENGTH_LONG).show();
            }
        });
        hidePass = true;
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.backInfo:
                startActivity(new Intent(AccountInfo.this, Menu.class));
                finish();
                break;
            case R.id.profilePicture:
                System.out.println("Profile picture pressed.");
                break;
            case R.id.showPass:
                hidePass = !hidePass;
                if(hidePass){
                    pass.setText("Password: " + password);
                }
                else{
                    pass.setText("Password: (tap to show/hide)");
                }
                break;
            case R.id.signOut:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(AccountInfo.this, LoginPage.class));
                break;
            default:
                System.out.println("This button is not yet registered.");
                break;
        }
    }
}