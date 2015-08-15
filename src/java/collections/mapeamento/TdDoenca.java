package collections.mapeamento;
// Generated 06/07/2014 13:30:02 by Hibernate Tools 3.2.1.GA



public class TdDoenca   {


    
     private String codCid;
     private String nmeDoenca;
   

    public TdDoenca() {
    }

	
    public TdDoenca( String codCid, String nmeDoenca) {
        
        this.codCid = codCid;
        this.nmeDoenca = nmeDoenca;
    }
    
   
    
    
    
    public String getCodCid() {
        return this.codCid;
    }
    
    public void setCodCid(String codCid) {
        this.codCid = codCid;
    }
    
    
    public String getNmeDoenca() {
        return this.nmeDoenca;
    }
    
    public void setNmeDoenca(String nmeDoenca) {
        this.nmeDoenca = nmeDoenca;
    }




}


