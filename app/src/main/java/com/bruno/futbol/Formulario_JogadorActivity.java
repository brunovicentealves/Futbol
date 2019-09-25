package com.bruno.futbol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Formulario_JogadorActivity extends AppCompatActivity {

    private EditText  etNomeJogador;
    private EditText  etPosicaoJogador;
    private EditText  etNumeroCamiseta;
    private Button  btnSalvarJogador;
    private int idTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario__jogador);

        etNomeJogador = (EditText) findViewById(R.id.txtjogadornome);
        etPosicaoJogador = (EditText) findViewById(R.id.txtjogadorposicao);
        etNumeroCamiseta = (EditText) findViewById(R.id.txtnumerojogador);

        btnSalvarJogador = (Button) findViewById(R.id.btnsalvarjogador);

        idTime = getIntent().getExtras().getInt("idtime");

        btnSalvarJogador.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarJogador();
            }
        });
    }


    private void salvarJogador(){

        String nomejogador = etNomeJogador.getText().toString();
        String posicao = etPosicaoJogador.getText().toString();
        int numerocamiseta = Integer.parseInt(etNumeroCamiseta.getText().toString());


        Jogador jogador = new Jogador();

        jogador.setNomejogador(nomejogador);
        jogador.setPosicao(posicao);
        jogador.setNumerocamiseta(numerocamiseta);
        jogador.setIdtime(idTime);


        JogadorDAO.inserirJogador(this,jogador);

        this.finish();

        }








}

