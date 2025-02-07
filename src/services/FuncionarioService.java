package services;

import models.Funcionario;
import utils.Formatador;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuncionarioService {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }
    public void removerFuncionario(String nome) {
        for (Funcionario i : funcionarios) {
            if (i.getNome().equalsIgnoreCase(nome)) {
                funcionarios.remove(i);
                return;
            }
        }
    }
    public void listarFuncionarios() {
        for (Funcionario i : funcionarios) {
            System.out.println(i.getNome() + " - " +
                    Formatador.formatarData(i.getDataNascimento()) + " - " +
                    Formatador.formatarMoeda(i.getSalario()) + " - " +
                    i.getFuncao());
        }
    }
    public void aumentarSalario(double percentual) {
        for (Funcionario f : funcionarios) {
            BigDecimal aumento = f.getSalario().multiply(BigDecimal.valueOf(percentual / 100));
            f.setSalario(f.getSalario().add(aumento));
        }
    }

    public Map<String, List<Funcionario>> agruparPorFuncao() {
        Map<String, List<Funcionario>> mapa = new HashMap<>();
        for (Funcionario i : funcionarios) {
            mapa.putIfAbsent(i.getFuncao(), new ArrayList<>());
            mapa.get(i.getFuncao()).add(i);
        }
        return mapa;
    }

    public void listarAniversariantes(int... meses) {
        for (Funcionario f : funcionarios) {
            int mesNascimento = f.getDataNascimento().getMonthValue();
            for (int mes : meses) {
                if (mesNascimento == mes) {
                    System.out.println(f.getNome() + " faz aniversário em " + mes);
                }
            }
        }
    }

    public Funcionario obterFuncionarioMaisVelho() {
        Funcionario maisVelho = null;
        for (Funcionario f : funcionarios) {
            if (maisVelho == null || f.getDataNascimento().isBefore(maisVelho.getDataNascimento())) {
                maisVelho = f;
            }
        }
        return maisVelho;
    }
    public void listarOrdenadoPorNome() {
        funcionarios.sort((f1, f2) -> f1.getNome().compareToIgnoreCase(f2.getNome()));
        listarFuncionarios();
    }

    public BigDecimal calcularTotalSalarios() {
        BigDecimal total = BigDecimal.ZERO;
        for (Funcionario f : funcionarios) {
            total = total.add(f.getSalario());
        }
        return total;
    }

    public void calcularSalariosMinimos(BigDecimal salarioMinimo) {
        for (Funcionario f : funcionarios) {
            BigDecimal qtdSalariosMinimos = f.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP);
            System.out.println(f.getNome() + " ganha " + qtdSalariosMinimos + " salários mínimos.");
        }
    }
}
