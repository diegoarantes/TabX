/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arantes.tabs;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.*;

public class TabX extends JPanel {
    private final JTabbedPane pane;

      //
     //CONSTRUTOR
    //
    //Início...
    public TabX(final JTabbedPane pane) {
        //unset default FlowLayout' gaps
        super(new FlowLayout(FlowLayout.LEFT, 0, 0));
        if (pane == null) {
            throw new NullPointerException("TabbedPane is null");
        }
        this.pane = pane;
        setOpaque(false);

        //faz a JLabel ler o título do JTabbedPane
        JLabel label = new JLabel() {
            public String getText() {
                int i = pane.indexOfTabComponent(TabX.this);
                if (i != -1) {
                    return pane.getTitleAt(i);
                }
                return null;
            }
        };

        add(label);
        //adiciona mais espaço entre a label e o botão
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        //tab button
        JButton button = new TabButton();
        add(button);
        //adiciona mais espaço para o topo do componente
        setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0)); //2,
    }//Fim do construtor.

      //
     //CLASSE TABBUTTON
    //
    //Define as características do botão fechar.
    //
    //Início
    private class TabButton extends JButton implements ActionListener {
        public TabButton() {
            int size = 18; //17
            setPreferredSize(new Dimension(size, size));
            setToolTipText("Fechar esta aba!");
            //Faz o botão ser igual para todas as Laf's
            setUI(new BasicButtonUI());
            //Torna-o transparente
            setContentAreaFilled(false);
            //Não necessidade de estar com focusable
            setFocusable(false);
           
            //usamos o mesmo listener para todos os botões
            addMouseListener(buttonMouseListener);
            setRolloverEnabled(true);
            //Fecha a guia apropriada, clicando no botão
            addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
            int i = pane.indexOfTabComponent(TabX.this);
            if (i != -1) {
                
//                //Pega o título da tab fechada
//           String titulo =  jPrincipal.jPaineldeabas.getTitleAt(i);
//                
//           
//           //se for fechada antes de gtravar apaga o cod atual Pega pelo titulo
//           if("Não-Conformidade".equals(titulo)){
//               NaoConformidadeDAO.deleta(NaoConformidade.jcodigo.getText());
//               //seta como false
//               NaoConformidade.statusTela = false;
//               
//           }if("Nota de Melhoria".equals(titulo)){
//                NotaMelhoriaDAO.deleta(NotaMelhoria.jcodigo.getText());
//                
//                NotaMelhoria.statusTela = false;
//           }if("Ação Preventiva".equals(titulo)){
//                AcaoPreventivaDAO.deleta(AcaoPreventiva.jcodigo.getText());
//                
//                AcaoPreventiva.statusTela = false;
//           }if("Consulta de Auditorias".equals(titulo)){
//              
//                Auditoria.statusTela = false;
//           }if("Consulta de Documentos".equals(titulo)){
//              
//                Documentos.statusTela = false;
//           }if("Consulta de Ocorrências".equals(titulo)){
//              
//                Consulta.statusTela = false;
//           }if("Agenda de compromissos".equals(titulo)){
//              
//                Agenda.statusTela = false;
//           }
           
                //Fecha a Aba!
                
                pane.remove(i);
            }
        }
        
        
          
        //pinta o X
       @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            //Graphics2D g2 = (Graphics2D) g.create();
            //mudança na imagem para botões pressionados

           ImageIcon i = new ImageIcon(getClass().getResource("/com/arantes/images/delete16.png"));
            
           //g.drawImage(i, 20, 20, this);
           i.paintIcon(this, g, 0, 3);
            if (getModel().isPressed()) {
              //  g2.translate(1, 1);
            }
            //g2.setStroke(new BasicStroke(2));
            //g2.setColor(Color.BLACK);
            if (getModel().isRollover()) {
                //g2.setColor(Color.RED);
            }
           // int delta = 6;
            //g2.drawLine(delta, delta, getWidth() - delta - 1, getHeight() - delta - 1);
            //g2.drawLine(getWidth() - delta - 1, delta, delta, getHeight() - delta - 1);
            //g2.dispose();
        
        }
      
    }//Fim da classe TabButton.

      //
     //MOUSELISTENER
    //
    //Define os eventos de entrada e saida do mouse.
    //
    //Início...
    private final static MouseListener buttonMouseListener = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            Component component = e.getComponent();
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.setBorderPainted(true);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            Component component = e.getComponent();
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.setBorderPainted(false);
            }
        }
    };//Fim dos Listeners.
}
