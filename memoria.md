# Memória

## Avaliações

Foram realizadas avaliações da memória utilizando o as ferramentas Android Profiler e LeakCanary.

### Android Profiler
O uso da memória variou entre 50 MB e 140 MB com maiores picos quando clicado na página web do hemocentro. Com minutos de uso da memória do aplicativo estabilizou em 100 MB.
#### [Página principal](https://github.com/rmso/linben/blob/master/imagensAnalise/hemocentroMemoria.PNG) 
O uso da memória quando na página principal ficou em torno de 50 - 51MB

#### [Criar Causa](https://github.com/rmso/linben/blob/master/imagensAnalise/criarMemoria.PNG)
Ao criar uma causa o uso da memória aumenta e fica entre 60 - 70 MB 
#### [Ver detalhes](https://github.com/rmso/linben/blob/master/imagensAnalise/verDetalhesMem.PNG)
O uso de ver detalhes de uma causa ocasiona um aumento de memória de 7MB, ficando em torno de 57MB 
#### [Ir para Hemocentro](https://github.com/rmso/linben/blob/master/imagensAnalise/hemocentroMemoria.PNG)
Abrindo a página de hemocentros a memória tem um pico para 81MB

- Traçar rota:
- [Pagina web:](https://github.com/rmso/linben/blob/master/imagensAnalise/paginaWebmemoria.PNG)
    Ao abrir a webview a memória registra o maior pico, na faixa de 140 MB
   


### LeakCanary

O leak canary acusou um leak de memória em [hemocentro](https://github.com/rmso/linben/blob/master/imagensAnalise/leakCanary.PNG) quando a web view é aberta e na [WebView](https://github.com/rmso/linben/blob/master/imagensAnalise/leakWebView.PNG). 


## Boas práticas 
- RecyclerView
No projeto inicial era usado um listview para a listagem das causas, nesse era mostrado todos os detalhes das causas que estavam guardado no banco. Para a melhoria deste caso utilizamos o RecyclerView em listar causas.
O Recycler View é uma versão mais avançada e flexível do ListView.  Quando o usuário scrolla a lista o recyclerview identifica as views que não estão mais visíveis para o usuário e as reutiliza colocando novos valores, de acordo com o conteúdo daquela posição da lista.

 ```java
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

 
  ```
  No MenuActivity, onde tem a chamada do recyclerView:
 
 ```java 
       causaAdapter = new CausaAdapter(causaList);
        rv_causa.setAdapter(causaAdapter);
        causaAdapter.setRecycleViewClick(this);
   ``` 
