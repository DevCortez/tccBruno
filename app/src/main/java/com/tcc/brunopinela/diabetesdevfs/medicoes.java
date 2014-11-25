package com.tcc.brunopinela.diabetesdevfs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class medicoes extends Activity {

    SQLiteDatabase bancoDados = null;
    Cursor cursor;
    private EditText editDia, editHora, editGlicose, editTipoInsulina, editUnidades, editPeriodo, editObs;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private Date dataHora;
    private int year, month, day, hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicoes);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        try {abreouCriaBanco();} catch (Exception e) {e.printStackTrace();}
        inicializacaoObjetos();
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "Data da Medição", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3)
        {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
        }
    };

    public void inicializacaoObjetos()
    {
        try{
            editDia =
            editGlicose = (EditText) findViewById(R.id.txtGlicemia);
            editTipoInsulina = (EditText) findViewById(R.id.editText2);
            editUnidades = (EditText) findViewById(R.id.editText3);
            editPeriodo = (EditText) findViewById(R.id.editText4);
            editObs = (EditText) findViewById(R.id.editText5);
        }
        catch (Exception erro){
            ExibirMensagem("Erro", "Erro ao inicializar os objetos");
        }
    }

    public void abreouCriaBanco() throws Exception {
        try{
            bancoDados = openOrCreateDatabase("BancoDiabetes", MODE_PRIVATE, null);
            String sql = "CREATE TABLE IF NOT EXISTS medicoes" +
                    "(id INTEGER PRIMARY KEY, Dia DATETIME," +
                    "Glicose TEXT, TipoInsulina TEXT, Unidades REAL, " +
                    "Periodo TEXT, Observacoes TEXT);";
            bancoDados.execSQL(sql);
            //ExibirMensagem("Banco", "Banco Criado com sucesso!");
        }
        catch (Exception erro)
        {
            ExibirMensagem("Erro na Conexão", "Ocorreu algum erro ao tentar se conectar ao banco de dados");
        }
    }

    public void ExibirMensagem(String titulo, String texto)
    {
        AlertDialog.Builder mensagem = new AlertDialog.Builder(medicoes.this);
        mensagem.setTitle(titulo);
        mensagem.setMessage(texto);
        mensagem.setNeutralButton("OK", null);
        mensagem.show();
    }

    public void gravarRegistro()
    {
        try{
            String sql = "INSERT INTO medicoes (Dia, Hora, Glicose, TipoInsulina, Unidades, Periodo, Observacoes) values ('"
                    +editDia.getText().toString()+"','"
                    +editHora.getText().toString()+"','"
                    +editGlicose.getText().toString()+"','"
                    +editTipoInsulina.getText().toString()+"','"
                    +editUnidades.getText().toString()+"','"
                    +editPeriodo.getText().toString()+"','"
                    +editObs.getText().toString()+"')";

            bancoDados.execSQL(sql);
            ExibirMensagem("Sucesso", "Registro gravado com sucesso!");
        }
        catch (Exception erro){
            ExibirMensagem("Erro Banco", "Erro ao inserir os dados.");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.medicoes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.save) {
            gravarRegistro();
            //finish();
        }

        if (id == R.id.back){
            //voltar para a main
        }
        return super.onOptionsItemSelected(item);
    }
}
