import models.Funcionario;
import services.FuncionarioService;
import utils.Formatador;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApplicationIniflex {

    public  static  void main(String[] args) {

        FuncionarioService service = new FuncionarioService();

        // Adicionando funcionários
        service.adicionarFuncionario(new Funcionario("Maria", "2000-10-18", new BigDecimal("2009.44"), "Operador"));
        service.adicionarFuncionario(new Funcionario("João", "1990-05-12", new BigDecimal("2284.38"), "Operador"));
        service.adicionarFuncionario(new Funcionario("Caio", "1961-05-02", new BigDecimal("9836.14"), "Coordenador"));
        service.adicionarFuncionario(new Funcionario("Miguel", "1988-10-14", new BigDecimal("19119.88"), "Diretor"));
        service.adicionarFuncionario(new Funcionario("Alice", "1995-01-05", new BigDecimal("2234.68"), "Recepcionista"));
        service.adicionarFuncionario(new Funcionario("Heitor", "1999-11-19", new BigDecimal("1582.72"), "Operador"));
        service.adicionarFuncionario(new Funcionario("Arthur", "1993-03-31", new BigDecimal("4071.84"), "Contador"));
        service.adicionarFuncionario(new Funcionario("Laura", "1994-07-08", new BigDecimal("3017.45"), "Gerente"));
        service.adicionarFuncionario(new Funcionario("Heloísa", "2003-05-24", new BigDecimal("1606.85"), "Eletricista"));
        service.adicionarFuncionario(new Funcionario("Helena", "1996-09-02", new BigDecimal("2799.93"), "Gerente"));

        // Remove João
        service.removerFuncionario("João");

        service.listarFuncionarios();
        service.aumentarSalario(10);
        service.agruparPorFuncao();
        service.listarAniversariantes(10, 12);
        service.obterFuncionarioMaisVelho();
        service.listarOrdenadoPorNome();
        service.calcularTotalSalarios();
        service.calcularSalariosMinimos(BigDecimal.valueOf(1212.00));
    }
}
