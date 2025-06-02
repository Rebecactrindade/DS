public class ProjetoCarro {
    public static void main(String[] args) {
        Carro meuCarro = new Carro("Civic", "Honda", 2020);

        meuCarro.ligar();
        meuCarro.abastecer(10);
        meuCarro.acelerar(30);
        meuCarro.andar();
        meuCarro.frear(15);
        meuCarro.andar();
        meuCarro.buzinar();
        meuCarro.desligar();

        System.out.println(meuCarro);
    }
}

abstract class Veiculo {
    protected String nome;
    protected String marca;
    protected int ano;
    protected boolean ligado;
    protected int velocidade;
    protected double combustivel;

    public Veiculo(String nome, String marca, int ano) {
        this.nome = nome;
        this.marca = marca;
        this.ano = ano;
        this.velocidade = 0;
        this.combustivel = 0;
        this.ligado = false;
    }

    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println(nome + " está ligado.");
        } else {
            System.out.println(nome + " já está ligado.");
        }
    }

    public void desligar() {
        if (ligado) {
            ligado = false;
            velocidade = 0;
            System.out.println(nome + " foi desligado.");
        } else {
            System.out.println(nome + " já está desligado.");
        }
    }

    public void abastecer(double litros) {
        combustivel += litros;
        System.out.println(nome + " abastecido com " + litros + " litros. Total: " + combustivel + " litros.");
    }

    public abstract void acelerar(int kmh);
    public abstract void frear(int kmh);
    public abstract void andar();
}

class Carro extends Veiculo {

    public Carro(String nome, String marca, int ano) {
        super(nome, marca, ano);
    }

    @Override
    public void acelerar(int kmh) {
        if (!ligado) {
            System.out.println(nome + " está desligado. Ligue o carro primeiro.");
            return;
        }
        if (combustivel <= 0) {
            System.out.println(nome + " está sem combustível.");
            return;
        }
        velocidade += kmh;
        combustivel -= kmh * 0.05;
        if (combustivel < 0) combustivel = 0;
        System.out.println(nome + " acelerou para " + velocidade + " km/h. Combustível restante: " + combustivel + " L");
    }

    @Override
    public void frear(int kmh) {
        velocidade -= kmh;
        if (velocidade < 0) velocidade = 0;
        System.out.println(nome + " reduziu para " + velocidade + " km/h.");
    }

    @Override
    public void andar() {
        if (!ligado) {
            System.out.println(nome + " está desligado.");
        } else if (velocidade == 0) {
            System.out.println(nome + " está parado.");
        } else {
            System.out.println(nome + " está andando a " + velocidade + " km/h.");
        }
    }

    public void buzinar() {
        System.out.println(nome + " está buzinando: BEEP BEEP!");
    }

    @Override
    public String toString() {
        return "Carro{" +
                "nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                ", ano=" + ano +
                ", velocidade=" + velocidade +
                " km/h, combustível=" + combustivel +
                " L, ligado=" + ligado +
                '}';
    }
}
