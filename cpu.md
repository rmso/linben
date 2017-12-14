# CPU

## Análise 
Para a análise da CPU foi utilizado o Android Profiler e o PowerTutor. 

### Android Profiler

### Criar Causa
Criando uma causa o uso da CPU chega até 16,69% de consumo.
![](https://github.com/rmso/linben/blob/master/imagensAnalise/criarCpu.PNG)

### Manipulando a Lista
Ao manipular a lista de causa o consumo da cpu chegou até no máximo 16,6%
![](https://github.com/rmso/linben/blob/master/imagensAnalise/listaCpu.PNG)

### Ver detalhes
A navegação entre ver os detalhes das causas cadastradas fez com que a CPU chegasse a  no máximo 9,9%
![](https://github.com/rmso/linben/blob/master/imagensAnalise/DetalhesCpu.PNG)

- Detalhes + página principal : Estando nos detalhes de uma causa e indo de volta para a página principal o consumo de cpu variou de 4,8% a 19,28%

![](https://github.com/rmso/linben/blob/master/imagensAnalise/detalhesPrincipalCpu.PNG)

### Manipulando o menu lateral 
Na manipulação do menu lateral a cpu chegou no máximo à 16,81% de uso 
![](https://github.com/rmso/linben/blob/master/imagensAnalise/menuLateralCpu.PNG)

### Ir para ajuda 
A navegação até ajuda variou mais ao abrir a activity de ajuda e a navegação na lista. No maximo chegando a 15,69%. 

![](https://github.com/rmso/linben/blob/master/imagensAnalise/ajudaElistaCpu.PNG)

### Ir para Sobre 
A navegação até a area sobre do aplicativo ficou na faixa de 14,28% de consumo da cpu.
![](https://github.com/rmso/linben/blob/master/imagensAnalise/sobreCpu.PNG)

### Hemocentro
A navegação até a activity de hemocentro foi uma das activities com  o consumo mais alto de CPU,  chegando a 25,07% de uso.

![](https://github.com/rmso/linben/blob/master/imagensAnalise/hemocentroCPU.PNG)
- Traçar rota: Clicando em traçar rota o consumo de cpu chegou a 30,53%
![](https://github.com/rmso/linben/blob/master/imagensAnalise/tracarRotaCPU.PNG)
- Pagina web: Onde teve o pico maior do uso de cpu foi na abertura da webView, a cpu chegou a 41,22% de uso

![](https://github.com/rmso/linben/blob/master/imagensAnalise/verSiteCpu.PNG)

### PowerTutor 
No power tudo fizemos uma análise mais geral do funcionamento do aplicativo. Essa analise foi feita num celular Motorola G2.
- Navegando pela página principal, detalhes e criar
![](https://github.com/rmso/linben/blob/0d9bcf92530b1f6b6b13aa0326e8f4e3ae8f2b0f/imagensAnalise/cpuPowerTutor.png)

## Boas práticas
As boas práticas para melhoras de CPU foram a criação de recycler view (explicado no arquivo memoria.md) e a utilização do live data e room (explicados no arquivo archcomponents.md).
