package collections.mapeamento;
// Generated 06/07/2014 13:30:02 by Hibernate Tools 3.2.1.GA


public class TbCaracterizacaoMedicamento   {


     private Integer idtCaracterizacaoMedicamento;
     private TbRestricaoPrescricao tbRestricaoPrescricao;
     private TbMedicamento tbMedicamento;
     private TbClasseTerapeutica tbClasseTerapeutica;
    
     private String catReguladora;
     private String nmeComercial;
     private int tmpConservacaoDoMedicamentoMin;
     private int tmpConservacaoDoMedicamentoMax;
     private String dscCuidadosAdicionais;
   

    public TbCaracterizacaoMedicamento() {
    }

	
    public TbCaracterizacaoMedicamento(TbMedicamento tbMedicamento,String catReguladora) {
        
        this.tbMedicamento = tbMedicamento;
       this.catReguladora = catReguladora;
       
    }
    public TbCaracterizacaoMedicamento(TbRestricaoPrescricao tbRestricaoPrescricao, TbMedicamento tbMedicamento, TbClasseTerapeutica tbClasseTerapeutica, String catReguladora, String nmeComercial, int tmpConservacaoDoMedicamentoMin, int tmpConservacaoDoMedicamentoMax, String dscCuidadosAdicionais) {
       this.tbRestricaoPrescricao = tbRestricaoPrescricao;
       this.tbMedicamento = tbMedicamento;
       this.tbClasseTerapeutica = tbClasseTerapeutica;
     
       this.catReguladora = catReguladora;
       this.nmeComercial = nmeComercial;
       this.tmpConservacaoDoMedicamentoMin = tmpConservacaoDoMedicamentoMin;
       this.tmpConservacaoDoMedicamentoMax = tmpConservacaoDoMedicamentoMax;
       this.dscCuidadosAdicionais = dscCuidadosAdicionais;
      
    }
   
  
    public Integer getIdtCaracterizacaoMedicamento() {
        return this.idtCaracterizacaoMedicamento;
    }
    
    public void setIdtCaracterizacaoMedicamento(Integer idtCaracterizacaoMedicamento) {
        this.idtCaracterizacaoMedicamento = idtCaracterizacaoMedicamento;
    }

    public TbRestricaoPrescricao getTbRestricaoPrescricao() {
        return this.tbRestricaoPrescricao;
    }
    
    public void setTbRestricaoPrescricao(TbRestricaoPrescricao tbRestricaoPrescricao) {
        this.tbRestricaoPrescricao = tbRestricaoPrescricao;
    }

    public TbMedicamento getTbMedicamento() {
        return this.tbMedicamento;
    }
    
    public void setTbMedicamento(TbMedicamento tbMedicamento) {
        this.tbMedicamento = tbMedicamento;
    }

    public TbClasseTerapeutica getTbClasseTerapeutica() {
        return this.tbClasseTerapeutica;
    }
    
    public void setTbClasseTerapeutica(TbClasseTerapeutica tbClasseTerapeutica) {
        this.tbClasseTerapeutica = tbClasseTerapeutica;
    }
    
    
  
   
    public String getCatReguladora() {
        return this.catReguladora;
    }
    
    public void setCatReguladora(String catReguladora) {
        this.catReguladora = catReguladora;
    }
    
   
    public String getNmeComercial() {
        return this.nmeComercial;
    }
    
    public void setNmeComercial(String nmeComercial) {
        this.nmeComercial = nmeComercial;
    }
    
   
    public int getTmpConservacaoDoMedicamentoMin() {
        return this.tmpConservacaoDoMedicamentoMin;
    }
    
    public void setTmpConservacaoDoMedicamentoMin(int tmpConservacaoDoMedicamentoMin) {
        this.tmpConservacaoDoMedicamentoMin = tmpConservacaoDoMedicamentoMin;
    }
    
    
    public int getTmpConservacaoDoMedicamentoMax() {
        return this.tmpConservacaoDoMedicamentoMax;
    }
    
    public void setTmpConservacaoDoMedicamentoMax(int tmpConservacaoDoMedicamentoMax) {
        this.tmpConservacaoDoMedicamentoMax = tmpConservacaoDoMedicamentoMax;
    }
    
    
    public String getDscCuidadosAdicionais() {
        return this.dscCuidadosAdicionais;
    }
    
    public void setDscCuidadosAdicionais(String dscCuidadosAdicionais) {
        this.dscCuidadosAdicionais = dscCuidadosAdicionais;
    }




}


