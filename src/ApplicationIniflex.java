import models.Funcionario;
import services.FuncionarioService;

import java.math.BigDecimal;


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

        System.out.println("Imprime a lista de funcionáios sem o João");
        service.listarFuncionarios();
        System.out.println("------------------------------------\n");

        System.out.println("Aumenta o salário em 10%");
        service.aumentarSalario(10);
        service.listarFuncionarios();
        System.out.println("------------------------------------\n");

        // Funcionários são agrupados
        service.agruparPorFuncao();
        service.listarFuncionarios();

        // Lista os aniversariantes de outubro e dezembro
        System.out.println("Lista os aniversariantes");
        service.listarAniversariantes(10, 12);
        System.out.println("------------------------------------\n");

        // Agora mostrando o mais velho
        System.out.println("Lista o mais velho");
        service.obterFuncionarioMaisVelho();
        System.out.println("------------------------------------\n");

        // Ordem alfabética
        System.out.println("Imprimindo em ordem alfabética");
        service.listarOrdenadoPorNome();
        System.out.println("------------------------------------\n");


        System.out.println("Lista quantidade de salários mínimos");
        service.calcularTotalSalarios();
        service.calcularSalariosMinimos(BigDecimal.valueOf(1212.00));
    }
}
