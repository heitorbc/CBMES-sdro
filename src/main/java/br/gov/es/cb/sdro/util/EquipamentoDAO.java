/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.es.cb.sdro.util;

import br.gov.es.cb.sdro.model.Equipamento;
import java.util.List;
/**
 *
 * @author Heitor
 */
public class EquipamentoDAO  extends AbstractDAO<Equipamento>{
    Equipamento equipamento;
    List<Equipamento> listaEquipamentos;
  
    
    public Equipamento buscaEquipamentoPorNome(String nome) {
        busca = "Equipamento.findByNome";
        parametro = "nome";
        equipamento = buscaPorString(nome);
        return equipamento;
    }
    
    public List<Equipamento> buscaEquipamentos(){
        busca = "Equipamento.findAll";
        listaEquipamentos = (List<Equipamento>) buscaListaSemParametro();
        return listaEquipamentos;
    }
     @Override
    public boolean remove(Equipamento obj) {
              try {
                       em.getTransaction().begin();
                       obj = em.find(obj.getClass(),obj.getIdequipamento());
                       em.remove(obj);
                       
                       em.getTransaction().commit();
                       return true;
              } catch (Exception ex) {
                       ex.printStackTrace();
                       em.getTransaction().rollback();
              }
              return false;
    }
  
     public boolean update(Equipamento obj) {
                     try {
                              em.getTransaction().begin();
                              em.merge(obj);
                              em.getTransaction().commit();
                              return true;
                     } catch (Exception ex) {
                              ex.printStackTrace();
                              em.getTransaction().rollback();
                     }
                     return false;
           }

   
}
