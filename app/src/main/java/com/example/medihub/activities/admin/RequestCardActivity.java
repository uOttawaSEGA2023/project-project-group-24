package com.example.medihub.activities.admin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.medihub.R;

public class RequestCardActivity extends AppCompatActivity {

    Button show_card_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_card);


        show_card_button = findViewById(R.id.buttonAccessCards);

        show_card_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRequestCard();
            }
        });
    }

    private void showRequestCard()
    {
        ConstraintLayout request_window = findViewById(R.id.request_card_1);
        View view = LayoutInflater.from(this).inflate(R.layout.activity_card, request_window);
        Button confirmDone = findViewById(R.id.buttonConfirm);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);

        final AlertDialog alertDialog = builder.create();

        confirmDone.findViewById(R.id.buttonConfirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                Toast.makeText(RequestCardActivity.this, "confirm", Toast.LENGTH_SHORT).show();
            }
        });
        if (alertDialog.getWindow()!=null)
        {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }
}