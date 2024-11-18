import javax.swing.*;
import java.awt.*;

public class CadastroUsuarios {
    private final JFrame principal;

    public CadastroUsuarios(JFrame principal) {
        this.principal = principal;
    }

    public void exibir() {
        JDialog dialog = new JDialog(principal, "Cadastro de Usuários", true);
        dialog.setSize(600, 300);
        dialog.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Cadastro de Usuários", SwingConstants.CENTER);
        dialog.add(titulo, BorderLayout.NORTH);

        JPanel painelCampos = new JPanel(new GridLayout(4, 2, 5, 5));
        painelCampos.add(new JLabel("Usuário:"));
        painelCampos.add(new JTextField(25));
        painelCampos.add(new JLabel("Senha:"));
        painelCampos.add(new JPasswordField(15));
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(new JTextField(30));
        painelCampos.add(new JLabel("Ativo:"));
        painelCampos.add(new JRadioButton());

        dialog.add(painelCampos, BorderLayout.CENTER);
        dialog.add(new BotoesCadastro(dialog).criar(), BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(principal);
        dialog.setVisible(true);
    }
}

class CadastroUsuariosCustomizado extends CadastroUsuarios {

    public CadastroUsuariosCustomizado(JFrame principal) {
        super(principal);
    }

    @Override
    public void exibir() {
        JDialog dialog = new JDialog(principal, "Cadastro de Usuários Customizado", true);
        dialog.setSize(600, 300);
        dialog.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Cadastro de Usuários Customizado", SwingConstants.CENTER);
        dialog.add(titulo, BorderLayout.NORTH);

        JPanel painelCampos = new JPanel(new GridLayout(4, 2, 5, 5));
        painelCampos.add(new JLabel("Usuário:"));
        painelCampos.add(new JTextField(25));
        painelCampos.add(new JLabel("Senha:"));
        painelCampos.add(new JPasswordField(15));
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(new JTextField(30));
        painelCampos.add(new JLabel("Ativo:"));
        painelCampos.add(new JRadioButton());

        dialog.add(painelCampos, BorderLayout.CENTER);
        dialog.add(new BotoesCadastroCustomizado(dialog).criar(), BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(principal);
        dialog.setVisible(true);
    }
}
