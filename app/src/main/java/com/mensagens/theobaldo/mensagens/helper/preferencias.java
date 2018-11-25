package com.mensagens.theobaldo.mensagens.helper;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class preferencias {

    private Context contexto;
    private SharedPreferences preferencias;
    private String NOMEARQUIVO = "mensagens.preferencias";
    private int MODE = 0;
    private SharedPreferences.Editor editor;

    private String CHAVE_NOME = "nome";
    private String CHAVE_TELEFONE = "telefone";
    private String CHAVE_TOKEN = "token";

    public preferencias (Context contextoParametro){

        contexto = contextoParametro;
        preferencias = contexto.getSharedPreferences(NOMEARQUIVO, MODE);
        editor = preferencias.edit();

    }

    public void salvarusuariopreferencias (String nome, String telefone, String token){

        editor.putString(CHAVE_NOME, nome);
        editor.putString(CHAVE_TELEFONE, telefone);
        editor.putString(CHAVE_TOKEN, token);
        editor.commit();
    }

    public HashMap<String, String> getdadosusuarios(){

        HashMap< String, String> dadosUsuario = new HashMap<>();

        dadosUsuario.put(CHAVE_NOME, preferencias.getString(CHAVE_NOME, null));
        dadosUsuario.put(CHAVE_TELEFONE, preferencias.getString(CHAVE_TELEFONE, null));
        dadosUsuario.put(CHAVE_TOKEN, preferencias.getString(CHAVE_TOKEN, null));


        return dadosUsuario;

    }

}
