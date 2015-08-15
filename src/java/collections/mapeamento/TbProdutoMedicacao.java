package collections.mapeamento;
// Generated 06/07/2014 13:30:02 by Hibernate Tools 3.2.1.GA



public class TbProdutoMedicacao   {


   
     private TbProduto tbProduto;
     private TbCaracterizacaoMedicamento tbCaracterizacaoMedicamento;
     private boolean stsFabricacaoPropria;
     private boolean stsDiluente;
     private boolean stsReconstituente;
     private boolean stsNecessitaReconstituicaoDiluicaoAdministrar;
     private String arqCertificadoPaisOrigem;
    

    public TbProdutoMedicacao() {
    }

	
  
    public TbProdutoMedicacao(TbProduto tbProduto, TbCaracterizacaoMedicamento tbCaracterizacaoMedicamento, boolean stsFabricacaoPropria, boolean stsDiluente, boolean stsReconstituente, boolean stsNecessitaReconstituicaoDiluicaoAdministrar, String arqCertificadoPaisOrigem) {
       this.tbProduto = tbProduto;
       this.tbCaracterizacaoMedicamento = tbCaracterizacaoMedicamento;
       this.stsFabricacaoPropria = stsFabricacaoPropria;
       this.stsDiluente = stsDiluente;
       this.stsReconstituente = stsReconstituente;
       this.stsNecessitaReconstituicaoDiluicaoAdministrar = stsNecessitaReconstituicaoDiluicaoAdministrar;
       this.arqCertificadoPaisOrigem = arqCertificadoPaisOrigem;
      
    }
   
    
    

    public TbProduto getTbProduto() {
        return this.tbProduto;
    }
    
    public void setTbProduto(TbProduto tbProduto) {
        this.tbProduto = tbProduto;
    }

    public TbCaracterizacaoMedicamento getTbCaracterizacaoMedicamento() {
        return this.tbCaracterizacaoMedicamento;
    }
    
    public void setTbCaracterizacaoMedicamento(TbCaracterizacaoMedicamento tbCaracterizacaoMedicamento) {
        this.tbCaracterizacaoMedicamento = tbCaracterizacaoMedicamento;
    }
    
    public boolean isStsFabricacaoPropria() {
        return this.stsFabricacaoPropria;
    }
    
    public void setStsFabricacaoPropria(boolean stsFabricacaoPropria) {
        this.stsFabricacaoPropria = stsFabricacaoPropria;
    }

    public boolean isStsDiluente() {
        return this.stsDiluente;
    }
    
    public void setStsDiluente(boolean stsDiluente) {
        this.stsDiluente = stsDiluente;
    }
    
    public boolean isStsReconstituente() {
        return this.stsReconstituente;
    }
    
    public void setStsReconstituente(boolean stsReconstituente) {
        this.stsReconstituente = stsReconstituente;
    }
    
    public boolean isStsNecessitaReconstituicaoDiluicaoAdministrar() {
        return this.stsNecessitaReconstituicaoDiluicaoAdministrar;
    }
    
    public void setStsNecessitaReconstituicaoDiluicaoAdministrar(boolean stsNecessitaReconstituicaoDiluicaoAdministrar) {
        this.stsNecessitaReconstituicaoDiluicaoAdministrar = stsNecessitaReconstituicaoDiluicaoAdministrar;
    }
    

    public String getArqCertificadoPaisOrigem() {
        return this.arqCertificadoPaisOrigem;
    }
    
    public void setArqCertificadoPaisOrigem(String arqCertificadoPaisOrigem) {
        this.arqCertificadoPaisOrigem = arqCertificadoPaisOrigem;
    }




}


