package com.carteiracliente.josemarsilva.carteiradecliente;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ActMain extends AppCompatActivity { // deve herdar da classe  "AppCompatActivity" compatibiliza versoes

    @Override
    protected void onCreate(Bundle savedInstanceState) { // método sempre chamado qdo activity for iniciado
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_main);  // relacionando o activity com o layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // adicionar botão na parte superior
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab); // está se tornando um padrao de layout android
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
