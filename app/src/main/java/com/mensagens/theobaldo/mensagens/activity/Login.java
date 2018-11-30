package com.mensagens.theobaldo.mensagens.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.firebase.database.DatabaseReference;
import com.mensagens.theobaldo.mensagens.Configuracao.ConfiguracaoFirebase;
import com.mensagens.theobaldo.mensagens.R;
import com.mensagens.theobaldo.mensagens.helper.Permissao;
import com.mensagens.theobaldo.mensagens.helper.preferencias;

import java.util.HashMap;
import java.util.Random;

public class Login extends AppCompatActivity {

    private DatabaseReference referenciaFirebase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        referenciaFirebase = ConfiguracaoFirebase.getFirebase();
        referenciaFirebase.child("pontos").setValue("800");

    }

    public void abrirCadastroUsuario(View view) {

        Intent intent = new Intent(getApplicationContext(), CadastroUsuarioActivity.class);
        startActivity(intent);

    }

}
