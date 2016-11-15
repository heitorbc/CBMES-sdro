package br.gov.es.cb.sdro.model;

import br.gov.es.cb.sdro.model.SafoFuncionario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-15T09:25:02")
@StaticMetamodel(SafoLotacao.class)
public class SafoLotacao_ { 

    public static volatile SingularAttribute<SafoLotacao, String> atual;
    public static volatile SingularAttribute<SafoLotacao, Integer> funcaoqdi;
    public static volatile SingularAttribute<SafoLotacao, Date> dataUltAlteracao;
    public static volatile SingularAttribute<SafoLotacao, Integer> idlotacao;
    public static volatile SingularAttribute<SafoLotacao, Date> dataFim;
    public static volatile SingularAttribute<SafoLotacao, String> substituicao;
    public static volatile SingularAttribute<SafoLotacao, Date> dataInicio;
    public static volatile SingularAttribute<SafoLotacao, Integer> funcionario;
    public static volatile SingularAttribute<SafoLotacao, Integer> local;
    public static volatile ListAttribute<SafoLotacao, SafoFuncionario> safoFuncionarioList;
    public static volatile SingularAttribute<SafoLotacao, String> usuarioUltAlteracao;
    public static volatile SingularAttribute<SafoLotacao, Integer> versao;

}