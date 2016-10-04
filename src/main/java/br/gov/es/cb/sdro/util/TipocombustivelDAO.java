/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.es.cb.sdro.util;

import br.gov.es.cb.sdro.model.Tipocombustivel;

/**
 *
 * @author Heitor
 */
public class TipocombustivelDAO extends AbstractDAO<Tipocombustivel>{
    private Tipocombustivel tipocombustivel;
    
    public Tipocombustivel buscaTipoCombustivelPorNome(String nome) {
        busca = "Tipocombustivel.findByDescricao";
        parametro = "descricao";
        tipocombustivel = buscaPorString(nome);
        return tipocombustivel;
    }
    
}
