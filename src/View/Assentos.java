package View;

import javax.swing.*;
import Model.DAO.AssentoDAO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Assentos extends JFrame {
    private List<String> assentosDisponiveis;
    private List<JButton> assentoButtons;
    private AssentoDAO assentoDAO; 
    private List<String> assentosSelecionados; // Lista de assentos selecionados
    private JButton continuarButton;
    private JButton botaoVoltar;
    private String tituloDoFilme;
    JPanel assentosPanel = new JPanel(new GridLayout(0, 6));

    public Assentos(String tituloDoFilme, String caminhoImagem, String sala, String horario) {
    	 this.tituloDoFilme = tituloDoFilme;
        assentoDAO = new AssentoDAO(); 
        assentoButtons = new ArrayList<>();
        assentosSelecionados = new ArrayList<>();
        carregarAssentos(assentosPanel, sala, horario); 
        add(assentosPanel, BorderLayout.CENTER);

        setTitle("Assentos Cinema");
        setSize(930, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        continuarButton = new JButton("Continuar");
        continuarButton.setFont(new Font("Arial", Font.BOLD, 16));
        continuarButton.setBackground(Color.GRAY);
        continuarButton.setForeground(Color.WHITE);
        continuarButton.setFocusPainted(false);
        continuarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaIngressos telaIngressos = new TelaIngressos(tituloDoFilme,assentosSelecionados, Assentos.this);
                telaIngressos.setVisible(true);
                setVisible(false);
            }
        });

        botaoVoltar = new JButton("<-- Voltar");
        botaoVoltar.setFont(new Font("Arial", Font.BOLD, 16));
        botaoVoltar.setBackground(Color.GRAY);
        botaoVoltar.setForeground(Color.WHITE);
        botaoVoltar.setFocusPainted(false);
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Horarios horarios = new Horarios(tituloDoFilme, caminhoImagem);
                setVisible(false);
                horarios.setVisible(true);
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(botaoVoltar);
        buttonPanel.add(continuarButton);
        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
        setVisible(true);
    }

    private void carregarAssentos(JPanel assentosPanel, String sala, String horario) {
        assentosDisponiveis = assentoDAO.carregarAssentos(sala, horario); 
        for (String assento : assentosDisponiveis) {
            JButton button = new JButton(assento);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton clickedButton = (JButton) e.getSource();
                    String assentoText = clickedButton.getText();
                    boolean disponivel = clickedButton.getBackground().equals(Color.RED);
                    clickedButton.setBackground(disponivel ? Color.ORANGE : Color.RED);
                    // Atualiza a lista de assentos selecionados
                    if (disponivel) {
                        assentosSelecionados.remove(assentoText);
                    } else {
                        assentosSelecionados.add(assentoText);
                    }
                    
                    atualizarDisponibilidadeAssento(sala, horario, assentoText, !disponivel);
                }
            });
            boolean disponivel = assentoDAO.verificarDisponibilidadeAssento(sala, horario, assento);
            button.setBackground(disponivel ? Color.RED : Color.ORANGE);
            assentoButtons.add(button);
            assentosPanel.add(button); 
        }
    }

    private void atualizarDisponibilidadeAssento(String sala, String horario, String assento, boolean disponivel) {
        assentoDAO.atualizarDisponibilidadeAssento(sala, horario, assento, disponivel);
    }
}