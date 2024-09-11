package View;


import javax.swing.*;

import Model.Compra;
import Model.DAO.CompraDAO;
import Model.DAO.ConectaBD;
import Model.DAO.HistoricoComprasDAO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TelaPrincipal extends JFrame {
    private JMenuBar menuBar;
    private JMenu menuOpcoes;
    private JMenuItem historicoComprasMenuItem;
    private JMenuItem verMeuIngressoMenuItem;
    private JPanel filmesPanel;
    private JTextField campoIdCompraExcluir;
    private JButton btnExcluirCompra;
    private String filmeSelecionado;
    private String caminhoImagemSelecionado;

    public TelaPrincipal() {
        setTitle("Cinema XYZ");
        setSize(930, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        filmesPanel = new JPanelGradient();
        filmesPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 120));

        adicionarFilme("Guerra Civil", "/Assets/download.jpg");
        adicionarFilme("Ursinho Pooh: Sangue e Mel 2", "/Assets/ursinho-pooh-sangue-e-mel-2-poster-desktop-5770c.png");
        adicionarFilme("Kung-Fu Panda 4", "/Assets/kung-fu-panda-4-poster-desktop-5558c.jpg");
        adicionarFilme("Godzilla e Kong - Novo Imperio", "/Assets/godzilla-e-kong-o-novo-imperio-poster-desktop-5605c.jpg");
        adicionarFilme("Garfield - Fora de Casa", "/Assets/garfield-fora-de-casa-poster-desktop-5823c.jpg");
        adicionarFilme("O Dublê", "/Assets/o-duble-poster-desktop-5621c.png");
        adicionarFilme("A Teia", "/Assets/a-teia-poster-desktop-5696c.jpg");

        add(new JScrollPane(filmesPanel));

        menuBar = new JMenuBar();
        menuOpcoes = new JMenu("Opções");
        historicoComprasMenuItem = new JMenuItem("Histórico de Compras");
        verMeuIngressoMenuItem = new JMenuItem("Ver Meu Ingresso");
        menuOpcoes.add(historicoComprasMenuItem);
        menuOpcoes.add(verMeuIngressoMenuItem);
        menuBar.add(menuOpcoes);

        setJMenuBar(menuBar);

        historicoComprasMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 exibirHistoricoCompras();
            }
        });

        verMeuIngressoMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                	String nomeUsuario = "pedro123";
                    List<Compra> compras = CompraDAO.obterComprasDoUsuario(nomeUsuario); 
                 
                    StringBuilder mensagem = new StringBuilder();
                    mensagem.append("Seus ingressos:\n");
                    for (Compra compra : compras) {
                        mensagem.append("Filme: ").append(compra.getFilme()).append("\n");
                        mensagem.append("Tipo de ingresso: ").append(compra.getTipoIngresso()).append("\n");
                        mensagem.append("Quantidade de ingressos: ").append(compra.getQuantidadeIngressos()).append("\n");
                        mensagem.append("Valor total: ").append(compra.getValorTotal()).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(TelaPrincipal.this, mensagem.toString());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(TelaPrincipal.this, "Erro ao obter os ingressos: " + ex.getMessage());
                }
            }
        });     
     
        setVisible(true);
    }

    private void adicionarFilme(String titulo, String caminhoImagem) {
        JPanel filmePanel = new JPanel(new BorderLayout());

        ImageIcon imagem = new ImageIcon(getClass().getResource(caminhoImagem));
        JButton filmeButton = new JButton(imagem);
        filmeButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        filmeButton.setHorizontalTextPosition(SwingConstants.CENTER);
        filmeButton.setPreferredSize(new Dimension(140, 220));

        filmeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                filmeSelecionado = titulo;
                caminhoImagemSelecionado = caminhoImagem;

                
                Horarios horarios = new Horarios(filmeSelecionado, caminhoImagemSelecionado);
                horarios.setVisible(true);
            }
        });

        JLabel tituloLabel = new JLabel(titulo, SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 11));
        tituloLabel.setForeground(Color.BLACK);
        tituloLabel.setVerticalAlignment(SwingConstants.CENTER);
        tituloLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        filmePanel.add(filmeButton, BorderLayout.CENTER);
        filmePanel.add(tituloLabel, BorderLayout.SOUTH);

        filmesPanel.add(filmePanel);
    }

    class JPanelGradient extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            int width = getWidth();
            int height = getHeight();

            Color color1 = new Color(0x800000);
            Color color2 = new Color(0x000000);

            GradientPaint gradient = new GradientPaint(0, 0, color1, width, 0, color2);

            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, width, height);
        }
    }
    private void exibirHistoricoCompras() {
       
        HistoricoComprasDAO historicoComprasDAO = new HistoricoComprasDAO();
        
        try {
            
            Connection connection = ConectaBD.getConexao();
            
           
            List<String> historico = historicoComprasDAO.obterHistoricoCompras(connection);
            
          
            StringBuilder historicoString = new StringBuilder();
            for (String registro : historico) {
                historicoString.append(registro).append("\n");
            }
            JOptionPane.showMessageDialog(this, historicoString.toString(), "Histórico de Compras", JOptionPane.INFORMATION_MESSAGE);
            
            
            ConectaBD.fecharConexao(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao acessar o histórico de compras: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    }

