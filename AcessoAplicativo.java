import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AcessoAplicativo {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Acesso Aplicativo");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel userLabel = new JLabel("Usuário:");
        userLabel.setBounds(10, 20, 80, 25);
        
        JTextField userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        
        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(10, 50, 80, 25);
        
        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        
        JButton confirmButton = new JButton("Confirmar");
        confirmButton.setBounds(10, 80, 120, 25);
        
        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setBounds(150, 80, 120, 25);
        
        frame.add(userLabel);
        frame.add(userText);
        frame.add(passwordLabel);
        frame.add(passwordText);
        frame.add(confirmButton);
        frame.add(cancelButton);
        
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.");
                } else if ("denys.silva".equals(username) && "Teste@2024".equals(password)) {
                    JOptionPane.showMessageDialog(frame, "Acesso confirmado!");
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Usuário ou senha inválido!");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); 
            }
        });

        userText.requestFocus(); // Foco no campo de usuário
        frame.setVisible(true);
    }
}