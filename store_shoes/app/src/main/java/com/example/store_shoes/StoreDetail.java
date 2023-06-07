package com.example.store_shoes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.store_shoes.adapter.StoreShoesAdapter;
import com.example.store_shoes.models.StoreModel;
import com.example.store_shoes.repository.ShoesRepository;
import com.example.store_shoes.repository.StoreRepository;

import java.util.List;

public class StoreDetail extends AppCompatActivity {

    private TextView tvNameStoreDetail, tvDescriptionDetail;
    private ImageView ivImageStore;

    private StoreRepository repository;
    private ShoesRepository shoesRepository;

    private StoreShoesAdapter storeShoesAdapter;

    private RecyclerView rvStoreShoesDeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detail);

        repository = new StoreRepository(this);
        shoesRepository = new ShoesRepository(this);

        tvNameStoreDetail = findViewById(R.id.tvNameShoesDetails);
        tvDescriptionDetail = findViewById(R.id.tvDescriptionDetailShoes);
        ivImageStore = findViewById(R.id.ivImageShoesDetail);
        rvStoreShoesDeta = findViewById(R.id.rvStoreShoesDeta);

        Intent i = getIntent();

        String id = i.getStringExtra("ID");

        List<StoreModel> store = repository.findStore(id);

        tvNameStoreDetail.setText(store.get(0).getNameStore());
        tvDescriptionDetail.setText(store.get(0).getDescriptionStore());

        storeShoesAdapter = new StoreShoesAdapter(this, shoesRepository.findShoes(id));

        int imgResource = getResources().getIdentifier(
                store.get(0).getImageStore(), null, getPackageName());

        ivImageStore.setImageDrawable(getResources().getDrawable(imgResource));

        rvStoreShoesDeta.setHasFixedSize(true);
        rvStoreShoesDeta.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvStoreShoesDeta.setAdapter(storeShoesAdapter);
        storeShoesAdapter.notifyDataSetChanged();

    }
}