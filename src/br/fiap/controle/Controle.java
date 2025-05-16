package br.fiap.controle;
import br.fiap.assento.Assento;
import br.fiap.cliente.Cliente;
import br.fiap.reserva.Reserva;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
import static javax.swing.JOptionPane.*;

public class Controle {

    private static List<Cliente> listaCliente = new ArrayList<>();
    private static List<Assento> listaAssento = new ArrayList<>();
    private List<Reserva> listaReserva = new ArrayList<>();

    static {

    }

    public void menu() {
        int opcao;

        while(true) {
            try {
                opcao = parseInt(showInputDialog(gerarMenu()));
            }
            catch(NumberFormatException e) {
                showMessageDialog(null, "você deve digitar um número");
            }
        }
    }

    private String gerarMenu() {
        String aux = "SISTEMA DE RESERVA DE PASSAGEM AÉREA";
        aux += "1. Reservar\n";
        aux += "2. Pesquisar reserva\n";
        aux += "3. Cancelar reserva\n";
        aux += "4. Finalizar";
        return aux;
    }
}
