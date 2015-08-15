package seguranca.mb;

import seguranca.dao.OpcaoDAO;
import seguranca.dao.TbUsuarioDAO;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import seguranca.model.TbOpcao;
import seguranca.model.TbUsuario;
import org.primefaces.context.RequestContext;
import seguranca.dao.TbSistemaDAO;
import seguranca.model.TbSistema;

@ManagedBean
@SessionScoped
/*Classe Responsável pela Verificação do Login e Acesso a paginas.*/
public class LoginBean {

    static String nome;
    static String senha;
    static String nomeSistema;
    public String username;
    public String password;
    public String nomeUsuario;
    private List<TbUsuario> pessoas;
    static Boolean logado;
    public String sistema;

    /*O metodo verificarLogin confere se o Usuário está logado e se tem acesso a pagina.*/
    public boolean verificarLogin(String opcao) {
        OpcaoDAO opcaoDAO = new OpcaoDAO();
        boolean opEx = false;
        if (logado != false) {
            List<TbOpcao> TbOpcao = opcaoDAO.verificarOpcao(nome, senha);
            for (Iterator<TbOpcao> it2 = TbOpcao.iterator(); it2.hasNext();) {
                TbOpcao tbOpcao = it2.next();
                if (tbOpcao.getUrlOpcao().equals(opcao)) {
                    opEx = true;
                }
            }
        } else {
            opEx = false;
        }
        return opEx;
    }

    public void logout() {
        logado = false;
    }

    public void login() {
        TbUsuarioDAO tbUsuarioDAO = new TbUsuarioDAO();
        RequestContext context = RequestContext.getCurrentInstance();
        TbSistemaDAO tbSistemaDAO = new TbSistemaDAO();
        FacesMessage msg;
        boolean loggedIn = false;
        List<TbSistema> sistemas = tbSistemaDAO.consultarTodos();
        for (Iterator<TbSistema> it = sistemas.iterator(); it.hasNext();) {
            TbSistema tbSistema = it.next();
            sistema = tbSistema.getNmeSistema();
        }
        List<TbUsuario> TbUsuarios = tbUsuarioDAO.fazerLogin(username, password);
        msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Usuario não está cadastrado");
        for (Iterator<TbUsuario> it = TbUsuarios.iterator(); it.hasNext();) {
            TbUsuario tbUsuario = it.next();
            if (username != null && username.equals(tbUsuario.getUsrUsuario()) && password != null && password.equals(tbUsuario.getPwdUsuario())) {
                loggedIn = true;
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem Vindo", username);
                nome = username;
                senha = password;
                logado = loggedIn;
                nomeUsuario = tbUsuario.getNmeUsuario();
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public List<TbUsuario> getUsuarios() {
        return pessoas;
    }

    public void setUsuarios(List<TbUsuario> pessoas) {
        this.pessoas = pessoas;
    }
}
