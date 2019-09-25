package com.bruno.futbol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Formulario_TimeActivity extends AppCompatActivity {

    private EditText etNomeTime;

    private Button btnSalvar;

    private Integer idtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario__time);

        etNomeTime = (EditText) findViewById(R.id.txtnometime);

        btnSalvar = (Button) findViewById(R.id.btnsalvartime);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

    }

    private void salvar(){

      String nometime = etNomeTime.getText().toString();

        if( nometime.isEmpty() ){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setIcon( android.R.drawable.ic_dialog_alert);
            alerta.setTitle("Atenção!");
            alerta.setMessage("Você deve informar o nome do produto.");
            alerta.setPositiveButton("OK", null);
            alerta.show();
        }else {

            Time time = new Time();

            time.setNome(nometime);

            TimeDAO.inserirTime( this, time );

            this.finish();

        }

    }
}
