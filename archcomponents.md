Para a aplicação da Architecture Components foram implementados os três pricipais componentes: Room,ViewModel e Live Data.

Room - é uma biblioteca que melhora os problemas do banco de dados.

Na classe Causa, foi necessário usar @Entity, @PrimaryKey e outros.Essas identificação na classe model, serve para informar ao Room que essa seria a classe para a tabela do banco de dados.

Foi criada a classe CausaDAO para definir as consultas que serão realizadas no banco de dados.

A criação do banco de dados foi realizada na classe AppDataBase. Essaclasse é responsável por criar o banco e manter uma instância.


ViewModel - fornece os dados para a interface do usuário. Ela pode manter o estado dos dados mesmo mudando a orientação do dispositivo.

Foi criada a classe CausaViewModel que contém os dados necessários para a activity

Live Data -uma classe de suporte de dados que pode ser observada. Guarda sempre em cache última versão de dados. Notifica os observadores quando os dados mudam

A implementação do Live Data foi realizado para a nossa lista de Causas. Na classe CausaViewModel é onde está o seu uso.
