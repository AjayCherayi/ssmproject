package com.example.project007.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project007.MainActivity;
import com.example.project007.NavBar;
import com.example.project007.R;
import com.example.project007.UserDatas;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sign extends AppCompatActivity {

    TextInputLayout name,phone,email,password;
    FirebaseDatabase rootNode;
    DatabaseReference reference  ;

    Button reg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);

        reg = findViewById(R.id.reg);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootNode = FirebaseDatabase.getInstance("https://project-007-ef30b-default-rtdb.firebaseio.com/");
                reference  = rootNode.getReference("Ready");

                String uname = name.getEditText().getText().toString();
                String uphone = phone .getEditText().getText().toString();
                String uemail = email.getEditText().getText().toString();
                String uppassword = password.getEditText().getText().toString();

                UserDatas usrdatas = new UserDatas(uname,uphone,uemail,uppassword);

                reference.child(uphone).setValue(usrdatas);

                startActivity(new Intent(Sign.this, DashBoard.class));
            }
        });
    }
}


