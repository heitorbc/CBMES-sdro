package br.gov.es.cb.sdro.model;

import br.gov.es.cb.sdro.model.Equipe;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-15T09:25:02")
@StaticMetamodel(Empenho.class)
public class Empenho_ { 

    public static volatile SingularAttribute<Empenho, Date> datainicio;
    public static volatile SingularAttribute<Empenho, Equipe> idequipe;
    public static volatile SingularAttribute<Empenho, Date> datafim;
    public static volatile SingularAttribute<Empenho, Integer> idempenho;
    public static volatile SingularAttribute<Empenho, String> descricao;

}