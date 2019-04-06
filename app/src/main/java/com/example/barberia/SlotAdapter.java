package com.example.barberia;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

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

    @Override
    public void onBindViewHolder(@NonNull SlotViewHolder holder, final int i) {
        Slots slot = slotList_Adapter.get(i);
        holder.slot_id.setText(slot.getSlot_id());
        holder.start_time.setText(slot.getStart_time());
        holder.end_time.setText(slot.getEnd_time());

        // holder.slot_id.setEnabled(false);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mCtx, "Position: " + i, Toast.LENGTH_SHORT).show();

                FirebaseDatabase.getInstance().getReference("").setValue("")
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    // Hide progress bar
                                    notifyDataSetChanged();
                                }
                            }
                        });
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

        public SlotViewHolder(@NonNull View itemView) {
            super(itemView);

            slot_id = itemView.findViewById(R.id.slotId);
            start_time = itemView.findViewById(R.id.startTime);
            end_time = itemView.findViewById(R.id.endTime);
            parent = itemView.findViewById(R.id.parent_slots);

        }
    }
}
