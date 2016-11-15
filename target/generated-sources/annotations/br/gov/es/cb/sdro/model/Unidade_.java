package br.gov.es.cb.sdro.model;

import br.gov.es.cb.sdro.model.Equipamento;
import br.gov.es.cb.sdro.model.Equipe;
import br.gov.es.cb.sdro.model.Militar;
import br.gov.es.cb.sdro.model.Viatura;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-15T09:25:02")
@StaticMetamodel(Unidade.class)
public class Unidade_ { 

    public static volatile ListAttribute<Unidade, Viatura> viaturaList;
    public static volatile SingularAttribute<Unidade, Integer> idsubcomandante;
    public static volatile ListAttribute<Unidade, Militar> militarList;
    public static volatile SingularAttribute<Unidade, Integer> idunidade;
    public static volatile SingularAttribute<Unidade, Integer> idcomandante;
    public static volatile SingularAttribute<Unidade, String> nome;
    public static volatile ListAttribute<Unidade, Equipe> equipeList;
    public static volatile ListAttribute<Unidade, Equipamento> equipamentoList;

}