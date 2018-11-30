package com.mensagens.theobaldo.mensagens.Configuracao;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//Utilizando o Final, a classe não pode ser extendida (Ex: public final class...)
public final class ConfiguracaoFirebase {

    //quando se utiiza o atributo static o valor será sempre o mesmo, independente das instacias criadas dessa classe.
    private static DatabaseReference referenciaFirebase;
    private static FirebaseAuth autenticacao;

    public static DatabaseReference getFirebase(){

        if (referenciaFirebase == null){
            referenciaFirebase = FirebaseDatabase.getInstance().getReference();
        }
        return referenciaFirebase;

    }

    public static FirebaseAuth getFirebaseAutenticacao(){
        if (autenticacao == null){
            autenticacao = FirebaseAuth.getInstance();
        }
        return autenticacao;

    }


}
