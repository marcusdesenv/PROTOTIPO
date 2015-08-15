/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.mb;

import collections.factory.ListasFactory;
import collections.mapeamento.TbMedicamento;
import collections.mapeamento.TbModoDeUsoMedicamento;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Avell B153
 */
@ManagedBean
@ApplicationScoped
public class ManterModoUsoMB {

   
    private List<TbMedicamento> medicamentos;
    private TbModoDeUsoMedicamento selModoUso ;
    private List<TbModoDeUsoMedicamento> modosUso;
    private TbMedicamento selMedicamento;
    private int codMedicamento;

    public ManterModoUsoMB() {
      
        ListasFactory.iniciarPopular();
        medicamentos = ListasFactory.getMedicamentos();
        modosUso = ListasFactory.getModosDeUso();
        reinit();

    }

    public void reinit() {
       ListasFactory.setModosDeUso(modosUso);
        ListasFactory.setMedicamentos(medicamentos);

    }

    public void novo() {
        selModoUso = ListasFactory.retornarModoUso(selMedicamento,codMedicamento);
        modosUso = ListasFactory.getModosDeUso();   
    }

    

    public void salvar() {
  
        selModoUso.setTbMedicamento(selMedicamento);
        TbModoDeUsoMedicamento temp = new TbModoDeUsoMedicamento(selModoUso.getTbMedicamento(),selModoUso.getModPreparo() ,selModoUso.getModAdministracao(),selModoUso.getSintSuperdosagem() ,selModoUso.getCondEmSuperdosagem());  
        try {modosUso.set(modosUso.indexOf(selModoUso), temp);
            
        } catch (Exception e) {
            modosUso.add(temp);
        }
        
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem:", "Modo de Uso atualizadas com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        reinit();
    }

   

    public List<TbMedicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<TbMedicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public TbModoDeUsoMedicamento getSelModoUso() {
        return selModoUso;
    }

    public void setSelModoUso(TbModoDeUsoMedicamento selModoUso) {
        this.selModoUso = selModoUso;
    }

    public List<TbModoDeUsoMedicamento> getModosUso() {
        return modosUso;
    }

    public void setModosUso(List<TbModoDeUsoMedicamento> modosUso) {
        this.modosUso = modosUso;
    }

    public TbMedicamento getSelMedicamento() {
        return selMedicamento;
    }

    public void setSelMedicamento(TbMedicamento selMedicamento) {
        this.selMedicamento = selMedicamento;
    }

    public int getCodMedicamento() {
        return codMedicamento;
    }

    public void setCodMedicamento(int codMedicamento) {
        this.codMedicamento = codMedicamento;
    }

}
