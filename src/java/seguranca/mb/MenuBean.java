package seguranca.mb;

import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import seguranca.dao.MenuDAO;
import seguranca.dao.OpcaoDAO;
import seguranca.model.TbMenu;
import seguranca.model.TbOpcao;

@ManagedBean
@ViewScoped
public class MenuBean {

    private MenuModel model;
    private String username;
    private String password;

    /* MenuBean é a Classe Responsável pela Geração do Menu Conforme o Usuário 
     * Logado sendo a mesma atualizada constantemente durante a Execução do Prototipo.*/
    public MenuBean() {
        OpcaoDAO opcaoDAO = new OpcaoDAO();
        MenuDAO menuDAO = new MenuDAO();
        model = new DefaultMenuModel();
        username = LoginBean.nome;
        password = LoginBean.senha;
        List<TbMenu> TbMenu = menuDAO.gerarMenu(username, password);
        
        for (Iterator<TbMenu> it = TbMenu.iterator(); it.hasNext();) {
            DefaultSubMenu submenu = new DefaultSubMenu();
            TbMenu tbMenu = it.next();
            submenu.setLabel(tbMenu.getSglMenu());
            List<TbOpcao> TbOpcao = opcaoDAO.gerarOpcoes(tbMenu.getIdtMenu(), username, password);
            for (Iterator<TbOpcao> it2 = TbOpcao.iterator(); it2.hasNext();) {
                TbOpcao tbOpcao = it2.next();
                DefaultMenuItem item = new DefaultMenuItem();
                item.setValue(tbOpcao.getSglOpcao());
                item.setUrl(tbOpcao.getUrlOpcao() + ".xhtml");
                submenu.addElement(item);
           }
            model.addElement(submenu);
        }
    }

    public MenuModel getModel() {
        return model;
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
