package com.example.store_shoes.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.store_shoes.R;
import com.example.store_shoes.StoreDetail;
import com.example.store_shoes.models.StoreModel;

import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreAdapterViewHolder> {

    private Context context;
    private List<StoreModel> newStoreModel;

    public StoreAdapter(Context context, List<StoreModel> newStoreModel) {
        this.context = context;
        this.newStoreModel = newStoreModel;
    }

    @Override
    public StoreAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);

        view = inflater.inflate(R.layout.store_recycler_items, parent, false);

        final StoreAdapterViewHolder viewHolder = new StoreAdapterViewHolder(view);

        return viewHolder;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(@NonNull StoreAdapter.StoreAdapterViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.tvNameStore.setText(newStoreModel.get(position).getIdStore()+"-"+newStoreModel.get(position).getNameStore());

        int imgResource = context.getResources().getIdentifier(
                newStoreModel.get(position).getImageStore(), null, context.getPackageName());

        holder.itemImage.setImageDrawable(context.getResources().getDrawable(imgResource));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, StoreDetail.class);
                i.putExtra("ID", newStoreModel.get(position).getIdStore()+"");
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newStoreModel.size();
    }

    public static class StoreAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        LinearLayout storeLinear;
        TextView tvNameStore;
        ImageView itemImage;
        public StoreAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.ivStore);
            storeLinear = itemView.findViewById(R.id.llStoreLineal);
            tvNameStore = itemView.findViewById(R.id.tvNameStore);
        }

        @Override
        public void onClick(View view) {

        }
    }

}
