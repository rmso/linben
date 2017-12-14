# Architecture Components
Para a aplicação da Architecture Components foram implementados os três pricipais componentes: Room,ViewModel e Live Data.

## Room 
É uma biblioteca que melhora os problemas do banco de dados.

Na classe Causa, foi necessário usar @Entity, @PrimaryKey e outros.Essas identificação na classe model, serve para informar ao Room que essa seria a classe para a tabela do banco de dados.

```java
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey; 

@Entity
public class Causa {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String descricao;
    private String nome;
    private String tipoSanguineo;
    private String tipoDoenca;
    
```    

Foi criada a classe CausaDAO para definir as consultas que serão realizadas no banco de dados.

```java

@Dao
public interface CausaDAO {

    @Query("select * from Causa")
    LiveData<List<Causa>> getAllCausaItems();

    @Query("select * from Causa where id = :id")
    Causa getId(String id);

    @Insert(onConflict = REPLACE)
    void addCausa(Causa causa);
}
```

A criação do banco de dados foi realizada na classe AppDataBase. Essaclasse é responsável por criar o banco e manter uma instância.

```java
@Database(entities = {Causa.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase INSTANCE;

    public static AppDataBase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "causa_db")
                            .build();
        }
        return INSTANCE;
    }

    public abstract CausaDAO itemCausaModel();
}
```

## ViewModel  
Fornece os dados para a interface do usuário. Ela pode manter o estado dos dados mesmo mudando a orientação do dispositivo.
Foi criada a classe CausaViewModel que contém os dados necessários para a activity.

```java
public class CausaViewModel extends AndroidViewModel {

    private final LiveData<List<Causa>> itemCausaList;

    private AppDataBase appDatabase;

    public CausaViewModel(@NonNull Application application) {
        super(application);

        appDatabase = AppDataBase.getDatabase(this.getApplication());

        itemCausaList = appDatabase.itemCausaModel().getAllCausaItems();
    }

    public LiveData<List<Causa>> getItemCausaList() {
        return itemCausaList;
    }

    public void addModel(final Causa causa) {
        new addAsyncTask(appDatabase).execute(causa);
    }

    private static class addAsyncTask extends AsyncTask<Causa, Void, Void> {

        private AppDataBase db;

        addAsyncTask(AppDataBase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final Causa... params) {
            db.itemCausaModel().addCausa(params[0]);
            return null;
        }

    }
}
```

## Live Data 
Uma classe de suporte de dados que pode ser observada. Guarda sempre em cache última versão de dados. Notifica os observadores quando os dados mudam

A implementação do Live Data foi realizado para a nossa lista de Causas. Na classe CausaViewModel é onde está o seu uso.

```java
public class CausaViewModel extends AndroidViewModel {

    private final LiveData<List<Causa>> itemCausaList;

    private AppDataBase appDatabase;

    public CausaViewModel(@NonNull Application application) {
        super(application);

        appDatabase = AppDataBase.getDatabase(this.getApplication());

        itemCausaList = appDatabase.itemCausaModel().getAllCausaItems();
    }

    public LiveData<List<Causa>> getItemCausaList() {
        return itemCausaList;
    }

```
