package collections.mapeamento;
// Generated 06/07/2014 13:30:02 by Hibernate Tools 3.2.1.GA



public class TaFraseAlertaBula   {


   
     private TbIndicacaoTerapeuticaMedicamento tbIndicacaoTerapeuticaMedicamento;
     private TdFraseAlerta tdFraseAlerta;



    public TaFraseAlertaBula(TbIndicacaoTerapeuticaMedicamento tbIndicacaoTerapeuticaMedicamento, TdFraseAlerta tdFraseAlerta) {
       this.tbIndicacaoTerapeuticaMedicamento = tbIndicacaoTerapeuticaMedicamento;
       this.tdFraseAlerta = tdFraseAlerta;
    }
   
    
    public TbIndicacaoTerapeuticaMedicamento getTbIndicacaoTerapeuticaMedicamento() {
        return this.tbIndicacaoTerapeuticaMedicamento;
    }
    
    public void setTbIndicacaoTerapeuticaMedicamento(TbIndicacaoTerapeuticaMedicamento tbIndicacaoTerapeuticaMedicamento) {
        this.tbIndicacaoTerapeuticaMedicamento = tbIndicacaoTerapeuticaMedicamento;
    }

    public TdFraseAlerta getTdFraseAlerta() {
        return this.tdFraseAlerta;
    }
    
    public void setTdFraseAlerta(TdFraseAlerta tdFraseAlerta) {
        this.tdFraseAlerta = tdFraseAlerta;
    }




}


