package View;

import Model.PlaceHolder;
import Model.DAO.CompraDAO;
import Model.DAO.PagamentoDAO;
import Model.beans.IngressoBean;
import Model.Compra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TipoPagamento extends JFrame {
    private PlaceHolder campoCartao;
    private PlaceHolder campoUsuario;
    private PlaceHolder campoValidade;
    private JButton botaoCancelar;
    private JButton botaoConcluir;
    private PlaceHolder campoCPF;
    private PlaceHolder campoCVC;
    private JPanel areaPix;
    private double compra;
    private double valorTotal;
    private String filmeSelecionado;
	private IngressoBean ingressoBean;
    private List<String> selectedSeats;
    private int tiposIngressoSelecionados;
    public TipoPagamento(String tipoPagamento, double valorTotal, int tiposIngressoSelecionados, String filmeSelecionado, List<String> selectedSeats) {
    	this.selectedSeats = selectedSeats;
    	this.tiposIngressoSelecionados = tiposIngressoSelecionados;
    	this.compra = valorTotal;
    	this.filmeSelecionado = filmeSelecionado;
    	this.ingressoBean = new IngressoBean();
        if (!tipoPagamento.equals("Pix")) {
            configurarPagamentoCartao();
        } else {
            configurarPagamentoPix();
        }
    }

   
	private void configurarPagamentoCartao() {
        setTitle("Pagamento com Cartão");
        setSize(500, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel labelCartao = new JLabel("Número do cartão");
        labelCartao.setFont(new Font("Arial", Font.PLAIN, 16));
        campoCartao = new PlaceHolder("Número do cartão");
        campoCartao.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(labelCartao);
        panel.add(campoCartao);

        JLabel labelUsuario = new JLabel("Nome do titular");
        labelUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
        campoUsuario = new PlaceHolder("Nome do titular");
        campoUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(labelUsuario);
        panel.add(campoUsuario);

        JLabel labelCPF = new JLabel("CPF");
        labelCPF.setFont(new Font("Arial", Font.PLAIN, 16));
        campoCPF = new PlaceHolder("CPF");
        campoCPF.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(labelCPF);
        panel.add(campoCPF);

        JLabel labelValidade = new JLabel("Data de validade");
        labelValidade.setFont(new Font("Arial", Font.PLAIN, 16));
        campoValidade = new PlaceHolder("MM/YY");
        campoValidade.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(labelValidade);
        panel.add(campoValidade);

        JLabel labelCVC = new JLabel("CVC");
        labelCVC.setFont(new Font("Arial", Font.PLAIN, 16));
        campoCVC = new PlaceHolder("CVC");
        campoCVC.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(labelCVC);
        panel.add(campoCVC);

        configurarBotoes(panel);

        add(panel);
        setVisible(true);
    }

    private void configurarBotoes(JPanel panel) {
        botaoConcluir = new JButton("Concluir pagamento");
        botaoConcluir.setFont(new Font("Arial", Font.BOLD, 16));
        botaoConcluir.setBackground(Color.GRAY);
        botaoConcluir.setForeground(Color.WHITE);
        botaoConcluir.setFocusPainted(false);

        botaoConcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarPagamento();
            }
        });

        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setFont(new Font("Arial", Font.BOLD, 16));
        botaoCancelar.setBackground(Color.BLACK);
        botaoCancelar.setForeground(Color.WHITE);
        botaoCancelar.setFocusPainted(false);

        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Pedido Cancelado");
                setVisible(false);
            }
        });

        panel.add(botaoCancelar);
        panel.add(botaoConcluir);
    }

    private void finalizarPagamento() {
        String numeroCartao = campoCartao.getText();
        String nomeTitular = campoUsuario.getText();
        String cpf = campoCPF.getText();
        String dataValidade = campoValidade.getText();
        String cvc = campoCVC.getText();

        if (camposPreenchidos()) {
           
            int quantidadeIngressos = tiposIngressoSelecionados;
              double valor = ingressoBean.calcularValorTotal();
            Compra compra = new Compra(filmeSelecionado, valor, selectedSeats, quantidadeIngressos);
            
            PagamentoDAO pagamentoDAO = new PagamentoDAO();
            try {
                pagamentoDAO.inserirPagamentoCartao(numeroCartao, nomeTitular, cpf, dataValidade, cvc);
                CompraDAO.registrarCompra(compra);
                JOptionPane.showMessageDialog(botaoConcluir, "Pagamento Confirmado");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao finalizar o pagamento: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
        }
    }
    private boolean camposPreenchidos() {
        return !campoCartao.getText().isEmpty() &&
               !campoUsuario.getText().isEmpty() &&
               !campoCPF.getText().isEmpty() &&
               !campoValidade.getText().isEmpty() &&
               !campoCVC.getText().isEmpty();
    }

    private void configurarPagamentoPix() {
        setTitle("Pagamento via Pix");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        areaPix = new JPanel(new BorderLayout());
        add(areaPix, BorderLayout.CENTER);

        setVisible(true);
    }


    private void adicionarImagemQRCode(String caminhoImagem, int width, int height) {
        ImageIcon imagemIcon = new ImageIcon(getClass().getResource(caminhoImagem));
        Image imagem = imagemIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon imagemRedimensionada = new ImageIcon(imagem);

        JLabel labelImagem = new JLabel(imagemRedimensionada, SwingConstants.CENTER);
        areaPix.add(labelImagem, BorderLayout.CENTER);
    }
}
