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

public class AdapterTime extends BaseAdapter {

    private List<Time> listarTime;
    private Context context;
    private LayoutInflater inflater;

    public AdapterTime(Context context,List<Time> listarTime){
        this.context=context;
        this.listarTime=listarTime;
        this.inflater= LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return listarTime.size();
    }

    @Override
    public Object getItem(int i) {
        return listarTime.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listarTime.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Itemsuporte item ;

        if(view == null){
            view = inflater.inflate(R.layout.lista_time,null);
            item = new Itemsuporte();
             item.tvId = (TextView) view.findViewById(R.id.tvListaId);
             item.tvNome = (TextView) view.findViewById(R.id.tvListaNome);
             item.layout = (LinearLayout) view.findViewById(R.id.layout);
            view.setTag(item);

        }else{
            item = (Itemsuporte) view.getTag();
        }
        Time time = listarTime.get(i);
        item.tvId.setText(String.valueOf(time.getId()));
        item.tvNome.setText(time.getNome());

        if(time.getNome().equals("lista vazia !")){
            item.tvId.setText( " " );
        }
            //intercala a cor do listview
        if ( i % 2 == 0 ){
            item.layout.setBackgroundColor(Color.WHITE);
        }else {
            item.layout.setBackgroundColor( Color.rgb(230, 230, 230) );
        }

        return view;
    }

    private class Itemsuporte {
        TextView tvId, tvNome ;
        LinearLayout layout;

    }
}
