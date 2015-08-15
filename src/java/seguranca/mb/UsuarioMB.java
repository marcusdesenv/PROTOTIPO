package seguranca.mb;

import java.sql.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import seguranca.dao.TbPerfilDAO;
import seguranca.dao.TbUsuarioDAO;
import seguranca.model.TbPerfil;
import seguranca.model.TbUsuario;

@ManagedBean
@ViewScoped
public class UsuarioMB {

   
    private boolean incluirNovo;
    private int idtPerfil;
    private Date data;
    private String usuario;
    private List<TbUsuario> usuarios;
    private TbUsuario tbUsuario;
    private List<TbPerfil> perfis;

    private String nomeUsuario;
    
    public UsuarioMB(){
        incluirNovo = false;
        usuario = LoginBean.nome;        
        data = new Date(System.currentTimeMillis());
        idtPerfil = 0;
        nomeUsuario ="";
        tbUsuario = new TbUsuario();
        TbPerfilDAO tbPerfilDAO = new TbPerfilDAO();
        perfis = tbPerfilDAO.consultarTodos();
        filtrar();
    }
    
    public void filtrar(){
        TbUsuarioDAO tbUsuarioDAO = new TbUsuarioDAO();
        usuarios = tbUsuarioDAO.consultarPorIdtPerfilePorNome(idtPerfil, nomeUsuario);
    }
    
    public void novo() {
        idtPerfil =0;
        nomeUsuario ="";
        tbUsuario = new TbUsuario();
        tbUsuario.setIdtUsuario(0);
        tbUsuario.setDtaUsuarioCad(data);
        tbUsuario.setUsrUsuarioCad(usuario);
        incluirNovo = true;
    }
    
    public void salvar() {
        TbUsuarioDAO tbUsuarioDAO = new TbUsuarioDAO();
//        if(incluirNovo == false){            
//        tbUsuario.setDtaUsuarioMod(data);
//        tbUsuario.setUsrUsuarioMod(usuario);
//        }
        TbPerfilDAO tbPerfilDAO = new TbPerfilDAO();
        tbUsuario.setTbPerfil(tbPerfilDAO.consultarPorIdt(idtPerfil));
        if (tbUsuario.getIdtUsuario() == 0) {
            //Incluir
            tbUsuario.setIdtUsuario(null);
            tbUsuarioDAO.incluir(tbUsuario);
        } else {
            // Alterar
            tbUsuarioDAO.juntar(tbUsuario);
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Gravação", "Atualização efetivada na base de dados.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        idtPerfil = tbUsuario.getTbPerfil().getIdtPerfil();
        incluirNovo = false;
        filtrar();
    }
    
    public void excluir() {
        idtPerfil=0;
        TbUsuarioDAO tbUsuarioDAO = new TbUsuarioDAO();
        if (tbUsuario.getIdtUsuario() != 0) {
            if (tbUsuarioDAO.excluir(tbUsuario.getIdtUsuario())) {
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

     public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    public int getIdtPerfil() {
        return idtPerfil;
    }

    public void setIdtPerfil(int idtPerfil) {
        this.idtPerfil = idtPerfil;
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

    public List<TbUsuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<TbUsuario> usuarios) {
        this.usuarios = usuarios;
    }

    public TbUsuario getTbUsuario() {
        return tbUsuario;
    }

    public void setTbUsuario(TbUsuario tbUsuario) {
        this.tbUsuario = tbUsuario;
        idtPerfil = tbUsuario.getTbPerfil().getIdtPerfil();
    }

    public List<TbPerfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<TbPerfil> perfis) {
        this.perfis = perfis;
    }
    }

