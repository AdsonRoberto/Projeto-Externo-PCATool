package com.developer.barbosa.pcatool.modelAntigo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Messias on 28/04/2017.
 */

public class QuestaoDAO extends BDOpenHelper {

    Context context;

    public QuestaoDAO(Context context) {
        super(context);
        this.context = context;
    }

    public long insertQuestao(Questao questao){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // ID Posto é Auto Incremento
        values.put(BDOpenHelper.NUMERO_QUESTAO, questao.getNumeroQuestao());
        values.put(BDOpenHelper.DESCRICAO_QUESTAO, questao.getDescricao());

        long id = db.insert(BDOpenHelper.TABELA_QUESTAO, null, values);
        db.close();

        return id;
    }

    public Questao getQuestaoById(long id){
        String sql = "SELECT questao.* FROM questao" +
                " WHERE questao.id_questao = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        Questao questao = null;

        if (cursor.moveToFirst()) {
            questao = this.cursorToQuestao(cursor);
        }
        db.close();

        return questao;
    }

    public Questao getQuestaoByNumero(String numeroQuestao){
        String sql = "SELECT questao.* FROM questao" +
                " WHERE questao.numero_questao = '" + numeroQuestao + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        Questao questao = null;

        if (cursor.moveToFirst()) {
            questao = this.cursorToQuestao(cursor);
        }
        db.close();

        return questao;
    }

    public ArrayList<Questao> getAll() {
        String sql = "SELECT questao.* FROM questao";
        return findByQuery(sql);
    }

    private Questao cursorToQuestao(Cursor cursor) {
        Questao questao = new Questao();
        questao.setId_questao(cursor.getLong(cursor.getColumnIndex("id_questao")));
        questao.setNumeroQuestao(cursor.getString(cursor.getColumnIndex("numero_questao")));
        questao.setDescricao(cursor.getString(cursor.getColumnIndex("descricao_questao")));

        return questao;
    }

    public ArrayList<Questao> findByQuery(String sql) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<Questao> list = new ArrayList<Questao>();

        if (cursor.moveToFirst()) {
            do {
                Questao obj = this.cursorToQuestao(cursor);
                list.add(obj);
            } while(cursor.moveToNext());
        }
        db.close();

        return list;
    }

    public void createQuestoes(){

        if (this.getQuestaoById(1) == null) {

            Questao q1 = new Questao();
            q1.setNumeroQuestao("A-A1");
            q1.setDescricao("A1 – Há um médico/enfermeiro ou serviço de saúde onde você geralmente vai quando fica doente ou precisa de conselhos sobre a sua saúde?");

            Questao q2 = new Questao();
            q2.setNumeroQuestao("A-A2");
            q2.setDescricao("A2 – Há um médico/enfermeiro ou serviço de saúde que o/a conhece melhor como pessoa?");

            Questao q3 = new Questao();
            q3.setNumeroQuestao("A-A3");
            q3.setDescricao("A3 – Há um médico/enfermeiro ou serviço de saúde que é mais responsável por seu atendimento de saúde?");

            Questao q4 = new Questao();
            q4.setNumeroQuestao("A-A4");
            q4.setDescricao("A4 - Nome do médico/enfermeiro ou serviço de saúde procurado pela última vez:");

            Questao q5 = new Questao();
            q5.setNumeroQuestao("A-A5");
            q5.setDescricao("A5 - A partir de agora, todas as perguntas seguintes serão sobre o(a): (“nome do médico/enfermeiro/serviço de saúde”). (Vá para a Seção B)");

            Questao q6 = new Questao();
            q6.setNumeroQuestao("A-B1");
            q6.setDescricao("B1 – Quando você necessita de uma consulta de revisão (consulta de rotina, check-up), você vai ao seu “nome do serviço de saúde / ou nome médico/enfermeiro” antes de ir a outro serviço de saúde?");

            Questao q7 = new Questao();
            q7.setNumeroQuestao("A-B2");
            q7.setDescricao("B2 – Quando você tem um novo problema de saúde, você vai ao seu “nome do serviço de saúde / ou nome médico/enfermeiro” antes de ir a outro serviço de saúde?");

            Questao q8 = new Questao();
            q8.setNumeroQuestao("A-B3");
            q8.setDescricao("B3 – Quando você tem que consultar um especialista, o seu “nome do serviço de saúde / ou nome médico/ enfermeiro” tem que encaminhar você obrigatoriamente?");

            Questao q9 = new Questao();
            q9.setNumeroQuestao("A-C1");

            Questao q10 = new Questao();
            q10.setNumeroQuestao("A-C2");

            Questao q11 = new Questao();
            q11.setNumeroQuestao("A-C3");

            Questao q12 = new Questao();
            q12.setNumeroQuestao("A-C4");

            Questao q13 = new Questao();
            q13.setNumeroQuestao("A-C5");

            Questao q14 = new Questao();
            q14.setNumeroQuestao("A-C6");

            Questao q15 = new Questao();
            q15.setNumeroQuestao("A-C7");

            Questao q16 = new Questao();
            q16.setNumeroQuestao("A-C8");

            Questao q17 = new Questao();
            q17.setNumeroQuestao("A-C9");

            Questao q18 = new Questao();
            q18.setNumeroQuestao("A-C10");

            Questao q19 = new Questao();
            q19.setNumeroQuestao("A-C11");

            Questao q20 = new Questao();
            q20.setNumeroQuestao("A-C12");

            Questao q21 = new Questao();
            q21.setNumeroQuestao("A-D1");

            Questao q22 = new Questao();
            q22.setNumeroQuestao("A-D2");

            Questao q23 = new Questao();
            q23.setNumeroQuestao("A-D3");

            Questao q24 = new Questao();
            q24.setNumeroQuestao("A-D4");

            Questao q25 = new Questao();
            q25.setNumeroQuestao("A-D5");

            Questao q26 = new Questao();
            q26.setNumeroQuestao("A-D6");

            Questao q27 = new Questao();
            q27.setNumeroQuestao("A-D7");

            Questao q28 = new Questao();
            q28.setNumeroQuestao("A-D8");

            Questao q29 = new Questao();
            q29.setNumeroQuestao("A-D9");

            Questao q30 = new Questao();
            q30.setNumeroQuestao("A-D10");

            Questao q31 = new Questao();
            q31.setNumeroQuestao("A-D11");

            Questao q32 = new Questao();
            q32.setNumeroQuestao("A-D12");

            Questao q33 = new Questao();
            q33.setNumeroQuestao("A-D13");

            Questao q34 = new Questao();
            q34.setNumeroQuestao("A-D14");

            Questao q35 = new Questao();
            q35.setNumeroQuestao("A-E1");

            Questao q36 = new Questao();
            q36.setNumeroQuestao("A-E2");

            Questao q37 = new Questao();
            q37.setNumeroQuestao("A-E3");

            Questao q38 = new Questao();
            q38.setNumeroQuestao("A-E4");

            Questao q39 = new Questao();
            q39.setNumeroQuestao("A-E5");

            Questao q40 = new Questao();
            q40.setNumeroQuestao("A-E6");

            Questao q41 = new Questao();
            q41.setNumeroQuestao("A-E7");

            Questao q42 = new Questao();
            q42.setNumeroQuestao("A-E8");

            Questao q43 = new Questao();
            q43.setNumeroQuestao("A-E9");

            Questao q44 = new Questao();
            q44.setNumeroQuestao("A-F1");

            Questao q45 = new Questao();
            q45.setNumeroQuestao("A-F2");

            Questao q46 = new Questao();
            q46.setNumeroQuestao("A-F3");

            Questao q47 = new Questao();
            q47.setNumeroQuestao("A-G1");

            Questao q48 = new Questao();
            q48.setNumeroQuestao("A-G2");

            Questao q49 = new Questao();
            q49.setNumeroQuestao("A-G3");

            Questao q50 = new Questao();
            q50.setNumeroQuestao("A-G4");

            Questao q51 = new Questao();
            q51.setNumeroQuestao("A-G5");

            Questao q52 = new Questao();
            q52.setNumeroQuestao("A-G6");

            Questao q53 = new Questao();
            q53.setNumeroQuestao("A-G7");

            Questao q54 = new Questao();
            q54.setNumeroQuestao("A-G8");

            Questao q55 = new Questao();
            q55.setNumeroQuestao("A-G9");

            Questao q56 = new Questao();
            q56.setNumeroQuestao("A-G10");

            Questao q57 = new Questao();
            q57.setNumeroQuestao("A-G11");

            Questao q58 = new Questao();
            q58.setNumeroQuestao("A-G12");

            Questao q59 = new Questao();
            q59.setNumeroQuestao("A-G13");

            Questao q60 = new Questao();
            q60.setNumeroQuestao("A-G14");

            Questao q61 = new Questao();
            q61.setNumeroQuestao("A-G15");

            Questao q62 = new Questao();
            q62.setNumeroQuestao("A-G16");

            Questao q63 = new Questao();
            q63.setNumeroQuestao("A-G17");

            Questao q64 = new Questao();
            q64.setNumeroQuestao("A-G18");

            Questao q65 = new Questao();
            q65.setNumeroQuestao("A-G19");

            Questao q66 = new Questao();
            q66.setNumeroQuestao("A-G20");

            Questao q67 = new Questao();
            q67.setNumeroQuestao("A-G21");

            Questao q68 = new Questao();
            q68.setNumeroQuestao("A-G22");

            Questao q69 = new Questao();
            q69.setNumeroQuestao("A-H1");

            Questao q70 = new Questao();
            q70.setNumeroQuestao("A-H2");

            Questao q71 = new Questao();
            q71.setNumeroQuestao("A-H3");

            Questao q72 = new Questao();
            q72.setNumeroQuestao("A-H4");

            Questao q73 = new Questao();
            q73.setNumeroQuestao("A-H5");

            Questao q74 = new Questao();
            q74.setNumeroQuestao("A-H6");

            Questao q75 = new Questao();
            q75.setNumeroQuestao("A-H7");

            Questao q76 = new Questao();
            q76.setNumeroQuestao("A-H8");

            Questao q77 = new Questao();
            q77.setNumeroQuestao("A-H9");

            Questao q78 = new Questao();
            q78.setNumeroQuestao("A-H10");

            Questao q79 = new Questao();
            q79.setNumeroQuestao("A-H11");

            Questao q80 = new Questao();
            q80.setNumeroQuestao("A-H12");

            Questao q81 = new Questao();
            q81.setNumeroQuestao("A-H13");

            Questao q82 = new Questao();
            q82.setNumeroQuestao("A-I1");

            Questao q83 = new Questao();
            q83.setNumeroQuestao("A-I2");

            Questao q84 = new Questao();
            q84.setNumeroQuestao("A-I3");

            Questao q85 = new Questao();
            q85.setNumeroQuestao("A-J1");

            Questao q86 = new Questao();
            q86.setNumeroQuestao("A-J2");

            Questao q87 = new Questao();
            q87.setNumeroQuestao("A-J3");

            Questao q88 = new Questao();
            q88.setNumeroQuestao("A-J4");

            Questao q89 = new Questao();
            q89.setNumeroQuestao("A-J5");

            Questao q90 = new Questao();
            q90.setNumeroQuestao("A-J6");

            this.insertQuestao(q1);
            this.insertQuestao(q2);
            this.insertQuestao(q3);
            this.insertQuestao(q4);
            this.insertQuestao(q5);
            this.insertQuestao(q6);
            this.insertQuestao(q7);
            this.insertQuestao(q8);
            this.insertQuestao(q9);
            this.insertQuestao(q10);
            this.insertQuestao(q11);
            this.insertQuestao(q12);
            this.insertQuestao(q13);
            this.insertQuestao(q14);
            this.insertQuestao(q15);
            this.insertQuestao(q16);
            this.insertQuestao(q17);
            this.insertQuestao(q18);
            this.insertQuestao(q19);
            this.insertQuestao(q20);
            this.insertQuestao(q21);
            this.insertQuestao(q22);
            this.insertQuestao(q23);
            this.insertQuestao(q24);
            this.insertQuestao(q25);
            this.insertQuestao(q26);
            this.insertQuestao(q27);
            this.insertQuestao(q28);
            this.insertQuestao(q29);
            this.insertQuestao(q30);
            this.insertQuestao(q31);
            this.insertQuestao(q32);
            this.insertQuestao(q33);
            this.insertQuestao(q34);
            this.insertQuestao(q35);
            this.insertQuestao(q36);
            this.insertQuestao(q37);
            this.insertQuestao(q38);
            this.insertQuestao(q39);
            this.insertQuestao(q40);
            this.insertQuestao(q41);
            this.insertQuestao(q42);
            this.insertQuestao(q43);
            this.insertQuestao(q44);
            this.insertQuestao(q45);
            this.insertQuestao(q46);
            this.insertQuestao(q47);
            this.insertQuestao(q48);
            this.insertQuestao(q49);
            this.insertQuestao(q50);
            this.insertQuestao(q51);
            this.insertQuestao(q52);
            this.insertQuestao(q53);
            this.insertQuestao(q54);
            this.insertQuestao(q55);
            this.insertQuestao(q56);
            this.insertQuestao(q57);
            this.insertQuestao(q58);
            this.insertQuestao(q59);
            this.insertQuestao(q60);
            this.insertQuestao(q61);
            this.insertQuestao(q62);
            this.insertQuestao(q63);
            this.insertQuestao(q64);
            this.insertQuestao(q65);
            this.insertQuestao(q66);
            this.insertQuestao(q67);
            this.insertQuestao(q68);
            this.insertQuestao(q69);
            this.insertQuestao(q70);
            this.insertQuestao(q71);
            this.insertQuestao(q72);
            this.insertQuestao(q73);
            this.insertQuestao(q74);
            this.insertQuestao(q75);
            this.insertQuestao(q76);
            this.insertQuestao(q77);
            this.insertQuestao(q78);
            this.insertQuestao(q79);
            this.insertQuestao(q80);
            this.insertQuestao(q81);
            this.insertQuestao(q82);
            this.insertQuestao(q83);
            this.insertQuestao(q84);
            this.insertQuestao(q85);
            this.insertQuestao(q86);
            this.insertQuestao(q87);
            this.insertQuestao(q88);
            this.insertQuestao(q89);
            this.insertQuestao(q90);

            System.out.println("Inserindo Questoes no BD");

        }



    }

}
