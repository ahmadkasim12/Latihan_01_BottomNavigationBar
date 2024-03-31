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
import com.akbar08.latihan_bottomnavigationbar.activities.bangun_ruang.br_balok;
import com.akbar08.latihan_bottomnavigationbar.activities.bangun_ruang.br_bola;
import com.akbar08.latihan_bottomnavigationbar.activities.bangun_ruang.br_kubus;
import com.akbar08.latihan_bottomnavigationbar.activities.bangun_ruang.br_tabung;
import com.akbar08.latihan_bottomnavigationbar.fragments.fragments_model.rv_adapter;
import com.akbar08.latihan_bottomnavigationbar.fragments.fragments_model.itemSetter;

import java.util.ArrayList;
import java.util.List;


public class frg_bangun_ruang extends Fragment implements rv_adapter.ItemClickListener {

    RecyclerView row;
    rv_adapter adapter;
    List<itemSetter> row_title;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_frg_bangun_ruang, container, false);
        row = root.findViewById(R.id.frg_bangun_ruang_recycler_view);
        row.setLayoutManager(new LinearLayoutManager(getContext()));
        row.setHasFixedSize(true);
        row_title = new ArrayList<itemSetter>();
        adapter = new rv_adapter(getContext(), row_title);
        adapter.setClickListener(this);
        row.setAdapter(adapter);

        row_title.add(new itemSetter("Kubus"));
        row_title.add(new itemSetter("Balok"));
        row_title.add(new itemSetter("Tabung"));
        row_title.add(new itemSetter("Bola"));

        return root;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public void onItemClick(@NonNull View view, int position) {
        view.performHapticFeedback(HapticFeedbackConstants.CONFIRM);

        switch (position){
            case 0:
                Intent intent = new Intent(getContext(), br_kubus.class);
                startActivity(intent);
                break;
            case 1:
                Intent intent1 = new Intent(getContext(), br_balok.class);
                startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(getContext(), br_tabung.class);
                startActivity(intent2);
                break;
            case 3:
                Intent intent3 = new Intent(getContext(), br_bola.class);
                startActivity(intent3);
                break;
        }
    }
}