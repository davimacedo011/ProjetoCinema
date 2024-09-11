package Control;
import javax.swing.*;

import View.TelaPrincipal;
import View.TelaLogin;
import View.TelaCadastro;
import View.TelaIngressos;
import View.Assentos;
import View.Horarios;
import View.TelaPagamentos;
import View.TipoPagamento;
public class Teste {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaPrincipal ();
                
                
            }
        });

	}
}
