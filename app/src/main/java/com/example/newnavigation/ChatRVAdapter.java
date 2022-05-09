package com.example.newnavigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatRVAdapter extends RecyclerView.Adapter{
    private ArrayList<ChatsModal> chatsModalArrayList;
    private Context context;
    public ChatRVAdapter(ArrayList<ChatsModal> chatsModalArrayList, Context context){
        this.chatsModalArrayList = chatsModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {
            case 0:

                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_msg_rv_item, parent, false);
                return new UserViewHolder(view);
            case 1:

                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_msg_rv_item, parent, false);
                return new BotViewHolder(view);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChatsModal modal = chatsModalArrayList.get(position);
        switch (modal.getSender()) {
            case "user":
                //below line is to set the text to our text view of user layout
                ((UserViewHolder) holder).userTv.setText(modal.getMessage());
                break;
            case "bot":
                //below line is to set the text to our text view of bot layout
                ((BotViewHolder) holder).botmsgTv.setText(modal.getMessage());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return chatsModalArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        //below line of code is to set position.
        switch (chatsModalArrayList.get(position).getSender()) {
            case "user":
                return 0;
            case "bot":
                return 1;
            default:
                return -1;
        }

    }
    public static  class UserViewHolder extends  RecyclerView.ViewHolder{
        TextView userTv;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userTv = itemView.findViewById(R.id.idTVUser);

        }
    }
    public static  class BotViewHolder extends RecyclerView.ViewHolder{
        TextView botmsgTv;
        public BotViewHolder(@NonNull View itemView) {
            super(itemView);
            botmsgTv = itemView.findViewById(R.id.idTVBot);
        }
    }
}
