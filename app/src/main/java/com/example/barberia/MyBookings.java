package com.example.barberia;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyBookings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bookings);
        final TextView start_time_bookings,end_time_bookings,slot_id_bookings,sllot_id;


        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser() ;

        start_time_bookings=(TextView) findViewById(R.id.STARTTIME);
        end_time_bookings=(TextView) findViewById(R.id.ENDTIME);
        slot_id_bookings=(TextView) findViewById(R.id.BOOKING_ID);
        sllot_id=(TextView)findViewById(R.id.SLOTID);
        FirebaseDatabase.getInstance().getReference("users").child(user.getUid()).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                String booking_id_bookings=dataSnapshot.getValue().toString();
                Log.d("c",booking_id_bookings);
                slot_id_bookings.setText(booking_id_bookings);



              //  String slot_id_bookings=FirebaseDatabase.getInstance().getReference("").

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                String booking_id_bookings=dataSnapshot.getValue().toString();
                Log.d("c",booking_id_bookings);
                slot_id_bookings.setText(booking_id_bookings);

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Log.d("here",FirebaseDatabase.getInstance().getReference("slots").getKey());
        FirebaseDatabase.getInstance().getReference("slots").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    Log.d("loop","fine");
//                    Log.d("under",snapshot.child("booking_id").getValue(String.class));
//                    if(slot_id_bookings.equals(snapshot.child("booking_id").getValue(String.class)))
//                    {
//
//                        String start_TIME,end_TIME,slot_ID;
//                        start_time_bookings.setText(snapshot.child("start_time").getValue(String.class));
//                        end_time_bookings.setText(snapshot.child("end_time").getValue(String.class));
//                        sllot_id.setText(snapshot.getKey());
//                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
}
