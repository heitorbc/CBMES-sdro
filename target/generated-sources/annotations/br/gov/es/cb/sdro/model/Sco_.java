package br.gov.es.cb.sdro.model;

import br.gov.es.cb.sdro.model.Equipe;
import br.gov.es.cb.sdro.model.Viatura;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-15T09:25:02")
@StaticMetamodel(Sco.class)
public class Sco_ { 

    public static volatile SingularAttribute<Sco, Date> datainicio;
    public static volatile ListAttribute<Sco, Viatura> viaturaList;
    public static volatile SingularAttribute<Sco, Integer> idfuncionarioplanejamento;
    public static volatile SingularAttribute<Sco, Integer> idsco;
    public static volatile SingularAttribute<Sco, Integer> idfuncionarioadministracao;
    public static volatile SingularAttribute<Sco, Date> datafim;
    public static volatile SingularAttribute<Sco, Integer> idfuncionariologistica;
    public static volatile SingularAttribute<Sco, String> nome;
    public static volatile ListAttribute<Sco, Equipe> equipeList;
    public static volatile SingularAttribute<Sco, Integer> idfuncionariooperacoes;
    public static volatile SingularAttribute<Sco, String> local;
    public static volatile SingularAttribute<Sco, Integer> idfuncionariocomando;

}