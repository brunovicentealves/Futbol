package com.bruno.futbol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormularioEditarActivity extends AppCompatActivity {


    private EditText etNomeJogador;
    private EditText  etPosicaoJogador;
    private EditText  etNumeroCamiseta;
    private Button btnalterarjogador;
    private int idjogador,idtime;
    private String acao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_editar);

        etNomeJogador = (EditText) findViewById(R.id.txtnomejogadoralterar);
        etPosicaoJogador = (EditText) findViewById(R.id.txtposicaoalterar);
        etNumeroCamiseta = (EditText) findViewById(R.id.txtnumerojogadoralterar);
        btnalterarjogador = (Button) findViewById(R.id.btnalterarsalvar);


         acao = getIntent().getExtras().getString("acao");

         if(acao.equals("editar")){

             idjogador = getIntent().getExtras().getInt("idjogador");
             idtime = getIntent().getExtras().getInt("idtime");

             carregarFormularioEditar(idjogador);

             btnalterarjogador.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {

                     salvarAlterar();
                     finish();
                 }
             });
         }
    }

    private void salvarAlterar(){
        String nome = etNomeJogador.getText().toString();
        String posicao = etPosicaoJogador.getText().toString();
        String numerojogador = etNumeroCamiseta.getText().toString();

        if(nome.isEmpty() || posicao.isEmpty() || numerojogador == null){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setIcon(android.R.drawable.ic_dialog_alert);
            alerta.setTitle("Atenção!");
            alerta.setMessage("Campo em branco .");
            alerta.setPositiveButton("Ok",null);
            alerta.show();
        }else{

            Jogador jogador = new Jogador();
            jogador.setIdjogador(idjogador);
            jogador.setNomejogador(nome);
            jogador.setPosicao(posicao);
            jogador.setIdtime(idtime);
            jogador.setNumerocamiseta(Integer.valueOf(numerojogador));
            JogadorDAO.editarJogador(this,jogador);

        }
    }

    private void carregarFormularioEditar( int idjogador){

        Jogador jogadores = JogadorDAO.jogadorById(this,idjogador);

        etNomeJogador.setText(jogadores.getNomejogador());
        etPosicaoJogador.setText(jogadores.getPosicao());
        etNumeroCamiseta.setText(String.valueOf(jogadores.getNumerocamiseta()));



    }


}
