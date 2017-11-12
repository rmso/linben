package com.example.samsung.linben;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.samsung.linben.entidades.Causa;

import java.util.List;

/**
 * Created by Samsung on 12/11/2017.
 */

public class CausaAdapter extends RecyclerView.Adapter<CausaAdapter.CausaViewHolder> {

    private List<Causa> causaList;
    private RecycleViewClickHack recycleViewClickHack;

    public CausaAdapter (List<Causa> listCausa){
         this.causaList = listCausa;
    }

    public class CausaViewHolder extends RecyclerView.ViewHolder{

        TextView tv_nome;
        TextView tv_descricao;
        CausaViewHolder(View itemView){
            super(itemView);

            tv_nome = (TextView) itemView.findViewById(R.id.nome_causa);
            tv_descricao = (TextView) itemView.findViewById(R.id.descricao_causa);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if(recycleViewClickHack != null){
                        recycleViewClickHack.onClickListener(getAdapterPosition());
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if(recycleViewClickHack != null){
                        recycleViewClickHack.onLongClickListener(getAdapterPosition());
                    }
                    return false;
                }
            });
        }
    }

    public void mudarListaAdapter(List<Causa> receitaList){
        this.causaList = receitaList;
        notifyDataSetChanged();
    }

    @Override
    public CausaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_causa_detalhe, parent, false);
        CausaViewHolder receitaViewHolder = new CausaViewHolder(view);
        return receitaViewHolder;
    }

    @Override
    public void onBindViewHolder(CausaViewHolder holder, int position) {
        holder.tv_nome.setText(causaList.get(position).getNome());
        holder.tv_descricao.setText(causaList.get(position).getDescricao());
    }

    @Override
    public int getItemCount() {
        return causaList.size();
    }

    public void setRecycleViewClick(RecycleViewClickHack recycleViewClickHack){
        this.recycleViewClickHack = recycleViewClickHack;
    }
}
