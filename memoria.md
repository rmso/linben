# Memória

## Avaliações

Foram realizadas avaliações da memória utilizando o as ferramentas Android Profiler e LeakCanary. O celular utilizado para as análises foi um Samsung S7.

## Android Profiler
O uso da memória variou entre 50 MB e 140 MB com maiores picos quando clicado na página web do hemocentro. Com minutos de uso da memória do aplicativo estabilizou em 100 MB.

### Página principal 
O uso da memória quando na página principal ficou em torno de 68,2 - 72,98 
![](https://github.com/rmso/linben/blob/master/imagensAnalise/pagPrincMemoria.PNG) 


### Criar Causa 
Ao criar uma causa o uso da memória aumenta e fica na faixa de 87,24 MB 
![](https://github.com/rmso/linben/blob/master/imagensAnalise/criarMemoria.PNG)


### Manipular lista
Manipulando a lista o uso da memória se manteve em 100,3 MB
![](https://github.com/rmso/linben/blob/master/imagensAnalise/listaMemoria.PNG)


### Ver detalhes
O uso de ver detalhes a memória se manteve em 86,6 MB
![](https://github.com/rmso/linben/blob/master/imagensAnalise/detalhesMemoria.PNG)

- Ver detalhes + Página Principal : Quando se está em detalhes e volta para a página principal o uso da memória fica no máx 104,5 MB e constante em 88,7 MB

![](https://github.com/rmso/linben/blob/master/imagensAnalise/detalhesPrincipalMemoria.PNG)

### Menu Lateral
Na manipulação do menu lateral do app o uso da memória ficou constante em 98,3MB 
![](https://github.com/rmso/linben/blob/master/imagensAnalise/menuLateralMemoria.PNG)

### Ir para Ajuda e Rolar a Lista
Indo para a aba de ajuda e após isso manipular a lista o usp da memória ficou constante em 97,8MB
![](https://github.com/rmso/linben/blob/master/imagensAnalise/ajudaElistaMemoria.PNG)

### Sobre 
Indo para a aba de sobre no menu a memória ficou em 112,2 MB.
![](https://github.com/rmso/linben/blob/master/imagensAnalise/sobreMemoria.PNG)

### Ir para Hemocentro
Abrindo a página de hemocentros a memória tem um pico para no minimo 143,2MB e no máximo 171,28MB  
![](https://github.com/rmso/linben/blob/master/imagensAnalise/hemocentroMemoria.PNG)

- Traçar rota: Indo para a página de traçar rota, dentro de hemocentros, o uso da memória fica entre 151,13MB e 161,47MB
  ![](https://github.com/rmso/linben/blob/master/imagensAnalise/tracarRotaMemoria.PNG)
- Pagina web: Ao abrir a webview a memória registra o maior pico, na faixa de 212,76MB
 ![](https://github.com/rmso/linben/blob/master/imagensAnalise/verSiteMemoria.PNG)
    
   


## LeakCanary

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
