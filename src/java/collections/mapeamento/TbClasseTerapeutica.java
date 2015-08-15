package collections.mapeamento;
// Generated 06/07/2014 13:30:02 by Hibernate Tools 3.2.1.GA



public class TbClasseTerapeutica   {


     
     private String codClasseTerapeutica;
     private String dscClasseTerapeutica;
     

    public TbClasseTerapeutica() {
    }

	
    public TbClasseTerapeutica(String codClasseTerapeutica) {
        this.codClasseTerapeutica = codClasseTerapeutica;
    }
    public TbClasseTerapeutica(String codClasseTerapeutica, String dscClasseTerapeutica) {
       this.codClasseTerapeutica = codClasseTerapeutica;
       this.dscClasseTerapeutica = dscClasseTerapeutica;
       
    }
   
     
  
    
    
    public String getCodClasseTerapeutica() {
        return this.codClasseTerapeutica;
    }
    
    public void setCodClasseTerapeutica(String codClasseTerapeutica) {
        this.codClasseTerapeutica = codClasseTerapeutica;
    }
    
    
    public String getDscClasseTerapeutica() {
        return this.dscClasseTerapeutica;
    }
    
    public void setDscClasseTerapeutica(String dscClasseTerapeutica) {
        this.dscClasseTerapeutica = dscClasseTerapeutica;
    }





}


