package seguranca.mb;

import java.sql.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import seguranca.dao.TbMenuDAO;
import seguranca.dao.TbSistemaDAO;
import seguranca.model.TbMenu;
import seguranca.model.TbSistema;

@ManagedBean
@ViewScoped
/*CRUD de Menus*/
public class MenuMB {

    private boolean incluirNovo;
    private int idtSistema;
    private Date data;
    private String usuario;
    private List<TbMenu> menus;
    private TbMenu tbMenu;
    private List<TbSistema> sistemas;
    TbMenuDAO tbMenuDAO = new TbMenuDAO();

    public MenuMB() {
        incluirNovo = false;
        usuario = LoginBean.nome;
        data = new Date(System.currentTimeMillis());
        idtSistema = 0;
        tbMenu = new TbMenu();
        TbSistemaDAO tbSistemaDAO = new TbSistemaDAO();
        sistemas = tbSistemaDAO.consultarTodos();
        filtrar();
    }

    public void filtrar() {
        menus = tbMenuDAO.consultarPorIdtSistema(idtSistema);
    }

    public void novo() {
        incluirNovo = true;
        idtSistema = 0;
        tbMenu = new TbMenu();
        tbMenu.setIdtMenu(0);
        tbMenu.setDtaMenuCad(data);
        tbMenu.setUsrMenuCad(usuario);
    }

    public void salvar() {
        if (incluirNovo == false) {
            tbMenu.setDtaMenuMod(data);
            tbMenu.setUsrMenuMod(usuario);
        }
        TbSistemaDAO tbSistemaDAO = new TbSistemaDAO();
        tbMenu.setTbSistema(tbSistemaDAO.consultarPorIdt(idtSistema));
        if (tbMenu.getIdtMenu() == 0) {
            //Incluir
            tbMenu.setIdtMenu(null);
            tbMenuDAO.incluir(tbMenu);
        } else {
            // Alterar
            tbMenuDAO.juntar(tbMenu);
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Gravação", "Atualização efetivada na base de dados.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        idtSistema = tbMenu.getTbSistema().getIdtSistema();
        incluirNovo = false;
        filtrar();
    }

    public void excluir() {
        idtSistema = 0;
        if (tbMenu.getIdtMenu() != 0) {
            if (tbMenuDAO.excluir(tbMenu.getIdtMenu())) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Exclusão", "Exclusão efetuada com sucesso.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resultado da Exclusão", "Não foi possível excluir.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
        filtrar();
    }

    public int getIdtSistema() {
        return idtSistema;
    }

    public void setIdtSistema(int idtSistema) {
        this.idtSistema = idtSistema;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<TbMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<TbMenu> menus) {
        this.menus = menus;
    }

    public TbMenu getTbMenu() {
        return tbMenu;
    }

    public void setTbMenu(TbMenu tbMenu) {
        this.tbMenu = tbMenu;
        idtSistema = tbMenu.getTbSistema().getIdtSistema();
    }

    public List<TbSistema> getSistemas() {
        return sistemas;
    }

    public void setSistemas(List<TbSistema> sistemas) {
        this.sistemas = sistemas;
    }

    public boolean isIncluirNovo() {
        return incluirNovo;
    }

    public void setIncluirNovo(boolean incluirNovo) {
        this.incluirNovo = incluirNovo;
    }
}
