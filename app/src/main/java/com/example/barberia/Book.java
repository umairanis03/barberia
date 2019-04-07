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
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }

    private void foo() {


        FirebaseDatabase.getInstance().getReference().child("slots")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            String slot_id = snapshot.getKey();
                            String start_time = snapshot.child("start_time").getValue(String.class)+ " - " + snapshot.child("end_time").getValue(String.class);
                            String booking_id = snapshot.child("booking_id").getValue(String.class);
                            Slots slot = new Slots(slot_id, start_time,booking_id);
                            //String null_String = "null";
                            //if (booking_id.equals(null_String))
                                slots.add(slot);

                        }


                        adapter = new SlotAdapter(Book.this, slots);
                        recyclerView.setAdapter(adapter);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }
}
