package com.example.trabajopractico3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<String> resultadomutable;

    public LiveData<String> getResultadoMutable(){
        if(resultadomutable==null){
            resultadomutable= new MutableLiveData<>();
        }
        return resultadomutable;
    }

    public void calcular1 (String euros){
        double eur,res,valordolar=1.18;


        try {


            eur = Double.parseDouble(euros);
            res = eur * valordolar;

            resultadomutable.setValue(res+"");
        }catch (Exception e){

            resultadomutable.setValue("Ingresar  numeros");
        }
    }
    public void calcular2 (String dolar){
        double dol,res,valoreuro=0.84;

        try {

            dol = Double.parseDouble(dolar);
            res = dol * valoreuro;

            resultadomutable.setValue(res+"");
        }catch (Exception e){

            resultadomutable.setValue("Ingresar  numeros");
        }
    }
}
