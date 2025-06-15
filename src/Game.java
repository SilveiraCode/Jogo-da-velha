import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);
    String[][] tabuleiro = new String[3][3];
    private int jogador = 0;
    private int parada = 1;
    private int cont = 1;

    public Game() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = " ";
            }
        }
    }

    public void executar() {
        do {
            tela();
            verificarJogador();
            jogada();
            verificarPartida();
        } while (parada == 1);
    }

    public void tela() {
        System.out.println("   0  1  2");
        System.out.println("0: " + tabuleiro[0][0] + " | " + tabuleiro[0][1] + " | " + tabuleiro[0][2]);
        System.out.println("1: " + tabuleiro[1][0] + " | " + tabuleiro[1][1] + " | " + tabuleiro[1][2]);
        System.out.println("2: " + tabuleiro[2][0] + " | " + tabuleiro[2][1] + " | " + tabuleiro[2][2]);
    }

    public int verificarJogador() {
        jogador = (jogador == 0) ? 1 : 0;
        return jogador;
    }

    public void jogada() {
        int linhaJogada, colunaJogada;

        do {
            System.out.println("Digite a linha escolhida: ");
            linhaJogada = scanner.nextInt();

            System.out.println("Digite a coluna escolhida: ");
            colunaJogada = scanner.nextInt();

            if (linhaJogada >= 0 && linhaJogada < 3 && colunaJogada >= 0 && colunaJogada < 3 && tabuleiro[linhaJogada][colunaJogada].equals(" ")) {
                preencherTabuleiro(linhaJogada, colunaJogada);
                break;
            } else {
                System.out.println("Jogada inválida! Tente novamente!");
            }
        } while (true);
    }

    public String preencherTabuleiro(int linha, int coluna) {
        if (jogador == 0) {
            tabuleiro[linha][coluna] = "0";
        } else {
            tabuleiro[linha][coluna] = "X";
        }
        return tabuleiro[linha][coluna];
    }

    public void verificarPartida() {
        if (cont < 9) {
            for (int i = 0; i < 3; i++) {
                if (tabuleiro[i][0].equals(tabuleiro[i][1]) && tabuleiro[i][0].equals(tabuleiro[i][2]) && !tabuleiro[i][0].equals(" ")) {
                    anunciarVencedor();
                    return;
                }
            }

            for (int i = 0; i < 3; i++) {
                if (tabuleiro[0][i].equals(tabuleiro[1][i]) && tabuleiro[0][i].equals(tabuleiro[2][i]) && !tabuleiro[0][i].equals(" ")) {
                    anunciarVencedor();
                    return;
                }
            }

            if ((tabuleiro[0][0].equals(tabuleiro[1][1]) && tabuleiro[0][0].equals(tabuleiro[2][2]) && !tabuleiro[0][0].equals(" ")) ||
                    (tabuleiro[2][0].equals(tabuleiro[1][1]) && tabuleiro[2][0].equals(tabuleiro[0][2]) && !tabuleiro[2][0].equals(" "))) {
                anunciarVencedor();
                return;
            }

            cont++;
            if (cont == 9) {
                tela();
                System.out.println("Empate!");
                parada = 0;
            }
        }
    }

    private void anunciarVencedor() {
        tela();
        System.out.println("O '" + (jogador == 0 ? "0" : "X") + "' venceu!");
        parada = 0;
    }
}
