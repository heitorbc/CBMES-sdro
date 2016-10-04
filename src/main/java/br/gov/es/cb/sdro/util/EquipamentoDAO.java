/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.es.cb.sdro.util;

import java.util.List;

/**
 *
 * @author Heitor
 */
public class EquipamentoDAO  extends AbstractDAO<EquipamentoDAO>{
    EquipamentoDAO equipamento;
    List<EquipamentoDAO> listaEquipamentos;
    
    public EquipamentoDAO buscaEquipamentoPorNome(String nome) {
        busca = "Equipamento.findByNome";
        parametro = "nome";
        equipamento = buscaPorString(nome);
        return equipamento;
    }
    
    public List<EquipamentoDAO> buscaEquipamentos(){
        busca = "Equipamento.findAll";
        listaEquipamentos = (List<EquipamentoDAO>) buscaListaSemParametro();
        return listaEquipamentos;
    }
}
