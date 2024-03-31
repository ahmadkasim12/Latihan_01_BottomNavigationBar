package com.akbar08.latihan_bottomnavigationbar.fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.akbar08.latihan_bottomnavigationbar.R;
import com.akbar08.latihan_bottomnavigationbar.bangun_datar.bd_lingkaran;
import com.akbar08.latihan_bottomnavigationbar.bangun_datar.bd_persegi;
import com.akbar08.latihan_bottomnavigationbar.bangun_datar.bd_persegi_panjang;
import com.akbar08.latihan_bottomnavigationbar.bangun_datar.bd_segitiga;
import com.akbar08.latihan_bottomnavigationbar.fragments.fragments_model.itemSetter;
import com.akbar08.latihan_bottomnavigationbar.fragments.fragments_model.rv_adapter;

import java.util.ArrayList;
import java.util.List;


public class frg_bangun_datar extends Fragment implements rv_adapter.ItemClickListener{

    RecyclerView row;
    rv_adapter adapter;
    List<itemSetter> row_title;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_frg_bangun_datar, container, false);
        row = root.findViewById(R.id.frg_bangun_datar_recycler_view);
        row.setLayoutManager(new LinearLayoutManager(getContext()));
        row.setHasFixedSize(true);
        row_title = new ArrayList<itemSetter>();

        adapter = new rv_adapter(getContext(), row_title);
        adapter.setClickListener(this);
        row.setAdapter(adapter);

        row_title.add(new itemSetter("Persegi"));
        row_title.add(new itemSetter("Persegi Panjang"));
        row_title.add(new itemSetter("Segitiga"));
        row_title.add(new itemSetter("Lingkaran"));

        return root;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public void onItemClick(@NonNull View view, int position) {
        view.performHapticFeedback(HapticFeedbackConstants.CONFIRM);

        switch (position){
            case 0:
                Intent intent = new Intent(getContext(), bd_persegi.class);
                startActivity(intent);
                break;
            case 1:
                Intent intent1 = new Intent(getContext(), bd_persegi_panjang.class);
                startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(getContext(), bd_segitiga.class);
                startActivity(intent2);
                break;
            case 3:
                Intent intent3 = new Intent(getContext(), bd_lingkaran.class);
                startActivity(intent3);
                break;
        }
    }
}