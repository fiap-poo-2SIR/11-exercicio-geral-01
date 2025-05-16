package br.fiap.reserva;

import br.fiap.assento.Assento;
import br.fiap.cliente.Cliente;
import br.fiap.cliente.PessoaFisica;
import br.fiap.desconto.Desconto;

public class Reserva {
    private Cliente cliente;
    private double valorOriginal;
    private double valorFinal;
    private Assento assento;

    public Reserva(Cliente cliente, double valorOriginal, Assento assento) {
        this.cliente = cliente;
        this.valorOriginal = valorOriginal;
        this.assento = assento;
        aplicarDesconto(valorOriginal);
    }

    private void aplicarDesconto(double valorOriginal) {
        if(cliente instanceof Desconto) {
            Desconto desconto = (Desconto) cliente;
            valorFinal = desconto.aplicarDesconto(valorOriginal);
        }
        else {
            valorFinal = valorOriginal;
        }
    }
}
