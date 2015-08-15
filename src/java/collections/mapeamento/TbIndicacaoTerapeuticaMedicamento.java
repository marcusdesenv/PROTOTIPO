package collections.mapeamento;
// Generated 06/07/2014 13:30:02 by Hibernate Tools 3.2.1.GA


public class TbIndicacaoTerapeuticaMedicamento  {


     private Integer idtIndicacaoTerapeuticaMedicamento;
     private TdRestricaoDeUso tdRestricaoDeUso;
     private TbUnidadeMedida tbUnidadeMedida;
     private TbMedicamento tbMedicamento;
     private String limMaxDiario;
     private String tempMedInicioAcao;
     private String arqBulaPaciente;
     private String arqBulaProfissional;
   

    public TbIndicacaoTerapeuticaMedicamento() {
    }

	
    public TbIndicacaoTerapeuticaMedicamento(TbMedicamento tbMedicamento) {
       
        this.tbMedicamento = tbMedicamento;
       
    }
   
    public TbIndicacaoTerapeuticaMedicamento(TdRestricaoDeUso tdRestricaoDeUso, TbUnidadeMedida tbUnidadeMedida, TbMedicamento tbMedicamento, String limMaxDiario, String tempMedInicioAcao, String arqBulaPaciente, String arqBulaProfissional) {
       this.tdRestricaoDeUso = tdRestricaoDeUso;
       this.tbUnidadeMedida = tbUnidadeMedida;
       this.tbMedicamento = tbMedicamento;
       this.limMaxDiario = limMaxDiario;
       this.tempMedInicioAcao = tempMedInicioAcao;
       this.arqBulaPaciente = arqBulaPaciente;
       this.arqBulaProfissional = arqBulaProfissional;
     
    }
   
   
    public Integer getIdtIndicacaoTerapeuticaMedicamento() {
        return this.idtIndicacaoTerapeuticaMedicamento;
    }
    
    public void setIdtIndicacaoTerapeuticaMedicamento(Integer idtIndicacaoTerapeuticaMedicamento) {
        this.idtIndicacaoTerapeuticaMedicamento = idtIndicacaoTerapeuticaMedicamento;
    }

    public TdRestricaoDeUso getTdRestricaoDeUso() {
        return this.tdRestricaoDeUso;
    }
    
    public void setTdRestricaoDeUso(TdRestricaoDeUso tdRestricaoDeUso) {
        this.tdRestricaoDeUso = tdRestricaoDeUso;
    }

    public TbUnidadeMedida getTbUnidadeMedida() {
        return this.tbUnidadeMedida;
    }
    
    public void setTbUnidadeMedida(TbUnidadeMedida tbUnidadeMedida) {
        this.tbUnidadeMedida = tbUnidadeMedida;
    }

    public TbMedicamento getTbMedicamento() {
        return this.tbMedicamento;
    }
    
    public void setTbMedicamento(TbMedicamento tbMedicamento) {
        this.tbMedicamento = tbMedicamento;
    }
    
    
    public String getLimMaxDiario() {
        return this.limMaxDiario;
    }
    
    public void setLimMaxDiario(String limMaxDiario) {
        this.limMaxDiario = limMaxDiario;
    }
    
   
    public String getTempMedInicioAcao() {
        return this.tempMedInicioAcao;
    }
    
    public void setTempMedInicioAcao(String tempMedInicioAcao) {
        this.tempMedInicioAcao = tempMedInicioAcao;
    }
    
   
    public String getArqBulaPaciente() {
        return this.arqBulaPaciente;
    }
    
    public void setArqBulaPaciente(String arqBulaPaciente) {
        this.arqBulaPaciente = arqBulaPaciente;
    }
    
  
    public String getArqBulaProfissional() {
        return this.arqBulaProfissional;
    }
    
    public void setArqBulaProfissional(String arqBulaProfissional) {
        this.arqBulaProfissional = arqBulaProfissional;
    }




}


