/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios.mb;

import collections.factory.ListasFactory;
import collections.mapeamento.TbColaborador;
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
public class RelatorioPorColaboradorMB {
     private List<TbColaborador> colaboradores;

    /**
     * Creates a new instance of RelatorioUsuarios
     */
    public RelatorioPorColaboradorMB() {
        ListasFactory.iniciarPopular();
        colaboradores = ListasFactory.getColaboradores();
    }

    public void impParametrizado() {
        
        ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String path = context.getRealPath("/WEB-INF/reports/Relatorio_de_Analise_por_Colaborador.pdf");
        File arquivo = new File(path);
        try {
            Desktop.getDesktop().open(arquivo);
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex, "ERRO", JOptionPane.ERROR_MESSAGE);

        }

    }

    public List<TbColaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(List<TbColaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }
}
