package br.uece.gesad.pcatoolbrasil.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.uece.gesad.pcatoolbrasil.model.domain.Entrevistador;

/**
 * Created by Messias on 20/05/2017.
 */

public class EntrevistadorDAO extends BDOpenHelper{

    public static final String NOME_ENTREVISTADOR = "nomeEntrevistador";
    public static final String PREFERENCE_ENTREVISTADOR = "PREFERENCE_ENTREVISTADOR";

    private Context context;

    public EntrevistadorDAO(Context context){
        super(context);
        this.context = context;
    }

    public long insert(Entrevistador entrevistador){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // ID Entrevistador é Auto Incremento
        values.put(BDOpenHelper.NOME_ENTREVISTADOR, entrevistador.getNome());

        long id = db.insert(TABELA_ENTREVISTADOR, null, values);
        db.close();

        return id;
    }

    public Entrevistador getEntrevistador(){
        String sql = "SELECT entrevistador.* FROM entrevistador" +
                " WHERE id_entrevistador = 1";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        Entrevistador entrevistador = null;

        if (cursor.moveToFirst()) {
            entrevistador = this.cursorToEntrevistador(cursor);
        }
        db.close();

        return entrevistador;
    }

    public long update(Entrevistador entrevistador) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id_entrevistador", 1);
        values.put("nome_entrevistador", entrevistador.getNome());

        long id = db.update("entrevistador", values, "id_entrevistador = ?", new String[] { "1" });

        db.close();

        return id;
    }

    private Entrevistador cursorToEntrevistador(Cursor cursor) {
        String nome = cursor.getString(cursor.getColumnIndex("nome_entrevistador"));
        Entrevistador entrevistador = new Entrevistador(nome);

        return entrevistador;
    }

}
