package com.tcc.brunopinela.diabetesdevfs;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.tcc.brunopinela.model.M_usuario;

public class Main extends Activity {

    //usuario objUsuario = new usuario();
    ImageButton imageButton;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton5;
    ImageButton imageButton9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
        addListenerOnButton2();
        addListenerOnButton3();
        addListenerOnButton5();
        addListenerOnButton9();

    }

    private void addListenerOnButton() {
        imageButton = (ImageButton) findViewById(R.id.img1);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent irParaNovoUsuario = new Intent(Main.this, usuario.class);
                startActivity(irParaNovoUsuario);
            }
        });
    }

    private void addListenerOnButton2() {
        imageButton2 = (ImageButton) findViewById(R.id.img2);

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent irParaNovoMedicao = new Intent(Main.this, medicoes.class);
                startActivity(irParaNovoMedicao);
            }
        });
    }

    private void addListenerOnButton3() {
        imageButton3 = (ImageButton) findViewById(R.id.img3);

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent irParaNovaAlimentacao = new Intent(Main.this, Alimentacao.class);
                startActivity(irParaNovaAlimentacao);
            }
        });
    }

    private void addListenerOnButton5() {
        imageButton5 = (ImageButton) findViewById(R.id.img5);

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent irParaNovoLembrete = new Intent(Main.this, Lembretes.class);
                startActivity(irParaNovoLembrete);
            }
        });
    }

    private void addListenerOnButton9() {
        imageButton9 = (ImageButton) findViewById(R.id.img9);

        imageButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                call();
            }
        });
    }

    M_usuario m_usuario = new M_usuario();
    //String phone = m_usuario.getTelefoneResp().toString();
    String phone = "911";

    public void call() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phone));
        startActivity(callIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

   // @Override
   // public boolean onOptionsItemSelected(MenuItem item){
     //   int itemClicado = item.getItemId();

       // switch (itemClicado){
           // case R.id.home:
                //Intent irParaNovoUsuario = new Intent(this, usuario.class);
                //startActivity(irParaNovoUsuario);
               // break;

           // default:
           //     break;
       // }

       // return super.onOptionsItemSelected(item);
  //  }

}
