package br.uece.gesad.pcatoolbrasil.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.uece.gesad.pcatoolbrasil.model.domain.Componente;
import br.uece.gesad.pcatoolbrasil.model.domain.Questionario;

import java.util.ArrayList;

/**
 * Created by Messias on 28/04/2017.
 */

public class ComponenteDAO extends BDOpenHelper {

    Context context;

    public ComponenteDAO(Context context) {
        super(context);
        this.context = context;
    }

    public long insertComponente(Componente componente){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // ID Componente é Auto Incremento
        values.put(BDOpenHelper.ID_QUESTIONARIO, componente.getQuestionario().getId_questionario());
        values.put(BDOpenHelper.LETRA_COMPONENTE, componente.getLetraComponente());
        values.put(BDOpenHelper.ESCORE_COMPONENTE, componente.getEscoreComponente());

        long id = db.insert(BDOpenHelper.TABELA_COMPONENTE, null, values);
        db.close();

        return id;
    }

    public Componente getComponenteById(long id){
        String sql = "SELECT componente.* FROM componente" +
                " WHERE componente.id_componente = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        Componente componente = null;

        if (cursor.moveToFirst()) {
            componente = this.cursorToComponente(cursor);
        }
        db.close();

        return componente;
    }

    public ArrayList<Componente> getAll() {
        String sql = "SELECT componente.* FROM componente";
        return findByQuery(sql);
    }

    private Componente cursorToComponente(Cursor cursor) {
        Componente componente = new Componente();
        componente.setId_componente(cursor.getLong(cursor.getColumnIndex("id_componente")));
        componente.setLetraComponente(cursor.getString(cursor.getColumnIndex("letra_componente")));
        componente.setEscoreComponente(cursor.getDouble(cursor.getColumnIndex("escore_componente")));

        long id_questionario = cursor.getLong(cursor.getColumnIndex("id_questionario"));
        QuestionarioDAO questionarioDAO = new QuestionarioDAO(this.context);
        Questionario questionario = questionarioDAO.getQuestionarioById(id_questionario);
        componente.setQuestionario(questionario);

        return componente;
    }

    public ArrayList<Componente> findByQuery(String sql) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<Componente> list = new ArrayList<Componente>();

        if (cursor.moveToFirst()) {
            do {
                Componente obj = this.cursorToComponente(cursor);
                list.add(obj);
            } while(cursor.moveToNext());
        }
        db.close();

        return list;
    }

}
