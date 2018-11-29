package com.mensagens.theobaldo.mensagens.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.mensagens.theobaldo.mensagens.R;
import com.mensagens.theobaldo.mensagens.helper.preferencias;

import java.util.HashMap;

public class Validador extends AppCompatActivity {

    private EditText codigoValidacao;
    private Button validar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validador);

        codigoValidacao = (EditText) findViewById(R.id.edit_codigoID);
        validar = (Button)findViewById(R.id.bt_validarID);

        SimpleMaskFormatter simpleMaskCodigovalidacao = new SimpleMaskFormatter("NNNN");
        MaskTextWatcher mascaraCodigoValidacao = new MaskTextWatcher(codigoValidacao, simpleMaskCodigovalidacao);
        codigoValidacao.addTextChangedListener(mascaraCodigoValidacao);

        validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Recuperar dadas das preferencias do usuário
                preferencias preferencia = new preferencias (getApplicationContext());
                HashMap<String, String> usuario = preferencia.getdadosusuarios();

                String tokengerado = usuario.get("token");
                String tokendigitado = codigoValidacao.getText().toString();

                if (tokendigitado.equals(tokengerado)){

                    Toast.makeText(Validador.this, "Token Validado", Toast.LENGTH_SHORT).show();

                }else{

                    Toast.makeText(Validador.this, "Token NÃO validado", Toast.LENGTH_SHORT).show();

                }

            }
        });



    }
}
