package br.uece.gesad.pcatoolbrasil.activity.telas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import br.uece.gesad.pcatoolbrasil.R;
import br.uece.gesad.pcatoolbrasil.model.dao.EntrevistadorDAO;
import br.uece.gesad.pcatoolbrasil.model.dao.PostoDAO;
import br.uece.gesad.pcatoolbrasil.model.dao.RegionalDAO;

public class DashActivity extends AppCompatActivity {

    public static final String SHARED_PREF_PRIMEIRO_ACESSO = "prefPrimeiroAcesso";

    private LinearLayout opcNovaEntrevista, opcVisualizarQuestionarios, opcInformacoesEntrevistador,
                            opcResultados, opcExportarImportar;

    private RegionalDAO regionalDAO;
    private PostoDAO postoDAO;
    private EntrevistadorDAO entrevistadorDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cadastrarRegionaisPostos();

        entrevistadorDAO = new EntrevistadorDAO(this);

        opcNovaEntrevista = (LinearLayout) findViewById(R.id.opcNovaEntrevista);
        opcVisualizarQuestionarios = (LinearLayout) findViewById(R.id.opcVisualizarQuestionarios);
        opcInformacoesEntrevistador = (LinearLayout) findViewById(R.id.opcInformacoesEntrevistador);
        opcResultados = (LinearLayout) findViewById(R.id.opcResultados);
        opcExportarImportar = (LinearLayout) findViewById(R.id.opcExportarImportar);

        opcNovaEntrevista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashActivity.this, Cadastro.class);
                startActivity(intent);
            }
        });

        opcVisualizarQuestionarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashActivity.this, VisualizarQuestionariosActivity.class);
                startActivity(intent);
            }
        });

        opcInformacoesEntrevistador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashActivity.this, EditarEntrevistadorActivity.class);
                startActivity(intent);
            }
        });

        opcResultados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashActivity.this, ResultadosActivity.class);
                startActivity(intent);
            }
        });

        opcExportarImportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashActivity.this, ExportarImportarActivity.class);
                startActivity(intent);
            }
        });

        if(primeiroAcesso()){
            Intent intent = new Intent(DashActivity.this, BoasVindasActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_dash, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sobre:
                Intent intent = new Intent(DashActivity.this, SobreActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean primeiroAcesso(){
        SharedPreferences preferences = getSharedPreferences(SHARED_PREF_PRIMEIRO_ACESSO, Context.MODE_PRIVATE);
        if (preferences.getBoolean("primeiroAcesso",true)  || entrevistadorDAO.getEntrevistador() == null){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("primeiroAcesso", false);
            editor.commit();
            return true;
        }
        return false;
    }

    public void cadastrarRegionaisPostos(){
        this.regionalDAO = new RegionalDAO(this);
        this.postoDAO = new PostoDAO(this);
        regionalDAO.createRegionais();
        postoDAO.createPostos();
    }

}
