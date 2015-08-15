package collections.factory;

import collections.mapeamento.TaFraseAlertaBula;
import collections.mapeamento.TaIndicacaoPosologia;
import collections.mapeamento.TaViaAdministracaoMedicamento;
import collections.mapeamento.TbAnaliseMedicamento;
import collections.mapeamento.TbCaracterizacaoMedicamento;
import collections.mapeamento.TbClasseTerapeutica;
import collections.mapeamento.TbColaborador;
import collections.mapeamento.TbIndicacaoTerapeuticaMedicamento;
import collections.mapeamento.TbMedicamento;
import collections.mapeamento.TbModoDeUsoMedicamento;
import collections.mapeamento.TbProduto;
import collections.mapeamento.TbProdutoMedicacao;
import collections.mapeamento.TbRestricaoPrescricao;
import collections.mapeamento.TbUnidadeMedida;
import collections.mapeamento.TdDoenca;
import collections.mapeamento.TdEmpresa;
import collections.mapeamento.TdFraseAlerta;
import collections.mapeamento.TdObjetivoTerapeutico;
import collections.mapeamento.TdRestricaoDeUso;
import collections.mapeamento.TdViaAdministracao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListasFactory extends MaquinaRandom {
    // Essa e a Fabrica de listas que serao usadas pelos MB's, 

    private static List<TdViaAdministracao> viasAdministracao = new ArrayList<TdViaAdministracao>();
    private static List<TbMedicamento> medicamentos = new ArrayList<TbMedicamento>();
    private static List<TbCaracterizacaoMedicamento> caracteristicasMed = new ArrayList<TbCaracterizacaoMedicamento>();
    private static List<TbClasseTerapeutica> classesTerapeuticas = new ArrayList<TbClasseTerapeutica>();
    private static List<TbRestricaoPrescricao> restricoesPrescricao = new ArrayList<TbRestricaoPrescricao>();
    private static List<TbProdutoMedicacao> produtosMedicacao = new ArrayList<TbProdutoMedicacao>();
    private static List<TbModoDeUsoMedicamento> modosDeUso = new ArrayList<TbModoDeUsoMedicamento>();
    private static List<TbProduto> produtos = new ArrayList<TbProduto>();
     private static List<TdEmpresa> empresas = new ArrayList<TdEmpresa>();
    private static List<TbAnaliseMedicamento> analisesMed = new ArrayList<TbAnaliseMedicamento>();
    private static List<TbColaborador> colaboradores = new ArrayList<TbColaborador>();
    private static List<TdRestricaoDeUso> restricoesUso = new ArrayList<TdRestricaoDeUso>();
    private static List<TbUnidadeMedida> unidadesMedida = new ArrayList<TbUnidadeMedida>();
    private static List<TdObjetivoTerapeutico> objetivosTerapeuticos = new ArrayList<TdObjetivoTerapeutico>();
    private static List<TdDoenca> doencas = new ArrayList<TdDoenca>();
    private static List<TdFraseAlerta> frasesAlerta = new ArrayList<TdFraseAlerta>();
    private static List<TaFraseAlertaBula> frasesAlertaBula = new ArrayList<TaFraseAlertaBula>();
    private static List<TaIndicacaoPosologia> indicacoesPosologia = new ArrayList<TaIndicacaoPosologia>();
    private static List<TbIndicacaoTerapeuticaMedicamento> indicacoesTerapeuticas = new ArrayList<TbIndicacaoTerapeuticaMedicamento>();
    private static List<TaViaAdministracaoMedicamento> viasAdministracaoMedicamento = new ArrayList<TaViaAdministracaoMedicamento>();
    private static Integer controlador = 0;

    public ListasFactory() {
    }

    public static void iniciarPopular() {
        if (controlador == 0) {


            populateViasAdministracao();
            populateClasseTerapeutica();
            populateRestricoesPrescricao();
            populeProdutos();
            populateEmpresas();
            populateMedicamentos();
            populateColaboradores();
            populateRestricoesUso();
            populateUnidadesMedida();
            populateDoencas();
            populateObjetivosTerapeuticos();
            populateFrasesAlerta();
            controlador = 1;
        }
    }

    public static List<TbMedicamento> retornarMedicamentosNaoAprovados() {
        List<TbMedicamento> temp = new ArrayList<TbMedicamento>();


        for (Iterator<TbMedicamento> it2 = medicamentos.iterator(); it2.hasNext();) {
            TbMedicamento tbMedicamento = it2.next();
            if (tbMedicamento.getStsMedicamento().equals("Completo") & !"Aprovado".equals(tbMedicamento.getStsMedicamento()) & !"Indeferido".equals(tbMedicamento.getStsMedicamento())) {
                temp.add(tbMedicamento);

            }
        }

        return temp;
    }

    public static List<TbMedicamento> retornarMedicamentosIndeferidos() {
        List<TbMedicamento> temp = new ArrayList<TbMedicamento>();


        for (Iterator<TbMedicamento> it2 = medicamentos.iterator(); it2.hasNext();) {
            TbMedicamento tbMedicamento = it2.next();
            if (tbMedicamento.getStsMedicamento().equals("Indeferido")) {
                temp.add(tbMedicamento);

            }
        }

        return temp;
    }

    public static TbIndicacaoTerapeuticaMedicamento retornarIndicacaoTerapeutica(TbMedicamento a, int codMedicamento) {
        TbIndicacaoTerapeuticaMedicamento temp = new TbIndicacaoTerapeuticaMedicamento();
        boolean b = false;
        for (Iterator<TbIndicacaoTerapeuticaMedicamento> it2 = indicacoesTerapeuticas.iterator(); it2.hasNext();) {
            TbIndicacaoTerapeuticaMedicamento tbIndicacaoTerapeuticaMedicamento = it2.next();
            if (tbIndicacaoTerapeuticaMedicamento.getTbMedicamento().getNmeMedicamento() == null ? a.getNmeMedicamento() == null : tbIndicacaoTerapeuticaMedicamento.getTbMedicamento().getNmeMedicamento().equals(a.getNmeMedicamento())) {
                temp = tbIndicacaoTerapeuticaMedicamento;
                b = true;
            }

        }
        if (b == false) {
            indicacoesTerapeuticas.add(new TbIndicacaoTerapeuticaMedicamento(null, null, medicamentos.get(codMedicamento), null, null, null, null));
            temp = indicacoesTerapeuticas.get(indicacoesTerapeuticas.size() - 1);
        }
        return temp;
    }
     public static TbCaracterizacaoMedicamento retornarCaracterizacaoMedicamento(TbMedicamento a, int codMedicamento) {
        TbCaracterizacaoMedicamento temp = new TbCaracterizacaoMedicamento();
        boolean b = false;
        for (Iterator<TbCaracterizacaoMedicamento> it2 = caracteristicasMed.iterator(); it2.hasNext();) {
            TbCaracterizacaoMedicamento tbCaracterizacaoMedicamento = it2.next();
            if (tbCaracterizacaoMedicamento.getTbMedicamento().getNmeMedicamento() == null ? a.getNmeMedicamento() == null : tbCaracterizacaoMedicamento.getTbMedicamento().getNmeMedicamento().equals(a.getNmeMedicamento())) {
                temp = tbCaracterizacaoMedicamento;
                b = true;
            }

        }
        if (b == false) {
            caracteristicasMed.add(new TbCaracterizacaoMedicamento( medicamentos.get(codMedicamento),"novo"));
            temp = caracteristicasMed.get(caracteristicasMed.size() - 1);
        }
        return temp;
    }

    public static TbModoDeUsoMedicamento retornarModoUso(TbMedicamento a, int codMedicamento) {
        TbModoDeUsoMedicamento temp = new TbModoDeUsoMedicamento();
        if (modosDeUso.isEmpty()) {

            modosDeUso.add(new TbModoDeUsoMedicamento(medicamentos.get(codMedicamento), "", "", "", ""));
            temp = modosDeUso.get(modosDeUso.size() - 1);
        } else {
            for (Iterator<TbModoDeUsoMedicamento> it2 = modosDeUso.iterator(); it2.hasNext();) {
                TbModoDeUsoMedicamento tbModoUso = it2.next();
                if (tbModoUso.getTbMedicamento().getNmeMedicamento() == null ? a.getNmeMedicamento() == null : tbModoUso.getTbMedicamento().getNmeMedicamento().equals(a.getNmeMedicamento())) {
                    temp = tbModoUso;
                }
            }
        }

        return temp;
    }

    public static TbAnaliseMedicamento retornarAnalise(TbAnaliseMedicamento a, int codMedicamento, int codColaborador) {
        TbAnaliseMedicamento temp = new TbAnaliseMedicamento();
        if (analisesMed.isEmpty()) {

            analisesMed.add(new TbAnaliseMedicamento(colaboradores.get(codColaborador), medicamentos.get(codMedicamento), ""));
            temp = analisesMed.get(analisesMed.size() - 1);
        } else {
            for (Iterator<TbAnaliseMedicamento> it2 = analisesMed.iterator(); it2.hasNext();) {
                TbAnaliseMedicamento tbAnaliseMed = it2.next();
                if (tbAnaliseMed.getDesAnaliseMedicamento() == null ? a.getDesAnaliseMedicamento() == null : tbAnaliseMed.getDesAnaliseMedicamento().equals(a.getDesAnaliseMedicamento())) {
                    temp = tbAnaliseMed;
                }
            }
        }

        return temp;
    }

    public static List<TaViaAdministracaoMedicamento> retornarViasAdministracao(TbCaracterizacaoMedicamento caracterizacao) {
        List<TaViaAdministracaoMedicamento> temp = new ArrayList<TaViaAdministracaoMedicamento>();

        for (Iterator<TaViaAdministracaoMedicamento> it2 = viasAdministracaoMedicamento.iterator(); it2.hasNext();) {
            TaViaAdministracaoMedicamento taViaAdministracaoMedicamento = it2.next();
            if (taViaAdministracaoMedicamento.getTbCaracterizacaoMedicamento().getTbMedicamento().getNmeMedicamento().equals(caracterizacao.getTbMedicamento().getNmeMedicamento())) {
                temp.add(taViaAdministracaoMedicamento);

            }
        }

        return temp;
    }
     public static List<TbProdutoMedicacao> retornarProdutosSelecionados(TbCaracterizacaoMedicamento caracterizacao) {
        List<TbProdutoMedicacao> temp = new ArrayList<TbProdutoMedicacao>();

        for (Iterator<TbProdutoMedicacao> it2 = produtosMedicacao.iterator(); it2.hasNext();) {
            TbProdutoMedicacao tbProdutoMedicacao = it2.next();
            if (tbProdutoMedicacao.getTbCaracterizacaoMedicamento().getTbMedicamento().getNmeMedicamento().equals(caracterizacao.getTbMedicamento().getNmeMedicamento())) {
                temp.add(tbProdutoMedicacao);

            }
        }

        return temp;
    }

    public static List<TaFraseAlertaBula> retornarFrasesBula(TbIndicacaoTerapeuticaMedicamento indicacao) {
        List<TaFraseAlertaBula> temp = new ArrayList<TaFraseAlertaBula>();

        for (Iterator<TaFraseAlertaBula> it2 = frasesAlertaBula.iterator(); it2.hasNext();) {
            TaFraseAlertaBula taFraseAlertaBula = it2.next();
            if (taFraseAlertaBula.getTbIndicacaoTerapeuticaMedicamento().getTbMedicamento().getNmeMedicamento().equals(indicacao.getTbMedicamento().getNmeMedicamento())) {
                temp.add(taFraseAlertaBula);

            }
        }

        return temp;
    }
    public static List<TaIndicacaoPosologia> retornarIndicacoesPosologia(TbIndicacaoTerapeuticaMedicamento indicacao) {
        List<TaIndicacaoPosologia> temp = new ArrayList<TaIndicacaoPosologia>();

        for (Iterator<TaIndicacaoPosologia> it2 = indicacoesPosologia.iterator(); it2.hasNext();) {
            TaIndicacaoPosologia taIndicacaoPosologia = it2.next();
            if (taIndicacaoPosologia.getTbIndicacaoTerapeuticaMedicamento().getTbMedicamento().getNmeMedicamento().equals(indicacao.getTbMedicamento().getNmeMedicamento())) {
                temp.add(taIndicacaoPosologia);

            }
        }

        return temp;
    }

    public static void populateObjetivosTerapeuticos() {
        objetivosTerapeuticos.add(new TdObjetivoTerapeutico("Tratamento"));
        objetivosTerapeuticos.add(new TdObjetivoTerapeutico("Diagnóstico"));
        objetivosTerapeuticos.add(new TdObjetivoTerapeutico("Auxiliar no diagnóstico"));
        objetivosTerapeuticos.add(new TdObjetivoTerapeutico("Prevenção"));
    }

    public static void populateDoencas() {
        doencas.add(new TdDoenca("A00", "Cólera"));
        doencas.add(new TdDoenca("A01.0", "Febre Tifóide"));
        doencas.add(new TdDoenca("A67.3", "Lesões Mistas da Pinta"));
        doencas.add(new TdDoenca("B06", "Rubéola"));
        doencas.add(new TdDoenca("B38", "Coccidioidomicose"));
        doencas.add(new TdDoenca("B67", "Equinococose"));
        doencas.add(new TdDoenca("C25", "Neoplasia Maligna do Pâncreas"));
        doencas.add(new TdDoenca("C58", "Neoplasia Maligna da Placenta"));
        doencas.add(new TdDoenca("H20", "Iridociclite"));
        doencas.add(new TdDoenca("S04", "Traumatismo Dos Nervos Cranianos"));

    }

    public static void populateUnidadesMedida() {
        unidadesMedida.add(new TbUnidadeMedida("m"));
        unidadesMedida.add(new TbUnidadeMedida("kg"));
        unidadesMedida.add(new TbUnidadeMedida("s"));
        unidadesMedida.add(new TbUnidadeMedida("g"));

    }

    public static void populateRestricoesUso() {
        restricoesUso.add(new TdRestricaoDeUso("Pediátrico"));
        restricoesUso.add(new TdRestricaoDeUso("Adulto"));
        restricoesUso.add(new TdRestricaoDeUso("Adulto e Pediátrica"));
        restricoesUso.add(new TdRestricaoDeUso("Adulto acima de 22 anos"));
        restricoesUso.add(new TdRestricaoDeUso("Pediátrico acima de 4 anos"));



    }

    public static void populateFrasesAlerta() {
        frasesAlerta.add(new TdFraseAlerta("Frase Alerta 01"));
        frasesAlerta.add(new TdFraseAlerta("Frase Alerta 02"));
        frasesAlerta.add(new TdFraseAlerta("Frase Alerta 03"));
        frasesAlerta.add(new TdFraseAlerta("Frase Alerta 04"));
        frasesAlerta.add(new TdFraseAlerta("Frase Alerta 05"));
    }

    public static void populateColaboradores() {
        colaboradores.add(new TbColaborador("Andre", "047.845.154-08", "Interno"));
        colaboradores.add(new TbColaborador("Davi", "575.575.154-04", "Externo"));
        colaboradores.add(new TbColaborador("Matheus", "047.213.154-05", "Interno"));
        colaboradores.add(new TbColaborador("Marcus", "876.845.154-10", "Externo"));
        colaboradores.add(new TbColaborador("Juliana", "644.845.454-12", "Interno"));
        colaboradores.add(new TbColaborador("Maria", "332.845.154-12", "Externo"));
        colaboradores.add(new TbColaborador("Antonia", "454.789.154-12", "Interno"));
    }

    public static void populateEmpresas() {

        empresas.add(new TdEmpresa("87.457.154", "Empresa 01", "Endereço 01", "empresa01@email.com"));
        empresas.add(new TdEmpresa("56.557.154", "Empresa 02", "Endereço 02", "empresa02@email.com"));
        empresas.add(new TdEmpresa("54.457.112", "Empresa 03", "Endereço 03", "empresa03@email.com"));
        empresas.add(new TdEmpresa("24.457.154", "Empresa 04", "Endereço 04", "empresa04@email.com"));
        empresas.add(new TdEmpresa("54.545.154", "Empresa 05", "Endereço 05", "empresa05@email.com"));
    }

    public static void populateMedicamentos() {
        medicamentos.add(new TbMedicamento(empresas.get(0), "Pendente", "Medicamento 01"));
        medicamentos.add(new TbMedicamento(empresas.get(1), "Completo", "Medicamento 02"));
        medicamentos.add(new TbMedicamento(empresas.get(2), "Aprovado", "Medicamento 03"));
        medicamentos.add(new TbMedicamento(empresas.get(3), "Indeferido", "Medicamento 04"));
        medicamentos.add(new TbMedicamento(empresas.get(4), "Pendente", "Medicamento 05"));
        medicamentos.add(new TbMedicamento(empresas.get(0), "Completo", "Medicamento 06"));
        medicamentos.add(new TbMedicamento(empresas.get(1), "Completo", "Medicamento 07"));
        medicamentos.add(new TbMedicamento(empresas.get(2), "Completo", "Medicamento 08"));
        medicamentos.add(new TbMedicamento(empresas.get(3), "Indeferido", "Medicamento 09"));
        medicamentos.add(new TbMedicamento(empresas.get(4), "Indeferido", "Medicamento 10"));


    }

    public static void populateViasAdministracao() {
        viasAdministracao.add(new TdViaAdministracao("Auricular"));
        viasAdministracao.add(new TdViaAdministracao("Bucal"));
        viasAdministracao.add(new TdViaAdministracao("Intra-arterial"));
        viasAdministracao.add(new TdViaAdministracao("Intra-articular"));
        viasAdministracao.add(new TdViaAdministracao("Instramuscular"));
        viasAdministracao.add(new TdViaAdministracao("Intrassinovial"));
        viasAdministracao.add(new TdViaAdministracao("Intratecal"));
        viasAdministracao.add(new TdViaAdministracao("Intravenosa"));
        viasAdministracao.add(new TdViaAdministracao("Nasal"));
        viasAdministracao.add(new TdViaAdministracao("Ocular"));
        viasAdministracao.add(new TdViaAdministracao("Oral"));
        viasAdministracao.add(new TdViaAdministracao("Respiratória"));
        viasAdministracao.add(new TdViaAdministracao("Retal"));
        viasAdministracao.add(new TdViaAdministracao("Subcutânea"));
        viasAdministracao.add(new TdViaAdministracao("Sublingual"));
        viasAdministracao.add(new TdViaAdministracao("Tópica"));
        viasAdministracao.add(new TdViaAdministracao("Transdérmica"));
        viasAdministracao.add(new TdViaAdministracao("Vaginal"));

    }

    public static void populateRestricoesPrescricao() {
        restricoesPrescricao.add(new TbRestricaoPrescricao("Diabetes"));
        restricoesPrescricao.add(new TbRestricaoPrescricao("Gravidez"));
        restricoesPrescricao.add(new TbRestricaoPrescricao("Peso abaixo de 40kg"));
        restricoesPrescricao.add(new TbRestricaoPrescricao("Suspeita de Dengue"));
        restricoesPrescricao.add(new TbRestricaoPrescricao("Peso acima de 80kg"));

    }

    public static void populateClasseTerapeutica() {
        classesTerapeuticas.add(new TbClasseTerapeutica("D06D", "Produtos Tópicos para infecção viral"));
        classesTerapeuticas.add(new TbClasseTerapeutica("C03A", "Diuréticos"));
        classesTerapeuticas.add(new TbClasseTerapeutica("H02A", "Corticosteróides sistêmicos puros"));
        classesTerapeuticas.add(new TbClasseTerapeutica("J01D", "Cefalosporinas"));
        classesTerapeuticas.add(new TbClasseTerapeutica("J02A", "Agentes para infecções fúngicas sistêcas"));
        classesTerapeuticas.add(new TbClasseTerapeutica("N05C", "Tranquilizantes"));
        classesTerapeuticas.add(new TbClasseTerapeutica("A10H", "Sulfonilureias"));
        classesTerapeuticas.add(new TbClasseTerapeutica("N02B", "Nalgésicos não narcóticos e antipiréticos"));
        classesTerapeuticas.add(new TbClasseTerapeutica("D06A", "Antibacterianos tópicos"));
        classesTerapeuticas.add(new TbClasseTerapeutica("R05C", "Expectorantes"));
        classesTerapeuticas.add(new TbClasseTerapeutica("R05D", "Antitussígenos"));
        classesTerapeuticas.add(new TbClasseTerapeutica("N05A", "Antipsicóticos"));

    }

    public static void populeProdutos() {
        produtos.add(new TbProduto(null, "Aprovado", "Produto 01"));
        produtos.add(new TbProduto(null, "Aprovado", "Produto 02"));
        produtos.add(new TbProduto(null, "Aprovado", "Produto 03"));
        produtos.add(new TbProduto(null, "Aprovado", "Produto 04"));
        produtos.add(new TbProduto(null, "Aprovado", "Produto 05"));
        produtos.add(new TbProduto(null, "Aprovado", "Produto 06"));
        produtos.add(new TbProduto(null, "Aprovado", "Produto 07"));
    }

    public static List<TaViaAdministracaoMedicamento> getViasAdministracaoMedicamento() {
        return viasAdministracaoMedicamento;
    }

    public static void setViasAdministracaoMedicamento(List<TaViaAdministracaoMedicamento> viasAdministracaoMedicamento) {
        ListasFactory.viasAdministracaoMedicamento = viasAdministracaoMedicamento;
    }

    public static List<TaFraseAlertaBula> getFrasesAlertaBula() {
        return frasesAlertaBula;
    }

    public static void setFrasesAlertaBula(List<TaFraseAlertaBula> frasesAlertaBula) {
        ListasFactory.frasesAlertaBula = frasesAlertaBula;
    }

    public static List<TdFraseAlerta> getFrasesAlerta() {
        return frasesAlerta;
    }

    public static void setFrasesAlerta(List<TdFraseAlerta> frasesAlerta) {
        ListasFactory.frasesAlerta = frasesAlerta;
    }

    public static List<TaIndicacaoPosologia> getIndicacoesPosologia() {
        return indicacoesPosologia;
    }

    public static void setIndicacoesPosologia(List<TaIndicacaoPosologia> indicacoesPosologia) {
        ListasFactory.indicacoesPosologia = indicacoesPosologia;
    }

    public static List<TbIndicacaoTerapeuticaMedicamento> getIndicacoesTerapeuticas() {
        return indicacoesTerapeuticas;
    }

    public static void setIndicacoesTerapeuticas(List<TbIndicacaoTerapeuticaMedicamento> indicacoesTerapeuticas) {
        ListasFactory.indicacoesTerapeuticas = indicacoesTerapeuticas;
    }

    public static List<TbUnidadeMedida> getUnidadesMedida() {
        return unidadesMedida;
    }

    public static void setUnidadesMedida(List<TbUnidadeMedida> unidadesMedida) {
        ListasFactory.unidadesMedida = unidadesMedida;
    }

    public static List<TdObjetivoTerapeutico> getObjetivosTerapeuticos() {
        return objetivosTerapeuticos;
    }

    public static void setObjetivosTerapeuticos(List<TdObjetivoTerapeutico> objetivosTerapeuticos) {
        ListasFactory.objetivosTerapeuticos = objetivosTerapeuticos;
    }

    public static List<TdDoenca> getDoencas() {
        return doencas;
    }

    public static void setDoencas(List<TdDoenca> doencas) {
        ListasFactory.doencas = doencas;
    }

    public static List<TdRestricaoDeUso> getRestricoesUso() {
        return restricoesUso;
    }

    public static void setRestricoesUso(List<TdRestricaoDeUso> restricoesUso) {
        ListasFactory.restricoesUso = restricoesUso;
    }

    public static List<TdViaAdministracao> getViasAdministracao() {
        return viasAdministracao;
    }

    public static void setViasAdministracao(List<TdViaAdministracao> viasAdministracao) {
        ListasFactory.viasAdministracao = viasAdministracao;
    }

    public static List<TbMedicamento> getMedicamentos() {
        return medicamentos;
    }

    public static void setMedicamentos(List<TbMedicamento> medicamentos) {
        ListasFactory.medicamentos = medicamentos;
    }

    public static List<TbCaracterizacaoMedicamento> getCaracteristicasMed() {
        return caracteristicasMed;
    }

    public static void setCaracteristicasMed(List<TbCaracterizacaoMedicamento> caracteristicasMed) {
        ListasFactory.caracteristicasMed = caracteristicasMed;
    }

    public static List<TbClasseTerapeutica> getClassesTerapeuticas() {
        return classesTerapeuticas;
    }

    public static void setClassesTerapeuticas(List<TbClasseTerapeutica> classesTerapeuticas) {
        ListasFactory.classesTerapeuticas = classesTerapeuticas;
    }

    public static List<TbRestricaoPrescricao> getRestricoesPrescricao() {
        return restricoesPrescricao;
    }

    public static void setRestricoesPrescricao(List<TbRestricaoPrescricao> restricoesPrescricao) {
        ListasFactory.restricoesPrescricao = restricoesPrescricao;
    }

    public static List<TbProdutoMedicacao> getProdutosMedicacao() {
        return produtosMedicacao;
    }

    public static void setProdutosMedicacao(List<TbProdutoMedicacao> produtosMedicacao) {
        ListasFactory.produtosMedicacao = produtosMedicacao;
    }

    public static List<TbProduto> getProdutos() {
        return produtos;
    }

    public static void setProdutos(List<TbProduto> produtos) {
        ListasFactory.produtos = produtos;
    }

 
    public static List<TdEmpresa> getEmpresas() {
        return empresas;
    }

    public static void setEmpresas(List<TdEmpresa> empresas) {
        ListasFactory.empresas = empresas;
    }

    public static List<TbModoDeUsoMedicamento> getModosDeUso() {
        return modosDeUso;
    }

    public static void setModosDeUso(List<TbModoDeUsoMedicamento> modosDeUso) {
        ListasFactory.modosDeUso = modosDeUso;
    }

    public static List<TbColaborador> getColaboradores() {
        return colaboradores;
    }

    public static void setColaboradores(List<TbColaborador> colaboradores) {
        ListasFactory.colaboradores = colaboradores;
    }

    public static List<TbAnaliseMedicamento> getAnalisesMed() {
        return analisesMed;
    }

    public static void setAnalisesMed(List<TbAnaliseMedicamento> analisesMed) {
        ListasFactory.analisesMed = analisesMed;
    }
}
