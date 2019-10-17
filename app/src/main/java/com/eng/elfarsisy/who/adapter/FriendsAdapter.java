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
import com.eng.elfarsisy.who.model.User;

import java.util.List;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.FriendsHolder> {
    Context mContext;
    List<User> mData;

    public FriendsAdapter() {
    }

    public FriendsAdapter(Context mContext, List<User> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public FriendsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.friend_item, parent, false);


        return new FriendsHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendsHolder holder, int position) {
        holder.friendName.setText(mData.get(position).getName());
        Glide.with(mContext).load(mData.get(position).getPersonalimage()).into(holder.friendImage);
    }


    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public class FriendsHolder extends RecyclerView.ViewHolder {
        ImageView friendImage;
        TextView friendName;

        public FriendsHolder(@NonNull View itemView) {
            super(itemView);
            friendImage = itemView.findViewById(R.id.friendImage);
            friendName = itemView.findViewById(R.id.frindename);


        }
    }
}
