package seguranca.mb;


import java.sql.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import seguranca.dao.TbSistemaDAO;
import seguranca.model.TbSistema;

@ManagedBean
@ViewScoped
public class SistemaMB {
    private boolean incluirNovo;
    private Date data;
    private String usuario;
    private String nmeSistema;
    private List<TbSistema> sistemas;
    private TbSistema tbSistema;
    
    public SistemaMB(){
        incluirNovo = false;
        usuario = LoginBean.nome;        
        data = new Date(System.currentTimeMillis());
        nmeSistema="";
        tbSistema = new TbSistema();
        filtrar();
       
    }
    
    public void filtrar(){        
        TbSistemaDAO tbSistemaDAO = new TbSistemaDAO();
        sistemas=tbSistemaDAO.consultarPorNme(nmeSistema);
    }
    
    public void novo() {
        incluirNovo = true;
        tbSistema = new TbSistema();
        tbSistema.setIdtSistema(0);
        tbSistema.setDtaSistemaCad(data);
        tbSistema.setUsrSistemaCad(usuario);
    }
    
    public void salvar() {
        TbSistemaDAO tbSistemaDAO = new TbSistemaDAO();
        if(incluirNovo == false){
        tbSistema.setDtaSistemaMod(data);
        tbSistema.setUsrSistemaMod(usuario);
        }
        if (tbSistema.getIdtSistema() == 0) {
            //Incluir
            tbSistema.setIdtSistema(null);
            tbSistemaDAO.incluir(tbSistema);
        } else {
            // Alterar
            tbSistemaDAO.juntar(tbSistema);
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Gravação", "Atualização efetivada na base de dados.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        incluirNovo = false;
        filtrar();
    }
    
    public void excluir(){
        TbSistemaDAO tbSistemaDAO = new TbSistemaDAO();
        if (tbSistema.getIdtSistema() != 0) {
            if (tbSistemaDAO.excluir(tbSistema.getIdtSistema())) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Exclusão", "Exclusão efetuada com sucesso.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resultado da Exclusão", "Não foi possível excluir.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
        filtrar();
    }

    public boolean isIncluirNovo() {
        return incluirNovo;
    }

    public void setIncluirNovo(boolean incluirNovo) {
        this.incluirNovo = incluirNovo;
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

    public String getNmeSistema() {
        return nmeSistema;
    }

    public void setNmeSistema(String nmeSistema) {
        this.nmeSistema = nmeSistema;
    }

    public List<TbSistema> getSistemas() {
        return sistemas;
    }

    public void setSistemas(List<TbSistema> sistemas) {
        this.sistemas = sistemas;
    }

    public TbSistema getTbSistema() {
        return tbSistema;
    }

    public void setTbSistema(TbSistema tbSistema) {
        this.tbSistema = tbSistema;
    }

}
