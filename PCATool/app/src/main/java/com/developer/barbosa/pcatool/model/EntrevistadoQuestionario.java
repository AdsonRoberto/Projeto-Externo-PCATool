package com.developer.barbosa.pcatool.model;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by Bruno Barbosa on 10/01/2017.
 */

@Table
public class EntrevistadoQuestionario extends SugarRecord{

    private Entrevistado entrevistado;

    private Questionario questionario;

    public EntrevistadoQuestionario() {  }

    public EntrevistadoQuestionario(Entrevistado entrevistado, Questionario questionario) {
        this.entrevistado = entrevistado;
        this.questionario = questionario;
    }

    public Entrevistado getEntrevistado() {
        return entrevistado;
    }

    public void setEntrevistado(Entrevistado entrevistado) {
        this.entrevistado = entrevistado;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }
}
