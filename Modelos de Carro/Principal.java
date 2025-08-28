public class Principal {
    public static void main(String[] args) {
        ModeloCarro meuCarro = new ModeloCarro();

        meuCarro.setNomeModelo("Agile");
        meuCarro.setAnos(2013, 2012, 2011);
        meuCarro.setPrecos(30000, 29000, 28000);

        meuCarro.exibeInformacaoCarro();
    }
}

class Carro {
    private String nomeModelo;
    protected double precoAno1;
    protected double precoAno2;
    protected double precoAno3;

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public void setPrecos(double precoAno1, double precoAno2, double precoAno3) {
        this.precoAno1 = precoAno1;
        this.precoAno2 = precoAno2;
        this.precoAno3 = precoAno3;
    }

    public double calcularMenorPreco() {
        double menorPreco = precoAno1;

        if (precoAno2 < menorPreco) {
            menorPreco = precoAno2;
        }

        if (precoAno3 < menorPreco) {
            menorPreco = precoAno3;
        }

        return menorPreco;
    }

    public double calcularMaiorPreco() {
        double maiorPreco = precoAno1;

        if (precoAno2 > maiorPreco) {
            maiorPreco = precoAno2;
        }

        if (precoAno3 > maiorPreco) {
            maiorPreco = precoAno3;
        }

        return maiorPreco;
    }

    public void exibeInformacaoCarro() {
        System.out.println("Nome do carro: " + nomeModelo);
    }
}

class ModeloCarro extends Carro {
    int ano1;
    int ano2;
    int ano3;

    public void setAnos(int ano1, int ano2, int ano3) {
        this.ano1 = ano1;
        this.ano2 = ano2;
        this.ano3 = ano3;
    }

    public int getAnoMenorPreco() {
        double menorPreco = calcularMenorPreco();

        if (menorPreco == precoAno1) {
            return ano1;
        } else if (menorPreco == precoAno2) {
            return ano2;
        } else {
            return ano3;
        }
    }

    public int getAnoMaiorPreco() {
        double maiorPreco = calcularMaiorPreco();

        if (maiorPreco == precoAno1) {
            return ano1;
        } else if (maiorPreco == precoAno2) {
            return ano2;
        } else {
            return ano3;
        }
    }

    @Override
    public void exibeInformacaoCarro() {
        super.exibeInformacaoCarro();

        System.out.println("O modelo do menor preço é do ano " + getAnoMenorPreco() +
                           " do preço R$" + calcularMenorPreco());

        System.out.println("O modelo do maior preço é do ano " + getAnoMaiorPreco() +
                           " do preço R$" + calcularMaiorPreco());
    }
}
