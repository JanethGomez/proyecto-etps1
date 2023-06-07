package com.example.store_shoes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.store_shoes.adapter.ShoesAdapter;
import com.example.store_shoes.adapter.StoreShoesAdapter;
import com.example.store_shoes.models.ShoesModel;
import com.example.store_shoes.repository.ShoesRepository;

import java.util.List;

public class ShoesDetail extends AppCompatActivity {

    private ShoesRepository shoesRepository;

    private ShoesAdapter shoesAdapter;

    private TextView tvNameShoesDetails, tvDescriptionDetailShoes;
    private ImageView ivImageShoesDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoes_detail);

        Intent i = getIntent();

        String id = i.getStringExtra("ID");

        List<ShoesModel> shoes = shoesRepository.findShoes(id, true);

        ivImageShoesDetail = findViewById(R.id.ivImageShoesDetail);
        tvNameShoesDetails = findViewById(R.id.tvNameShoesDetails);
        tvDescriptionDetailShoes = findViewById(R.id.tvDescriptionDetailShoes);

        tvNameShoesDetails.setText(shoes.get(0).getTitleShoes());
        tvDescriptionDetailShoes.setText(shoes.get(0).getDescription());

        shoesAdapter = new ShoesAdapter(this, shoes);


        int imgResource = getResources().getIdentifier(
                shoes.get(0).getImage(), null, getPackageName());

        ivImageShoesDetail.setImageDrawable(getResources().getDrawable(imgResource));

    }
}