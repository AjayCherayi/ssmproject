package com.example.project007.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
    ImageView backBtn;
    Button b1,b2;
    TextView title;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);

        title = findViewById(R.id.nxt);
        backBtn = findViewById(R.id.back_btn);
        b2 = findViewById(R.id.nxt);
        b2 = findViewById(R.id.log_in);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        phone.setPrefixText("+91");



        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootNode = FirebaseDatabase.getInstance("https://project-007-ef30b-default-rtdb.firebaseio.com/");
                reference  = rootNode.getReference("Ready");

                String uname = name.getEditText().getText().toString();
                String uphone = "+91"+phone.getEditText().getText().toString();
                String uemail = email.getEditText().getText().toString();
                String uppassword = password.getEditText().getText().toString();

                UserDatas usrdatas = new UserDatas(uname,uphone,uemail,uppassword);

                reference.child(uphone).setValue(usrdatas);

                startActivity(new Intent(Sign.this, DashBoard.class));
            }
        });
    }
    public void verifyPage(View view){


        Intent intent = new Intent(getApplicationContext(),Verifcation.class);
        //Add Transition
        Pair[] pairs =new Pair[4];

        pairs[0] = new Pair<View,String>(backBtn,"back_arrow");
        pairs[1] = new Pair<View,String>(b1,"transition_next");
        pairs[2] = new Pair<View,String>(b2,"transition_login");
        pairs[3] = new Pair<View,String>(title,"tran_text");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Sign.this,pairs);
            startActivity(intent,options.toBundle());
        }else{
            startActivity(intent);

        }


    }
}


