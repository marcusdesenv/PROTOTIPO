package collections.mapeamento;
// Generated 06/07/2014 13:30:02 by Hibernate Tools 3.2.1.GA


public class TbMedicamento   {


    
     private TdEmpresa tdEmpresa;
     private String stsMedicamento;
     private String nmeMedicamento;
    

    public TbMedicamento() {
    }

	
    public TbMedicamento(TdEmpresa tdEmpresa, String stsMedicamento, String nmeMedicamento ) {
        this.tdEmpresa = tdEmpresa;
        this.stsMedicamento = stsMedicamento;
       this.nmeMedicamento = nmeMedicamento;
        
    }

    public String getNmeMedicamento() {
        return nmeMedicamento;
    }

    public void setNmeMedicamento(String nmeMedicamento) {
        this.nmeMedicamento = nmeMedicamento;
    }
   
   

    public TdEmpresa getTdEmpresa() {
        return this.tdEmpresa;
    }
    
    public void setTdEmpresa(TdEmpresa tdEmpresa) {
        this.tdEmpresa = tdEmpresa;
    }
    
  
    public String getStsMedicamento() {
        return this.stsMedicamento;
    }
    
    public void setStsMedicamento(String stsMedicamento) {
        this.stsMedicamento = stsMedicamento;
    }




}


