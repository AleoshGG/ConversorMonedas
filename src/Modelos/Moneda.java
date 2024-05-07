package Modelos;


public class Moneda {
    private double valorDivisa;

    public Moneda(MonedasAPI monedasAPI) {
        this.valorDivisa = Double.valueOf(monedasAPI.conversion_rate());
    }

    public double getValorDivisa() {
        return valorDivisa;
    }

}
