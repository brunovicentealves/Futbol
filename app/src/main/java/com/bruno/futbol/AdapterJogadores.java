package com.bruno.futbol;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class AdapterJogadores extends BaseAdapter {

    private List<Jogador> listarJogador;
    private Context context;
    private LayoutInflater inflater;

    public AdapterJogadores(Context context,List<Jogador> listarJogador){
        this.context=context;
        this.listarJogador=listarJogador;
        this.inflater= LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return listarJogador.size();
    }

    @Override
    public Object getItem(int i) {
        return listarJogador.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listarJogador.get(i).getIdjogador();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Itemsuporte item;

        if (view == null) {
            view = inflater.inflate(R.layout.lista_jogadores, null);
            item = new Itemsuporte();
            item.tvNome = (TextView) view.findViewById(R.id.tvListaNome);
            item.tvPosicao = (TextView) view.findViewById(R.id.tvListaPosicao);
            item.tvnumerocamiseta = (TextView) view.findViewById(R.id.tvListaNumeroCamiseta);
            item.tvidtime = (TextView) view.findViewById(R.id.tvListaIDtime);
            item.layout = (LinearLayout) view.findViewById(R.id.layoutjogadores);
            view.setTag(item);

        } else {
            item = (Itemsuporte) view.getTag();
        }
        Jogador jogador = listarJogador.get(i);

        item.tvNome.setText(jogador.getNomejogador());
        item.tvPosicao.setText(jogador.getPosicao());
        item.tvnumerocamiseta.setText(String.valueOf(jogador.getNumerocamiseta()));
        item.tvidtime.setText(String.valueOf(jogador.getIdtime()));


        if (jogador.getNomejogador().equals("lista vazia !")) {
            item.tvnumerocamiseta.setText(" ");
            item.tvPosicao.setText(" ");
            item.tvidtime.setText(" ");
        }
        //intercala a cor do listview
        if (i % 2 == 0) {
            item.layout.setBackgroundColor(Color.WHITE);
        } else {
            item.layout.setBackgroundColor(Color.rgb(230, 230, 230));
        }

        return view;
    }
    private class Itemsuporte {
        TextView  tvId, tvNome,tvPosicao,tvnumerocamiseta,tvidtime ;
        LinearLayout layout;

    }
}

