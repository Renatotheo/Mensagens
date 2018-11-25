package com.mensagens.theobaldo.mensagens.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.mensagens.theobaldo.mensagens.R;
import com.mensagens.theobaldo.mensagens.helper.Permissao;
import com.mensagens.theobaldo.mensagens.helper.preferencias;

import java.util.HashMap;
import java.util.Random;

public class Login extends AppCompatActivity {

    private EditText telefone;
    private EditText area;
    private EditText pais;
    private EditText nome;
    private Button cadastrar;
    private String [] permissoesNecesarias = new String[]{
            Manifest.permission.SEND_SMS,
            Manifest.permission.INTERNET,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Permissao.validapermissoes(1,this, permissoesNecesarias);

        telefone = (EditText) findViewById(R.id.edit_telefoneID);
        area     = (EditText) findViewById(R.id.edit_codigoareaID);
        pais     = (EditText) findViewById(R.id.edit_codigopaisID);
        nome     =  (EditText) findViewById(R.id.edit_nomeID);
        cadastrar= (Button) findViewById(R.id.bt_cadastrarID);


        //Criação de mascaras
        SimpleMaskFormatter simpleMaskTelefone = new SimpleMaskFormatter("(NNNN-NNNNN");
        MaskTextWatcher maskTelefone = new MaskTextWatcher(telefone, simpleMaskTelefone);
        telefone.addTextChangedListener(maskTelefone);

        SimpleMaskFormatter simpleMaskArea = new SimpleMaskFormatter("(NN)");
        MaskTextWatcher maskArea = new MaskTextWatcher(area, simpleMaskArea);
        area.addTextChangedListener(maskArea);

        SimpleMaskFormatter simpleMaskPais = new SimpleMaskFormatter("+NN");
        MaskTextWatcher maskPais = new MaskTextWatcher(pais, simpleMaskPais);
        pais.addTextChangedListener(maskPais);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Recupera o que está na caixa de texto Nome
                String nomeUsuario = nome.getText().toString();

                //Recupera o que está na caixa dos numeros de telefone e concatena
                String telefoneCompleto =
                        pais.getText().toString() +
                        area.getText().toString() +
                        telefone.getText().toString();

                //Formatação do número retirando traços e parenteses (Filtro)
                String telefoneSemFormatacao = telefoneCompleto.replace("+","");
                telefoneSemFormatacao = telefoneSemFormatacao.replace("-", "");
                telefoneSemFormatacao = telefoneSemFormatacao.replace("(", "");

                //Geração de Token com classe Random
                Random randomico = new Random();
                int numeroRandomico = randomico.nextInt(9999 - 1000) + 1000;

                String Token = String.valueOf(numeroRandomico);
                String mensagemEnvio = "Código de confirmação" + Token;

                // Log.i("Token","T:" + Token);

                preferencias Preferencias = new preferencias(getApplicationContext());
                Preferencias.salvarusuariopreferencias(nomeUsuario, telefoneCompleto, Token);

                //Envio do SMS
               // telefoneSemFormatacao = "8135";
                boolean enviadoSMS = enviaSMS("+" + telefoneSemFormatacao, mensagemEnvio);


                /*
                HashMap<String, String> usuario = Preferencias.getdadosusuarios();

                Log.i("TOKEN","T:" + usuario.get("token"));
                */




                //Log.i("Telefone","T:" + telefoneSemFormatacao);
                
            }
        });


    }

    //Envio do SMS
    private boolean enviaSMS (String telefone, String mensagem){

        try{

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(telefone, null, mensagem,null,null);

            return true;

        }catch (Exception e){
            e.printStackTrace();

            return false;
        }

    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[]grandResult){


        super.onRequestPermissionsResult(requestCode, permissions, grandResult);

        for (int resultado : grandResult){

            if (resultado == PackageManager.PERMISSION_DENIED){
                alertaValidacaoPermissao();
            }

        }

    }

    private void alertaValidacaoPermissao (){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Permissões Negadas");
        builder.setMessage("Necessário utilizar as permissões");

        builder.setPositiveButton("CONFIRMAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }
}
