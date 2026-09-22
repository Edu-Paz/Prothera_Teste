package entities;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Funcionario extends Pessoa{
    private BigDecimal salario;
    private String funcao;

    public Funcionario() {
        super();
    }

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void aumentarSalario(BigDecimal percentual){
        if (percentual == null || percentual.compareTo(BigDecimal.ZERO) < 0) {
            return;
        }

        BigDecimal fator = BigDecimal.ONE.add(percentual);
        setSalario(getSalario().multiply(fator));
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(Locale.forLanguageTag("pt-BR"));
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        DecimalFormat salaryFormatter = new DecimalFormat("#,##0.00", symbols);

        return "Nome: " + getNome()
                + " | Data: " + getDataNascimento().format(dateFormatter)
                + " | Salário: R$ " + salaryFormatter.format(getSalario())
                + " | Função: " + getFuncao();
    }


}
