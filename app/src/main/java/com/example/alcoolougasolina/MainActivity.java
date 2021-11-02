package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view) {

        //recuperar valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //Validar campos Digitados
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if (camposValidados) {

            //convertendo Strings para números

            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorgasolina = Double.parseDouble(precoGasolina);
            Double resultado = valorAlcool / valorgasolina;
            if (resultado >= 0.7) {
                textResultado.setText("É melhor utilizar Gasolina");
            } else {
                textResultado.setText("É melhor utilizar álcool");
            }
        } else {
            textResultado.setText("Preencha is preços primeiro");
        }
    }



    public Boolean validarCampos( String pAlcool,String pGasolina){


        Boolean camposValidados= true;
        String campo = "Preenchido";

        if(pAlcool == null || pAlcool.equals("")){

            camposValidados= false;


        }
        else if(pGasolina == null || pGasolina.equals("")){

            camposValidados= false;

        }
        return camposValidados;
    }


}
