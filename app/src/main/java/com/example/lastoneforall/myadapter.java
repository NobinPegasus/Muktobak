package com.example.lastoneforall;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {
    static ArrayList<String> dataset;
    static Context context;
    static Integer gek;
    private static View.OnClickListener clickListener;

    public myadapter(ArrayList<String>dataset, Context context)
    {
        this.dataset=dataset;
        this.context=context;

    }
    @NonNull
   @Override
    public myadapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LinearLayout v= (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_linear,parent,false);
        myviewholder s=new myviewholder(v);
        return s;
    }

    @Override
    public void onBindViewHolder(@NonNull myadapter.myviewholder holder, int position) {
        holder.textView.setText(dataset.get(position));


    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }




    public static class myviewholder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        LinearLayout linearLayout;
        TextView textView;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            linearLayout=itemView.findViewById(R.id.linear);
            textView=itemView.findViewById(R.id.t);
            itemView.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context,videoplayer.class);
            intent.putExtra("hello",dataset.get(getAdapterPosition()));

            context.startActivity(intent);

        }

    }
    void  show(String e)
    {
        AlertDialog.Builder a =new AlertDialog.Builder(context);
        a.setMessage(e);
        a.setCancelable(true);
        a.show();

    }
}
