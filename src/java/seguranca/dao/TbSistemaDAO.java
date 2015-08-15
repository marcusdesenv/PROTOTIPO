/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seguranca.dao;

import java.util.List;
import seguranca.model.TbSistema;
import org.hibernate.Query;
import org.primefaces.component.tabview.Tab;

/**
 *
 * @author RA21077291
 */
public class TbSistemaDAO extends BaseDAO<TbSistema>{
    
    public List<TbSistema> consultarPorVrs(String vrs) {
        List<TbSistema> lista;
        Query qy = hib.createQuery("SELECT obj FROM " + getClasse().getSimpleName() + " obj WHERE vrs" + getClasse().getSimpleName().substring(2) + " LIKE ?");
        qy.setString(0, "%" + vrs + "%");
        lista = qy.list();
        return lista;
    }
    public List<TbSistema> consultarPorSgl(String sgl) {
        List<TbSistema> lista;
        Query qy = hib.createQuery("SELECT obj FROM " + getClasse().getSimpleName() + " obj WHERE sgl" + getClasse().getSimpleName().substring(2) + " LIKE ?");
        qy.setString(0, "%" + sgl + "%");
        lista = qy.list();
        return lista;
    }
    public List<TbSistema> consultarPorUsrMod(String usrmod) {
        List<TbSistema> lista;
        Query qy = hib.createQuery("SELECT obj FROM " + getClasse().getSimpleName() + " obj WHERE usrmod" + getClasse().getSimpleName().substring(2) + " LIKE ?");
        qy.setString(0, "%" + usrmod + "%");
        lista = qy.list();
        return lista;
    }
    public List<TbSistema> consultarPorUsrCad(String usrcad) {
        List<TbSistema> lista;
        Query qy = hib.createQuery("SELECT obj FROM " + getClasse().getSimpleName() + " obj WHERE usrcad" + getClasse().getSimpleName().substring(2) + " LIKE ?");
        qy.setString(0, "%" + usrcad + "%");
        lista = qy.list();
        return lista;
    }
    
}
