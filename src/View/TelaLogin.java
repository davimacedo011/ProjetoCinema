package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Model.DAO.UsuarioDAO;

public class TelaLogin extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    private JButton botaoLogin;
    private JButton botaoCadastro;

    public TelaLogin() {
        setTitle("Login");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
      
        JLabel labelUsuario = new JLabel("Usuário:");
        labelUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
        campoUsuario = new JTextField();
        campoUsuario.setFont(new Font("Arial", Font.PLAIN, 16)); 

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setFont(new Font("Arial", Font.PLAIN, 16)); 
        campoSenha = new JPasswordField();
        campoSenha.setFont(new Font("Arial", Font.PLAIN, 16));

        botaoLogin = new JButton("Login");
        botaoLogin.setFont(new Font("Arial", Font.BOLD, 16)); 
        botaoLogin.setBackground(Color.BLACK); 
        botaoLogin.setForeground(Color.WHITE); 
        botaoLogin.setFocusPainted(false);
         
        botaoCadastro = new JButton("Cadastre-se");
        botaoCadastro.setFont(new Font("Arial", Font.BOLD, 16));
        botaoCadastro.setBackground(Color.GRAY);
        botaoCadastro.setForeground(Color.WHITE);
        botaoCadastro.setFocusPainted(false);
         
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (realizarLogin()) {
                    setDefaultCloseOperation(EXIT_ON_CLOSE);
                    setVisible(false);
                }
            }
        });
         
        botaoCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); 
                new TelaCadastro().setVisible(true);
            }
        });
         
        panel.add(labelUsuario);
        panel.add(campoUsuario);
        panel.add(labelSenha);
        panel.add(campoSenha);
        panel.add(new JLabel());
        panel.add(botaoLogin);
        panel.add(botaoCadastro);
        add(panel);
        setVisible(true);
    }
 	
    private boolean realizarLogin() {
        String usuario = campoUsuario.getText();
        String senha = new String(campoSenha.getPassword());

        Model.DAO.UsuarioDAO usuarioDAO = new Model.DAO.UsuarioDAO();
        if (usuarioDAO.validarUsuario(usuario, senha)) {
            JOptionPane.showMessageDialog(this, "Login bem-sucedido!");
            new TelaPrincipal();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos!");
            return false;
        }
    }
}
