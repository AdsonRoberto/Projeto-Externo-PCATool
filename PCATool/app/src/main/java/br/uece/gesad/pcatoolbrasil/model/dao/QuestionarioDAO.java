package br.uece.gesad.pcatoolbrasil.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.uece.gesad.pcatoolbrasil.model.domain.Entrevistado;
import br.uece.gesad.pcatoolbrasil.model.domain.Questionario;
import br.uece.gesad.pcatoolbrasil.model.domain.Regional;

import java.util.ArrayList;

/**
 * Created by Messias on 28/04/2017.
 */

public class QuestionarioDAO extends BDOpenHelper {

    Context context;

    public QuestionarioDAO(Context context) {
        super(context);
        this.context = context;
    }

    public long insertQuestionario(Questionario questionario){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // ID Posto é Auto Incremento
        values.put(ID_ENTREVISTADO, questionario.getEntrevistado().getId_entrevistado());
        values.put(ID_REGIONAL, questionario.getRegional().getId_regional());
        values.put(DATA_REALIZACAO, questionario.getDataRealizacao());
        values.put(TIPO_QUESTIONARIO, questionario.getTipoQuestionario());
        values.put(ESCORE_ESSENCIAL, questionario.getEscoreEssencial());
        values.put(ESCORE_GERAL, questionario.getEscoreGeral());

        long id = db.insert(TABELA_QUESTIONARIO, null, values);
        db.close();

        return id;
    }


    public Questionario getQuestionarioById(long id){
        String sql = "SELECT questionario.* FROM questionario" +
                " WHERE questionario.id_questionario = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        Questionario questionario = null;

        if (cursor.moveToFirst()) {
            questionario = this.cursorToQuestionario(cursor);
        }
        db.close();

        return questionario;
    }

    public ArrayList<Questionario> getAll() {
        String sql = "SELECT questionario.* FROM questionario";
        return findByQuery(sql);
    }

    private Questionario cursorToQuestionario(Cursor cursor) {
        Questionario questionario = new Questionario();
        questionario.setId_questionario(cursor.getLong(cursor.getColumnIndex("id_questionario")));
        questionario.setDataRealizacao(cursor.getString(cursor.getColumnIndex("data_realizacao")));
        questionario.setTipoQuestionario(cursor.getString(cursor.getColumnIndex("tipo_questionario")));
        questionario.setEscoreEssencial(cursor.getDouble((cursor.getColumnIndex("escore_essencial"))));
        questionario.setEscoreGeral(cursor.getDouble((cursor.getColumnIndex("escore_geral"))));

        long id_entrevistado = cursor.getLong(cursor.getColumnIndex("id_entrevistado"));
        EntrevistadoDAO entrevistadoDAO = new EntrevistadoDAO(this.context);
        Entrevistado entrevistado = entrevistadoDAO.getEntrevistadoById(id_entrevistado);
        questionario.setEntrevistado(entrevistado);

        long id_regional = cursor.getLong(cursor.getColumnIndex("id_regional"));
        RegionalDAO regionalDAO = new RegionalDAO(this.context);
        Regional regional = regionalDAO.getRegionalById(id_regional);
        questionario.setRegional(regional);

        return questionario;
    }

    public ArrayList<Questionario> findByQuery(String sql) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<Questionario> list = new ArrayList<Questionario>();

        if (cursor.moveToFirst()) {
            do {
                Questionario obj = this.cursorToQuestionario(cursor);
                list.add(obj);
            } while(cursor.moveToNext());
        }
        db.close();

        return list;
    }

}
