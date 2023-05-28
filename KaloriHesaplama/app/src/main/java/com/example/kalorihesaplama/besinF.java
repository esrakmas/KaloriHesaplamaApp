package com.example.kalorihesaplama;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link besinF#newInstance} factory method to
 * create an instance of this fragment.
 */
public class besinF extends Fragment {


    TabHost tabHost;
    private RecyclerView rcyclerSabah,rcyclerOgle,rcyclerAksam;
    private ArrayList<Food> foods=new ArrayList<>();
    private ArrayList<Food2> foods2=new ArrayList<>();
    private ArrayList<Food3> foods3=new ArrayList<>();




    private MyrecycAdaptor myadaptor;
    private MyrecycAdaptor2 myadaptor2;
    private MyrecycAdaptor3 myadaptor3;
    private DatabaseReference mRef,mRef2,mRef3;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_besin, container, false);



        tabHost=(TabHost) view.findViewById(R.id.tabhost);
        tabHost.setup();

// İlk sekme
        TabHost.TabSpec sabah = tabHost.newTabSpec("Tab1");
        sabah.setIndicator("SABAH"); // Sekme adı veya görsel belirteci
        sabah.setContent(R.id.sabah); // İçerik görünümü
        tabHost.addTab(sabah);

// İkinci sekme
        TabHost.TabSpec ogle = tabHost.newTabSpec("ogle");
        ogle.setIndicator("ÖĞLEN"); // Sekme adı veya görsel belirteci
        ogle.setContent(R.id.ogle); // İçerik görünümü
        tabHost.addTab(ogle);

// İkinci sekme
        TabHost.TabSpec aksam = tabHost.newTabSpec("aksam");
        aksam.setIndicator("AKŞAM"); // Sekme adı veya görsel belirteci
        aksam.setContent(R.id.aksam); // İçerik görünümü
        tabHost.addTab(aksam);



        //database bağladık
        mRef=FirebaseDatabase.getInstance().getReference();
        mRef2=FirebaseDatabase.getInstance().getReference();
        mRef3=FirebaseDatabase.getInstance().getReference();

        alBesinler();
        alBesinler2();
        alBesinler3();

        myadaptor=new MyrecycAdaptor(foods);
        myadaptor2=new MyrecycAdaptor2(foods2);
        myadaptor3=new MyrecycAdaptor3(foods3);

        myadaptor.setOncliCListener(new MyrecycAdaptor.MyOnClikListener() {
            @Override
            public void MyOnClick(Food foods, int position, ArrayList<Food> urunekle) {
                Toast.makeText(getContext(), "ürün seç"+urunekle.size(), Toast.LENGTH_SHORT).show();
            }
        });

        rcyclerSabah=(RecyclerView)view.findViewById(R.id.rcyclerSabah);
        rcyclerSabah.setAdapter(myadaptor);
        rcyclerSabah.setLayoutManager(new LinearLayoutManager(getActivity()));


        rcyclerOgle=(RecyclerView)view.findViewById(R.id.rcyclerOgle);
        rcyclerOgle.setAdapter(myadaptor2);
        rcyclerOgle.setLayoutManager(new LinearLayoutManager(getActivity()));


        rcyclerAksam=(RecyclerView)view.findViewById(R.id.rcyclerAksam);
        rcyclerAksam.setAdapter(myadaptor3);
        rcyclerAksam.setLayoutManager(new LinearLayoutManager(getActivity()));





        besinEkle("Muz", "96 kcal", "1 adet");
        besinEkle("Yulaf ezmesi", "389 kcal", "1 porsiyon");
        besinEkle("Yoğurt", "59 kcal", "1 kase");
        besinEkle("Yumurta", "78 kcal", "1 adet");
        besinEkle("Ekmek", "82 kcal", "1 dilim");
        besinEkle("Domates", "18 kcal", "1 adet");
        besinEkle("Salata", "5 kcal", "1 porsiyon");
        besinEkle("Süt", "60 kcal", "1 bardak");
        besinEkle("Peynir", "101 kcal", "1 dilim");
        besinEkle("Zeytin", "10 kcal", "3 adet");
        besinEkle("Bal", "64 kcal", "1 yemek kaşığı");
        besinEkle("Ceviz", "185 kcal", "30 gram");
        besinEkle("Yer fıstığı", "166 kcal", "30 gram");
        besinEkle("Yulaf lapası", "145 kcal", "1 porsiyon");
        besinEkle("Çilek", "32 kcal", "1 su bardağı");
        besinEkle("Lor peyniri", "90 kcal", "1 dilim");
        besinEkle("Tereyağı", "102 kcal", "1 yemek kaşığı");
        besinEkle("Reçel", "48 kcal", "1 tatlı kaşığı");
        besinEkle("Simit", "260 kcal", "1 adet");
        besinEkle("Marmelat", "50 kcal", "1 tatlı kaşığı");
        besinEkle("Kepekli ekmek", "65 kcal", "1 dilim");
        besinEkle("Hardal", "5 kcal", "1 yemek kaşığı");
        besinEkle("Yulaf gevreği", "154 kcal", "1 su bardağı");
        besinEkle("Tost peyniri", "98 kcal", "1 dilim");
        besinEkle("Ballı yoğurt", "155 kcal", "1 kase");
        besinEkle("Mısır gevreği", "120 kcal", "1 su bardağı");
        besinEkle("Çikolata", "210 kcal", "1 adet");
        besinEkle("Badem", "160 kcal", "30 gram");
        besinEkle("Marmelat", "50 kcal", "1 tatlı kaşığı");
        besinEkle("Yumurta beyazı", "17 kcal", "1 adet");
        besinEkle("Tahin", "89 kcal", "1 yemek kaşığı");
        besinEkle("Krem peynir", "110 kcal", "1 yemek kaşığı");
        besinEkle("Meyve suyu", "120 kcal", "1 bardak");
        besinEkle("Kahvaltılık peynir", "120 kcal", "1 dilim");
        besinEkle("Yaban mersini", "85 kcal", "1 su bardağı");
        besinEkle("Sosis", "150 kcal", "1 adet");
        besinEkle("Fındık", "176 kcal", "30 gram");
        besinEkle("Sade omlet", "140 kcal", "2 yumurta");


        besinEkle2("Mercimek Çorbası", "150 kcal", "1 kase");
        besinEkle2("Izgara Somon", "250 kcal", "150 gram");
        besinEkle2("Bulgur Pilavı", "180 kcal", "1 porsiyon");
        besinEkle2("Taze Yeşillikler", "30 kcal", "1 porsiyon");
        besinEkle2("Tavuk Salatası", "200 kcal", "1 porsiyon");
        besinEkle2("Sebzeli Makarna", "300 kcal", "1 porsiyon");
        besinEkle2("Köfte", "200 kcal", "100 gram");
        besinEkle2("Kuskus Salatası", "150 kcal", "1 porsiyon");
        besinEkle2("Ton Balığı Sandviç", "350 kcal", "1 adet");
        besinEkle2("Nohutlu Piyaz", "180 kcal", "1 porsiyon");
        besinEkle2("Sebzeli Omlet", "200 kcal", "2 yumurta");
        besinEkle2("Patates Kızartması", "250 kcal", "1 porsiyon");
        besinEkle2("Mantarlı Tavuk Sote", "180 kcal", "1 porsiyon");
        besinEkle2("Ispanaklı Börek", "220 kcal", "1 dilim");
        besinEkle2("Taze Peynirli Sandviç", "280 kcal", "1 adet");
        besinEkle2("Köri Soslu Tavuk", "300 kcal", "1 porsiyon");
        besinEkle2("Sebzeli Noodle", "220 kcal", "1 porsiyon");
        besinEkle2("Zeytinyağlı Dolma", "180 kcal", "4 adet");
        besinEkle2("Balık Tava", "250 kcal", "1 porsiyon");
        besinEkle2("Meksika Salatası", "150 kcal", "1 porsiyon");
        besinEkle2("Peynirli Omlet", "220 kcal", "2 yumurta");
        besinEkle2("Tavuklu Makarna", "300 kcal", "1 porsiyon");
        besinEkle2("Fırında Patates", "180 kcal", "1 porsiyon");
        besinEkle2("Sebzeli Izgara", "200 kcal", "1 porsiyon");
        besinEkle2("Kıymalı Pide", "350 kcal", "1 dilim");
        besinEkle2("Karnıyarık", "250 kcal", "1 porsiyon");
        besinEkle2("Ton Balıklı Salata", "180 kcal", "1 porsiyon");
        besinEkle2("Mantarlı Omlet", "220 kcal", "2 yumurta");
        besinEkle2("Tavuklu Pilav", "300 kcal", "1 porsiyon");


        besinEkle3("Tavuk göğsü", "165 kcal", "100 gram");
        besinEkle3("Pilav", "180 kcal", "1 porsiyon");
        besinEkle3("Mercimek çorbası", "120 kcal", "1 kase");
        besinEkle3("Kuru fasulye", "220 kcal", "1 porsiyon");
        besinEkle3("Salata", "50 kcal", "1 porsiyon");
        besinEkle3("Bulgur pilavı", "150 kcal", "1 porsiyon");
        besinEkle3("Izgara köfte", "250 kcal", "1 adet");
        besinEkle3("Sebzeli makarna", "280 kcal", "1 porsiyon");
        besinEkle3("Türlü", "180 kcal", "1 porsiyon");
        besinEkle3("Balık", "200 kcal", "100 gram");
        besinEkle3("Patates kızartması", "312 kcal", "1 porsiyon");
        besinEkle3("Köfte", "260 kcal", "1 adet");
        besinEkle3("Mantar çorbası", "80 kcal", "1 kase");
        besinEkle3("Sebzeli pilav", "210 kcal", "1 porsiyon");
        besinEkle3("Tavuk sote", "220 kcal", "1 porsiyon");
        besinEkle3("Nohut yemeği", "180 kcal", "1 porsiyon");
        besinEkle3("Peynirli omlet", "200 kcal", "1 adet");
        besinEkle3("Kuru patlıcan dolması", "150 kcal", "1 adet");
        besinEkle3("Etli sebze yemeği", "250 kcal", "1 porsiyon");
        besinEkle3("Peynirli börek", "280 kcal", "1 adet");
        besinEkle3("Pilav üstü tavuk", "350 kcal", "1 porsiyon");
        besinEkle3("Et döner", "400 kcal", "1 porsiyon");
        besinEkle3("Karnıyarık", "280 kcal", "1 porsiyon");
        besinEkle3("Mevsim salatası", "60 kcal", "1 porsiyon");
        besinEkle3("Köfte dürüm", "420 kcal", "1 adet");





        return view;

    }








    public void besinEkle(String ad, String kalori, String miktar) {

        Food besin = new Food();
        besin.setAd(ad);
        besin.setKalori(kalori);
        besin.setMiktar(miktar);

        mRef = FirebaseDatabase.getInstance().getReference("besinler");
        mRef.orderByChild("ad").equalTo(ad).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Besin zaten kayıtlı, güncelleme yap
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        String besinKey = snapshot.getKey();
                        mRef.child(besinKey).setValue(besin);
                    }
                } else {
                    // Besin kayıtlı değil, yeni bir kayıt ekle
                    String key = mRef.push().getKey(); // Yeni bir benzersiz anahtar oluştur
                    mRef.child(key).setValue(besin);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Veritabanına erişim sırasında hata oluştuğunda yapılacak işlemler
            }
        });
    }

    public void besinEkle2(String ad2, String kalori2, String miktar2) {
        // int kaloriSayisi = Integer.parseInt(kalori.split(" ")[0]); // İlk öğe olarak sayıyı alır
        // Kalori sayısını kullanarak işlemler yapabilirsiniz
        // ...
        Food2 besin2 = new Food2();
        besin2.setAd2(ad2);
        besin2.setKalori2(kalori2);
        besin2.setMiktar2(miktar2);

        mRef2 = FirebaseDatabase.getInstance().getReference("besinler2");
        mRef2.orderByChild("ad2").equalTo(ad2).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Besin zaten kayıtlı, güncelleme yap
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        String besinKey = snapshot.getKey();
                        mRef2.child(besinKey).setValue(besin2);
                    }
                } else {
                    // Besin kayıtlı değil, yeni bir kayıt ekle
                    String key = mRef2.push().getKey(); // Yeni bir benzersiz anahtar oluştur
                    mRef2.child(key).setValue(besin2);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Veritabanına erişim sırasında hata oluştuğunda yapılacak işlemler
            }
        });
    }

    public void besinEkle3(String ad3, String kalori3, String miktar3) {
        // int kaloriSayisi = Integer.parseInt(kalori.split(" ")[0]); // İlk öğe olarak sayıyı alır
        // Kalori sayısını kullanarak işlemler yapabilirsiniz
        // ...
        Food3 besin3 = new Food3();
        besin3.setAd3(ad3);
        besin3.setKalori3(kalori3);
        besin3.setMiktar3(miktar3);

        mRef3 = FirebaseDatabase.getInstance().getReference("besinler3");
        mRef3.orderByChild("ad3").equalTo(ad3).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Besin zaten kayıtlı, güncelleme yap
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        String besinKey = snapshot.getKey();
                        mRef3.child(besinKey).setValue(besin3);
                    }
                } else {
                    // Besin kayıtlı değil, yeni bir kayıt ekle
                    String key = mRef3.push().getKey(); // Yeni bir benzersiz anahtar oluştur
                    mRef3.child(key).setValue(besin3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Veritabanına erişim sırasında hata oluştuğunda yapılacak işlemler
            }
        });
    }





    private void alBesinler() {
        // Firebase veritabanından "besinler" düğümündeki verileri alın
        mRef.child("besinler").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // foods listesini temizle
                foods.clear();


                // Veritabanından alınan her besin için döngü
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // Besin verisini Food nesnesine dönüştür
                    Food food = snapshot.getValue(Food.class);
                    // Food nesnesini foods listesine ekle
                    foods.add(food);

                }
                // foods listesindeki veriler güncellendiğinde adaptera haber ver
                myadaptor.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Veritabanına erişim sırasında hata oluştuğunda yapılacak işlemler

            }
        });


    }

    private void alBesinler2() {
        // Firebase veritabanından "besinler" düğümündeki verileri alın
        mRef2.child("besinler2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // foods listesini temizle
                foods2.clear();


                // Veritabanından alınan her besin için döngü
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // Besin verisini Food nesnesine dönüştür
                    Food2 food2 = snapshot.getValue(Food2.class);
                    // Food nesnesini foods listesine ekle
                    foods2.add(food2);

                }
                // foods listesindeki veriler güncellendiğinde adaptera haber ver
                myadaptor2.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Veritabanına erişim sırasında hata oluştuğunda yapılacak işlemler

            }
        });

    }

    private void alBesinler3() {
        // Firebase veritabanından "besinler3" düğümündeki verileri alın
        mRef3.child("besinler3").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // foods3 listesini temizle
                foods3.clear();


                // Veritabanından alınan her besin için döngü
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // Besin verisini Food3 nesnesine dönüştür
                    Food3 food3 = snapshot.getValue(Food3.class);
                    // Food3 nesnesini foods3 listesine ekle
                    foods3.add(food3);

                }
                // foods3 listesindeki veriler güncellendiğinde adaptera haber ver
                myadaptor3.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Veritabanına erişim sırasında hata oluştuğunda yapılacak işlemler

            }
        });
    }




}