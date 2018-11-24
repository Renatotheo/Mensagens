package com.mensagens.theobaldo.mensagens.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.mensagens.theobaldo.mensagens.R;

public class Login extends AppCompatActivity {

    private EditText telefone;
    private EditText area;
    private EditText pais;
    private EditText nome;
    private Button cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        telefone = (EditText) findViewById(R.id.edit_telefoneID);
        area     = (EditText) findViewById(R.id.edit_codigoareaID);
        pais     = (EditText) findViewById(R.id.edit_codigopaisID);
        nome     =  (EditText) findViewById(R.id.edit_nomeID);
        cadastrar= (Button) findViewById(R.id.bt_cadastrarID);

        SimpleMaskFormatter simpleMaskTelefone = new SimpleMaskFormatter("(NNNN-NNNNN");
        MaskTextWatcher maskTelefone = new MaskTextWatcher(telefone, simpleMaskTelefone);
        telefone.addTextChangedListener(maskTelefone);

        SimpleMaskFormatter simpleMaskArea = new SimpleMaskFormatter("(NN)");
        MaskTextWatcher maskArea = new MaskTextWatcher(area, simpleMaskArea);
        area.addTextChangedListener(maskArea);

        SimpleMaskFormatter simpleMaskPais = new SimpleMaskFormatter("NN");
        MaskTextWatcher maskPais = new MaskTextWatcher(pais, simpleMaskPais);
        pais.addTextChangedListener(maskPais);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });


    }
}
