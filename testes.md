# Conjunto de Testes

Foram realizados dos tipos de teste utilizando JUnit e UIAutomator:


## Teste com JUnit 
### CadastroCausaActivityTest 
Classe para fazer validação de campos importantes no cadastro da Causa. Existem 4 metódos de verificação.
  - #### testTipoSanguineoCorreto() :
      Teste para validação de tipo sanguíneo, se o tipo sanguíneo está dentro de [A+,A-,B+,B-,AB+,AB-,O-,O+].
      ```java
      @Test
    public void testTipoSanguineoCorreto(){
        Causa causa = new Causa("Minha prima está internada com leucemia e precisa de doação de sangue", "Josefa Maria da Silva", "A+", "leucemia");
        boolean resultado = causa.validacaoTipoSanguineo();
        assertTrue(resultado);
    }
      
      ```     
      
  - ####  testTipoSanguineoIncorreto(): 
      Teste para validação de tipo sanguíneo, caso de erro, onde o usuário não digita o tipo senaguineo corretamente.
  
    ```java
       @Test
    public void testTipoSanguineoIncorreto(){
        Causa causa= new Causa("Vou fazer uma cirurgia e preciso de doações de sangue", "Maria das Graças", "A", "Cirurgia");
        boolean resultado = causa.validacaoTipoSanguineo();
        assertFalse(resultado);
    }
        
    ```
  - ####  testValidacaoCampoDoenca()
    Teste para validação se o campo doença está preenchido
  
    ```java
      @Test
    public void testValidacaoCampoDoenca() {
        Causa causa = new Causa("Meu filho precisa de doação de sangue,pois perdeu muito sangue em um acidente. Conto com a sua colaboração!","José Carlos","O-","" );
        boolean resultado = causa.validacaoCampoDoenca();
        assertFalse(resultado);
    }
        
    ```
  - ####  testValidacaoCamposNulo()
    Teste para validação se o usuário preencheu todos os campos 
  
    ```java
     @Test
    public void testValidacaoCamposNulo(){
        Causa causa = new Causa ("","","","");
        boolean resultado = causa.validacaoTodosCamposNulo();
        assertFalse(resultado);
    }
        
    ```
  
  ## Teste com UIAutomator
  
  ### CadastroCausaTeste
      Classe que testa a criação de uma causa, preenchendo todos os campos e criando uma causa.
- Nessa parte do código ocorre a ação de abertura do aplicativo
```java
    
    public void setUp() throws Exception {
        device = UiDevice.getInstance(getInstrumentation());
        device.pressHome();
        device.wait(Until.hasObject(By.desc("Apps")), 5000);

        UiObject2 appsButton = device.findObject(By.desc("Apps"));
        appsButton.click();
        device.wait(Until.hasObject(By.text("Linben")), 5000);

        UiObject2 linbenApp = device.findObject(By.text("Linben"));
        linbenApp.click();
        device.wait(Until.hasObject(By.text("Open navigation drawer")), 3000);
        
```
- Parte do código onde, já na página principal, ocorre o click em criar causa
```java
    
    UiObject2 botaoCriar = device.findObject(By.text("criar"));
        botaoCriar.click();
        device.wait(Until.hasObject(By.text("Concluir")), 5000);

        
```

- Parte do código onde, na página de criação de causa, ocorre o preenchimento dos campos de criar causa
```java
    
   UiObject editarNome = new UiObject(new UiSelector().text("Joana Pereira da Silva").className("android.widget.EditText"));
        editarNome.setText("Nepomuceno");

        UiObject editarTipoSanguineo = new UiObject(new UiSelector().text("A+").className("android.widget.EditText"));
        editarTipoSanguineo.setText("B+");

        UiObject editarDoenca = new UiObject(new UiSelector().text("Leucemia").className("android.widget.EditText"));
        editarDoenca.setText("Acidente");

        UiObject editarDescricao = new UiObject(new UiSelector().text("Descrição da situação").className("android.widget.EditText"));
        editarDescricao.setText("Meu filho sofreu um acidente de moto e precisa de doação de sangue");

        UiObject2 criarCausa = device.findObject(By.text("Concluir"));
        criarCausa.click();
        device.wait(Until.hasObject(By.text("Open navigation drawer")),70000);

        
```
   ### VerDetalheCausaTeste
      Classe que testa a visualização de uma causa específica.
- Nessa parte do código ocorre a ação de abertura do aplicativo
```java
    
    public void setUp() throws Exception {
        device = UiDevice.getInstance(getInstrumentation());
        device.pressHome();
        device.wait(Until.hasObject(By.desc("Apps")), 5000);

        UiObject2 appsButton = device.findObject(By.desc("Apps"));
        appsButton.click();
        device.wait(Until.hasObject(By.text("Linben")), 5000);

        UiObject2 linbenApp = device.findObject(By.text("Linben"));
        linbenApp.click();
        device.wait(Until.hasObject(By.text("Open navigation drawer")), 3000);
        
```

- Nessa parte do código ocorre o click para a vizualização da causa que o nome é "Nepomuceno" e o redirecionamento para a activity de 
 detalhes de uma causa
```java
    
     UiObject selecionarItem = device.findObject(new UiSelector().className("android.widget.TextView").text("Nepomuceno"));
        selecionarItem.click();
        device.wait(Until.hasObject(By.text("Descrição")), 4000);
        
```

###  VerHemocentroTeste
      Classe que testa a ida na visualização do hemocentro.
- Nessa parte do código ocorre a ação de abertura do aplicativo
```java
    
    public void setUp() throws Exception {
        device = UiDevice.getInstance(getInstrumentation());
        device.pressHome();
        device.wait(Until.hasObject(By.desc("Apps")), 5000);

        UiObject2 appsButton = device.findObject(By.desc("Apps"));
        appsButton.click();
        device.wait(Until.hasObject(By.text("Linben")), 5000);

        UiObject2 linbenApp = device.findObject(By.text("Linben"));
        linbenApp.click();
        device.wait(Until.hasObject(By.text("Open navigation drawer")), 3000);
        
```

- Nessa parte do código ocorre a ação de abertura da activity de Hemocentro e a visualização dos dados do hemocentro
```java
    
  
        UiObject abrirMenu = device.findObject(new UiSelector().className("android.widget.ImageButton").index(0));
        abrirMenu.click();
        device.wait(Until.hasObject(By.text("Hemocentros")), 4000);

        UiObject abrirHemocentro = device.findObject(new UiSelector().className("android.support.v7.widget.LinearLayoutCompat").index(1));
        abrirHemocentro.click();
        device.wait(Until.hasObject(By.text("Allow")), 4000);

        UiObject2 aceitarPermissao = device.findObject(By.text("Allow"));
        aceitarPermissao.click();
        device.wait(Until.hasObject(By.text("Traçar Rota")), 4000);
        
```


 
 

