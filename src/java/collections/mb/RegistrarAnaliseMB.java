/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.mb;

import collections.factory.ListasFactory;
import collections.mapeamento.TbAnaliseMedicamento;
import collections.mapeamento.TbColaborador;
import collections.mapeamento.TbMedicamento;
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
public class RegistrarAnaliseMB {

    private List<TbMedicamento> medicamentos;
    private TbAnaliseMedicamento selAnaliseMed ;
    private List<TbAnaliseMedicamento> analisesMed;
    private TbMedicamento selMedicamento;
    private List<TbColaborador> colaboradores;
    private TbColaborador selColaborador;
    private int codMedicamento;
    private int codColaborador;

    public RegistrarAnaliseMB() {
      
        ListasFactory.iniciarPopular();
        medicamentos = ListasFactory.getMedicamentos();
        analisesMed = ListasFactory.getAnalisesMed();
        colaboradores = ListasFactory.getColaboradores();
        selAnaliseMed = new  TbAnaliseMedicamento();
        reinit();

    }

    public void reinit() {
       ListasFactory.setAnalisesMed(analisesMed);
        ListasFactory.setMedicamentos(medicamentos);

    }

    public void novo() {
        selAnaliseMed = new TbAnaliseMedicamento();
        analisesMed = ListasFactory.getAnalisesMed();
        codColaborador = 0;
        codMedicamento = 0;
    }
    public void alterar() {
        selAnaliseMed = ListasFactory.retornarAnalise(selAnaliseMed,codMedicamento,codColaborador);
        analisesMed = ListasFactory.getAnalisesMed();   
    }

    

    public void salvar() {
  
        selAnaliseMed.setTbMedicamento(medicamentos.get(codMedicamento));
        selAnaliseMed.setTbColaborador(colaboradores.get(codColaborador));
        TbAnaliseMedicamento temp = new TbAnaliseMedicamento(selAnaliseMed.getTbColaborador(), selAnaliseMed.getTbMedicamento(), selAnaliseMed.getRelatorioAnaliseMedicamento(), selAnaliseMed.getTipoAnaliseMedicamento(), selAnaliseMed.getDesAnaliseMedicamento());  
        try {analisesMed.set(analisesMed.indexOf(selAnaliseMed), temp);
            
        } catch (Exception e) {
            analisesMed.add(temp);
        }
        
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem:", "Modo de Uso atualizadas com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        reinit();
    }

    public TbColaborador getSelColaborador() {
        return selColaborador;
    }

    public void setSelColaborador(TbColaborador selColaborador) {
        this.selColaborador = selColaborador;
    }

    public List<TbMedicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<TbMedicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public TbAnaliseMedicamento getSelAnaliseMed() {
        return selAnaliseMed;
    }

    public void setSelAnaliseMed(TbAnaliseMedicamento selAnaliseMed) {
        this.selAnaliseMed = selAnaliseMed;
    }

    public List<TbAnaliseMedicamento> getAnalisesMed() {
        return analisesMed;
    }

    public void setAnalisesMed(List<TbAnaliseMedicamento> analisesMed) {
        this.analisesMed = analisesMed;
    }

    public TbMedicamento getSelMedicamento() {
        return selMedicamento;
    }

    public void setSelMedicamento(TbMedicamento selMedicamento) {
        this.selMedicamento = selMedicamento;
    }

    public List<TbColaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(List<TbColaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public int getCodMedicamento() {
        return codMedicamento;
    }

    public void setCodMedicamento(int codMedicamento) {
        this.codMedicamento = codMedicamento;
    }

    public int getCodColaborador() {
        return codColaborador;
    }

    public void setCodColaborador(int codColaborador) {
        this.codColaborador = codColaborador;
    }

}
