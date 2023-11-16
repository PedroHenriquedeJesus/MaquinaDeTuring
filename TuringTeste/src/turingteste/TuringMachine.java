/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package turingteste;

/**
 *
 * @author aluno
 */
public class TuringMachine {

    private static final String[] alfabeto = {"0", "1"};
    private static final String[] estados = {"q0", "q1", "q2", "q3"};
    private static final String[] transicoes = {
            "q0,0,L,q0,0",
            "q0,1,R,q1,0",
            "q1,1,R,q1,0",
            "q1,0,L,q2,0",
            "q2,0,L,q2,0",
            "q2,1,R,q3,1",
            "q3,1,R,q3,1",
            "q3,0,R,q3,1"
    };

    public static void main(String[] args) {
        String cadeia = "0";
        TuringMachine tm = new TuringMachine(cadeia);
        tm.executar();
        System.out.println(tm.aceita() ? "A cadeia é aceita" : "A cadeia não é aceita");
    }

    private String cadeia;
    private int estado;
    private int posicao;

    public TuringMachine(String cadeia) {
        this.cadeia = cadeia;
        this.estado = 0;
        this.posicao = 0;
    }

    public void executar() {
        while (true) {
            if (posicao < 0 || posicao >= cadeia.length()) {
                // Se a posição estiver fora dos limites da cadeia, insira um espaço em branco na posição atual
                cadeia = cadeia.substring(0, posicao) + " " + cadeia.substring(posicao);
            }

            String[] transicao = transicoes[estado].split(",");
            char simbolo = posicao < cadeia.length() ? cadeia.charAt(posicao) : ' ';

            if (transicao[0].equals(estados[estado]) && simbolo == transicao[1].charAt(0)) {
                char novoSimbolo = transicao[2].charAt(0);
                int proximoEstado = Integer.parseInt(transicao[3].substring(1));
                int movimento = transicao[4].equals("R") ? 1 : -1;

                if (posicao < 0) {
                    cadeia = novoSimbolo + cadeia;
                    posicao = 0;
                } else if (posicao >= cadeia.length()) {
                    cadeia = cadeia + novoSimbolo;
                } else {
                    cadeia = cadeia.substring(0, posicao) + novoSimbolo + cadeia.substring(posicao + 1);
                }

                estado = proximoEstado;
                posicao += movimento;

                System.out.println("Cadeia atual: " + cadeia + ", Estado atual: " + estados[estado] + ", Posição atual: " + posicao);

                if (proximoEstado == 3) {
                    System.out.println("Cadeia final: " + cadeia);
                    return;
                }
            } else {
                System.out.println("A cadeia não é aceita");
                return;
            }
        }
    }

    public boolean aceita() {
        return estado == 3;
    }
}
