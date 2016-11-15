package br.gov.es.cb.sdro.model;

import br.gov.es.cb.sdro.model.Categoria;
import br.gov.es.cb.sdro.model.Equipamento;
import br.gov.es.cb.sdro.model.Equipe;
import br.gov.es.cb.sdro.model.Sco;
import br.gov.es.cb.sdro.model.Status;
import br.gov.es.cb.sdro.model.Tipocombustivel;
import br.gov.es.cb.sdro.model.Tipoviatura;
import br.gov.es.cb.sdro.model.Unidade;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-15T09:25:02")
@StaticMetamodel(Viatura.class)
public class Viatura_ { 

    public static volatile SingularAttribute<Viatura, Tipoviatura> idtipoviatura;
    public static volatile SingularAttribute<Viatura, Integer> capagua;
    public static volatile SingularAttribute<Viatura, Integer> idviatura;
    public static volatile SingularAttribute<Viatura, Integer> ano;
    public static volatile SingularAttribute<Viatura, Equipe> idequipe;
    public static volatile SingularAttribute<Viatura, Boolean> isalocado;
    public static volatile SingularAttribute<Viatura, Categoria> idcategoria;
    public static volatile SingularAttribute<Viatura, Integer> cappessoas;
    public static volatile SingularAttribute<Viatura, String> modelo;
    public static volatile ListAttribute<Viatura, Equipamento> equipamentoList;
    public static volatile SingularAttribute<Viatura, String> marca;
    public static volatile SingularAttribute<Viatura, Sco> idsco;
    public static volatile SingularAttribute<Viatura, Tipocombustivel> idtipocombustivel;
    public static volatile SingularAttribute<Viatura, Status> idstatus;
    public static volatile SingularAttribute<Viatura, Unidade> idunidade;
    public static volatile SingularAttribute<Viatura, String> prefixo;
    public static volatile SingularAttribute<Viatura, Boolean> iscbmes;
    public static volatile SingularAttribute<Viatura, String> placa;

}