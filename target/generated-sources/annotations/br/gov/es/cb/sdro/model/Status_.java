package br.gov.es.cb.sdro.model;

import br.gov.es.cb.sdro.model.Equipamento;
import br.gov.es.cb.sdro.model.Viatura;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-15T09:25:02")
@StaticMetamodel(Status.class)
public class Status_ { 

    public static volatile ListAttribute<Status, Viatura> viaturaList;
    public static volatile SingularAttribute<Status, Integer> idstatus;
    public static volatile SingularAttribute<Status, String> descricao;
    public static volatile ListAttribute<Status, Equipamento> equipamentoList;

}