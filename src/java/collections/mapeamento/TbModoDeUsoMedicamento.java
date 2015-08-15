package collections.mapeamento;
// Generated 06/07/2014 13:30:02 by Hibernate Tools 3.2.1.GA



public class TbModoDeUsoMedicamento  {


  
     private TbMedicamento tbMedicamento;
     private String modPreparo;
     private String modAdministracao;
     private String sintSuperdosagem;
     private String condEmSuperdosagem;

    public TbModoDeUsoMedicamento() {
    }

	
  
    public TbModoDeUsoMedicamento(TbMedicamento tbMedicamento, String modPreparo, String modAdministracao, String sintSuperdosagem, String condEmSuperdosagem) {
       this.tbMedicamento = tbMedicamento;
       this.modPreparo = modPreparo;
       this.modAdministracao = modAdministracao;
       this.sintSuperdosagem = sintSuperdosagem;
       this.condEmSuperdosagem = condEmSuperdosagem;
    }
   
  
    
    public TbMedicamento getTbMedicamento() {
        return this.tbMedicamento;
    }
    
    public void setTbMedicamento(TbMedicamento tbMedicamento) {
        this.tbMedicamento = tbMedicamento;
    }
    
   
    public String getModPreparo() {
        return this.modPreparo;
    }
    
    public void setModPreparo(String modPreparo) {
        this.modPreparo = modPreparo;
    }
    
    
    public String getModAdministracao() {
        return this.modAdministracao;
    }
    
    public void setModAdministracao(String modAdministracao) {
        this.modAdministracao = modAdministracao;
    }
    
   
    public String getSintSuperdosagem() {
        return this.sintSuperdosagem;
    }
    
    public void setSintSuperdosagem(String sintSuperdosagem) {
        this.sintSuperdosagem = sintSuperdosagem;
    }
    
    
    public String getCondEmSuperdosagem() {
        return this.condEmSuperdosagem;
    }
    
    public void setCondEmSuperdosagem(String condEmSuperdosagem) {
        this.condEmSuperdosagem = condEmSuperdosagem;
    }




}


