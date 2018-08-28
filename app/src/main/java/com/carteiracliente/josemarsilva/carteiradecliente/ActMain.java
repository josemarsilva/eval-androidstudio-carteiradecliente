package com.carteiracliente.josemarsilva.carteiradecliente;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.carteiracliente.josemarsilva.carteiradecliente.database.DadosOpenHelper;
import com.carteiracliente.josemarsilva.carteiradecliente.dominio.entidades.Cliente;
import com.carteiracliente.josemarsilva.carteiradecliente.dominio.repositorio.ClienteRepositorio;

import java.util.List;

public class ActMain extends AppCompatActivity { // deve herdar da classe  "AppCompatActivity" compatibiliza versoes

    private RecyclerView lstDados;
    private FloatingActionButton fab;
    private ConstraintLayout layoutCotentMain;

    private SQLiteDatabase conexao;
    private DadosOpenHelper dadosOpenHelper;

    private ClienteRepositorio clienteRepositorio;

    private ClienteAdapter clienteAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) { // método sempre chamado qdo activity for iniciado
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);  // relacionando o activity com o layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // adicionar botão na parte superior
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab); // está se tornando um padrao de layout android
        lstDados = (RecyclerView)findViewById(R.id.lstDados);

        layoutCotentMain = (ConstraintLayout) findViewById(R.id.layout_content_main);

        criarConexao();

        lstDados.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        lstDados.setLayoutManager(linearLayoutManager);

        clienteRepositorio = new ClienteRepositorio(conexao);

        List<Cliente> dados =  clienteRepositorio.buscarTodos();

        clienteAdapter = new ClienteAdapter(dados);

        lstDados.setAdapter(clienteAdapter);


    }

    private void criarConexao() { // Seria bom separar este método em outra classe

        try {

            dadosOpenHelper = new DadosOpenHelper(this);
            conexao = dadosOpenHelper.getWritableDatabase();
            Snackbar.make(layoutCotentMain, R.string.message_conexao_criada_sucesso, Snackbar.LENGTH_LONG)
                    .setAction(R.string.action_ok, null).show();

        } catch (SQLException ex) {

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle(R.string.title_erro);
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton(R.string.action_ok, null);
            dlg.show();

        }
    }


    public void cadastrar(View view) { // Property OnClick do Res/layout/act_main.xml
        Intent it = new Intent(ActMain.this, ActCadCliente.class);
        startActivity(it);
    }

}
