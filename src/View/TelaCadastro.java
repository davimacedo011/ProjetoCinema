package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Model.DAO.CadastroDAO;

public class TelaCadastro extends JFrame {
    private JTextField campoNome;
    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    private JButton botaoLogin;
    private JButton botaoCadastro;

    public TelaCadastro() {
        setTitle("Cadastro");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 3));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel labelNome = new JLabel("Nome:");
        labelNome.setFont(new Font("Arial", Font.PLAIN, 16));
        campoNome = new JTextField();
        campoNome.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel labelUsuario = new JLabel("Usuário:");
        labelUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
        campoUsuario = new JTextField();
        campoUsuario.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setFont(new Font("Arial", Font.PLAIN, 16));
        campoSenha = new JPasswordField();
        campoSenha.setFont(new Font("Arial", Font.PLAIN, 16));

        botaoCadastro = new JButton("Cadastre-se");
        botaoCadastro.setFont(new Font("Arial", Font.BOLD, 16));
        botaoCadastro.setBackground(Color.GRAY);
        botaoCadastro.setForeground(Color.WHITE);
        botaoCadastro.setFocusPainted(false);

        botaoLogin = new JButton("Voltar ao Login");
        botaoLogin.setFont(new Font("Arial", Font.BOLD, 16));
        botaoLogin.setBackground(Color.BLACK);
        botaoLogin.setForeground(Color.WHITE);
        botaoLogin.setFocusPainted(false);

        botaoCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarCadastro();
            }
        });

        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaLogin().setVisible(true);
            }
        });

        panel.add(labelNome);
        panel.add(campoNome);
        panel.add(labelUsuario);
        panel.add(campoUsuario);
        panel.add(labelSenha);
        panel.add(campoSenha);
        panel.add(new JLabel());
        panel.add(botaoCadastro);
        panel.add(botaoLogin);
        add(panel);
        setVisible(true);
    }

    private void realizarCadastro() {
        String nome = campoNome.getText();
        String usuario = campoUsuario.getText();
        String senha = new String(campoSenha.getPassword());

        CadastroDAO cadastroDAO = new CadastroDAO();
        if (cadastroDAO.cadastrarUsuario(nome, usuario, senha)) {
            JOptionPane.showMessageDialog(this, "Cadastro Feito!");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao realizar o cadastro.");
        }
    }
}
