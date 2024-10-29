import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaPessoa {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema de Pessoa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel cadastroPanel = new JPanel();
        JPanel visualizacaoPanel = new JPanel(new BorderLayout());
        JPanel sairPanel = new JPanel(new BorderLayout());


        tabbedPane.addTab("Cadastro", cadastroPanel);
        tabbedPane.addTab("Visualização", visualizacaoPanel);
        tabbedPane.addTab("Sair", sairPanel);


        frame.add(tabbedPane);

        placeComponents(cadastroPanel);
        placeVisualizacaoComponents(visualizacaoPanel);
        placeVisualizacaoComponents(sairPanel);


        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Usuário:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 80, 80, 25);
        panel.add(emailLabel);

        JTextField emailText = new JTextField(20);
        emailText.setBounds(100, 80, 165, 25);
        panel.add(emailText);

        JLabel activeLabel = new JLabel("Ativo:");
        activeLabel.setBounds(10, 110, 80, 25);
        panel.add(activeLabel);

        JRadioButton activeButton = new JRadioButton();
        activeButton.setBounds(100, 110, 25, 25);
        panel.add(activeButton);

        JButton incluirButton = new JButton("Incluir");
        incluirButton.setBounds(10, 150, 100, 25);
        panel.add(incluirButton);

        JButton alterarButton = new JButton("Alterar");
        alterarButton.setBounds(120, 150, 100, 25);
        panel.add(alterarButton);

        JButton excluirButton = new JButton("Excluir");
        excluirButton.setBounds(230, 150, 100, 25);
        panel.add(excluirButton);

        JButton consultarButton = new JButton("Consultar");
        consultarButton.setBounds(340, 150, 100, 25);
        panel.add(consultarButton);

        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.setBounds(450, 150, 100, 25);
        panel.add(cancelarButton);

        JButton sairButtonInferior = new JButton("Sair");
        sairButtonInferior.setBounds(560, 150, 100, 25);
        panel.add(sairButtonInferior);

        incluirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, "Botão clicado!");
            }
        });

        alterarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, "Botão clicado!");
            }
        });

        excluirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, "Botão clicado!");
            }
        });

        consultarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, "Botão clicado!");
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, "Botão clicado!");
            }
        });

        sairButtonInferior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private static void placeVisualizacaoComponents(JPanel panel) {
        JPanel buttonPanel = new JPanel(new BorderLayout());

        JButton sairButtonSuperior = new JButton("Sair");
        buttonPanel.add(sairButtonSuperior, BorderLayout.NORTH);

        JButton sairButtonInferior = new JButton("Sair (Inferior)");
        buttonPanel.add(sairButtonInferior, BorderLayout.SOUTH);

        panel.add(buttonPanel, BorderLayout.CENTER);

        sairButtonSuperior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        sairButtonInferior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
