package com.eng.elfarsisy.who.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.eng.elfarsisy.who.R;
import com.eng.elfarsisy.who.model.Massage;
import com.eng.elfarsisy.who.model.User;

import java.util.List;
import java.util.zip.Inflater;


public class MassageAdapter extends RecyclerView.Adapter<MassageAdapter.MassageHolder> {
    Context mContext;
    List<Massage> mData;

    public MassageAdapter(Context mContext, List<Massage> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MassageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(mContext).inflate(R.layout.massage_item,parent,false);
        return new MassageHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull MassageHolder holder, int position) {
        Glide.with(mContext).load(mData.get(position).getUserImage()).into(holder.senderImage);
        holder.massageTxtView.setText(mData.get(position).getMassageTxt());

    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public class MassageHolder extends RecyclerView.ViewHolder {

        TextView massageTxtView;
        ImageView senderImage;

        public MassageHolder(@NonNull View itemView) {
            super(itemView);
            massageTxtView=itemView.findViewById(R.id.massage_textView);
            senderImage=itemView.findViewById(R.id.userimage);
        }
    }
}
