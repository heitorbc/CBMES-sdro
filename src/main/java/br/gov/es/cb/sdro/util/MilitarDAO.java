/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.es.cb.sdro.util;

import br.gov.es.cb.sdro.model.Militar;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author Heitor
 */
public class MilitarDAO extends AbstractDAO<Militar> {

    Militar militar;
    List<Militar> listaMilitars;

    public Militar buscaMilitarPorNome(String nome) {
        busca = "Militar.findByNome";
        parametro = "nome";
        militar = buscaPorString(nome);
        return militar;
    }

    public List<Militar> buscaMilitars() {
        busca = "Militar.findAll";
        listaMilitars = (List<Militar>) buscaListaSemParametro();
        return listaMilitars;
    }

    public List<Militar> buscaMilitarsPorGraducao(String nome) {
        busca = "Militar.findByPostoGraducao";
        parametro = "idgraducao";
        listaMilitars = (List<Militar>) buscaListaComParametro(nome);
        return listaMilitars;
    }

    public Militar buscaMilitarPorId(Integer id) {
        try {
            busca = "Militar.findByIdmilitar";
            parametro = "idmilitar";
            militar = buscaPorInteger(id);
            return militar;
        } catch (NoResultException e) {
            return null;
        }
    }
}
