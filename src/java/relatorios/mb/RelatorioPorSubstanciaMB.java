/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios.mb;

import collections.factory.ListasFactory;
import collections.mapeamento.TbMedicamento;
import java.awt.Desktop;
import java.io.File;
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
public class RelatorioPorSubstanciaMB {
    private List<TbMedicamento> medicamentos;

    /**
     * Creates a new instance of RelatorioPorSubstanciaMB
     */
 public RelatorioPorSubstanciaMB() {
      ListasFactory.iniciarPopular();
        medicamentos = ListasFactory.getMedicamentos();
    }
      public void impParametrizado() {
        
        ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String path = context.getRealPath("/WEB-INF/reports/Relatorio_de_Substancia_por_Medicamento.pdf");
        File arquivo = new File(path);
        try {
            Desktop.getDesktop().open(arquivo);
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex, "ERRO", JOptionPane.ERROR_MESSAGE);

        }

    }

    public List<TbMedicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<TbMedicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }
}
