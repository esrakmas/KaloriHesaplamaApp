package com.example.kalorihesaplama;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyrecycAdaptor4 extends RecyclerView.Adapter<MyrecycAdaptor4.Myholder>{

    private ArrayList<DD> dds;


    public ArrayList<DD> getDds() {
        return dds;
    }




    public MyrecycAdaptor4(ArrayList<DD> dds) {
        this.dds=dds;
    }



    @NonNull
    @Override

    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rapor_item,parent,false) ;
        return new Myholder(view);

    }



    @Override
    public void onBindViewHolder(@NonNull Myholder holder4, int position) {
        // Her besin öğesini doğru konumda görüntülemek için verileri yerleştirin
        DD dd = dds.get(position);
        holder4.txtTarih.setText(dds.get(position).getTarih());
       //  holder4.txtToplamkcla.setText(dds.get(position).getToplamkcal());

        // Toplam kalori değerini txtToplamkcla TextView'ine set etme
        holder4.txtToplamkcla.setText(String.valueOf(toplamKalori));

    }



    @Override
    public int getItemCount() {return dds.size();}



    public class Myholder extends RecyclerView.ViewHolder{
        TextView txtTarih,txtToplamkcla;

        public Myholder(@NonNull View itemView) {
            super(itemView);

            txtTarih=itemView.findViewById(R.id.txtTarih);

            txtToplamkcla= itemView.findViewById(R.id.txtToplamkcal);





        }
    }

    private int toplamKalori;

    public void setToplamKalori(int toplamKalori) {
        this.toplamKalori = toplamKalori;
        notifyDataSetChanged();
    }



}


