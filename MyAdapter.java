package com.example.healthplus;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<BookingDataClass> bookingDataList;

    public MyAdapter(Context context, List<BookingDataClass> bookingDataList) {
        this.context = context;
        this.bookingDataList = bookingDataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booked_doc_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(bookingDataList.get(position).getDataImage()).into(holder.recImage);
        holder.recDocName.setText(bookingDataList.get(position).getDataDocName());
        holder.recDate.setText(bookingDataList.get(position).getDataDate());
        holder.recTime.setText(bookingDataList.get(position).getDataTime());

        holder.recDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BookingDetail.class);
                intent.putExtra("Image", bookingDataList.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("Date", bookingDataList.get(holder.getAdapterPosition()).getDataDate());
                intent.putExtra("Doctor Name", bookingDataList.get(holder.getAdapterPosition()).getDataDocName());
                intent.putExtra("Time", bookingDataList.get(holder.getAdapterPosition()).getDataTime());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return bookingDataList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView recImage;
    TextView recDocName, recDate, recTime;
    CardView recDoc;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        recImage = itemView.findViewById(R.id.recImage);
        recDoc = itemView.findViewById(R.id.recDoc);
        recDate = itemView.findViewById(R.id.recDate);
        recTime = itemView.findViewById(R.id.recTime);
        recDocName = itemView.findViewById(R.id.recDocName);
    }
}
