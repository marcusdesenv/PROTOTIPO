/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.mb;

import collections.factory.ListasFactory;
import collections.mapeamento.TbMedicamento;
import collections.mapeamento.TdEmpresa;
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
public final class CadastrarMedicamentoMB {

   private List<TbMedicamento> medicamentos;
   private TbMedicamento selmedicamento;
   private List<TdEmpresa> empresas;
  
   private int codEmpresa;
   
 
   
   
    public CadastrarMedicamentoMB() {
        selmedicamento = new TbMedicamento();
              
        ListasFactory.iniciarPopular();
        medicamentos = ListasFactory.getMedicamentos();
        empresas = ListasFactory.getEmpresas();
        reinit();
        
    }
     public void reinit(){
        
        ListasFactory.setMedicamentos(medicamentos);
       
    }
     public void novo(){
        
          selmedicamento = new TbMedicamento();
     }

    public void adicionar(){
       
        medicamentos.add(new TbMedicamento(empresas.get(codEmpresa), selmedicamento.getStsMedicamento(),selmedicamento.getNmeMedicamento()));
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem:", "Cadastro realizado com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        reinit();
    }

    public void salvar(){
        if(selmedicamento.getStsMedicamento().equals("Aprovado")){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", "O Medicamento já foi aprovado pela Anvisa e não pode ser alterado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        }else{
        selmedicamento = getSelMedicamento();
        TbMedicamento temp = new TbMedicamento(empresas.get(codEmpresa),selmedicamento.getStsMedicamento(),selmedicamento.getNmeMedicamento());
        medicamentos.set(medicamentos.indexOf(selmedicamento),temp);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem:", "Medicamento atualizado com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        reinit();
    }

    public void remover() {
        if(selmedicamento.getStsMedicamento().equals("Aprovado")){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", "O Medicamento já foi aprovado pela Anvisa e não pode ser excluido");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        else{
        medicamentos.remove(selmedicamento);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem", "Excluido com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        }
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

 
    public List<TdEmpresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<TdEmpresa> empresas) {
        this.empresas = empresas;
    }

 
  

    public int getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(int codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

   
    
    
}
