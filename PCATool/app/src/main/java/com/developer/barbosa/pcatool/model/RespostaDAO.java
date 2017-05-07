package com.developer.barbosa.pcatool.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Messias on 28/04/2017.
 */

public class RespostaDAO extends BDOpenHelper {

    Context context;

    public RespostaDAO(Context context) {
        super(context);
        this.context = context;
    }

    public long insertResposta(Resposta resposta){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // ID Resposta é Auto Incremento
        values.put(BDOpenHelper.ID_QUESTIONARIO, resposta.getQuestionario().getId_questionario());
        values.put(BDOpenHelper.NUMERO_QUESTAO, resposta.getNumeroQuestao());
        values.put(BDOpenHelper.OPCAO_RESPOTA, resposta.getOpcao());
        values.put(BDOpenHelper.NOME_PROF_SERV, resposta.getNomeProfServ());
        values.put(BDOpenHelper.ENDERECO_RESPOSTA, resposta.getEndereco());

        long id = db.insert(BDOpenHelper.TABELA_RESPOSTA, null, values);
        db.close();

        return id;
    }

    public Resposta getRespostaById(long id){
        String sql = "SELECT resposta.* FROM resposta" +
                " WHERE resposta.id_resposta = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        Resposta resposta = null;

        if (cursor.moveToFirst()) {
            resposta = this.cursorToResposta(cursor);
        }
        db.close();

        return resposta;
    }

    public ArrayList<Resposta> getAll() {
        String sql = "SELECT resposta.* FROM resposta";
        return findByQuery(sql);
    }

    private Resposta cursorToResposta(Cursor cursor) {
        Resposta resposta = new Resposta();
        resposta.setId_resposta(cursor.getLong(cursor.getColumnIndex("id_resposta")));
        resposta.setNumeroQuestao(cursor.getString(cursor.getColumnIndex("numero_questao")));
        resposta.setOpcao(cursor.getInt(cursor.getColumnIndex("opcao_resposta")));
        resposta.setNomeProfServ(cursor.getString(cursor.getColumnIndex("nome_profissional_servico")));
        resposta.setEndereco(cursor.getString(cursor.getColumnIndex("endereco_resposta")));

        long id_questionario = cursor.getLong(cursor.getColumnIndex("id_questionario"));
        QuestionarioDAO questionarioDAO = new QuestionarioDAO(this.context);
        Questionario questionario = questionarioDAO.getQuestionarioById(id_questionario);
        resposta.setQuestionario(questionario);

        return resposta;
    }

    public ArrayList<Resposta> findByQuery(String sql) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<Resposta> list = new ArrayList<Resposta>();

        if (cursor.moveToFirst()) {
            do {
                Resposta obj = this.cursorToResposta(cursor);
                list.add(obj);
            } while(cursor.moveToNext());
        }
        db.close();

        return list;
    }


}
