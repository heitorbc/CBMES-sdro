/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.es.cb.sdro.util;

import br.gov.es.cb.sdro.model.Unidade;
import java.util.List;



/**
 *
 * @author Heitor
 */
public class UnidadesDAO extends AbstractDAO<Unidade>{
    Unidade unidade;
    List<Unidade> listaUnidades;
    
    public Unidade buscaUnidadePorNome(String nome) {
        busca = "Unidade.findByNome";
        parametro = "nome";
        unidade = buscaPorString(nome);
        return unidade;
    }
    
    public List<Unidade> buscaUnidades(){
        busca = "Unidade.findAll";
        listaUnidades = (List<Unidade>) buscaListaSemParametro();
        return listaUnidades;
    }
}
