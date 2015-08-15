/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.mb;

import collections.factory.ListasFactory;
import collections.mapeamento.TaFraseAlertaBula;
import collections.mapeamento.TaIndicacaoPosologia;
import collections.mapeamento.TbIndicacaoTerapeuticaMedicamento;
import collections.mapeamento.TbMedicamento;
import collections.mapeamento.TbUnidadeMedida;
import collections.mapeamento.TdDoenca;
import collections.mapeamento.TdFraseAlerta;
import collections.mapeamento.TdObjetivoTerapeutico;
import collections.mapeamento.TdRestricaoDeUso;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Avell B153
 */
@ManagedBean
@ApplicationScoped
public class ManterIndicacaoTerapeuticaMB {

    private List<TbIndicacaoTerapeuticaMedicamento> indicacoesTerapeuticas;
    private TbIndicacaoTerapeuticaMedicamento selIndicacaoTerapeutica;
    private List<TbMedicamento> medicamentos;
    private TbMedicamento selmedicamento;
    int codMedicamento;
    private List<TdRestricaoDeUso> restricoesUso;
    int codRestricaoUso;
    private List<TbUnidadeMedida> unidadesMed;
    int codUnidadeMed;
    private List<TdObjetivoTerapeutico> objetivosTerapeuticos;
    int codObjetivoTerapeutico;
    private List<TdDoenca> doencas;
    int codDoenca;
    private List<TaIndicacaoPosologia> indicacoesSelecionadas;
    private List<TaIndicacaoPosologia> indicacoes;
    private TaIndicacaoPosologia selIndicacaoPosologia;
    int codIndicacaoPosologia;
    private List<TaFraseAlertaBula> frasesBulaSelecionadas;
    private List<TaFraseAlertaBula> frasesBula;
    private TaFraseAlertaBula selFraseAlertaBurla;
    private List<TdFraseAlerta> frasesAlerta;
    int codFraseAlerta;

    public ManterIndicacaoTerapeuticaMB() {
        ListasFactory.iniciarPopular();
        selmedicamento = new TbMedicamento();
        selIndicacaoTerapeutica = new TbIndicacaoTerapeuticaMedicamento();
        medicamentos = ListasFactory.getMedicamentos();
        doencas = ListasFactory.getDoencas();
        unidadesMed = ListasFactory.getUnidadesMedida();
        restricoesUso = ListasFactory.getRestricoesUso();
        frasesAlerta = ListasFactory.getFrasesAlerta();
        indicacoesTerapeuticas = ListasFactory.getIndicacoesTerapeuticas();
        indicacoes = ListasFactory.getIndicacoesPosologia();
        frasesBula = ListasFactory.getFrasesAlertaBula();
        objetivosTerapeuticos = ListasFactory.getObjetivosTerapeuticos();
        reinit();

    }

    public void reinit() {
        ListasFactory.setIndicacoesPosologia(indicacoes);
        ListasFactory.setFrasesAlertaBula(frasesBula);
        ListasFactory.setIndicacoesTerapeuticas(indicacoesTerapeuticas);
        indicacoesSelecionadas = ListasFactory.retornarIndicacoesPosologia(selIndicacaoTerapeutica);
        frasesBulaSelecionadas = ListasFactory.retornarFrasesBula(selIndicacaoTerapeutica);
    }

    public void novo() {
        selIndicacaoTerapeutica = new TbIndicacaoTerapeuticaMedicamento();
        selIndicacaoTerapeutica = ListasFactory.retornarIndicacaoTerapeutica(selmedicamento, codMedicamento);
        indicacoesSelecionadas = ListasFactory.retornarIndicacoesPosologia(selIndicacaoTerapeutica);
        frasesBulaSelecionadas = ListasFactory.retornarFrasesBula(selIndicacaoTerapeutica);
     codRestricaoUso =  restricoesUso.indexOf(selIndicacaoTerapeutica.getTdRestricaoDeUso()) ;
     codUnidadeMed =  unidadesMed.indexOf(selIndicacaoTerapeutica.getTbUnidadeMedida());
    }

    public void novoFrase() {
        selFraseAlertaBurla = new TaFraseAlertaBula(selIndicacaoTerapeutica, null);


    }

    public void novoIndicacao() {
        selIndicacaoPosologia = new TaIndicacaoPosologia(selIndicacaoTerapeutica, null, null, null, null, null, null, null);


    }

    public void salvar() {
        TbIndicacaoTerapeuticaMedicamento temp = new TbIndicacaoTerapeuticaMedicamento(restricoesUso.get(codRestricaoUso),
                unidadesMed.get(codUnidadeMed), selIndicacaoTerapeutica.getTbMedicamento(), selIndicacaoTerapeutica.getLimMaxDiario(), selIndicacaoTerapeutica.getTempMedInicioAcao(), selIndicacaoTerapeutica.getArqBulaPaciente(), selIndicacaoTerapeutica.getArqBulaProfissional());
        indicacoesTerapeuticas.set(indicacoesTerapeuticas.indexOf(selIndicacaoTerapeutica), temp);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem:", "Medicamento atualizado com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        reinit();
    }

    public void salvarFrases() {

        TaFraseAlertaBula temp = new TaFraseAlertaBula(selIndicacaoTerapeutica, frasesAlerta.get(codFraseAlerta));

        frasesBula.add(temp);


        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem:", "Frase Alerta cadastrada");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        reinit();
    }

    public void salvarIndicacaoPosologia() {


        TaIndicacaoPosologia temp = new TaIndicacaoPosologia(selIndicacaoTerapeutica, doencas.get(codDoenca), objetivosTerapeuticos.get(codObjetivoTerapeutico),
                selIndicacaoPosologia.getCompIndicacaoTerapeuticaTecnica(), selIndicacaoPosologia.getCompIndicacaoTerapeuticaParaPaciente(),
                selIndicacaoPosologia.getDosePadrao(), selIndicacaoPosologia.getDoseInicial(), selIndicacaoPosologia.getDoseManutencao());

        indicacoes.add(temp);



        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem:", "Indicação Posologica cadastrada");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        reinit();
    }

    public void removerFrase() {

        frasesBula.remove(selFraseAlertaBurla);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem", "Excluido com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        reinit();
    }

    public void removerIndicacaoPosologia() {
        indicacoes.remove(selIndicacaoPosologia);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem", "Excluido com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        reinit();
    }

    public List<TaIndicacaoPosologia> getIndicacoes() {
        return indicacoes;
    }

    public void setIndicacoes(List<TaIndicacaoPosologia> indicacoes) {
        this.indicacoes = indicacoes;
    }

    public List<TaFraseAlertaBula> getFrasesBula() {
        return frasesBula;
    }

    public void setFrasesBula(List<TaFraseAlertaBula> frasesBula) {
        this.frasesBula = frasesBula;
    }

    public int getCodMedicamento() {
        return codMedicamento;
    }

    public void setCodMedicamento(int codMedicamento) {
        this.codMedicamento = codMedicamento;
    }

    public List<TbIndicacaoTerapeuticaMedicamento> getIndicacoesTerapeuticas() {
        return indicacoesTerapeuticas;
    }

    public void setIndicacoesTerapeuticas(List<TbIndicacaoTerapeuticaMedicamento> indicacoesTerapeuticas) {
        this.indicacoesTerapeuticas = indicacoesTerapeuticas;
    }

    public TaFraseAlertaBula getSelFraseAlertaBurla() {
        return selFraseAlertaBurla;
    }

    public void setSelFraseAlertaBurla(TaFraseAlertaBula selFraseAlertaBurla) {
        this.selFraseAlertaBurla = selFraseAlertaBurla;
    }

    public List<TbMedicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<TbMedicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public TbIndicacaoTerapeuticaMedicamento getSelIndicacaoTerapeutica() {
        return selIndicacaoTerapeutica;
    }

    public void setSelIndicacaoTerapeutica(TbIndicacaoTerapeuticaMedicamento selIndicacaoTerapeutica) {
        this.selIndicacaoTerapeutica = selIndicacaoTerapeutica;
    }

    public TbMedicamento getSelmedicamento() {
        return selmedicamento;
    }

    public void setSelmedicamento(TbMedicamento selmedicamento) {
        this.selmedicamento = selmedicamento;
    }

    public List<TdRestricaoDeUso> getRestricoesUso() {
        return restricoesUso;
    }

    public void setRestricoesUso(List<TdRestricaoDeUso> restricoesUso) {
        this.restricoesUso = restricoesUso;
    }

    public int getCodRestricaoUso() {
        return codRestricaoUso;
    }

    public void setCodRestricaoUso(int codRestricaoUso) {
        this.codRestricaoUso = codRestricaoUso;
    }

    public List<TbUnidadeMedida> getUnidadesMed() {
        return unidadesMed;
    }

    public void setUnidadesMed(List<TbUnidadeMedida> unidadesMed) {
        this.unidadesMed = unidadesMed;
    }

    public int getCodUnidadeMed() {
        return codUnidadeMed;
    }

    public void setCodUnidadeMed(int codUnidadeMed) {
        this.codUnidadeMed = codUnidadeMed;
    }

    public List<TdObjetivoTerapeutico> getObjetivosTerapeuticos() {
        return objetivosTerapeuticos;
    }

    public void setObjetivosTerapeuticos(List<TdObjetivoTerapeutico> objetivosTerapeuticos) {
        this.objetivosTerapeuticos = objetivosTerapeuticos;
    }

    public int getCodObjetivoTerapeutico() {
        return codObjetivoTerapeutico;
    }

    public void setCodObjetivoTerapeutico(int codObjetivoTerapeutico) {
        this.codObjetivoTerapeutico = codObjetivoTerapeutico;
    }

    public List<TdDoenca> getDoencas() {
        return doencas;
    }

    public void setDoencas(List<TdDoenca> doencas) {
        this.doencas = doencas;
    }

    public int getCodDoenca() {
        return codDoenca;
    }

    public void setCodDoenca(int codDoenca) {
        this.codDoenca = codDoenca;
    }

    public List<TaIndicacaoPosologia> getIndicacoesSelecionadas() {
        return indicacoesSelecionadas;
    }

    public void setIndicacoesSelecionadas(List<TaIndicacaoPosologia> indicacoesSelecionadas) {
        this.indicacoesSelecionadas = indicacoesSelecionadas;
    }

    public List<TaFraseAlertaBula> getFrasesBulaSelecionadas() {
        return frasesBulaSelecionadas;
    }

    public void setFrasesBulaSelecionadas(List<TaFraseAlertaBula> frasesBulaSelecionadas) {
        this.frasesBulaSelecionadas = frasesBulaSelecionadas;
    }

    public TaIndicacaoPosologia getSelIndicacaoPosologia() {
        return selIndicacaoPosologia;
    }

    public void setSelIndicacaoPosologia(TaIndicacaoPosologia selIndicacaoPosologia) {
        this.selIndicacaoPosologia = selIndicacaoPosologia;
    }

    public int getCodIndicacaoPosologia() {
        return codIndicacaoPosologia;
    }

    public void setCodIndicacaoPosologia(int codIndicacaoPosologia) {
        this.codIndicacaoPosologia = codIndicacaoPosologia;
    }

    public List<TdFraseAlerta> getFrasesAlerta() {
        return frasesAlerta;
    }

    public void setFrasesAlerta(List<TdFraseAlerta> frasesAlerta) {
        this.frasesAlerta = frasesAlerta;
    }

    public int getCodFraseAlerta() {
        return codFraseAlerta;
    }

    public void setCodFraseAlerta(int codFraseAlerta) {
        this.codFraseAlerta = codFraseAlerta;
    }
}
