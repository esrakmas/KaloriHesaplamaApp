package com.example.kalorihesaplama;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyrecycAdaptor3 extends RecyclerView.Adapter<MyrecycAdaptor3.Myholder> {

    private ArrayList<Food3> foods3;

    public ArrayList<Food3> getFoods3() {
        return foods3;
    }

    public MyrecycAdaptor3(ArrayList<Food3> foods3) {
        this.foods3 = foods3;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food3_item, parent, false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder3, int position) {
        Food3 food3 = foods3.get(position);
        holder3.txtFoodname3.setText(foods3.get(position).getAd3());
        holder3.txtFoodmiktar3.setText(foods3.get(position).getMiktar3());
        holder3.txtFoodkcal3.setText(foods3.get(position).getKalori3());
    }

    @Override
    public int getItemCount() {
        return foods3.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
        TextView txtFoodname3, txtFoodmiktar3, txtFoodkcal3;
        ImageView imgFood3;
        Button btnarttır3, btnazalt3;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            txtFoodname3 = itemView.findViewById(R.id.txtFoodname3);
            txtFoodmiktar3 = itemView.findViewById(R.id.txtFoodmiktar3);
            txtFoodkcal3 = itemView.findViewById(R.id.txtFoodkcal3);
            imgFood3 = itemView.findViewById(R.id.imgFood3);
            btnarttır3 = itemView.findViewById(R.id.btnarttır3);
            btnazalt3 = itemView.findViewById(R.id.btnazalt3);
        }
    }
}
