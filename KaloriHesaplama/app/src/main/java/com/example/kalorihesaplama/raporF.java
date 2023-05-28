package com.example.kalorihesaplama;

import android.content.Intent;
import android.os.Bundle;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link raporF#newInstance} factory method to
 * create an instance of this fragment.
 */
public class raporF extends Fragment {

    private RecyclerView myrecycRapor;
    private DatabaseReference mRef4;
    private ArrayList<DD> dds=new ArrayList<>();
    private MyrecycAdaptor4 myadaptor4;
    TextView txtTarih,txtToplamkcla;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_rapor, container, false);

        mRef4= FirebaseDatabase.getInstance().getReference();
        myadaptor4=new MyrecycAdaptor4(dds);






        return view;

    }


    }
