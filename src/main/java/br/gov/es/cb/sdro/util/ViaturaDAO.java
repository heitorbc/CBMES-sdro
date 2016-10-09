/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.es.cb.sdro.util;

import br.gov.es.cb.sdro.model.Viatura;
import java.util.List;

/**
 *
 * @author Heitor
 */
public class ViaturaDAO extends AbstractDAO<Viatura>{
    Viatura viatura;
    List<Viatura> listaViaturas;
    
    public Viatura buscaViaturaPorNome(String nome) {
        busca = "Viatura.findByNome";
        parametro = "nome";
        viatura = buscaPorString(nome);
        return viatura;
    }
    
    public List<Viatura> buscaViaturas(){
        busca = "Viatura.findAll";
        listaViaturas = (List<Viatura>) buscaListaSemParametro();
        return listaViaturas;
    }
    
     public List<Viatura> buscaViaturasDisponiveis(){
        busca = "Viatura.findAllDisponiveis";
        listaViaturas = (List<Viatura>) buscaListaSemParametro();
        return listaViaturas;
    }
    public Viatura buscaViaturaPorID(int id){
      busca =  "Viatura.findByIdviatura";
      parametro = "idviatura";
      return buscaPorInteger(id);
    }
      
    public boolean update(Viatura obj) {
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
    @Override
    public boolean remove(Viatura obj) {
              try {
                       em.getTransaction().begin();
                       obj = em.find(obj.getClass(), obj.getIdviatura());
                       em.remove(obj);
                       em.getTransaction().commit();
                       return true;
              } catch (Exception ex) {
                       ex.printStackTrace();
                       em.getTransaction().rollback();
              }
              return false;
    }
}
