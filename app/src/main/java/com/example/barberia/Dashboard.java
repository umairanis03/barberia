package com.example.barberia;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {
    Button button_signOut,button_book,button_myBookings,button_myProfile;

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        button_signOut = (Button) findViewById(R.id.signoutbtn);
        Log.d("idhr aaya","a gya");
        button_book=(Button) findViewById(R.id.book_btn);
        Log.d("chal aaya","a gya");

        mAuth = FirebaseAuth.getInstance();

      //  startActivity(new Intent(Dashboard.this,Book.class));



        //startActivity(new Intent(this, Book.class));

        // Toast.makeText(Dashboard.this,)
//        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
//        String s = account.getEmail().toString();
//        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {
                    startActivity(new Intent(Dashboard.this, MainActivity.class));
                }
            }
        };
        button_signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
            }
        });

        button_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this,Book.class));
            }
        });

    }
}
