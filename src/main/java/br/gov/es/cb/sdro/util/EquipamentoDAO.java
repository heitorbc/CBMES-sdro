/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.es.cb.sdro.util;

import br.gov.es.cb.sdro.model.Equipamento;
import br.gov.es.cb.sdro.model.Unidade;
import br.gov.es.cb.sdro.model.Viatura;
import java.util.List;

/**
 *
 * @author Heitor
 */
public class EquipamentoDAO extends AbstractDAO<Equipamento> {

    Equipamento equipamento;
    List<Equipamento> listaEquipamentos;

    public Equipamento buscaEquipamentoPorNome(String nome) {
        busca = "Equipamento.findByNome";
        parametro = "nome";
        equipamento = buscaPorString(nome);
        return equipamento;
    }

    public List<Equipamento> buscaEquipamentos() {
        busca = "Equipamento.findAll";
        listaEquipamentos = (List<Equipamento>) buscaListaSemParametro();
        return listaEquipamentos;
    }

    public List<Equipamento> buscaEquipamentosDisponiveis() {
        busca = "Equipamento.findAllDisponiveis";
        listaEquipamentos = (List<Equipamento>) buscaListaSemParametro();
        return listaEquipamentos;
    }

    @Override
    public void remove(Equipamento equipamentoRemover) {
        try {
            em.getTransaction().begin();
            Equipamento obj = em.find(equipamentoRemover.getClass(), equipamentoRemover.getIdequipamento());
            em.remove(obj);

            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }

    }

    public boolean update(Equipamento obj) {
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
    }

    public Equipamento buscaEquipamentoPorID(int id) {
        busca = "Equipamento.findByIdequipamento";
        parametro = "idequipamento";
        return buscaPorInteger(id);
    }

    public boolean updateIsAlocado(Equipamento obj) {
        try {
            em.getTransaction().begin();
//                       obj = em.find(obj.getClass(), obj.getIdviatura());
            busca = "Equipamento.UpdateEstadoEquipamento";
            query = em.createNamedQuery(busca);
            String parametro1 = "idviatura";
            String parametro2 = "idequipamento";
            query.setParameter(parametro1, obj.getIdviatura());
            query.setParameter(parametro2, obj.getIdequipamento());
            query.executeUpdate();
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
    }

    public boolean liberaEquipamento(Equipamento obj) {
        try {
            em.getTransaction().begin();
//                       obj = em.find(obj.getClass(), obj.getIdviatura());
            busca = "Equipamento.liberaEquipamento";
            query = em.createNamedQuery(busca);
//                       String parametro1 = "idviatura";
            String parametro2 = "idequipamento";
//                       query.setParameter(parametro1, obj.getIdviatura());
            query.setParameter(parametro2, obj.getIdequipamento());
            query.executeUpdate();
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
    }

    public List<Equipamento> buscaEquipamentosAlocadosViatura(Viatura viatura) {
        busca = "Equipamento.findAllAlocadosViatura";
        parametro = "idViatura";
        query = em.createNamedQuery(busca);
        query.setParameter(parametro, viatura);
        List<Equipamento> listaEquipamentos = query.getResultList();
        return listaEquipamentos;
    }

    @SuppressWarnings("empty-statement")
    public List<Equipamento> buscaEquipamentosDisponiveisUnidade(Unidade unidade) {
        busca = "Equipamento.findAllDisponiveisUnidade";
        parametro = "idUnidade";
        query = em.createNamedQuery(busca);
        query.setParameter(parametro, unidade);
        List<Equipamento> listaEquipamentos = query.getResultList();
        return listaEquipamentos;
    }

}
