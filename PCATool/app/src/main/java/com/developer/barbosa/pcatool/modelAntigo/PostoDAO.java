package com.developer.barbosa.pcatool.modelAntigo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Messias on 28/04/2017.
 */

public class PostoDAO extends BDOpenHelper {

    private Context context;

    public PostoDAO(Context context) {
        super(context);
        this.context = context;
    }

    public long insertPosto(Posto posto){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // ID Posto é Auto Incremento
        values.put(BDOpenHelper.ID_REGIONAL, posto.getRegional().getId_regional());
        values.put(BDOpenHelper.NOME_POSTO, posto.getNome());
        values.put(BDOpenHelper.ENDERECO_POSTO, posto.getEndereco());

        long id = db.insert(BDOpenHelper.TABELA_POSTO, null, values);
        db.close();

        return id;
    }

    public Posto getPostoById(long id){
        String sql = "SELECT posto.* FROM posto" +
                " WHERE posto.id_posto = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        Posto posto = null;

        if (cursor.moveToFirst()) {
            posto = this.cursorToPosto(cursor);
        }
        db.close();

        return  posto;
    }

    public ArrayList<Posto> getAll() {
        String sql = "SELECT posto.* FROM posto";
        return findByQuery(sql);
    }

    private Posto cursorToPosto(Cursor cursor) {
        Posto posto = new Posto();
        posto.setId_posto(cursor.getLong(cursor.getColumnIndex("id_posto")));
        posto.setNome(cursor.getString(cursor.getColumnIndex("nome_posto")));
        posto.setEndereco(cursor.getString(cursor.getColumnIndex("endereco_posto")));

        long id_regional = cursor.getInt(cursor.getColumnIndex("id_regional"));
        RegionalDAO regionalDAO = new RegionalDAO(this.context);
        Regional regional = regionalDAO.getRegionalById(id_regional);
        posto.setRegional(regional);

        return posto;
    }

    public ArrayList<Posto> findByQuery(String sql) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<Posto> list = new ArrayList<Posto>();

        if (cursor.moveToFirst()) {
            do {
                Posto obj = this.cursorToPosto(cursor);
                list.add(obj);
            } while(cursor.moveToNext());
        }
        db.close();

        return list;
    }

    public void createPostos(){

        if (this.getPostoById(1) == null && this.getPostoById(2) == null) {

            System.out.println("Cadastrando Postos ... ");

            RegionalDAO regionalDAO = new RegionalDAO(this.context);

            Posto posto1 = new Posto();
            posto1.setNome("Posto de Saúde Paulo Marcelo");
            posto1.setEndereco("R. Vinte e Cinco de Março, 607 - Centro");
            posto1.setRegional( regionalDAO.getRegionalById(1));

            Posto posto2 = new Posto();
            posto2.setNome("Posto de Saúde Anastácio Magalhães");
            posto2.setEndereco("R. Delmiro de Farias, 1679 - Rodolfo Teófilo");
            posto2.setRegional(regionalDAO.getRegionalById(1));

            Posto posto3 = new Posto();
            posto3.setNome("Posto de Saúde Irmã Hercilia Aragão");
            posto3.setEndereco("Rua Frei Vidal, 1821 - São João do Tauape");
            posto3.setRegional(regionalDAO.getRegionalById(2));

            Posto posto4 = new Posto();
            posto4.setNome("Posto de Saúde Hélio Goes Ferreira");
            posto4.setEndereco("Av. Eng. Leal Lima Verde, 453 - Conjunto Alvorada");
            posto4.setRegional(regionalDAO.getRegionalById(2));

            Posto posto5 = new Posto();
            posto5.setNome("Posto de Saúde Luciano Torres de Melo");
            posto5.setEndereco("R. Delta, 365 - Manoel Sátiro");
            posto5.setRegional(regionalDAO.getRegionalById(3));

            Posto posto6 = new Posto();
            posto6.setNome("Posto de Saúde Fernando Façanha");
            posto6.setEndereco("R. Rio Tocantins - Jardim Iracema");
            posto6.setRegional(regionalDAO.getRegionalById(4));

            this.insertPosto(posto1);
            this.insertPosto(posto2);
            this.insertPosto(posto3);
            this.insertPosto(posto4);
            this.insertPosto(posto5);
            this.insertPosto(posto6);
        }

    }

}
