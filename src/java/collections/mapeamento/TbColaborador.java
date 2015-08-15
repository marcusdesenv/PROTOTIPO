package collections.mapeamento;
// Generated 06/07/2014 13:30:02 by Hibernate Tools 3.2.1.GA



public class TbColaborador   {


     private Integer idColaborador;
     private String nmeColaborador;
     private String cpfColaborador;
     private String cepColaborador;
     private String logradouroColaborador;
     private String telColaborador;
     private String rgColaborador;
     private int codCargo;
     private String tipoColaborador;
     private Float vlrSalario;
   

    public TbColaborador() {
    }

	
    public TbColaborador(String nmeColaborador, String cpfColaborador,  String tipoColaborador) {
        this.nmeColaborador = nmeColaborador;
        this.cpfColaborador = cpfColaborador;
        this.tipoColaborador = tipoColaborador;
    }
    public TbColaborador(String nmeColaborador, String cpfColaborador, String cepColaborador, String logradouroColaborador, String telColaborador, String rgColaborador, int codCargo, String tipoColaborador, Float vlrSalario) {
       this.nmeColaborador = nmeColaborador;
       this.cpfColaborador = cpfColaborador;
       this.cepColaborador = cepColaborador;
       this.logradouroColaborador = logradouroColaborador;
       this.telColaborador = telColaborador;
       this.rgColaborador = rgColaborador;
       this.codCargo = codCargo;
       this.tipoColaborador = tipoColaborador;
       this.vlrSalario = vlrSalario;
       
    }
   
   
    public Integer getIdColaborador() {
        return this.idColaborador;
    }
    
    public void setIdColaborador(Integer idColaborador) {
        this.idColaborador = idColaborador;
    }
    
 
    public String getNmeColaborador() {
        return this.nmeColaborador;
    }
    
    public void setNmeColaborador(String nmeColaborador) {
        this.nmeColaborador = nmeColaborador;
    }
    
   
    public String getCpfColaborador() {
        return this.cpfColaborador;
    }
    
    public void setCpfColaborador(String cpfColaborador) {
        this.cpfColaborador = cpfColaborador;
    }
    
   
    public String getCepColaborador() {
        return this.cepColaborador;
    }
    
    public void setCepColaborador(String cepColaborador) {
        this.cepColaborador = cepColaborador;
    }
    
  
    public String getLogradouroColaborador() {
        return this.logradouroColaborador;
    }
    
    public void setLogradouroColaborador(String logradouroColaborador) {
        this.logradouroColaborador = logradouroColaborador;
    }
    
  
    public String getTelColaborador() {
        return this.telColaborador;
    }
    
    public void setTelColaborador(String telColaborador) {
        this.telColaborador = telColaborador;
    }
    
    public String getRgColaborador() {
        return this.rgColaborador;
    }
    
    public void setRgColaborador(String rgColaborador) {
        this.rgColaborador = rgColaborador;
    }
    
  
    public int getCodCargo() {
        return this.codCargo;
    }
    
    public void setCodCargo(int codCargo) {
        this.codCargo = codCargo;
    }
    
   
    public String getTipoColaborador() {
        return this.tipoColaborador;
    }
    
    public void setTipoColaborador(String tipoColaborador) {
        this.tipoColaborador = tipoColaborador;
    }
    
   
    public Float getVlrSalario() {
        return this.vlrSalario;
    }
    
    public void setVlrSalario(Float vlrSalario) {
        this.vlrSalario = vlrSalario;
    }





}


