package br.gov.es.cb.sdro.model;

import br.gov.es.cb.sdro.model.Equipe;
import br.gov.es.cb.sdro.model.SafoFuncionario;
import br.gov.es.cb.sdro.model.Unidade;
import br.gov.es.cb.sdro.model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-15T09:25:02")
@StaticMetamodel(Militar.class)
public class Militar_ { 

    public static volatile SingularAttribute<Militar, Equipe> idequipe;
    public static volatile ListAttribute<Militar, Usuario> usuarioList;
    public static volatile SingularAttribute<Militar, SafoFuncionario> safoIdfuncionario;
    public static volatile SingularAttribute<Militar, Boolean> isalocado;
    public static volatile SingularAttribute<Militar, Unidade> idunidade;
    public static volatile SingularAttribute<Militar, Integer> idmilitar;

}