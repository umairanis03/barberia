package com.example.barberia;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;


public class SlotAdapter extends RecyclerView.Adapter<SlotAdapter.SlotViewHolder> {

    private Context mCtx;

    private List<Slots> slotList_Adapter;

    public SlotAdapter(Context mCtx, List<Slots> slotList_Adapter) {
        this.mCtx = mCtx;
        this.slotList_Adapter = slotList_Adapter;
    }

    @NonNull
    @Override
    public SlotViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, null);
        SlotViewHolder holder = new SlotViewHolder(view);
        return holder;
        // return null;

    }

    static String getAlphaNumericString(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    @Override
    public void onBindViewHolder(@NonNull SlotViewHolder holder, final int i) {
        final Slots slot = slotList_Adapter.get(i);
        holder.slot_id.setText(slot.getSlot_id());
        holder.start_time.setText(slot.getStart_time());
//        holder.end_time.setText(slot.getEnd_time());

        final FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;

        holder.book_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(mCtx);
                builder1.setMessage("Are you sure you want to book " + slot.getSlot_id() + " ?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                String random_string=getAlphaNumericString(7);
                                FirebaseDatabase.getInstance().getReference( ).child("users").child(currentFirebaseUser.getUid()).child("booking_id").setValue(random_string);
                                Log.d("Error",slot.getSlot_id());
                                FirebaseDatabase.getInstance().getReference( ).child("slots").child(slot.getSlot_id()).child("booking_id").setValue(random_string);
                                FirebaseDatabase.getInstance().getReference().child("bookings").child(currentFirebaseUser.getUid()).setValue(random_string);
                                dialog.cancel();




                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();






            }
        });

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mCtx, "Position: " + i, Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return slotList_Adapter.size();
    }

    class SlotViewHolder extends RecyclerView.ViewHolder {

        TextView slot_id, start_time, end_time;
        LinearLayout parent;
        Button book_lay;

        public SlotViewHolder(@NonNull View itemView) {
            super(itemView);

            slot_id = itemView.findViewById(R.id.slotId);
            start_time = itemView.findViewById(R.id.startTime);
            //end_time = itemView.findViewById(R.id.endTime);
            parent = itemView.findViewById(R.id.parent_slots);
            book_lay=itemView.findViewById(R.id.book_layot);



        }
    }
}


