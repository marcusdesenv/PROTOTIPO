/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios.mb;

import collections.factory.ListasFactory;
import collections.mapeamento.TbIndicacaoTerapeuticaMedicamento;
import collections.mapeamento.TdDoenca;
import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.swing.JOptionPane;

/**
 *
 * @author Avell B153
 */
@ManagedBean
@RequestScoped
public class RelatorioMedicamentoPorIndicacaoTerapeuticaMB {

    private List<TdDoenca> doencas;

    /**
     * Creates a new instance of RelatorioPorSubstanciaMB
     */
    public RelatorioMedicamentoPorIndicacaoTerapeuticaMB() {
        ListasFactory.iniciarPopular();
        doencas = ListasFactory.getDoencas();

    }

    public void impParametrizado() {

        ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String path = context.getRealPath("/WEB-INF/reports/Relatorio_medicamento_por_indicacao_terapeutica.pdf");
        File arquivo = new File(path);
        try {
            Desktop.getDesktop().open(arquivo);
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex, "ERRO", JOptionPane.ERROR_MESSAGE);

        }

    }

    public List<TdDoenca> getDoencas() {
        return doencas;
    }

    public void setDoencas(List<TdDoenca> doencas) {
        this.doencas = doencas;
    }
}
