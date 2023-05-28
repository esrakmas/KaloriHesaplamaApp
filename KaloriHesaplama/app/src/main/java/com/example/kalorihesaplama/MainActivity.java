package com.example.kalorihesaplama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText txtNick,txtEmail,txtPassword;
    Button btnkayıt,btngiris;
    String nick,email,password;

private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNick=findViewById(R.id.txtNick);
        txtEmail=findViewById(R.id.txtEmail);
        txtPassword=findViewById(R.id.txtPassword);
        btngiris=findViewById(R.id.btngiris);
        btnkayıt=findViewById(R.id.btnkayıt);


        //firebase bağlayalım
        mAuth= FirebaseAuth.getInstance();



        btngiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             /*  nick=txtNick.getText().toString();
                email=txtEmail.getText().toString();
                password=txtPassword.getText().toString();


                if(!TextUtils.isEmpty(nick)&&!TextUtils.isEmpty(email)&&!TextUtils.isEmpty(password)){
                    mAuth.signInWithEmailAndPassword(email,password)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Intent intent=new Intent(MainActivity.this,MainActivity3.class);
                                    startActivity(intent);
                                    Toast.makeText(MainActivity.this, "giriş yapıldı", Toast.LENGTH_SHORT).show();
                                }
                            });
                }*/


                Intent intent=new Intent(MainActivity.this,MainActivity3.class);
                startActivity(intent);
            }
        });


        btnkayıt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });



    }
}