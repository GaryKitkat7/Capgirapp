package com.example.mmontonv.pruebafirebase;

import java.util.ArrayList;

/**
 * Created by alexplanasobany on 29/11/16.
 */

public class Llista {
    private ArrayList<String> Llistee;
    private boolean Trobat = false;

    public boolean Trobar (String text){
        for(int i = 0; i < Llistee.size(); i++){
            if(Llistee.contains(text)){
                this.Trobat = true;
            }
        }
        return Trobat;
    }

    public void Afegir (String text){
        Llistee.add(text);
    }

}
