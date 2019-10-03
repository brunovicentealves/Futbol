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
        }


        return null;
    }

    private class Itemsuporte {
    }
}
