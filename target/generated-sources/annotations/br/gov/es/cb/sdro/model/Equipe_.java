package br.gov.es.cb.sdro.model;

import br.gov.es.cb.sdro.model.Empenho;
import br.gov.es.cb.sdro.model.Militar;
import br.gov.es.cb.sdro.model.Sco;
import br.gov.es.cb.sdro.model.Unidade;
import br.gov.es.cb.sdro.model.Viatura;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-15T09:25:02")
@StaticMetamodel(Equipe.class)
public class Equipe_ { 

    public static volatile ListAttribute<Equipe, Viatura> viaturaList;
    public static volatile SingularAttribute<Equipe, Sco> idsco;
    public static volatile SingularAttribute<Equipe, Integer> idequipe;
    public static volatile ListAttribute<Equipe, Militar> militarList;
    public static volatile SingularAttribute<Equipe, Unidade> idunidade;
    public static volatile ListAttribute<Equipe, Empenho> empenhoList;
    public static volatile SingularAttribute<Equipe, String> descricao;

}