package com.example.barberia;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;

public class MyProfile extends AppCompatActivity {

    TextView myName,myEmail,myPhone,personname;
    ImageView myPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        //FirebaseAuth.AuthStateListener mAuthListener;





        myPhoto=(ImageView) findViewById(R.id.DP);
        myName=(TextView)findViewById(R.id.about);
        myEmail=(TextView)findViewById(R.id.email);
        myPhone=(TextView)findViewById(R.id.contact);
        personname=(TextView)findViewById(R.id.personName);


        Glide.with(this).load(getIntent().getStringExtra("display_photo")).into(myPhoto);
        myName.setText("Student @IITJ");
        personname.setText(getIntent().getStringExtra("display_name"));
        myEmail.setText("E-mail : "+getIntent().getStringExtra("display_email"));
        myPhone.setText("Contact : "+getIntent().getStringExtra("display_phone"));
        //Toast.makeText(MyProfile.this, displayName + " " + displayEmail + " " + displayPhone, Toast.LENGTH_SHORT).show();
    }
}
