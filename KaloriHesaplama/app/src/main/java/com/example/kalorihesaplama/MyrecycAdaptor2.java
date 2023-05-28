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

// neyin ne olduğunu tanımlarıdk şimdi database veri kaydedip onalrı çekicez ve metodlara görev vericez
public class MyrecycAdaptor2 extends RecyclerView.Adapter<MyrecycAdaptor2.Myholder> {

    private ArrayList<Food2> foods2;

    public ArrayList<Food2> getFoods2() {
        return foods2;
    }

    public MyrecycAdaptor2(ArrayList<Food2> foods2) {

        this.foods2=foods2;
    }

    @NonNull
    @Override

    // ınflater ile şişirik holder ile tuttuk
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.food2_item,parent,false) ;
        return new Myholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder2, int position) {
        // Her besin öğesini doğru konumda görüntülemek için verileri yerleştirin
        Food2 food2 = foods2.get(position);
        holder2.txtFoodname2.setText(foods2.get(position).getAd2());
        holder2.txtFoodmiktar2.setText(foods2.get(position).getMiktar2());
        holder2.txtFoodkcal2.setText(foods2.get(position).getKalori2());
        //  holder.imgFood.setImageResource(foods.get(position).getFoto());
        // butonları yazmadık ne olucağını sonradan bak

    }




    //görüntü için
    @Override
    public int getItemCount() {

        return foods2.size();
    }


    public class Myholder extends RecyclerView.ViewHolder{
        TextView txtFoodname2,txtFoodmiktar2,txtFoodkcal2;
        ImageView imgFood2;
        Button btnarttır2,btnazalt2;


        public Myholder(@NonNull View itemView) {
            super(itemView);

            txtFoodname2=itemView.findViewById(R.id.txtFoodname2);
            txtFoodmiktar2= itemView.findViewById(R.id.txtFoodmiktar2);
            txtFoodkcal2= itemView.findViewById(R.id.txtFoodkcal2);
            imgFood2=itemView.findViewById(R.id.imgFood2);
            btnarttır2=itemView.findViewById(R.id.btnarttır2);
            btnazalt2=itemView.findViewById(R.id.btnazalt2);


        }
    }

}


