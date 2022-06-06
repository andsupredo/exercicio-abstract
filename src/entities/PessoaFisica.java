package entities;

public class PessoaFisica extends Pessoa{

    private Double gastosSaude;

    public PessoaFisica(){}

    public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    public Double getGastosSaude() {
        return gastosSaude;
    }

    public void setGastosSaude(Double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }

    public double imposto(){
        double taxa = 0;
        if (getRendaAnual() < 20000){
            taxa = getRendaAnual() * 0.15;
        }
        else{
            taxa = getRendaAnual() * 0.25;
        }
        return taxa - abatimento();
    }

    public double abatimento(){
        if (gastosSaude > 0){
            return (gastosSaude/2);
        }
        else {
            return 0;
        }
    }

    @Override
    public String toString(){
        return getNome() +
                " : " + " $ " +
                String.format("%.2f", imposto());
    }
}
