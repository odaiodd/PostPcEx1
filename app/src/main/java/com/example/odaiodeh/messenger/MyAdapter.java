package com.example.odaiodeh.messenger;

/**
 * Created by odai.odeh on 4/22/18.
 */

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView data ;

        private ViewHolder(View itemView) {
            super(itemView);
            data = itemView.findViewById(R.id.data);
        }
    }

    private List<dataText> msgList;
    public MyAdapter(List<dataText> messageList) {
        this.msgList = messageList;
    }


    public void addData(dataText data) {
        msgList.add(data);
        notifyItemInserted(msgList.size() - 1);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_layout,null );
        ViewHolder holder = new ViewHolder(view);
        return holder;



    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        dataText data = msgList.get(position);
        holder.data.setText(data.getContent());
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }


}
