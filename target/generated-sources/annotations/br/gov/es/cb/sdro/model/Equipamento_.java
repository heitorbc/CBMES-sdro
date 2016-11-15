package br.gov.es.cb.sdro.model;

import br.gov.es.cb.sdro.model.Status;
import br.gov.es.cb.sdro.model.Unidade;
import br.gov.es.cb.sdro.model.Viatura;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-15T09:25:02")
@StaticMetamodel(Equipamento.class)
public class Equipamento_ { 

    public static volatile SingularAttribute<Equipamento, String> marca;
    public static volatile SingularAttribute<Equipamento, Viatura> idviatura;
    public static volatile SingularAttribute<Equipamento, Status> idstatus;
    public static volatile SingularAttribute<Equipamento, Boolean> isalocado;
    public static volatile SingularAttribute<Equipamento, Unidade> idunidade;
    public static volatile SingularAttribute<Equipamento, String> nome;
    public static volatile SingularAttribute<Equipamento, Integer> idequipamento;

}