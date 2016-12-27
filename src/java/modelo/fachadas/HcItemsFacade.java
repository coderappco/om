/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.fachadas;

import java.util.List;
import javax.ejb.Stateless;
import modelo.entidades.CfgClasificaciones;
import modelo.entidades.HcItems;
import modelo.entidades.HcRegistro;

/**
 *
 * @author santos
 */
@Stateless
public class HcItemsFacade extends AbstractFacade<HcItems> {
    
    public HcItemsFacade() {
        super(HcItems.class);
    }
    
    public List<HcItems> findByIdRegistro(HcRegistro idRegistro) {
        try {
            String hql = "SELECT c FROM HcItems c WHERE c.idRegistro = :idRegistro order by c.idItem ASC";
            return getEntityManager().createQuery(hql).setParameter("idRegistro", idRegistro).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
