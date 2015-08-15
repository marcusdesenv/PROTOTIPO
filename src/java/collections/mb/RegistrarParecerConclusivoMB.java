/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.mb;

import collections.factory.ListasFactory;
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
public class RegistrarParecerConclusivoMB {

   private List<TbMedicamento> medicamentosIndeferidos;
   private List<TbMedicamento> medicamentosNaoAprovados;
   private List<TbMedicamento> medicamentos;
   private TbMedicamento selmedicamento;
   
  
   private int codEmpresa;
   
 
   
   
    public RegistrarParecerConclusivoMB() {
        selmedicamento = new TbMedicamento();
              
        ListasFactory.iniciarPopular();
       
        medicamentos = ListasFactory.getMedicamentos();
        medicamentosIndeferidos = ListasFactory.retornarMedicamentosIndeferidos();
        medicamentosNaoAprovados = ListasFactory.retornarMedicamentosNaoAprovados();
       
        reinit();
        
    }
     public void reinit(){
       medicamentosIndeferidos = ListasFactory.retornarMedicamentosIndeferidos();
        medicamentosNaoAprovados = ListasFactory.retornarMedicamentosNaoAprovados();
        ListasFactory.setMedicamentos(medicamentos);
       
    }
     public void novo(){
        
          selmedicamento = new TbMedicamento();
     }

    

    public void salvarAprovar(){
        selmedicamento = getSelMedicamento();
        selmedicamento.setStsMedicamento("Aprovado");
        TbMedicamento temp = new TbMedicamento(selmedicamento.getTdEmpresa(),selmedicamento.getStsMedicamento(),selmedicamento.getNmeMedicamento());
        medicamentos.set(medicamentos.indexOf(selmedicamento),temp);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem:", "Medicamento aprovado com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        reinit();
    }

   public void salvarIndeferir(){
        selmedicamento = getSelMedicamento();
        selmedicamento.setStsMedicamento("Indeferido");
        TbMedicamento temp = new TbMedicamento(selmedicamento.getTdEmpresa(),selmedicamento.getStsMedicamento(),selmedicamento.getNmeMedicamento());
        medicamentos.set(medicamentos.indexOf(selmedicamento),temp);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem:", "Medicamento indeferido com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        reinit();
    }
   public void salvarRevisao(){
        selmedicamento = getSelMedicamento();
        selmedicamento.setStsMedicamento("Pendente");
        TbMedicamento temp = new TbMedicamento(selmedicamento.getTdEmpresa(),selmedicamento.getStsMedicamento(),selmedicamento.getNmeMedicamento());
        medicamentos.set(medicamentos.indexOf(selmedicamento),temp);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem:", "Medicamento retornado para revisão");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        reinit();
    }

    public List<TbMedicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<TbMedicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public TbMedicamento getSelMedicamento() {
        return selmedicamento;
    }

    public void setSelMedicamento(TbMedicamento selmedicamento) {
        this.selmedicamento = selmedicamento;
    }

 
    public int getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(int codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public List<TbMedicamento> getMedicamentosIndeferidos() {
        return medicamentosIndeferidos;
    }

    public void setMedicamentosIndeferidos(List<TbMedicamento> medicamentosIndeferidos) {
        this.medicamentosIndeferidos = medicamentosIndeferidos;
    }

    public List<TbMedicamento> getMedicamentosNaoAprovados() {
        return medicamentosNaoAprovados;
    }

    public void setMedicamentosNaoAprovados(List<TbMedicamento> medicamentosNaoAprovados) {
        this.medicamentosNaoAprovados = medicamentosNaoAprovados;
    }

    public TbMedicamento getSelmedicamento() {
        return selmedicamento;
    }

    public void setSelmedicamento(TbMedicamento selmedicamento) {
        this.selmedicamento = selmedicamento;
    }

}
