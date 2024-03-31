package com.akbar08.latihan_bottomnavigationbar.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.akbar08.latihan_bottomnavigationbar.R;
import com.bumptech.glide.Glide;

import java.util.Objects;

public class frg_profile extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_frg_profile, container, false);
        ImageView user_profile_picture = root.findViewById(R.id.iv_user_avatar);
        Glide.with(getActivity()).load("https://cdn.discordapp.com/attachments/719779367911292938/1196078292143444018/image.png?ex=66129ab6&is=660025b6&hm=46ed531fd3af3cf20510da85e28a39d83a4d0591c98c6c60be8cc708410173a6&").into(user_profile_picture);
        return root;
    }
}