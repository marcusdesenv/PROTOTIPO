package collections.mapeamento;
// Generated 06/07/2014 13:30:02 by Hibernate Tools 3.2.1.GA


public class TaIndicacaoPosologia   {


    
     private TbIndicacaoTerapeuticaMedicamento tbIndicacaoTerapeuticaMedicamento;
     private TdDoenca tdDoenca;
     private TdObjetivoTerapeutico tdObjetivoTerapeutico;
     private String compIndicacaoTerapeuticaTecnica;
     private String compIndicacaoTerapeuticaParaPaciente;
     private String dosePadrao;
     private String doseInicial;
     private String doseManutencao;

    public TaIndicacaoPosologia() {
    }

	
    public TaIndicacaoPosologia(TbIndicacaoTerapeuticaMedicamento tbIndicacaoTerapeuticaMedicamento, TdDoenca tdDoenca, TdObjetivoTerapeutico tdObjetivoTerapeutico) {
        this.tbIndicacaoTerapeuticaMedicamento = tbIndicacaoTerapeuticaMedicamento;
        this.tdDoenca = tdDoenca;
        this.tdObjetivoTerapeutico = tdObjetivoTerapeutico;
    }
    public TaIndicacaoPosologia(TbIndicacaoTerapeuticaMedicamento tbIndicacaoTerapeuticaMedicamento, TdDoenca tdDoenca, TdObjetivoTerapeutico tdObjetivoTerapeutico, String compIndicacaoTerapeuticaTecnica, String compIndicacaoTerapeuticaParaPaciente, String dosePadrao, String doseInicial, String doseManutencao) {
       this.tbIndicacaoTerapeuticaMedicamento = tbIndicacaoTerapeuticaMedicamento;
       this.tdDoenca = tdDoenca;
       this.tdObjetivoTerapeutico = tdObjetivoTerapeutico;
       this.compIndicacaoTerapeuticaTecnica = compIndicacaoTerapeuticaTecnica;
       this.compIndicacaoTerapeuticaParaPaciente = compIndicacaoTerapeuticaParaPaciente;
       this.dosePadrao = dosePadrao;
       this.doseInicial = doseInicial;
       this.doseManutencao = doseManutencao;
    }
   
   

    public TbIndicacaoTerapeuticaMedicamento getTbIndicacaoTerapeuticaMedicamento() {
        return this.tbIndicacaoTerapeuticaMedicamento;
    }
    
    public void setTbIndicacaoTerapeuticaMedicamento(TbIndicacaoTerapeuticaMedicamento tbIndicacaoTerapeuticaMedicamento) {
        this.tbIndicacaoTerapeuticaMedicamento = tbIndicacaoTerapeuticaMedicamento;
    }

    public TdDoenca getTdDoenca() {
        return this.tdDoenca;
    }
    
    public void setTdDoenca(TdDoenca tdDoenca) {
        this.tdDoenca = tdDoenca;
    }

    public TdObjetivoTerapeutico getTdObjetivoTerapeutico() {
        return this.tdObjetivoTerapeutico;
    }
    
    public void setTdObjetivoTerapeutico(TdObjetivoTerapeutico tdObjetivoTerapeutico) {
        this.tdObjetivoTerapeutico = tdObjetivoTerapeutico;
    }
    

    public String getCompIndicacaoTerapeuticaTecnica() {
        return this.compIndicacaoTerapeuticaTecnica;
    }
    
    public void setCompIndicacaoTerapeuticaTecnica(String compIndicacaoTerapeuticaTecnica) {
        this.compIndicacaoTerapeuticaTecnica = compIndicacaoTerapeuticaTecnica;
    }

    public String getCompIndicacaoTerapeuticaParaPaciente() {
        return this.compIndicacaoTerapeuticaParaPaciente;
    }
    
    public void setCompIndicacaoTerapeuticaParaPaciente(String compIndicacaoTerapeuticaParaPaciente) {
        this.compIndicacaoTerapeuticaParaPaciente = compIndicacaoTerapeuticaParaPaciente;
    }
    

    public String getDosePadrao() {
        return this.dosePadrao;
    }
    
    public void setDosePadrao(String dosePadrao) {
        this.dosePadrao = dosePadrao;
    }
    

    public String getDoseInicial() {
        return this.doseInicial;
    }
    
    public void setDoseInicial(String doseInicial) {
        this.doseInicial = doseInicial;
    }
    

    public String getDoseManutencao() {
        return this.doseManutencao;
    }
    
    public void setDoseManutencao(String doseManutencao) {
        this.doseManutencao = doseManutencao;
    }




}


