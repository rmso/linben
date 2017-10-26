package com.example.samsung.linben;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Raquel on 06/07/2016.
 */
public class AgendarActivity extends AppCompatActivity {
    private int ano, mes, dia;
    Button data_nascimento;

    private Button btn_agendar;
    private Button btn_voltar;
    private Button btn_ajuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar);

        btn_agendar = (Button) findViewById(R.id.agendar);
        btn_voltar = (Button) findViewById(R.id.voltarseta);
        btn_ajuda = (Button) findViewById(R.id.ajuda);

        Calendar calendar = Calendar.getInstance();
        ano = calendar.get(Calendar.YEAR);
        mes = calendar.get(Calendar.MONTH);
        dia = calendar.get(Calendar.DAY_OF_MONTH);
        data_nascimento = (Button) findViewById(R.id.data);

        btn_agendar.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               Intent i = new Intent(AgendarActivity.this, DoacaoRegistradaActivity.class);
                                               startActivity(i);
                                           }
                                       }
        );

        btn_voltar.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent i = new Intent(AgendarActivity.this, CriteriosDoacaoActivity.class);
                                              startActivity(i);
                                          }
                                      }
        );

        btn_ajuda.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent i = new Intent(AgendarActivity.this, AjudaActivity.class);
                                             startActivity(i);
                                         }
                                     }
        );

    }

    public void selecionarData(View view) {
        showDialog(view.getId());
    }


    @Override
    protected Dialog onCreateDialog(int id) {
        if (R.id.data == id) {
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

            data_nascimento.setText(dt);

        }

    };
}
