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
public class MyrecycAdaptor  extends RecyclerView.Adapter<MyrecycAdaptor.Myholder> {

    MyOnClikListener listener;
    private ArrayList<Food> foods;
    public ArrayList<Food> urunekle;

    public ArrayList<Food> getUrunekle() {
        return urunekle;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }


    public MyrecycAdaptor(ArrayList<Food> foods) {
        this.foods=foods;
        this.urunekle=urunekle;

    }

    @NonNull
    @Override

    // ınflater ile şişirik holder ile tuttuk
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item,parent,false) ;
        return new Myholder(view);

    }



    //sayfnın içeriğini göndericez set ettik
    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        // Her besin öğesini doğru konumda görüntülemek için verileri yerleştirin
        Food food = foods.get(position);
        holder.txtFoodname.setText(foods.get(position).getAd());
       /* holder.txtFoodname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!=null )
                    listener.MyOnClick(foods.get(position),position,urunekle);
            }
        });*/
        holder.txtFoodmiktar.setText(foods.get(position).getMiktar());
        holder.txtFoodkcal.setText(""+foods.get(position).getKalori());
        holder.btnarttır.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                urunekle.add(foods.get(position));




            }
        });

    }



    //görüntü için
    @Override
    public int getItemCount() {

        return foods.size();
    }



    public class Myholder extends RecyclerView.ViewHolder {


        TextView txtFoodname,txtFoodmiktar,txtFoodkcal;
        ImageView imgFood;
        Button btnarttır,btnazalt;


             public Myholder(@NonNull View itemView) {
                  super(itemView);

                 txtFoodname=itemView.findViewById(R.id.txtFoodname);
                 txtFoodmiktar= itemView.findViewById(R.id.txtFoodmiktar);
                 txtFoodkcal= itemView.findViewById(R.id.txtFoodkcal);
                 imgFood=itemView.findViewById(R.id.imgFood);
                 btnarttır=itemView.findViewById(R.id.btnarttır);
                 btnazalt=itemView.findViewById(R.id.btnazalt);




             }
         }
         public interface MyOnClikListener{

         void MyOnClick(Food foods,int position,ArrayList<Food> urunekle);
    }


    public void setOncliCListener(MyOnClikListener listener){
        this.listener=listener;
    }

}


