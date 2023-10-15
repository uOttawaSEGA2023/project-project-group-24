package com.example.medihub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.medihub.models.PatientProfile;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class PatientActivity extends AppCompatActivity {
    private PatientProfile user;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDB;

    // UI elements
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        user = (PatientProfile) getIntent().getSerializableExtra("user");
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDB = FirebaseDatabase.getInstance();

        if (user == null) {
            firebaseAuth.signOut();

            Intent loginActivity = new Intent(this, LoginActivity.class);
            startActivity(loginActivity);
            finish();
        }

        logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }

    private void logout() {
        if (firebaseAuth.getCurrentUser() != null) {
            firebaseAuth.signOut();

            Intent loginIntent = new Intent(PatientActivity.this, LoginActivity.class);
            startActivity(loginIntent);

            PatientActivity.this.finish();
        }
    }
}