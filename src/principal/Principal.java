package principal;

import entities.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        inserirFuncionarios(funcionarios);

        removerFuncionario(funcionarios, "João");

        System.out.println("Lista de funcionários:");
        imprimirFuncionarios(funcionarios);

        aumentarSalario(funcionarios);

        System.out.println("Lista de funcionários com salários aumentados:");
        imprimirFuncionarios(funcionarios);

        imprimirPorFuncao(agruparPorFuncao(funcionarios));

        imprimirAniversariantesMes10e12(funcionarios);

        imprimirFuncionarioMaisVelho(funcionarios);

        imprimirFuncionariosEmOrdemAlfabetica(funcionarios);

        imprimirSalarioTotal(funcionarios);

        calcularSalariosMinimos(funcionarios);
    }

    public static void inserirFuncionarios(List<Funcionario> funcionarios) {
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        System.out.println("Funcionários inseridos com sucesso");
    }

    public static void removerFuncionario(List<Funcionario> funcionarios, String nome) {
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals(nome));

        System.out.println("Funcionário João removido com sucesso!");
    }

    public static void imprimirFuncionarios(List<Funcionario> funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }

        System.out.println("***FIM***");
        System.out.println();
    }

    public static void aumentarSalario(List<Funcionario> funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            funcionario.aumentarSalario(new BigDecimal("0.10"));
        }
    }

    public static Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public static void imprimirPorFuncao(Map<String, List<Funcionario>> grupos) {
        for (Map.Entry<String, List<Funcionario>> entry : grupos.entrySet()) {
            System.out.println("Função: " + entry.getKey());
            for (Funcionario funcionario : entry.getValue()) {
                System.out.println(funcionario);
            }
            System.out.println();
        }
    }

    public static void imprimirAniversariantesMes10e12(List<Funcionario> funcionarios) {
        System.out.println("\nAniversariantes de outubro ou dezembro:");
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getDataNascimento().getMonth().equals(Month.OCTOBER) || funcionario.getDataNascimento().getMonth().equals(Month.DECEMBER)) {
                System.out.println(funcionario);
            }
        }
    }

    public static void imprimirFuncionarioMaisVelho(List<Funcionario> funcionarios) {
        Funcionario maisVelho = funcionarios.getFirst();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getDataNascimento().isBefore(maisVelho.getDataNascimento())) {
                maisVelho = funcionario;
            }
        }

        int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now(ZoneId.of("America/Sao_Paulo"))).getYears();
        System.out.println("\nFuncionário mais velho: " + maisVelho.getNome() + " | Idade: " + idade + "\n");
    }

    public static void imprimirFuncionariosEmOrdemAlfabetica(List<Funcionario> funcionarios) {
        System.out.println("Lista de funcionários em ordem alfabética:");
        funcionarios.sort(Comparator.comparing(Funcionario::getNome));
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }

    public static void imprimirSalarioTotal(List<Funcionario> funcionarios){
        BigDecimal salarioTotal = BigDecimal.ZERO;
        for (Funcionario funcionario : funcionarios) {
            salarioTotal = salarioTotal.add(funcionario.getSalario());
        }
        System.out.println("\nA soma dos salários dos funcionários é: " + salarioTotal + "\n");
    }

    public static void calcularSalariosMinimos(List<Funcionario> funcionarios){
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        for (Funcionario funcionario : funcionarios) {
            BigDecimal quantidade = funcionario.getSalario()
                    .divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println(funcionario.getNome() + ": " + quantidade + " salários mínimos");
        }
    }
}