/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seguranca.dao;

import java.util.List;
import seguranca.model.TbMenu;
import org.hibernate.Query;

/**
 *
 * @author RA21077291
 */
public class TbMenuDAO extends BaseDAO<TbMenu>{
    public List<TbMenu> consultarPorSgl(String sgl) {
        List<TbMenu> lista;
        Query qy = hib.createQuery("SELECT obj FROM " + getClasse().getSimpleName() + " obj WHERE sgl" + getClasse().getSimpleName().substring(2) + " LIKE ? ORDER BY obj.ordMenu");
        qy.setString(0, "%" + sgl + "%");
        lista = qy.list();
        return lista;
    }
    
    public List<TbMenu> consultarPorIdtSistema(Integer idt) {
        List<TbMenu> lista;
        Query qy = hib.createQuery(
                "SELECT obj FROM TbMenu obj WHERE(0=? OR tbSistema.idtSistema=?) ORDER BY obj.ordMenu");
        qy.setInteger(0, idt);
        qy.setInteger(1, idt);
        lista = qy.list();
        return lista;
    }
    
    
}
