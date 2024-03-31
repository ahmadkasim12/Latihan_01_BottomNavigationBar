package com.akbar08.latihan_bottomnavigationbar.fragments.fragments_model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akbar08.latihan_bottomnavigationbar.R;

import java.util.List;

public class rv_adapter extends RecyclerView.Adapter<rv_adapter.layoutIdGetter> {

    Context context;
    private static ItemClickListener mClickListener;
    List<itemSetter> item;

    public rv_adapter(Context _context, List<itemSetter> item) {
        this.context = _context;
        this.item = item;
    }


    @NonNull
    @Override
    public layoutIdGetter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new layoutIdGetter(LayoutInflater.from(context).inflate(R.layout.recylcler_view_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull layoutIdGetter holder, int position) {
        holder.row_title.setText(item.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public static class layoutIdGetter extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView row_title;
        public layoutIdGetter(@NonNull View itemView) {
            super(itemView);
            row_title = itemView.findViewById(R.id.rv_tv_row_title);
            itemView.setOnClickListener(this);
        }

        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
