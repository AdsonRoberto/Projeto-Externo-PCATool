package br.uece.gesad.pcatoolbrasil.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.uece.gesad.pcatoolbrasil.model.domain.Regional;

import java.util.ArrayList;

/**
 * Created by Messias on 28/04/2017.
 */

public class RegionalDAO extends BDOpenHelper {

    private Context context;

    public RegionalDAO(Context context) {
        super(context);
        this.context = context;
    }

    public long insertRegional(Regional regional){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // ID Posto é Auto Incremento
        values.put(NOME_REGIONAL, regional.getNome());
        values.put(ENDERECO_REGIONAL, regional.getEndereco());

        long id = db.insert(BDOpenHelper.TABELA_REGIONAL, null, values);
        db.close();

        return id;
    }

    public Regional getRegionalById(long id){
        String sql = "SELECT regional.* FROM regional" +
                " WHERE regional.id_regional = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        Regional regional = null;

        if (cursor.moveToFirst()) {
            regional = this.cursorToRegional(cursor);
        }
        db.close();

        return regional;
    }

    public ArrayList<Regional> getAll() {
        String sql = "SELECT regional.* FROM regional";
        return findByQuery(sql);
    }

    private Regional cursorToRegional(Cursor cursor) {
        Regional regional = new Regional();
        regional.setId_regional(cursor.getLong(cursor.getColumnIndex("id_regional")));
        regional.setNome(cursor.getString(cursor.getColumnIndex("nome_regional")));
        regional.setEndereco(cursor.getString(cursor.getColumnIndex("endereco_regional")));

        return regional;
    }

    public ArrayList<Regional> findByQuery(String sql) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<Regional> list = new ArrayList<Regional>();

        if (cursor.moveToFirst()) {
            do {
                Regional obj = this.cursorToRegional(cursor);
                list.add(obj);
            } while(cursor.moveToNext());
        }
        db.close();

        return list;
    }

    public void createRegionais(){

        if (this.getRegionalById(1) == null) {
            System.out.println("Cadastrando Regionais ....");

            Regional regional1 = new Regional();
            regional1.setNome("SECRETARIA REGIONAL I");
            regional1.setEndereco("Rua Dom Jeronomo, 20 - Otávio Bomfim");

            Regional regional2 = new Regional();
            regional2.setNome("SECRETARIA REGIONAL II");
            regional2.setEndereco("Rua Professor Juraci M Oliveira, 1 - Edson Queiroz");

            Regional regional3 = new Regional();
            regional3.setNome("SECRETARIA REGIONAL III");
            regional3.setEndereco("Av. Jovita Feitosa, 1264 - Parquelândia");

            Regional regional4 = new Regional();
            regional4.setNome("SECRETARIA REGIONAL IV");
            regional4.setEndereco("Avenida Dedé Brasil, 3770 - Serrinha");

            Regional regional5 = new Regional();
            regional5.setNome("SECRETARIA REGIONAL V");
            regional5.setEndereco("Av. Augusto dos Anjos, 2466 - São Bento");

            Regional regional6 = new Regional();
            regional6.setNome("SECRETARIA REGIONAL VI");
            regional6.setEndereco("R. Padre Pedro de Alencar, 789-797 - Messejana");

            this.insertRegional(regional1);
            this.insertRegional(regional2);
            this.insertRegional(regional3);
            this.insertRegional(regional4);
            this.insertRegional(regional5);
            this.insertRegional(regional6);
        }

    }

}
