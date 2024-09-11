package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import Model.DAO.FilmeDAO;

public class Horarios extends JFrame {
    private JButton botaoVoltar;

    public Horarios(String tituloDoFilme, String caminhoImagem) {
        super(tituloDoFilme);
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
                TelaPrincipal telaPrincipal = new TelaPrincipal();
                setVisible(false);
                telaPrincipal.setVisible(true);
            }
        });

        botaoVoltar.setBounds(10, 10, 100, 40);
        add(botaoVoltar);

        ImageIcon imagemIcon = new ImageIcon(getClass().getResource(caminhoImagem));
        JLabel imagemLabel = new JLabel(imagemIcon);
        JLabel tituloLabel = new JLabel(tituloDoFilme, SwingConstants.CENTER);

        JPanel tituloPanel = new JPanel(new BorderLayout());
        tituloPanel.setBorder(BorderFactory.createEmptyBorder(0, 90, 120, 90));
        tituloPanel.add(tituloLabel, BorderLayout.NORTH);

        JPanel filmePanel = new JPanel(new BorderLayout());
        filmePanel.add(imagemLabel, BorderLayout.CENTER);
        filmePanel.add(tituloPanel, BorderLayout.SOUTH);

        add(filmePanel, BorderLayout.WEST);

        FilmeDAO filmeDAO = new FilmeDAO();
        List<String[]> horarios = filmeDAO.getHorariosDoFilme(tituloDoFilme);

        JPanel panelHorarios = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(50, 130, 50, 50);

        for (String[] horarioInfo : horarios) {
            String sala = horarioInfo[0];
            String horario = horarioInfo[1];
            JButton horarioButton = new JButton(sala + " - " + horario);
            horarioButton.setFont(new Font("Arial", Font.BOLD, 16));
            horarioButton.setBackground(Color.GRAY);
            horarioButton.setForeground(Color.WHITE);
            horarioButton.setFocusPainted(false);

            horarioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Você selecionou: " + sala + " - " + horario);
                    setVisible(false);
                    new Assentos(tituloDoFilme, caminhoImagem, sala, horario);
                }
            });
            panelHorarios.add(horarioButton, gbc);
            gbc.gridy++;
        }

        add(panelHorarios);

        setSize(930, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
