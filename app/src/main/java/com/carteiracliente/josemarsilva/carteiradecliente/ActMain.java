package com.carteiracliente.josemarsilva.carteiradecliente;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ActMain extends AppCompatActivity { // deve herdar da classe  "AppCompatActivity" compatibiliza versoes

    private RecyclerView lstDados;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // método sempre chamado qdo activity for iniciado
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);  // relacionando o activity com o layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // adicionar botão na parte superior
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab); // está se tornando um padrao de layout android
        lstDados = (RecyclerView)findViewById(R.id.lstDados)

        /*
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
    }


    public void cadastrar(View view) { // Property OnClick do Res/layout/act_main.xml
        Intent it = new Intent(ActMain.this, ActCadCliente.class);
        startActivity(it);
    }

}
