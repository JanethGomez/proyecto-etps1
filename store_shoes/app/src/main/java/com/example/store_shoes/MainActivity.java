package com.example.store_shoes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.store_shoes.adapter.ShoesAdapter;
import com.example.store_shoes.adapter.StoreAdapter;
import com.example.store_shoes.models.ShoesModel;
import com.example.store_shoes.models.StoreModel;
import com.example.store_shoes.repository.ShoesRepository;
import com.example.store_shoes.repository.StoreRepository;
import com.example.store_shoes.repository.TypeShoesRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerViewStore, recyclerViewShoes;
    private StoreAdapter storeAdapter;
    private ShoesAdapter shoesAdapter;

    private StoreRepository repository;
    private TypeShoesRepository repositoryTypeShoes;
    private ShoesRepository repositoryShoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repository = new StoreRepository(this);
        repositoryTypeShoes = new TypeShoesRepository(this);
        repositoryShoes = new ShoesRepository(this);

        recyclerViewStore = findViewById(R.id.recycleViewStore);
        recyclerViewShoes = findViewById(R.id.recycleShoes);

        storeAdapter = new StoreAdapter(this, repository.findStore());
        recyclerViewStore.setHasFixedSize(true);
        recyclerViewStore.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewStore.setAdapter(storeAdapter);
        storeAdapter.notifyDataSetChanged();

        shoesAdapter = new ShoesAdapter(this, repositoryShoes.findShoes());
        recyclerViewShoes.setHasFixedSize(true);
        recyclerViewShoes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewShoes.setAdapter(shoesAdapter);
        shoesAdapter.notifyDataSetChanged();
    }
}