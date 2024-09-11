package View;

import javax.swing.*;

import Model.beans.IngressoBean;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaIngressos extends JFrame {
	private Assentos telaAssentos;
    private JLabel lblTitulo;
    private JLabel lblIngressoComum;
    private JLabel lblIngressoVip;
    private JLabel lblIngressoMeia;
    private JLabel precoComum;
    private JLabel precoMeia;
    private JLabel precoVip;
    private JTextField txtQuantidadeMeia;
    private JTextField txtQuantidadeComum;
    private JTextField txtQuantidadeVip;
    private JButton btnConfirmar;
    private JButton MaisComum;
    private JButton MenosComum;
    private JButton MaisMeia;
    private JButton MenosMeia;
    private JButton MaisVip;
    private JButton MenosVip;
    private JButton botaoVoltar;
    private List<String> selectedSeats;
    private JPanel selectedSeatsPanel;
    private int totalSelectedSeats;
    private int tiposIngressoSelecionados = 0;
    private IngressoBean ingressoBean;
    private String tituloDoFilme;
    
    public TelaIngressos(String tituloDoFilme ,List<String> assentosSelecionados, Assentos telaAssentos) {
    	super("Seleção de Ingressos");
        this.selectedSeats = assentosSelecionados;
        this.totalSelectedSeats = assentosSelecionados.size();
        this.telaAssentos = telaAssentos;
        this.ingressoBean = new IngressoBean();
        this.tituloDoFilme = tituloDoFilme;
        setSize(930, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        
        
        lblTitulo = new JLabel("Selecione o tipo de ingressos:");
        lblTitulo.setBounds(50, 150, 250, 20);
        add(lblTitulo);

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5)); 
        containerPanel.setBounds(50, 165, 250, 40); 

        for (String seat : selectedSeats) {
            JLabel seatLabel = new JLabel(seat);
            seatLabel.setOpaque(true);
            seatLabel.setBackground(Color.RED);
            seatLabel.setForeground(Color.WHITE);
            containerPanel.add(seatLabel);
        }
        add(containerPanel);

        lblIngressoComum = new JLabel("Ingresso Comum:");
        lblIngressoComum.setBounds(80, 200, 120, 20);
        add(lblIngressoComum);

        precoComum = new JLabel("50,00R$");
        precoComum.setBounds(80, 215, 120, 20);
        add(precoComum);

        txtQuantidadeComum = new JTextField("0");
        txtQuantidadeComum.setBounds(236, 200, 24, 24);
        add(txtQuantidadeComum);

        MenosComum = new JButton("-");
        MenosComum.setBackground(Color.GRAY);
        MenosComum.setForeground(Color.WHITE);
        MenosComum.setFocusPainted(false);
        MenosComum.setBounds(190, 205, 41, 20);
        MenosComum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tiposIngressoSelecionados > 0) {
                    int quantidade = Integer.parseInt(txtQuantidadeComum.getText());
                    if (quantidade > 0) {
                        quantidade--;
                        txtQuantidadeComum.setText(String.valueOf(quantidade));
                        tiposIngressoSelecionados--;
                    }
                }
            }
        });
        add(MenosComum);

        MaisComum = new JButton("+");
        MaisComum.setBackground(Color.GRAY);
        MaisComum.setForeground(Color.WHITE);
        MaisComum.setFocusPainted(false);
        MaisComum.setBounds(265, 205, 41, 20);
        MaisComum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tiposIngressoSelecionados < selectedSeats.size()) {
                    int quantidade = Integer.parseInt(txtQuantidadeComum.getText());
                    quantidade++;
                    txtQuantidadeComum.setText(String.valueOf(quantidade));
                    tiposIngressoSelecionados++;
                } else {
                    JOptionPane.showMessageDialog(null, "Você já selecionou ingressos suficientes.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        add(MaisComum);

        lblIngressoMeia = new JLabel("Ingresso Meia:");
        lblIngressoMeia.setBounds(80, 250, 120, 20);
        add(lblIngressoMeia);

        precoMeia = new JLabel("25,00R$");
        precoMeia.setBounds(80, 270, 120, 20);
        add(precoMeia);

        txtQuantidadeMeia = new JTextField("0");
        txtQuantidadeMeia.setBounds(236, 250, 24, 24);
        add(txtQuantidadeMeia);

        MenosMeia = new JButton("-");
        MenosMeia.setBackground(Color.GRAY);
        MenosMeia.setForeground(Color.WHITE);
        MenosMeia.setFocusPainted(false);
        MenosMeia.setBounds(190, 255, 41, 20);
        MenosMeia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tiposIngressoSelecionados > 0) {
                    int quantidade = Integer.parseInt(txtQuantidadeMeia.getText());
                    if (quantidade > 0) {
                        quantidade--;
                        txtQuantidadeMeia.setText(String.valueOf(quantidade));
                        tiposIngressoSelecionados--;
                    }
                }
            }
        });
        add(MenosMeia);

        MaisMeia = new JButton("+");
        MaisMeia.setBackground(Color.GRAY);
        MaisMeia.setForeground(Color.WHITE);
        MaisMeia.setFocusPainted(false);
        MaisMeia.setBounds(265, 255, 41, 20);
        MaisMeia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tiposIngressoSelecionados < selectedSeats.size()) {
                    int quantidade = Integer.parseInt(txtQuantidadeMeia.getText());
                    quantidade++;
                    txtQuantidadeMeia.setText(String.valueOf(quantidade));
                    tiposIngressoSelecionados++;
                } else {
                    JOptionPane.showMessageDialog(null, "Você já selecionou ingressos suficientes.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        add(MaisMeia);

        lblIngressoVip = new JLabel("Ingresso VIP:");
        lblIngressoVip.setBounds(80, 300, 120, 20);
        add(lblIngressoVip);

        precoVip = new JLabel("75,00R$");
        precoVip.setBounds(80, 320, 120, 20);
        add(precoVip);

        txtQuantidadeVip = new JTextField("0");
        txtQuantidadeVip.setBounds(236, 299, 24, 24);
        add(txtQuantidadeVip);

        MenosVip = new JButton("-");
        MenosVip.setBackground(Color.GRAY);
        MenosVip.setForeground(Color.WHITE);
        MenosVip.setFocusPainted(false);
        MenosVip.setBounds(190, 300, 41, 20);
        MenosVip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tiposIngressoSelecionados > 0) {
                    int quantidade = Integer.parseInt(txtQuantidadeVip.getText());
                    if (quantidade > 0) {
                        quantidade--;
                        txtQuantidadeVip.setText(String.valueOf(quantidade));
                        tiposIngressoSelecionados--;
                    }
                }
            }
        });
        add(MenosVip);

        MaisVip = new JButton("+");
        MaisVip.setBackground(Color.GRAY);
        MaisVip.setForeground(Color.WHITE);
        MaisVip.setFocusPainted(false);
        MaisVip.setBounds(265, 300, 41, 20);
        MaisVip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tiposIngressoSelecionados < selectedSeats.size()) {
                    int quantidade = Integer.parseInt(txtQuantidadeVip.getText());
                    quantidade++;
                    txtQuantidadeVip.setText(String.valueOf(quantidade));
                    tiposIngressoSelecionados++;
                } else {
                    JOptionPane.showMessageDialog(null, "Você já selecionou ingressos suficientes.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        add(MaisVip);
        
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(705, 400, 100, 25); 
        btnConfirmar.setSize(150, 30);
        btnConfirmar.setFont(new Font("Arial", Font.BOLD, 16));
        btnConfirmar.setBackground(Color.GRAY);
        btnConfirmar.setForeground(Color.WHITE);
        btnConfirmar.setFocusPainted(false);
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tiposIngressoSelecionados == selectedSeats.size()) {
                   
                    ingressoBean.setQuantidadeComum(Integer.parseInt(txtQuantidadeComum.getText()));
                    ingressoBean.setQuantidadeMeia(Integer.parseInt(txtQuantidadeMeia.getText()));
                    ingressoBean.setQuantidadeVip(Integer.parseInt(txtQuantidadeVip.getText()));
                    
                  
                    double valorTotal = ingressoBean.calcularValorTotal();
                    TelaPagamentos telaPagamentos = new TelaPagamentos(tituloDoFilme, valorTotal, tiposIngressoSelecionados, tituloDoFilme,selectedSeats); 
                    telaPagamentos.setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Você precisa selecionar ingressos para todos os assentos.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        add(btnConfirmar);
        
        botaoVoltar = new JButton("<-- Voltar");
        botaoVoltar.setFont(new Font("Arial", Font.BOLD, 16));
        botaoVoltar.setBackground(Color.GRAY);
        botaoVoltar.setForeground(Color.WHITE);
        botaoVoltar.setFocusPainted(false);
        botaoVoltar.setBounds(29, 24, 94, 23); 
        botaoVoltar.setSize(150, 30);
    
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaAssentos.setVisible(true);
                dispose(); 
            }
        });
        add(botaoVoltar);
        
        setVisible(true);
    }
 
    
}
