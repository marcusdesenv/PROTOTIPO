package collections.mapeamento;
// Generated 06/07/2014 13:30:02 by Hibernate Tools 3.2.1.GA


public class TbProduto   {


     private int idtProduto;
     private TbComposicao tbComposicao;
     private String arqMudancaDuranteDesenv;
     private String nmeProduto;
     private String stsProduto;
    

    public TbProduto() {
    }

	
    public TbProduto( TbComposicao tbComposicao, String stsProduto, String nmeProduto) {
       
        this.tbComposicao = tbComposicao;
        this.stsProduto = stsProduto;
        this.nmeProduto = nmeProduto;
    }
    public TbProduto( TbComposicao tbComposicao, String arqMudancaDuranteDesenv, String stsProduto, String nmeProduto) {
       
       this.tbComposicao = tbComposicao;
       this.arqMudancaDuranteDesenv = arqMudancaDuranteDesenv;
       this.stsProduto = stsProduto;
       this.nmeProduto = nmeProduto;
      
    }
   
     
    public int getIdtProduto() {
        return this.idtProduto;
    }
    
    public void setIdtProduto(int idtProduto) {
        this.idtProduto = idtProduto;
    }

    public TbComposicao getTbComposicao() {
        return this.tbComposicao;
    }
    
    public void setTbComposicao(TbComposicao tbComposicao) {
        this.tbComposicao = tbComposicao;
    }
    
 
    public String getArqMudancaDuranteDesenv() {
        return this.arqMudancaDuranteDesenv;
    }
    
    public void setArqMudancaDuranteDesenv(String arqMudancaDuranteDesenv) {
        this.arqMudancaDuranteDesenv = arqMudancaDuranteDesenv;
    }

    public String getStsProduto() {
        return stsProduto;
    }

    public void setStsProduto(String stsProduto) {
        this.stsProduto = stsProduto;
    }

  
    
 

  

   

    public String getNmeProduto() {
        return nmeProduto;
    }

    public void setNmeProduto(String nmeProduto) {
        this.nmeProduto = nmeProduto;
    }




}


