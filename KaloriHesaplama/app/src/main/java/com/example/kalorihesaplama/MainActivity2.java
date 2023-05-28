package com.example.kalorihesaplama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {

    EditText txtName2,txtSurname2,txtNick2,txtEmail2,txtPassword2;
    Button btnkayıt2;

    String nick2,email2,password2;
    private FirebaseAuth mAuth2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtName2=findViewById(R.id.txtName2);
        txtSurname2=findViewById(R.id.txtSurname2);
        txtNick2=findViewById(R.id.txtNick2);
        txtEmail2=findViewById(R.id.txtEmail2);
        txtPassword2=findViewById(R.id.txtPassword2);
        btnkayıt2=findViewById(R.id.btnkayıt2);

        mAuth2= FirebaseAuth.getInstance();

        btnkayıt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nick2=txtNick2.getText().toString();
                email2=txtEmail2.getText().toString();
                password2=txtPassword2.getText().toString();

                if(!TextUtils.isEmpty(nick2)&&!TextUtils.isEmpty(email2)&&!TextUtils.isEmpty(password2)){
                    mAuth2.createUserWithEmailAndPassword(email2,password2)
                            .addOnCompleteListener(MainActivity2.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Toast.makeText(MainActivity2.this, "kayıt yapıldı", Toast.LENGTH_SHORT).show();
                                }
                            });
                }

            }
        });


    }
}