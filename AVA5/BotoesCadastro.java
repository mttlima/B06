import javax.swing.*;
import java.awt.*;

public class BotoesCadastro {
    private final JDialog dialog;

    public BotoesCadastro(JDialog dialog) {
        this.dialog = dialog;
    }

    public JPanel criar() {
        JPanel painelBotoes = new JPanel(new FlowLayout());
        String[] labels = {"Incluir", "Alterar", "Excluir", "Consultar", "Cancelar", "Sair"};
        for (String label : labels) {
            JButton button = new JButton(label);
            if ("Sair".equals(label)) {
                button.addActionListener(e -> dialog.setVisible(false));
            } else {
                button.addActionListener(e -> JOptionPane.showMessageDialog(dialog, "Botão " + label + " clicado!"));
            }
            painelBotoes.add(button);
        }
        return painelBotoes;
    }
}

class BotoesCadastroCustomizado extends BotoesCadastro {

    public BotoesCadastroCustomizado(JDialog dialog) {
        super(dialog);
    }

    @Override
    public JPanel criar() {
        JPanel painelBotoes = new JPanel(new FlowLayout());
        String[] labels = {"Incluir", "Alterar", "Excluir", "Consultar", "Cancelar", "Sair"};
        for (String label : labels) {
            JButton button = new JButton(label);
            if ("Sair".equals(label)) {
                button.addActionListener(e -> dialog.setVisible(false));
            } else {
                button.addActionListener(e -> JOptionPane.showMessageDialog(dialog, "Botão " + label + " clicado!"));
            }
            // Adicionando um comportamento diferente para o botão "Incluir"
            if ("Incluir".equals(label)) {
                button.addActionListener(e -> JOptionPane.showMessageDialog(dialog, "Botão Incluir customizado clicado!"));
            }
            painelBotoes.add(button);
        }
        return painelBotoes;
    }
}
