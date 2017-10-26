package com.example.samsung.linben;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.samsung.linben.database.DataBase;
import com.example.samsung.linben.entidades.Causa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * Created by Raquel on 12/05/2016.
 */
public class ApeloActivity extends Activity {
    private Spinner estado;
    private Spinner cidade;
    private Spinner hemocentro;
    private EditText descricao;
    private Button btn_voltar;
    private Button btn_continuar;
    private Button btn_ajuda;

    private DataBase database;
    private SQLiteDatabase dbActions;

    private static final int CAPTURAR_VIDEO = 2;
    private static final int SELECT_FILE = 1;
    private Button btn_camera;
    private File videosDir;
    private String IDcausa = "1";

    private void galleryIntent(){
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_PICK);
        startActivityForResult(intent.createChooser(intent, "Selecione o video"), SELECT_FILE);
    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) throws IOException {
        if(data != null){
            Uri uri = data.getData();
            String src = getRealPathFromURI(uri);
            File source = new File(src);
            String filename = IDcausa + ".mp4";
            File destination = new File(videosDir.getPath() + "/" + filename);
            Log.d("AQUI", "" + source);
            Log.d("AQUI", "" + destination);
            copy(source, destination);
            Bitmap thumb = ThumbnailUtils.createVideoThumbnail(videosDir.getPath() + "/1.mp4", MediaStore.Video.Thumbnails.MINI_KIND);
            BitmapDrawable bit = new BitmapDrawable(getApplicationContext().getResources(), thumb);
            btn_camera.setBackground(bit);
        }
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


    private void escolheVideo(){
        final CharSequence[] itens = {"Usar câmera", "Ir para galeria", "Cancelar"};
        AlertDialog.Builder builder = new AlertDialog.Builder(ApeloActivity.this);
        builder.setTitle("Adicionar foto");
        builder.setItems(itens, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean resultado = Utility.checkPermission(ApeloActivity.this);
                if(itens[item].equals("Usar câmera")){
                    if(resultado){
                        capturarVideo();
                    }
                } else if(itens[item].equals("Ir para galeria")){
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

    public void capturarVideo(){
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
        intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 240);
        startActivityForResult(intent, CAPTURAR_VIDEO);
    }
    private Uri uri;

    protected void onCreate(Bundle savedInstanceState){
        setContentView(R.layout.activity_apelo);
        super.onCreate(savedInstanceState);
        btn_voltar = (Button) findViewById(R.id.voltarseta);
        btn_continuar = (Button) findViewById(R.id.concluir);
        btn_ajuda = (Button) findViewById(R.id.ajuda);

        descricao = (EditText) findViewById(R.id.descricao);
        cidade = (Spinner) findViewById(R.id.cidade);
        estado = (Spinner) findViewById(R.id.estado);
        hemocentro = (Spinner) findViewById(R.id.hemocentro);


        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // aqui cria o diretório onde salva as imagens de perfil
        videosDir = cw.getDir("videos", Context.MODE_PRIVATE);


        try {
            database = new DataBase(this);
            dbActions = database.getWritableDatabase();

        }catch (SQLException ex){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao criar o banco!" + ex.getMessage());
            dlg.setNegativeButton("OK", null);
            dlg.show();

        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.estado,
                android.R.layout.simple_spinner_item);
        estado = (Spinner) findViewById(R.id.estado);
        estado.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                this, R.array.cidade1,
                android.R.layout.simple_spinner_item);
        cidade = (Spinner) findViewById(R.id.cidade);
        cidade.setAdapter(adapter1);


        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(
                this, R.array.hemocentro,
                android.R.layout.simple_spinner_item);
        hemocentro = (Spinner) findViewById(R.id.hemocentro);
        hemocentro.setAdapter(adapter3);

        btn_camera = (Button) findViewById(R.id.video);

        btn_camera.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                escolheVideo();
            }
        });

        btn_voltar.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent i = new Intent(ApeloActivity.this, MenuActivity.class);
                                              startActivity(i);
                                          }
                                      }
        );


        btn_continuar.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {

                                                 inserir();
                                                 Toast.makeText(ApeloActivity.this, "Novo apelo cadastrado", Toast.LENGTH_LONG).show();
                                                 Intent i = new Intent(ApeloActivity.this, MenuActivity.class);
                                                 startActivity(i);
                                                 }
                                             }



        );

        btn_ajuda.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent i = new Intent(ApeloActivity.this, AjudaActivity.class);
                                              startActivity(i);
                                          }
                                      }
        );

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            if(requestCode == CAPTURAR_VIDEO){
                String msg = "Vídeo gravado em " + data.getDataString();
                mostrarMensagem(msg);
                uri = data.getData();
                adicionarNaGaleria();
            } else if(requestCode == SELECT_FILE){
                try {
                    onSelectFromGalleryResult(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                mostrarMensagem("Vídeo não gravado");
            }
        }
    }
    public void visualizarVideo(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "video/mp4");
        startActivity(intent);
    }

    private void adicionarNaGaleria() {
        Intent intent = new Intent(
                Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(uri);
        this.sendBroadcast(intent);
    }

    private void mostrarMensagem(String msg){
        Toast.makeText(this, msg,Toast.LENGTH_LONG).show();
    }


    private void inserir() {
        try {
            Causa causa = new Causa();
            causa.setDescricao(descricao.getText().toString());
            causa.setCidade(cidade.getSelectedItem().toString());
            causa.setEstado(estado.getSelectedItem().toString());
            causa.setHemocentro(hemocentro.getSelectedItem().toString());

            database.insertCausa(causa);

        } catch (Exception ex) {

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao inserir os dados! " + ex.getMessage());
            dlg.setNegativeButton("OK", null);
            dlg.show();

        }
    }


}
