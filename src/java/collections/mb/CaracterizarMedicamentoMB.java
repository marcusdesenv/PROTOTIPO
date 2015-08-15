/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.mb;

import collections.factory.ListasFactory;
import collections.mapeamento.TaViaAdministracaoMedicamento;
import collections.mapeamento.TbCaracterizacaoMedicamento;
import collections.mapeamento.TbClasseTerapeutica;
import collections.mapeamento.TbMedicamento;
import collections.mapeamento.TbProduto;
import collections.mapeamento.TbProdutoMedicacao;
import collections.mapeamento.TbRestricaoPrescricao;
import collections.mapeamento.TdViaAdministracao;
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
public class CaracterizarMedicamentoMB {

    private List<TbCaracterizacaoMedicamento> caracterizacoesMedicamentos;
    private TbCaracterizacaoMedicamento selCaracterizacaoMedicamento;
    private List<TbMedicamento> medicamentos;
    private TbMedicamento selmedicamento;
    int codMedicamento;
    private List<TbRestricaoPrescricao> restricoesPrescricao;
    int codRestricaoPrescricao;
    private List<TbClasseTerapeutica> classesTerapeuticas;
    int codClasseTerapeutica;
    private List<TbProduto> produtos;
    int codProduto;
    private List<TdViaAdministracao> viasAdministracao;
    int codViaAdministracao;
    private List<TaViaAdministracaoMedicamento> viasSelecionadas;
    private List<TaViaAdministracaoMedicamento> viasAdministracaoMedicamento;
    private TaViaAdministracaoMedicamento selViaAdministracaoMedicamento;
    int codViaAdministracaoMedicamento;
    private List<TbProdutoMedicacao> produtosSelecionados;
    private List<TbProdutoMedicacao> produtosMedicacao;
    private TbProdutoMedicacao selProdutoMedicacao;
    int codProdutoMedicacao;

    public CaracterizarMedicamentoMB() {
        ListasFactory.iniciarPopular();
        selmedicamento = new TbMedicamento();
        selCaracterizacaoMedicamento = new TbCaracterizacaoMedicamento();
        medicamentos = ListasFactory.getMedicamentos();
        restricoesPrescricao = ListasFactory.getRestricoesPrescricao();
        classesTerapeuticas = ListasFactory.getClassesTerapeuticas();
        produtos = ListasFactory.getProdutos();
        viasAdministracao = ListasFactory.getViasAdministracao();
        viasAdministracaoMedicamento = ListasFactory.getViasAdministracaoMedicamento();
        produtosMedicacao = ListasFactory.getProdutosMedicacao();
        caracterizacoesMedicamentos = ListasFactory.getCaracteristicasMed();
    

    reinit();

    }

    public void reinit() {
        ListasFactory.setProdutosMedicacao(produtosMedicacao);
        ListasFactory.setViasAdministracaoMedicamento(viasAdministracaoMedicamento);
        ListasFactory.setCaracteristicasMed(caracterizacoesMedicamentos);
        viasSelecionadas = ListasFactory.retornarViasAdministracao(selCaracterizacaoMedicamento);
        produtosSelecionados = ListasFactory.retornarProdutosSelecionados(selCaracterizacaoMedicamento);
    }

    public void novo() {
        selCaracterizacaoMedicamento = new TbCaracterizacaoMedicamento();
        selCaracterizacaoMedicamento = ListasFactory.retornarCaracterizacaoMedicamento(selmedicamento, codMedicamento);
        viasSelecionadas = ListasFactory.retornarViasAdministracao(selCaracterizacaoMedicamento);
        produtosSelecionados = ListasFactory.retornarProdutosSelecionados(selCaracterizacaoMedicamento);

        codClasseTerapeutica = classesTerapeuticas.indexOf(selCaracterizacaoMedicamento.getTbClasseTerapeutica());
        codRestricaoPrescricao = restricoesPrescricao.indexOf(selCaracterizacaoMedicamento.getTbRestricaoPrescricao());
    }

    public void novoVias() {
        selViaAdministracaoMedicamento = new TaViaAdministracaoMedicamento(null, selCaracterizacaoMedicamento);


    }

    public void novoProdutoMedicacao() {
        selProdutoMedicacao = new TbProdutoMedicacao(null, selCaracterizacaoMedicamento, true, true, true, true, null);


    }

    public void salvar() {

        TbCaracterizacaoMedicamento temp = new TbCaracterizacaoMedicamento(restricoesPrescricao.get(codRestricaoPrescricao),
                selCaracterizacaoMedicamento.getTbMedicamento(), classesTerapeuticas.get(codClasseTerapeutica), selCaracterizacaoMedicamento.getCatReguladora(),
                selCaracterizacaoMedicamento.getNmeComercial(), selCaracterizacaoMedicamento.getTmpConservacaoDoMedicamentoMin(),
                selCaracterizacaoMedicamento.getTmpConservacaoDoMedicamentoMax(), selCaracterizacaoMedicamento.getDscCuidadosAdicionais());

        caracterizacoesMedicamentos.set(caracterizacoesMedicamentos.indexOf(selCaracterizacaoMedicamento), temp);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem:", "Medicamento atualizado com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        reinit();
    }

    public void salvarVias() {

        TaViaAdministracaoMedicamento temp = new TaViaAdministracaoMedicamento(viasAdministracao.get(codViaAdministracao), selCaracterizacaoMedicamento);

        viasAdministracaoMedicamento.add(temp);


        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem:", "Via administração cadastrada");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        reinit();
    }

    public void salvarProdutoMedicacao() {



        TbProdutoMedicacao temp = new TbProdutoMedicacao(produtos.get(codProduto), selCaracterizacaoMedicamento, selProdutoMedicacao.isStsFabricacaoPropria(),
                selProdutoMedicacao.isStsDiluente(), selProdutoMedicacao.isStsReconstituente(), selProdutoMedicacao.isStsNecessitaReconstituicaoDiluicaoAdministrar(),
                selProdutoMedicacao.getArqCertificadoPaisOrigem());

        produtosMedicacao.add(temp);



        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem:", "Produto cadastrado");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        reinit();
    }

    public void removerVias() {

        viasAdministracaoMedicamento.remove(selViaAdministracaoMedicamento);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem", "Excluido com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        reinit();
    }

    public void removerProdutoMedicacao() {
        produtosMedicacao.remove(selProdutoMedicacao);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem", "Excluido com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        reinit();
    }

    public List<TbCaracterizacaoMedicamento> getCaracterizacoesMedicamentos() {
        return caracterizacoesMedicamentos;
    }

    public void setCaracterizacoesMedicamentos(List<TbCaracterizacaoMedicamento> caracterizacoesMedicamentos) {
        this.caracterizacoesMedicamentos = caracterizacoesMedicamentos;
    }

    public TbCaracterizacaoMedicamento getSelCaracterizacaoMedicamento() {
        return selCaracterizacaoMedicamento;
    }

    public void setSelCaracterizacaoMedicamento(TbCaracterizacaoMedicamento selCaracterizacaoMedicamento) {
        this.selCaracterizacaoMedicamento = selCaracterizacaoMedicamento;
    }

    public List<TbMedicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<TbMedicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public TbMedicamento getSelmedicamento() {
        return selmedicamento;
    }

    public void setSelmedicamento(TbMedicamento selmedicamento) {
        this.selmedicamento = selmedicamento;
    }

    public int getCodMedicamento() {
        return codMedicamento;
    }

    public void setCodMedicamento(int codMedicamento) {
        this.codMedicamento = codMedicamento;
    }

    public List<TbRestricaoPrescricao> getRestricoesPrescricao() {
        return restricoesPrescricao;
    }

    public void setRestricoesPrescricao(List<TbRestricaoPrescricao> restricoesPrescricao) {
        this.restricoesPrescricao = restricoesPrescricao;
    }

    public int getCodRestricaoPrescricao() {
        return codRestricaoPrescricao;
    }

    public void setCodRestricaoPrescricao(int codRestricaoPrescricao) {
        this.codRestricaoPrescricao = codRestricaoPrescricao;
    }

    public List<TbClasseTerapeutica> getClassesTerapeuticas() {
        return classesTerapeuticas;
    }

    public void setClassesTerapeuticas(List<TbClasseTerapeutica> classesTerapeuticas) {
        this.classesTerapeuticas = classesTerapeuticas;
    }

    public int getCodClasseTerapeutica() {
        return codClasseTerapeutica;
    }

    public void setCodClasseTerapeutica(int codClasseTerapeutica) {
        this.codClasseTerapeutica = codClasseTerapeutica;
    }

    public List<TbProduto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<TbProduto> produtos) {
        this.produtos = produtos;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public List<TdViaAdministracao> getViasAdministracao() {
        return viasAdministracao;
    }

    public void setViasAdministracao(List<TdViaAdministracao> viasAdministracao) {
        this.viasAdministracao = viasAdministracao;
    }

    public int getCodViaAdministracao() {
        return codViaAdministracao;
    }

    public void setCodViaAdministracao(int codViaAdministracao) {
        this.codViaAdministracao = codViaAdministracao;
    }

    public List<TaViaAdministracaoMedicamento> getViasSelecionadas() {
        return viasSelecionadas;
    }

    public void setViasSelecionadas(List<TaViaAdministracaoMedicamento> viasSelecionadas) {
        this.viasSelecionadas = viasSelecionadas;
    }

    public List<TaViaAdministracaoMedicamento> getViasAdministracaoMedicamento() {
        return viasAdministracaoMedicamento;
    }

    public void setViasAdministracaoMedicamento(List<TaViaAdministracaoMedicamento> viasAdministracaoMedicamento) {
        this.viasAdministracaoMedicamento = viasAdministracaoMedicamento;
    }

    public TaViaAdministracaoMedicamento getSelViaAdministracaoMedicamento() {
        return selViaAdministracaoMedicamento;
    }

    public void setSelViaAdministracaoMedicamento(TaViaAdministracaoMedicamento selViaAdministracaoMedicamento) {
        this.selViaAdministracaoMedicamento = selViaAdministracaoMedicamento;
    }

    public int getCodViaAdministracaoMedicamento() {
        return codViaAdministracaoMedicamento;
    }

    public void setCodViaAdministracaoMedicamento(int codViaAdministracaoMedicamento) {
        this.codViaAdministracaoMedicamento = codViaAdministracaoMedicamento;
    }

    public List<TbProdutoMedicacao> getProdutosSelecionados() {
        return produtosSelecionados;
    }

    public void setProdutosSelecionados(List<TbProdutoMedicacao> produtosSelecionados) {
        this.produtosSelecionados = produtosSelecionados;
    }

    public List<TbProdutoMedicacao> getProdutosMedicacao() {
        return produtosMedicacao;
    }

    public void setProdutosMedicacao(List<TbProdutoMedicacao> produtosMedicacao) {
        this.produtosMedicacao = produtosMedicacao;
    }

    public TbProdutoMedicacao getSelProdutoMedicacao() {
        return selProdutoMedicacao;
    }

    public void setSelProdutoMedicacao(TbProdutoMedicacao selProdutoMedicacao) {
        this.selProdutoMedicacao = selProdutoMedicacao;
    }

    public int getCodProdutoMedicacao() {
        return codProdutoMedicacao;
    }

    public void setCodProdutoMedicacao(int codProdutoMedicacao) {
        this.codProdutoMedicacao = codProdutoMedicacao;
    }
}
