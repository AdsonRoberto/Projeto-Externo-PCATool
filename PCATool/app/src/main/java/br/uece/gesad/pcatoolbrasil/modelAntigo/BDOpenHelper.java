package br.uece.gesad.pcatoolbrasil.modelAntigo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Messias on 25/04/2017.
 */

public abstract class BDOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Database_PCATool";
    private Context context;

    public static final String TABELA_REGIONAL = "regional";
    public static final String ID_REGIONAL = "id_regional";
    public static final String NOME_REGIONAL = "nome_regional";
    public static final String ENDERECO_REGIONAL = "endereco_regional";

    public static final String TABELA_POSTO = "posto";
    public static final String ID_POSTO = "id_posto";
    public static final String NOME_POSTO = "nome_posto";
    public static final String ENDERECO_POSTO = "endereco_posto";

    public static final String TABELA_QUESTAO = "questao";
    public static final String ID_QUESTAO = "id_questao";
    public static final String NUMERO_QUESTAO= "numero_questao";
    public static final String DESCRICAO_QUESTAO = "descricao_questao";

    public static final String TABELA_ENTREVISTADO = "entrevistado";
    public static final String ID_ENTREVISTADO = "id_entrevistado";
    public static final String NOME_ENTREVISTADO = "nome_entrevistado";
    public static final String SEXO_ENTREVISTADO = "sexo_entrevistado";
    public static final String DATA_NASCIMENTO = "data_nascimento";

    public static final String TABELA_QUESTIONARIO = "questionario";
    public static final String ID_QUESTIONARIO = "id_questionario";
    public static final String DATA_REALIZACAO = "data_realizacao";
    public static final String TIPO_QUESTIONARIO = "tipo_questionario";

    public static final String TABELA_RESPOSTA = "resposta";
    public static final String ID_RESPOSTA = "id_resposta";
    public static final String OPCAO_RESPOTA = "opcao_resposta";
    public static final String NOME_PROF_SERV = "nome_profissional_servico";
    public static final String ENDERECO_RESPOSTA = "endereco_resposta";

    public BDOpenHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_REGIONAL = "CREATE TABLE IF NOT EXISTS " + TABELA_REGIONAL + "(" +
                ID_REGIONAL + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                NOME_REGIONAL + " TEXT," +
                ENDERECO_REGIONAL + " TEXT)";
        db.execSQL(CREATE_TABLE_REGIONAL);

        String CREATE_TABLE_POSTO = "CREATE TABLE IF NOT EXISTS " + TABELA_POSTO + "(" +
                ID_POSTO + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ID_REGIONAL + " INTEGER NOT NULL," +
                NOME_POSTO + " TEXT," +
                ENDERECO_POSTO + " TEXT)";
        db.execSQL(CREATE_TABLE_POSTO);

        String CREATE_TABLE_QUESTAO = "CREATE TABLE IF NOT EXISTS " + TABELA_QUESTAO + "(" +
                ID_QUESTAO + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                NUMERO_QUESTAO + " TEXT NOT NULL," +
                DESCRICAO_QUESTAO + " TEXT)";
        db.execSQL(CREATE_TABLE_QUESTAO);

        String CREATE_TABLE_ENTREVISTADO = "CREATE TABLE IF NOT EXISTS " + TABELA_ENTREVISTADO + "(" +
                ID_ENTREVISTADO + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                NOME_ENTREVISTADO + " TEX," +
                SEXO_ENTREVISTADO + " TEX," +
                DATA_NASCIMENTO + " TEXT)";
        db.execSQL(CREATE_TABLE_ENTREVISTADO);

        String CREATE_TABLE_QUESTIONARIO = "CREATE TABLE IF NOT EXISTS " + TABELA_QUESTIONARIO + "(" +
                ID_QUESTIONARIO + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ID_ENTREVISTADO + " INTEGER NOT NULL," +
                ID_POSTO + " INTEGER NOT NULL," +
                DATA_REALIZACAO + " TEXT," +
                TIPO_QUESTIONARIO + " TEXT)";
        db.execSQL(CREATE_TABLE_QUESTIONARIO);

        String CREATE_TABLE_RESPOSTA = "CREATE TABLE IF NOT EXISTS " + TABELA_RESPOSTA + "(" +
                ID_RESPOSTA + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ID_QUESTAO + " INTEGER NOT NULL," +
                ID_QUESTIONARIO + " INTEGER NOT NULL," +
                OPCAO_RESPOTA + " INTEGER," +
                NOME_PROF_SERV + " TEXT," +
                ENDERECO_RESPOSTA + " TEXT)";
        db.execSQL(CREATE_TABLE_RESPOSTA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_RESPOSTA);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_QUESTIONARIO);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_ENTREVISTADO);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_QUESTAO);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_POSTO);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_REGIONAL);
        this.onCreate(db);
    }

}
