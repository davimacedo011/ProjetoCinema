package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Model.beans.IngressoBean;
public class TelaPagamentos extends JFrame {
    private JPanel logoPagamentos;
    private JButton botaoVoltar;
    private JLabel lblValorTotal;
    private double valorTotal;
    private String tituloDoFilme;
    private List<String> selectedSeats;
	private IngressoBean ingressoBean;
	private int tiposIngressoSelecionados;
    public TelaPagamentos(String tituloDoFilme, double valorTotal, int tiposIngressoSelecionados, String filmeSelecionado,List<String> selectedSeats) {
    	this.tiposIngressoSelecionados = tiposIngressoSelecionados;
    	this.ingressoBean = new IngressoBean();
    	this.selectedSeats = selectedSeats;
    	 this.tituloDoFilme = tituloDoFilme;
    	  this.valorTotal = valorTotal;
    	  
    	   
        setSize(930, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        botaoVoltar = new JButton("Voltar");
        botaoVoltar.setFont(new Font("Arial", Font.BOLD, 16));
        botaoVoltar.setBackground(Color.GRAY);
        botaoVoltar.setForeground(Color.WHITE);
        botaoVoltar.setFocusPainted(false);
        botaoVoltar.setPreferredSize(new Dimension(10, 40));
        botaoVoltar.setLocation(10, 60);
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            }
        });
        botaoVoltar.setBounds(10, 10, 100, 40);
        add(botaoVoltar);

        lblValorTotal = new JLabel("Valor Total: R$ " + String.format("%.2f", valorTotal));
        lblValorTotal.setFont(new Font("Arial", Font.BOLD, 20));
        lblValorTotal.setBounds(550, 360, 350, 40);
        add(lblValorTotal);

        logoPagamentos = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 120));

        addLogoPagamento("/Assets/cartao_credito.png", "Cartão de Crédito", 140, 150, tituloDoFilme, valorTotal);
        addLogoPagamento("/Assets/cartao_debito.png", "Cartão de Débito", 140, 150, tituloDoFilme, valorTotal);
        addLogoPagamento("/Assets/pix.png", "Pix", 140, 150, filmeSelecionado, valorTotal);

        add(logoPagamentos);
        setVisible(true);
    }

    private void addLogoPagamento(String caminhoImagem, String tipoPagamento, int width, int height, String tituloDoFilme, double valorTotal) {
        ImageIcon imagemIcon = new ImageIcon(getClass().getResource(caminhoImagem));
        Image imagem = imagemIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon imagemRedimensionada = new ImageIcon(imagem);

        JButton botaoPagamento = new JButton(imagemRedimensionada);
        botaoPagamento.setVerticalTextPosition(SwingConstants.BOTTOM);
        botaoPagamento.setHorizontalTextPosition(SwingConstants.CENTER);
        botaoPagamento.setPreferredSize(new Dimension(width, height));
        botaoPagamento.setContentAreaFilled(false);

        JLabel labelTipoPagamento = new JLabel(tipoPagamento, SwingConstants.CENTER);
        labelTipoPagamento.setFont(new Font("Arial", Font.BOLD, 11));
        labelTipoPagamento.setForeground(Color.BLACK);
        labelTipoPagamento.setVerticalAlignment(SwingConstants.CENTER);
        labelTipoPagamento.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelPagamento = new JPanel(new BorderLayout());
        panelPagamento.add(botaoPagamento, BorderLayout.CENTER);
        panelPagamento.add(labelTipoPagamento, BorderLayout.SOUTH);

        botaoPagamento.addActionListener(e -> {
        	ingressoBean.calcularValorTotal();
        	TipoPagamento tipoPagamentoObj = new TipoPagamento(tipoPagamento, valorTotal, tiposIngressoSelecionados, tituloDoFilme, selectedSeats);
        });

        logoPagamentos.add(panelPagamento);
    }
}
