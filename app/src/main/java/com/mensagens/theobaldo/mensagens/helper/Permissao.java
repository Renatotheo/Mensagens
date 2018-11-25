package com.mensagens.theobaldo.mensagens.helper;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class Permissao {

    public static boolean validapermissoes (int requestcode, Activity activity, String[] permissoes){

        if(Build.VERSION.SDK_INT >=23){

            List<String>listapermissoes = new ArrayList<>();

            for (String permissao : permissoes){

                Boolean validapermissao = ContextCompat.checkSelfPermission(activity, permissao) == PackageManager.PERMISSION_GRANTED;

                if (!validapermissao) listapermissoes.add(permissao);
            }

               if (listapermissoes.isEmpty())
                   return true;

            String[]novaspermissoes = new String[listapermissoes.size()];
            listapermissoes.toArray(novaspermissoes);

            //Solicita permissão
            ActivityCompat.requestPermissions(activity, novaspermissoes,requestcode);


        }


        return true;


    }

}
