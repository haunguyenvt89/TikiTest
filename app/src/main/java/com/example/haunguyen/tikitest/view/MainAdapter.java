package com.example.haunguyen.tikitest.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.haunguyen.tikitest.R;
import com.example.haunguyen.tikitest.model.ProductList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    Context context;
    public MainAdapter(ProductList items) {
        this.items = items;
    }


    private ProductList items;

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_rc_product, parent, false);
        return new MainViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        String name= items.getProductModels().get(position).getName();
        int color = items.getProductModels().get(position).getColor();
        String item [] = name.split(" ");
        int len = item.length;
        int x = item.length/2;
        String s = "";
        if (len >= 2){
            for (int i = 0; i < x; i++){
                 s += item[i] + " ";
            }
            s += "\n";
            for (int j = x; j < len; j ++){
                s += item[j] + " ";
            }
        }else {
            s = name.trim();
        }
        holder.btnName.setText(s);
        GradientDrawable gd = new GradientDrawable();
        gd.setCornerRadius(5);
        gd.setColor(context.getResources().getColor(color, null));
        gd.setStroke(1, Color.TRANSPARENT);
        holder.btnName.setBackground(gd);
    }

    @Override
    public int getItemCount() {
        return items.getProductModels().size();
    }

    static class MainViewHolder extends RecyclerView.ViewHolder {

        Button btnName;

        MainViewHolder(View button) {
            super(button);
            btnName = button.findViewById(R.id.tv_product);
        }
    }
}