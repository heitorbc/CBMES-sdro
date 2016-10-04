/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.es.cb.sdro.util;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 *
 * @author Heitor
 * @param <T>
 */
public class AbstractDAO<T> implements DAO<T>{
    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("br.gov.es.cb_sdro-desk_jar_1.0-SNAPSHOTPU");
    protected EntityManager em = emf.createEntityManager();
    protected Query query;
    public String busca, parametro;
    
    @Override
    public void save(T objeto){
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
    }
    
    @Override
    public void remove(T objeto){
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
    }
    
    @Override
    public T buscaPorString(String palavraChave){
        query = em.createNamedQuery(busca);
        query.setParameter(parametro, palavraChave);
        T obj = (T) query.getSingleResult();
        return obj;
    }
    
    @Override
    public List buscaListaSemParametro(){
        query = em.createNamedQuery(busca);
        List<Object> listOfObj = query.getResultList();
        return listOfObj;
    }
    
    @Override
    public List buscaListaComParametro(Object objeto){
        query = em.createNamedQuery(busca);
        query.setParameter(parametro, objeto);
        List<Object> listOfObj = query.getResultList();
        return listOfObj;
    }
    
}
