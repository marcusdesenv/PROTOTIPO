package collections.mapeamento;



public class TdEmpresa{


 
     private String cnpjEmpresa;
     private String nmeEmpresa;
     private String endEmpresa;
     private String emlEmpresa;
 

    public TdEmpresa() {
    }

	
    public TdEmpresa(String cnpjEmpresa, String nmeEmpresa, String endEmpresa, String emlEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
        this.nmeEmpresa = nmeEmpresa;
        this.endEmpresa = endEmpresa;
        this.emlEmpresa = emlEmpresa;
    }

   
    
    
  
    public String getCnpjEmpresa() {
        return this.cnpjEmpresa;
    }
    
    public void setCnpjEmpresa(String cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }
    
  
    public String getNmeEmpresa() {
        return this.nmeEmpresa;
    }
    
    public void setNmeEmpresa(String nmeEmpresa) {
        this.nmeEmpresa = nmeEmpresa;
    }
    
   
    public String getEndEmpresa() {
        return this.endEmpresa;
    }
    
    public void setEndEmpresa(String endEmpresa) {
        this.endEmpresa = endEmpresa;
    }
    
  
    public String getEmlEmpresa() {
        return this.emlEmpresa;
    }
    
    public void setEmlEmpresa(String emlEmpresa) {
        this.emlEmpresa = emlEmpresa;
    }

   




}


