package collections.mapeamento;
// Generated 06/07/2014 13:30:02 by Hibernate Tools 3.2.1.GA



public class TaViaAdministracaoMedicamento  implements java.io.Serializable {


    
     private TdViaAdministracao tdViaAdministracao;
     private TbCaracterizacaoMedicamento tbCaracterizacaoMedicamento;

    public TaViaAdministracaoMedicamento() {
    }

    public TaViaAdministracaoMedicamento(TdViaAdministracao tdViaAdministracao, TbCaracterizacaoMedicamento tbCaracterizacaoMedicamento) {
       this.tdViaAdministracao = tdViaAdministracao;
       this.tbCaracterizacaoMedicamento = tbCaracterizacaoMedicamento;
    }
   
   
  

    public TdViaAdministracao getTdViaAdministracao() {
        return this.tdViaAdministracao;
    }
    
    public void setTdViaAdministracao(TdViaAdministracao tdViaAdministracao) {
        this.tdViaAdministracao = tdViaAdministracao;
    }

    public TbCaracterizacaoMedicamento getTbCaracterizacaoMedicamento() {
        return this.tbCaracterizacaoMedicamento;
    }
    
    public void setTbCaracterizacaoMedicamento(TbCaracterizacaoMedicamento tbCaracterizacaoMedicamento) {
        this.tbCaracterizacaoMedicamento = tbCaracterizacaoMedicamento;
    }




}


