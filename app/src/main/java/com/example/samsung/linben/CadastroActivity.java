package com.example.samsung.linben;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.samsung.linben.database.DataBase;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import com.example.samsung.linben.entidades.Usuario;

/**
 * Created by Raquel on 12/05/2016.
 */
public class CadastroActivity extends AppCompatActivity {
    private int ano, mes, dia;
    EditText dataNascimento;

    private Button btn_voltar;
    private Button btn_salvar;
    private Button btn_ajuda;
    private Usuario usuario;
    private DataBase database;
    private SQLiteDatabase dbActions;


    private EditText nome;
    private EditText email;
    private EditText senha;
    private Spinner genero;
    private Spinner tipo_sanguineo;


    private static final int REQUEST_CAMERA = 1;
    private static final int SELECT_FILE = 2;
    private Button btn_foto;
    private String userChoosenTask;
    private ImageView imageView;
    private String IDusuario = "1";


    private File profileDir;

    private void cameraIntent(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    private void galleryIntent(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
        startActivityForResult(intent.createChooser(intent, "Selecione a imagem"), SELECT_FILE);
    }

    private void escolheFoto(){
        final CharSequence[] itens = {"Usar câmera", "Ir para galeria", "Cancelar"};
        AlertDialog.Builder builder = new AlertDialog.Builder(CadastroActivity.this);
        builder.setTitle("Adicionar foto");
        builder.setItems(itens, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean resultado = Utility.checkPermission(CadastroActivity.this);
                if(itens[item].equals("Usar câmera")){
                    userChoosenTask = "Usar câmera";
                    if(resultado){
                        cameraIntent();
                    }
                } else if(itens[item].equals("Ir para galeria")){
                    userChoosenTask = "Ir para galeria";
                    if(resultado){
                        galleryIntent();
                    }
                } else if(itens[item].equals("Cancelar")){
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            if(requestCode ==  SELECT_FILE){
                try {
                    onSelectFromGalleryResult(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if(requestCode == REQUEST_CAMERA){
                try {
                    onCaptureImageResult(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) throws IOException {
        if(data != null){
            Uri uri = data.getData();
            String src = getRealPathFromURI(uri);
            File source = new File(src);
            String filename = IDusuario + ".jpg";
            File destination = new File(profileDir.getPath() + "/" + filename);
            Log.d("AQUI", "" + source);
            Log.d("AQUI", "" + destination);
            copy(source, destination);
            btn_foto.setBackground(Drawable.createFromPath(String.valueOf(new File(profileDir.getPath() + "/1.jpg"))));

        }
    }

    private String getRealPathFromURI(Uri contentURI) {
        String result;
        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }

    private void onCaptureImageResult(Intent data) throws IOException {
        imageView = (ImageView) findViewById(R.id.imageView);
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        File destination = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis() + ".jpg");
        FileOutputStream fo;
        try{
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        //picture_path = saveToInternalStorage(thumbnail);
        //imageView.setImageBitmap(thumbnail);
    }

    private void copy(File source, File destination) throws IOException {

        FileChannel in = new FileInputStream(source).getChannel();
        FileChannel out = new FileOutputStream(destination).getChannel();

        try {
            in.transferTo(0, in.size(), out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                in.close();
            if (out != null)
                out.close();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // aqui cria o diretório onde salva as imagens de perfil
        profileDir = cw.getDir("profilePics", Context.MODE_PRIVATE);

        //verifica se a tela mandou dados para a outra
        usuario = new Usuario();


        try {
            database = new DataBase(this);
            dbActions = database.getWritableDatabase();

        }catch (SQLException ex){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao criar o banco!" + ex.getMessage());
            dlg.setNegativeButton("OK", null);
            dlg.show();

        }

        btn_voltar = (Button) findViewById(R.id.voltarseta);
        btn_salvar = (Button) findViewById(R.id.bt_salvar);
        btn_ajuda = (Button) findViewById(R.id.ajuda);

        nome = (EditText) findViewById(R.id.nome);
        email = (EditText) findViewById(R.id.email);
        senha = (EditText) findViewById(R.id.t_senha);
        genero = (Spinner) findViewById(R.id.sexo);
        tipo_sanguineo = (Spinner) findViewById(R.id.sangue);

       /* Calendar calendar = Calendar.getInstance();
        this.ano = calendar.get(Calendar.YEAR);
        this.mes = calendar.get(Calendar.MONTH);
        this.dia = calendar.get(Calendar.DAY_OF_MONTH);*/
        dataNascimento = (EditText) findViewById(R.id.dataN);
        //dataNascimento.setText(dia + "/" + (mes+1) + "/" + ano);

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.tipo_sanguineo,
                android.R.layout.simple_spinner_item);
        tipo_sanguineo = (Spinner) findViewById(R.id.sangue);
        tipo_sanguineo.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                this, R.array.sexo,
                android.R.layout.simple_spinner_item);
        genero = (Spinner) findViewById(R.id.sexo);
        genero.setAdapter(adapter1);


        /*btn_foto = (Button) findViewById(R.id.camera);
        if (new File(profileDir.getPath() + "/1.jpg") != null){
            btn_foto.setBackground(Drawable.createFromPath(String.valueOf(new File(profileDir.getPath() + "/1.jpg"))));
        }

        btn_foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                escolheFoto();
            }
        });*/

        btn_ajuda.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent i = new Intent(CadastroActivity.this, AjudaActivity.class);
                                             startActivity(i);
                                         }
                                     }
        );

        btn_voltar.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent i = new Intent(CadastroActivity.this, LoginActivity.class);
                                              startActivity(i);
                                          }
                                      }
        );



        btn_salvar.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              if (usuario != null) {
                                                  if (email.getText().length()==0 || senha.getText().length()==0 || nome.getText().length()==0) {
                                                      Toast.makeText(getApplication(), "Todos os campos são obrigatórios", Toast.LENGTH_LONG).show();
                                                  }else {
                                                      inserir();
                                                      Toast.makeText(CadastroActivity.this, "Usuário cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                                                       Intent i = new Intent(CadastroActivity.this, LoginActivity.class);
                                                      startActivity(i);
                                                  }
                                              }
                                          }
                                      }
        );
    }



    /*public void selecionarData(View view){
        showDialog(view.getId());
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(R.id.data == id){
            return new DatePickerDialog(this, listener, ano, mes, dia);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view,
                              int year, int monthOfYear, int dayOfMonth) {
            ano = year;
            mes = monthOfYear;
            dia = dayOfMonth;

            Calendar calendar = Calendar.getInstance();
            calendar.set(ano, mes, dia);
            Date data = calendar.getTime();


            DateFormat format = DateFormat.getDateInstance(DateFormat.MEDIUM);
            String dt = format.format(data);

            dataNascimento.setText(dt);
            //dataNascimento.setText(dia + "/" + (mes+1) + "/" + ano);
            usuario.setData_nascimento(data);

        }
    };
*/


    private void inserir() {
        try {


            usuario.setNome(nome.getText().toString());
            usuario.setEmail(email.getText().toString());
            usuario.setSenha(senha.getText().toString());
            usuario.setGenero(genero.getSelectedItem().toString());
            usuario.setTipo_sanguineo(tipo_sanguineo.getSelectedItem().toString());
            usuario.setNome(dataNascimento.getText().toString());

            database.insertUser(usuario);

        } catch (Exception ex) {

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao inserir os dados! " + ex.getMessage());
            dlg.setNegativeButton("OK", null);
            dlg.show();

        }
    }


}
