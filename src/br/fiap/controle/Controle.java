package br.fiap.controle;
import br.fiap.assento.Assento;
import br.fiap.cliente.Cliente;
import br.fiap.cliente.PessoaFisica;
import br.fiap.cliente.PessoaJuridica;
import br.fiap.reserva.Reserva;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
import static javax.swing.JOptionPane.*;

public class Controle {

    private static List<Cliente> listaCliente = new ArrayList<>();
    private static List<Assento> listaAssento = new ArrayList<>();
    private List<Reserva> listaReserva = new ArrayList<>();

    static {
        // lista de clientes
        listaCliente.add(new PessoaFisica("Ana Maria", "111", "123"));
        listaCliente.add(new PessoaJuridica("XPTO", "222", "123/1000"));
        listaCliente.add(new PessoaFisica("Roberto Carlos", "333", "456"));
        listaCliente.add(new PessoaJuridica("Xuxa LTDA", "444", "789/1000"));

        // lista de assentos
        for(int i = 1; i <= 10; i++) {
            listaAssento.add(new Assento(i));
        }
    }

    public void menu() {
        int opcao;

        while(true) {
            try {
                opcao = parseInt(showInputDialog(gerarMenu()));
                switch(opcao) {
                    case 1:
                        reservar();
                        break;
                    case 2:
                        pesquisar();
                        break;
                    case 3:
                        cancelar();
                        break;
                    case 4:
                        return;
                    default:
                        showMessageDialog(null, "Opção inválida");
                }
            }
            catch(NumberFormatException e) {
                showMessageDialog(null, "você deve digitar um número");
            }
        }
    }

    private void cancelar() {
    }

    private void pesquisar() {
        String id = showInputDialog("Qual o CPF ou CNPJ para consulta?");
        for(Reserva reserva : listaReserva) {
            if(reserva.getCliente().getIdentificador().equals(id)) {
                showMessageDialog(null, reserva);
                return;
            }
        }
        showMessageDialog(null, "CPF/CNPJ: " + id + " não localizado");
    }

    private void reservar() {
        Random random = new Random();
        double valorOriginal;
        int numeroAssento;
        Assento assento;
        String id = showInputDialog("Qual o CPF ou CNPJ para reserva?");

        for(Cliente cliente : listaCliente) {
            if(cliente.getIdentificador().equals(id)) {
                numeroAssento = parseInt(showInputDialog(listarAssento()));
                valorOriginal = random.nextDouble(100, 1000);
                assento = listaAssento.get(numeroAssento);
                listaReserva.add(new Reserva(cliente, valorOriginal, assento));
                assento.setDisponivel(false);
                return;
            }
        }
        showMessageDialog(null, "CPF/CNPJ: " + id + " não localizado");
    }

    private String listarAssento() {
        String aux = "";
        for(Assento assento : listaAssento) {
            aux += assento;
            aux += "----------------------------\n";
        }
        return aux;
    }

    private String gerarMenu() {
        String aux = "SISTEMA DE RESERVA DE PASSAGEM AÉREA\n";
        aux += "1. Reservar\n";
        aux += "2. Pesquisar reserva\n";
        aux += "3. Cancelar reserva\n";
        aux += "4. Finalizar";
        return aux;
    }
}
