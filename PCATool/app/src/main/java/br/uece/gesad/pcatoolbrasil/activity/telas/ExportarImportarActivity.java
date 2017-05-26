package br.uece.gesad.pcatoolbrasil.activity.telas;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import br.uece.gesad.pcatoolbrasil.R;
import br.uece.gesad.pcatoolbrasil.model.domain.Questionario;
import br.uece.gesad.pcatoolbrasil.util.Conversor;

import java.util.ArrayList;

public class ExportarImportarActivity extends AppCompatActivity {

    private LinearLayout opcExportarQuestionarios, opcImportarQuestionarios;

    private AlertDialog alerta;
    private ProgressDialog dialog;

    private static final int FILE_SELECT_CODE = 0;
    private static final String SENHA_IMPORTAR = "pcatooladmin";

    private Conversor conversor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exportar_importar);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006E70")));

        this.conversor = new Conversor(this);

        this.opcExportarQuestionarios = (LinearLayout) findViewById(R.id.opcExportarQuestionarios);
        this.opcImportarQuestionarios = (LinearLayout) findViewById(R.id.opcImportarQuestionarios);

        this.opcExportarQuestionarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ExportarImportarActivity.this);
                builder.setTitle("Exportar Questionários");
                builder.setMessage("Será criado um arquivo .xml contendo os questionários cadastrados. Essa operação poderá levar alguns minutos. Continuar?");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        ExportarXMLAsync exportarXMLAsync = new ExportarXMLAsync();
                        exportarXMLAsync.execute();
                    }
                });
                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(ExportarImportarActivity.this, "Operação cancelada", Toast.LENGTH_SHORT).show();
                    }
                });

                alerta = builder.create();
                alerta.show();
            }
        });

        this.opcImportarQuestionarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            criarAlertDialogConfirmarSenha();
            }
        });

    }

    private class ExportarXMLAsync extends AsyncTask<Void,Void,Boolean> {

        @Override
        protected void onPreExecute() {
            dialog = ProgressDialog.show(ExportarImportarActivity.this,"Por favor aguarde","Exportando questionários ...");
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            return conversor.exportarQuestionariosXml();
        }

        @Override
        protected void onPostExecute(Boolean ok) {
            dialog.dismiss();
            if(ok)
                Toast.makeText(ExportarImportarActivity.this, "Exportação concluída com sucesso. Verifique o arquivo criado no armazenamento externo ou interno", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(ExportarImportarActivity.this, "Falha na exportação", Toast.LENGTH_LONG).show();
        }
    }

    public class ImportarXMLAsync extends AsyncTask<Void,Void,ArrayList<Questionario>> {

        Uri uri;

        public ImportarXMLAsync(Uri uri){
            this.uri = uri;
        }

        @Override
        protected void onPreExecute() {
            dialog = ProgressDialog.show(ExportarImportarActivity.this,"Por favor aguarde","Importando questionários ...");
        }

        @Override
        protected ArrayList<Questionario> doInBackground(Void... params) {
            ArrayList<Questionario> questionarios = conversor.deXmlParaArrayObjeto(uri);
            return questionarios;
        }

        @Override
        protected void onPostExecute(ArrayList<Questionario> questionarios) {
            dialog.dismiss();
            Toast.makeText(ExportarImportarActivity.this, "Importação concluida com sucesso\n" +
                    "Total de questionarios no arquivo = " + questionarios.size() + "\n" +
                    "Total de novos questionários cadastrados = " + conversor.getNumeroDeQuestionariosNovos(), Toast.LENGTH_LONG).show();
        }
    }

    private void showFileChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*"); // Todos os arquivos
        // intent.setType("text/xml"); // Somente XML
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        Intent chooserIntent;
        try {
            chooserIntent = Intent.createChooser(intent, "Selecione o arquivo XML com os questionários");
            startActivityForResult(chooserIntent, FILE_SELECT_CODE);
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(this, "Por favor, instale um Gerenciador de Arquvio", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case FILE_SELECT_CODE:
                if (resultCode == RESULT_OK) {
                    Uri uri = data.getData();

                    ImportarXMLAsync importarXMLAsync = new ImportarXMLAsync(uri);
                    importarXMLAsync.execute();
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void criarAlertDialogConfirmarSenha() {
        //LayoutInflater é utilizado para inflar nosso layout em uma view.
        //-pegamos nossa instancia da classe
        LayoutInflater li = getLayoutInflater();

        //inflamos o layout alerta.xml na view
        View view = li.inflate(R.layout.alerta_dialog, null);
        //definimos para o botão do layout um clickListener

        final EditText edtSenha = (EditText) view.findViewById(R.id.edtSenha);
        Button btnConfirmar = (Button) view.findViewById(R.id.btnConfirmar);

        view.findViewById(R.id.btnConfirmar).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                if(edtSenha.getText().toString().equals(SENHA_IMPORTAR)){
                    Toast.makeText(ExportarImportarActivity.this, "Acesso autorizado. Selecione o arquivo", Toast.LENGTH_SHORT).show();
                    alerta.dismiss();
                    showFileChooser();
                } else {
                    Toast.makeText(ExportarImportarActivity.this, "Senha incorreta", Toast.LENGTH_SHORT).show();
                    alerta.dismiss();
                }

            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmação de Senha");
        builder.setView(view);
        alerta = builder.create();
        alerta.show();
    }

}
