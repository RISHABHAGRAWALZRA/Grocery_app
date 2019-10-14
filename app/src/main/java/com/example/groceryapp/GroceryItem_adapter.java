package com.example.groceryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.groceryapp.Models.GroceryItem;

import java.util.ArrayList;

public class GroceryItem_adapter extends RecyclerView.Adapter<GroceryItem_adapter.ViewHolder> {

    private ArrayList<GroceryItem> list=new ArrayList<>();
    private Context context;

    public GroceryItem_adapter(Context context) {
        this.context = context;
    }

    public GroceryItem_adapter(){

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtname.setText(list.get(position).getName());
        holder.txtprice.setText(String.valueOf(list.get(position).getPrice()));
        Glide.with(context)
                .asBitmap()
                .load(list.get(position).getImageUrl())
                .into(holder.imgItem);

        holder.cardItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: jump to another activity
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(ArrayList<GroceryItem> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder {

        TextView txtname,txtprice;
        ImageView imgItem;
        CardView cardItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtname=itemView.findViewById(R.id.txtItemname);
            txtprice=itemView.findViewById(R.id.itemPrice);
            imgItem=itemView.findViewById(R.id.imgItem);
            cardItem=itemView.findViewById(R.id.cardvw);
        }
    }


}
