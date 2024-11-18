package sistemapessoa;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConfiguracoesSistema {
    public static final String VERSAO_SISTEMA = "12.1.2024";
    public static final String NOME_USUARIO = "denys.silva";
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yy HH:mm");
    public static final String DATA_ACESSO = DATE_FORMAT.format(new Date());

    public String obterConfiguracoes() {
        return "Versão: " + VERSAO_SISTEMA + ", Usuário: " + NOME_USUARIO + ", Data de Acesso: " + DATA_ACESSO;
    }
}

class ConfiguracoesSistemaCustomizado extends ConfiguracoesSistema {

    @Override
    public String obterConfiguracoes() {
        return "Configurações Customizadas - " + super.obterConfiguracoes();
    }
}
