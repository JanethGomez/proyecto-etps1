package com.example.store_shoes.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.store_shoes.R;
import com.example.store_shoes.models.ShoesModel;

import java.util.List;

public class StoreShoesAdapter extends RecyclerView.Adapter<StoreShoesAdapter.ShoesAdapterViewHolder> {

    private Context context;
    private List<ShoesModel> newShoesModel;

    public StoreShoesAdapter(Context context, List<ShoesModel> newShoesModel) {
        this.context = context;
        this.newShoesModel = newShoesModel;
    }

    @Override
    public ShoesAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);

        view = inflater.inflate(R.layout.shoes_recycler_item, parent, false);

        return new ShoesAdapterViewHolder(view);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(@NonNull StoreShoesAdapter.ShoesAdapterViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.tvShoesTitle.setText(newShoesModel.get(position).getTitleShoes());
        holder.tvShoesDescription.setText(newShoesModel.get(position).getDescription());

        int imgResource = context.getResources().getIdentifier(
                newShoesModel.get(position).getImage(), null, context.getPackageName());

        holder.itemImageShoes.setImageDrawable(context.getResources().getDrawable(imgResource));

        holder.tvShoesPrice.setText(String.valueOf(newShoesModel.get(position).getPrice()));

       /* holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ShoesModel.class);
                i.putExtra("name", newShoesModel.get(position).getTitleShoes());
                context.startActivity(i);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return newShoesModel.size();
    }

    public static class ShoesAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvShoesTitle, tvShoesDescription, tvShoesPrice;
        ImageView itemImageShoes;

        LinearLayout linealShoes;
        public ShoesAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            linealShoes = itemView.findViewById(R.id.linealShoes);

            tvShoesTitle = itemView.findViewById(R.id.tvNameShoes);
            tvShoesDescription = itemView.findViewById(R.id.tvDescribeShoes);
            tvShoesPrice = itemView.findViewById(R.id.tvPrice);
            itemImageShoes = itemView.findViewById(R.id.imageItemShoes);
        }

        @Override
        public void onClick(View view) {

        }
    }

}
