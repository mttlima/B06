import javax.swing.*; // Importa a biblioteca Swing para interface gráfica
import java.awt.*; // Importa classes para layout e componentes gráficos
import java.awt.event.ActionEvent; // Importa classe para eventos de ação
import java.awt.event.ActionListener; // Importa interface para ouvir eventos de ação

public class CadastroWindows extends JFrame {
    // Constantes para o limite de registros
    private static final int LIM_REG = 100; // Número máximo de registros
    private static String[][] registros = new String[LIM_REG][3]; // Matriz para armazenar registros (CPF, Nome, Telefone)
    private static int totalRegistros = 0; // Contador de registros cadastrados

    // Componentes da interface
    private JTextField cpfField; // Campo para entrada do CPF
    private JTextField nomeField; // Campo para entrada do Nome
    private JTextField telefoneField; // Campo para entrada do Telefone

    public CadastroWindows() {
        setTitle("Cadastro de Nomes"); // Título da janela
        setSize(400, 400); // Tamanho da janela
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Comportamento ao fechar a janela
        setLayout(new BorderLayout()); // Layout da janela

        // Menu
        JMenuBar menuBar = new JMenuBar(); // Cria a barra de menu
        JMenu menuCadastro = new JMenu("Cadastro"); // Cria o menu "Cadastro"
        JMenuItem menuItemCadastroNome = new JMenuItem("Cadastro de Nome"); // Opção para cadastro de nome
        JMenuItem menuItemListaNome = new JMenuItem("Lista de Nomes"); // Opção para listar nomes

        // Adiciona as opções ao menu
        menuCadastro.add(menuItemCadastroNome);
        menuCadastro.add(menuItemListaNome);
        menuBar.add(menuCadastro); // Adiciona o menu à barra de menu
        setJMenuBar(menuBar); // Define a barra de menu na janela

        // Painel para os campos de entrada
        JPanel inputPanel = new JPanel(new GridLayout(4, 2)); // Cria um painel com grid de 4 linhas e 2 colunas
        cpfField = new JTextField(); // Inicializa o campo para CPF
        nomeField = new JTextField(); // Inicializa o campo para Nome
        telefoneField = new JTextField(); // Inicializa o campo para Telefone

        // Adiciona rótulos e campos ao painel
        inputPanel.add(new JLabel("CPF:")); // Rótulo para CPF
        inputPanel.add(cpfField); // Campo para CPF
        inputPanel.add(new JLabel("Nome:")); // Rótulo para Nome
        inputPanel.add(nomeField); // Campo para Nome
        inputPanel.add(new JLabel("Telefone:")); // Rótulo para Telefone
        inputPanel.add(telefoneField); // Campo para Telefone
        inputPanel.add(new JLabel("")); // Linha em branco para espaçamento

        // Botões em um painel separado
        JPanel buttonPanel = new JPanel(new FlowLayout()); // Cria um painel para botões com layout em linha
        JButton incluirButton = new JButton("Incluir"); // Botão para incluir registro
        JButton alterarButton = new JButton("Alterar"); // Botão para alterar registro

        // Adiciona os botões ao painel
        buttonPanel.add(incluirButton);
        buttonPanel.add(alterarButton);
        add(inputPanel, BorderLayout.NORTH); // Adiciona o painel de entrada ao topo da janela
        add(buttonPanel, BorderLayout.CENTER); // Adiciona o painel de botões ao centro da janela

        // Ações dos botões
        incluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incluirRegistro(); // Chama o método para incluir registro
            }
        });

        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alterarRegistro(); // Chama o método para alterar registro
            }
        });

        // Ações do menu
        menuItemCadastroNome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCadastro(); // Chama o método para mostrar a tela de cadastro
            }
        });

        menuItemListaNome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarRegistros(); // Chama o método para listar registros
            }
        });
    }

    private void mostrarCadastro() {
        // Limpar campos e mostrar painel de cadastro
        limparCampos(); // Limpa os campos de entrada
        cpfField.setVisible(true); // Torna o campo CPF visível
        nomeField.setVisible(true); // Torna o campo Nome visível
        telefoneField.setVisible(true); // Torna o campo Telefone visível
    }

    private void incluirRegistro() {
        // Método para incluir um novo registro
        if (totalRegistros >= LIM_REG) { // Verifica se atingiu o limite de registros
            JOptionPane.showMessageDialog(this, "Cadastro cheio!", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Sai do método
        }
        // Armazena os dados nos registros
        registros[totalRegistros][0] = cpfField.getText();
        registros[totalRegistros][1] = nomeField.getText();
        registros[totalRegistros][2] = telefoneField.getText();
        totalRegistros++; // Incrementa o contador de registros
        JOptionPane.showMessageDialog(this, "Registro incluído com sucesso!"); // Mensagem de sucesso
        limparCampos(); // Limpa os campos de entrada
    }

    private void alterarRegistro() {
        // Método para alterar um registro existente
        String cpf = cpfField.getText(); // Obtém o CPF do campo
        int indice = buscarRegistroPorCPF(cpf); // Busca o índice do registro
        if (indice == -1) { // Se não encontrar o registro
            JOptionPane.showMessageDialog(this, "Registro não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Sai do método
        }
        // Atualiza os dados do registro
        registros[indice][1] = nomeField.getText();
        registros[indice][2] = telefoneField.getText();
        JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!"); // Mensagem de sucesso
        limparCampos(); // Limpa os campos de entrada
    }

    private void listarRegistros() {
        // Método para listar todos os registros cadastrados
        StringBuilder sb = new StringBuilder(); // Usado para construir a string da lista
        for (int i = 0; i < totalRegistros; i++) {
            sb.append("CPF: ").append(registros[i][0]) // Adiciona CPF à lista
              .append(", Nome: ").append(registros[i][1]) // Adiciona Nome à lista
              .append(", Telefone: ").append(registros[i][2]).append("\n"); // Adiciona Telefone à lista
        }

        // Mostrar a lista em um diálogo
        JTextArea textArea = new JTextArea(sb.toString()); // Cria uma área de texto para exibir a lista
        textArea.setEditable(false); // Torna a área de texto não editável
        JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Lista de Nomes", JOptionPane.INFORMATION_MESSAGE); // Exibe a lista em um diálogo
    }

    private int buscarRegistroPorCPF(String cpf) {
        // Método para buscar um registro pelo CPF
        for (int i = 0; i < totalRegistros; i++) {
            if (registros[i][0].equals(cpf)) { // Verifica se o CPF corresponde
                return i; // Retorna o índice do registro encontrado
            }
        }
        return -1; // Retorna -1 se não encontrar
    }

    private void limparCampos() {
        // Método para limpar os campos de entrada
        cpfField.setText(""); // Limpa o campo CPF
        nomeField.setText(""); // Limpa o campo Nome
        telefoneField.setText(""); // Limpa o campo Telefone
    }

    public static void main(String[] args) {
        // Método principal para iniciar a aplicação
        SwingUtilities.invokeLater(() -> {
            CadastroWindows app = new CadastroWindows(); // Cria uma instância da aplicação
            app.setVisible(true); // Torna a aplicação visível
        });
    }
}