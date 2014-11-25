package com.tcc.brunopinela.diabetesdevfs;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;

public class usuario extends Activity {

    SQLiteDatabase bancoDados = null;
    Cursor cursor;
    private EditText editNome, editDataNasc, editAltura, editPeso,
                     editEmail, editTelResp, editTelMed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        try {abreouCriaBanco();} catch (Exception e) {e.printStackTrace();}
        inicializacaoObjetos();
        buscarDados();
        MostrarDados();
    }

    public void inicializacaoObjetos()
    {
        try{
            editNome = (EditText) findViewById(R.id.txtGlicemia);
            editDataNasc = (EditText) findViewById(R.id.editText2);
            editAltura = (EditText) findViewById(R.id.txtHGT);
            editPeso = (EditText) findViewById(R.id.editText3);
            editEmail = (EditText) findViewById(R.id.txtTipoInsulina);
            editTelResp = (EditText) findViewById(R.id.txtPeridoDia);
            editTelMed = (EditText) findViewById(R.id.txtData2);
        }
        catch (Exception erro){
            ExibirMensagem("Erro", "Erro ao inicializar os objetos");
        }
    }

    public void abreouCriaBanco() throws Exception {
        try{
            bancoDados = openOrCreateDatabase("BancoDiabetes", MODE_PRIVATE, null);
            String sql = "CREATE TABLE IF NOT EXISTS usuarios" +
                    "(id INTEGER PRIMARY KEY, Nome TEXT, DataNasc TEXT," +
                    "Altura REAL, Peso TEXT, Email TEXT, " +
                    "TelResponsavel TEXT, TelMedico TEXT);";
            bancoDados.execSQL(sql);
            //ExibirMensagem("Banco", "Banco Criado com sucesso!");
        }
        catch (Exception erro)
        {
            ExibirMensagem("Erro na Conexão", "Ocorreu algum erro ao tentar se conectar ao banco de dados");
        }
    }

    public void FechaBanco()
    {
        try {
            bancoDados.close();
        }
        catch(Exception erro) {
            ExibirMensagem("Erro Banco", "Erro ao fechar o banco" + erro);
        }
    }

    public void ExibirMensagem(String titulo, String texto)
    {
        AlertDialog.Builder mensagem = new AlertDialog.Builder(usuario.this);
        mensagem.setTitle(titulo);
        mensagem.setMessage(texto);
        mensagem.setNeutralButton("OK", null);
        mensagem.show();
    }

    public void MostrarDados()
    {
        try {
            if (buscarDados()) {
                cursor.moveToLast();
                editNome.setText(cursor.getString(cursor.getColumnIndex("Nome")));
                editDataNasc.setText(cursor.getString(cursor.getColumnIndex("DataNasc")));
                editAltura.setText(cursor.getString(cursor.getColumnIndex("Altura")));
                editPeso.setText(cursor.getString(cursor.getColumnIndex("Peso")));
                editEmail.setText(cursor.getString(cursor.getColumnIndex("Email")));
                editTelResp.setText(cursor.getString(cursor.getColumnIndex("TelResponsavel")));
                editTelMed.setText(cursor.getString(cursor.getColumnIndex("TelMedico")));
            }
        }
        catch(Exception erro){
            ExibirMensagem("Erro", "Erro ao mostrar os dados");
        }
    }

    public void RemoverDados()
    {
        editNome.setText("");
        editDataNasc.setText("");
        editAltura.setText("");
        editPeso.setText("");
        editEmail.setText("");
        editTelResp.setText("");
        editTelMed.setText("");
    }


    //======================== METODOS SQL ========================

    public  boolean buscarDados()
    {
        try {
            cursor = bancoDados.query("usuarios",
                    new String[]{"Nome , DataNasc, Altura , Peso, Email, TelResponsavel, TelMedico"},
                    null,null,null,null,null);
            //por padrão a funcao query ja faz o select * from tabela

            int numeroRegistros = cursor.getCount();
            if (numeroRegistros != 0)
            {
                cursor.moveToFirst();
                return true;
            }
            else
                return false;
        }
        catch (Exception erro){
            ExibirMensagem("Erro Banco", "Erro ao buscar dados no banco.");
            return false;
        }
    }

    public void gravarRegistro()
    {
        try{
            String sql = "INSERT INTO usuarios (Nome, DataNasc, Altura , Peso, Email, TelResponsavel, TelMedico) values ('"
                    +editNome.getText().toString()+"','"
                    +editDataNasc.getText().toString()+"','"
                    +editAltura.getText().toString()+"','"
                    +editPeso.getText().toString()+"','"
                    +editEmail.getText().toString()+"','"
                    +editTelResp.getText().toString()+"','"
                    +editTelMed.getText().toString()+"')";

            bancoDados.execSQL(sql);
            ExibirMensagem("Sucesso", "Registro gravado com sucesso!");
        }
        catch (Exception erro){
            ExibirMensagem("Erro Banco", "Erro ao inserir os dados.");
        }
    }

    public void mostrarRegistroAnterior()
    {
        try{
            cursor.moveToPrevious();
            MostrarDados();
        }
        catch (Exception erro){
            ExibirMensagem("Erro Banco", "Nao foi possivel ir para o registro anterior");
        }
    }

    public void mostrarProximoRegistro()
    {
        try{
            cursor.moveToNext();
            MostrarDados();
        }
        catch (Exception erro){
            ExibirMensagem("Erro Banco", "Nao foi possivel ir para o proximo registro");
        }
    }


    //==============================================================//

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.usuario, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.save) {
            gravarRegistro();
            //finish();
        }

        if (id == R.id.update) {
            MostrarDados();
        }

        if (id == R.id.remove) {
            RemoverDados();
        }
        return super.onOptionsItemSelected(item);
    }
}
