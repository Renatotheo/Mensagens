package com.mensagens.theobaldo.mensagens.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mensagens.theobaldo.mensagens.Configuracao.ConfiguracaoFirebase;
import com.mensagens.theobaldo.mensagens.R;

public class Principal extends AppCompatActivity {

    //Criação de um atributo
    //Utilizando a classe FirebaseDatabase com o método  .getInstance() para ter acesso ao banco de dados
    // e o método  .getReference() para ir até a raiz do banco de dados.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);




    }
}
