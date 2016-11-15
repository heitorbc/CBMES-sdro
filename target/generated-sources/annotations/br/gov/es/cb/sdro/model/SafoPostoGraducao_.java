package br.gov.es.cb.sdro.model;

import br.gov.es.cb.sdro.model.SafoFuncionario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-15T09:25:02")
@StaticMetamodel(SafoPostoGraducao.class)
public class SafoPostoGraducao_ { 

    public static volatile SingularAttribute<SafoPostoGraducao, Date> dataUltAlteracao;
    public static volatile SingularAttribute<SafoPostoGraducao, String> numeroOrdem;
    public static volatile SingularAttribute<SafoPostoGraducao, String> abreviacao;
    public static volatile SingularAttribute<SafoPostoGraducao, Integer> idpostograducao;
    public static volatile SingularAttribute<SafoPostoGraducao, String> usuarioUltAlteracao;
    public static volatile SingularAttribute<SafoPostoGraducao, Integer> versao;
    public static volatile ListAttribute<SafoPostoGraducao, SafoFuncionario> safoFuncionarioList;
    public static volatile SingularAttribute<SafoPostoGraducao, String> descricao;

}