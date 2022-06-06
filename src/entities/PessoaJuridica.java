package entities;

public class PessoaJuridica extends Pessoa {

    private Integer qtdFuncionarios;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, Double rendaAnual, Integer qtdFuncionarios) {
        super(nome, rendaAnual);
        this.qtdFuncionarios = qtdFuncionarios;
    }

    public Integer getQtdFuncionarios() {
        return qtdFuncionarios;
    }

    public void setQtdFuncionarios(Integer qtdFuncionarios) {
        this.qtdFuncionarios = qtdFuncionarios;
    }

    public double imposto() {
        double taxa = 0;
        if (qtdFuncionarios <= 10) {
            taxa = getRendaAnual() * 0.16;
        } else {
            taxa = getRendaAnual() * 0.14;
        }
        return taxa;
    }
}
