package com.example.barberia;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        LayoutInflater inflater=LayoutInflater.from(mCtx);
        View view =inflater.inflate(R.layout.list_layout,null);
        SlotViewHolder holder=new SlotViewHolder(view);
        return holder;
       // return null;

    }

    @Override
    public void onBindViewHolder(@NonNull SlotViewHolder slotViewHolder, int i) {
            Slots slot=slotList_Adapter.get(i);
            slotViewHolder.slot_id.setText(slot.getSlot_id());
            slotViewHolder.slot_id.setText(slot.getSlot_id());
            slotViewHolder.slot_id.setText(slot.getSlot_id());
    }

    @Override
    public int getItemCount() {
        return slotList_Adapter.size();
    }

    class SlotViewHolder extends RecyclerView.ViewHolder{

        TextView slot_id,start_time,end_time;
        public SlotViewHolder(@NonNull View itemView) {
            super(itemView);

            slot_id=itemView.findViewById(R.id.slotId);
            start_time=itemView.findViewById(R.id.startTime);
            end_time=itemView.findViewById(R.id.endTime);

        }
    }
}
