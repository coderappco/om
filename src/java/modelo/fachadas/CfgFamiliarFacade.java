/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.fachadas;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.entidades.CfgFamiliar;
import modelo.entidades.CfgPacientes;

/**
 *
 * @author Luis
 */
@Stateless
public class CfgFamiliarFacade extends AbstractFacade<CfgFamiliar> {

    public List<CfgFamiliar> consultaNativaPacientes(String sql) {
        List<CfgFamiliar> lista = (List<CfgFamiliar>) getEntityManager().createNativeQuery(sql, CfgFamiliar.class).getResultList();
        return lista;
    }   
    
    public List<CfgFamiliar> findFamiliaresByPaciente(CfgPacientes idpaciente) {
        try {
            Query query = getEntityManager().createQuery("SELECT c FROM CfgFamiliar c WHERE c.idPaciente = ?1 ");
            query.setParameter(1, idpaciente);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


    public CfgFamiliarFacade() {
        super(CfgFamiliar.class);
    }

    
    public EntityManager obtenerEntityManager() {
        return getEntityManager();
    }

}
