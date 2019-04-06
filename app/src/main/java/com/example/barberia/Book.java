package com.example.barberia;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Book extends AppCompatActivity {
    //RecyclerView recyclerView;
    SlotAdapter adapter;
    ArrayList<Slots> slots = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        foo();

        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        // recyclerView.hasFixedSize();

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Log.d("here", "chala");


        ////arraylist


    }

    private void foo() {


        FirebaseDatabase.getInstance().getReference("slots")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            String slot_id = snapshot.getKey();
                            String start_time = snapshot.child("start_time").getValue(String.class);
                            String end_time = snapshot.child("end_time").getValue(String.class);
                            String booking_id = snapshot.child("booking_id").getValue(String.class);
                            Log.d("hell","aaya to h");


                            Slots slot = new Slots(slot_id, start_time, end_time, booking_id);
                            Log.d("id", booking_id);
                            String null_String = "null";
                            //if(booking_id.equals(null_String))
                            slots.add(slot);

                        }


                        adapter = new SlotAdapter(Book.this, slots);
                        recyclerView.setAdapter(adapter);

                        // Log.d("Cool", slots.get(0).getBooking_id());

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }
}
