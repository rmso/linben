package com.example.samsung.linben.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.samsung.linben.R;
import com.example.samsung.linben.models.Causa;

import java.util.List;

/**
 * Created by dell on 15/06/2016.
 */

public class CausaAdapter extends RecyclerView.Adapter<CausaAdapter.CausaViewHolder>{

    private List<Causa> causaList;
    private RecycleViewClickHack recycleViewClickHack;

    public CausaAdapter(List<Causa> causaList){
        this.causaList = causaList;
    }

    public class CausaViewHolder extends RecyclerView.ViewHolder {


        TextView tv_nome;
        TextView tv_tipo_sanguineo;
        TextView tv_tipo_doença;

        public CausaViewHolder(View itemView) {
            super(itemView);

            tv_nome = itemView.findViewById(R.id.tv_nome);
            tv_tipo_sanguineo = itemView.findViewById(R.id.tv_tipo_sanguineo);
            tv_tipo_doença = itemView.findViewById(R.id.tv_tipo_doenca);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if(recycleViewClickHack != null){
                        recycleViewClickHack.onClickListener(getAdapterPosition());
                    }
                }
            });

        }
    }

    public void mudarListaAdapter(List<Causa> causaList){
        this.causaList = causaList;
        notifyDataSetChanged();
    }

    @Override
    public CausaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_causa, parent, false);
        CausaViewHolder causaViewHolder = new CausaViewHolder(view);
        return causaViewHolder;
    }

    @Override
    public void onBindViewHolder(CausaViewHolder holder, int position) {
        holder.tv_nome.setText(causaList.get(position).getNome());
        holder.tv_tipo_sanguineo.setText(causaList.get(position).getTipoSanguineo());
        holder.tv_tipo_doença.setText(causaList.get(position).getTipoDoenca());
    }

    @Override
    public int getItemCount() {
        return causaList.size();
    }

    public void setRecycleViewClick(RecycleViewClickHack recycleViewClickHack){
        this.recycleViewClickHack = recycleViewClickHack;
    }
}
