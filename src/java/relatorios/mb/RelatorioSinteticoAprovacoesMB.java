/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios.mb;

import java.awt.Desktop;
import java.io.File;
import java.util.HashMap;
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
public class RelatorioSinteticoAprovacoesMB {

    /**
     * Creates a new instance of RelatorioPorSubstanciaMB
     */
 public RelatorioSinteticoAprovacoesMB() {
    }
      public void impParametrizado() {
        
        ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String path = context.getRealPath("/WEB-INF/reports/Relatorio_sintetico_de_aprovacoes.pdf");
        File arquivo = new File(path);
        try {
            Desktop.getDesktop().open(arquivo);
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex, "ERRO", JOptionPane.ERROR_MESSAGE);

        }

    }
    }

