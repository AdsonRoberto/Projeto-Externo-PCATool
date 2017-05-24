package com.developer.barbosa.pcatool.modelAntigo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Messias on 28/04/2017.
 */

public class EntrevistadoDAO extends BDOpenHelper {

    Context context;

    public EntrevistadoDAO(Context context) {
        super(context);
        this.context = context;
    }

    public long insertEntrevistado(Entrevistado entrevistado){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // ID Entrevistado é Auto Incremento
        values.put(BDOpenHelper.NOME_ENTREVISTADO, entrevistado.getNome());
        values.put(BDOpenHelper.SEXO_ENTREVISTADO, entrevistado.getSexo());
        values.put(BDOpenHelper.DATA_NASCIMENTO, entrevistado.getDataNascimento());

        long id = db.insert(BDOpenHelper.TABELA_ENTREVISTADO, null, values);
        db.close();

        return id;
    }

    public Entrevistado getEntrevistadoById(long id){
        String sql = "SELECT entrevistado.* FROM entrevistado" +
                " WHERE entrevistado.id_entrevistado = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        Entrevistado entrevistado = null;

        if (cursor.moveToFirst()) {
            entrevistado = this.cursorToEntrevistado(cursor);
        }
        db.close();

        return entrevistado;
    }

    public ArrayList<Entrevistado> getAll() {
        String sql = "SELECT entrevistado.* FROM entrevistado";
        return findByQuery(sql);
    }

    private Entrevistado cursorToEntrevistado(Cursor cursor) {
        Entrevistado entrevistado = new Entrevistado();
        entrevistado.setId_entrevistado(cursor.getLong(cursor.getColumnIndex("id_entrevistado")));
        entrevistado.setNome(cursor.getString(cursor.getColumnIndex("nome_entrevistado")));
        entrevistado.setSexo(cursor.getString(cursor.getColumnIndex("sexo_entrevistado")));
        entrevistado.setDataNascimento(cursor.getString(cursor.getColumnIndex("data_nascimento")));

        return entrevistado;
    }

    public ArrayList<Entrevistado> findByQuery(String sql) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<Entrevistado> list = new ArrayList<Entrevistado>();

        if (cursor.moveToFirst()) {
            do {
                Entrevistado obj = this.cursorToEntrevistado(cursor);
                list.add(obj);
            } while(cursor.moveToNext());
        }
        db.close();

        return list;
    }

    public ArrayList<Resposta> getRespostasFromEntrevistadoById(int id){
        String sql = "SELECT resposta.* FROM entrevistado " +
                " JOIN questionario ON questionario.id_entrevistado = entrevistado.id_entrevistado" +
                " JOIN resposta ON resposta.id_questionario = questionario.id_questionario" +
                " WHERE questionario.id_entrevistado = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        ArrayList<Resposta> list = new ArrayList<Resposta>();

        if (cursor.moveToFirst()) {
            do {
                Resposta obj = new Resposta();
                obj.setId_resposta(cursor.getLong(cursor.getColumnIndex("id_resposta")));
                obj.setOpcao(cursor.getInt(cursor.getColumnIndex("opcao_resposta")));

                obj.setNomeProfServ(cursor.getString(cursor.getColumnIndex("nome_profissional_servico")));
                //obj.setNomeMedServUlt(cursor.getString(cursor.getColumnIndex("nome_medico_servico_ult")));
                obj.setEndereco(cursor.getString(cursor.getColumnIndex("endereco_resposta")));
                //obj.setNomeMedServDef(cursor.getString(cursor.getColumnIndex("nome_medico_servico_def")));

                QuestaoDAO questaoDAO = new QuestaoDAO(this.context);
                Questao questao = questaoDAO.getQuestaoById(cursor.getLong(cursor.getColumnIndex("id_questao")));
                obj.setQuestao(questao);

                list.add(obj);
            } while(cursor.moveToNext());
        }
        db.close();

        return list;

    }

}
