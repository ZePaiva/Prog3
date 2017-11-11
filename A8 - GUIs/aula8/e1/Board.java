package aula8.e1;

public class Board
{
    private JogoDoGalo jogo;
    private int[][] mapa = new int[3][3];
    private int numeroJogadas = 0;
    private int[] soma = new int[8];

    public Board(JogoDoGalo jogo) {
        this.jogo = jogo;
    }

    public void joga(int x, int y, boolean player) {
        
    	if (!validMove(x, y) || (validMove(x, y) && !emptyPlace(x, y)))
        	throw new IllegalArgumentException("Posição não válida");
        
        byte move;
        if (player) {
            move = 1;
        } else {
            move = -1;
        }

        mapa[x - 1][y - 1] = move;
        numeroJogadas++;
        soma[x - 1] += move;
        soma[3 + y - 1] += move;
        if (x == y) {
            this.soma[6] += move;
        }

        if (x == 4 - y) {
            this.soma[7] += move;
        }

        if (end()) {
            jogo.notificaFim(result());
        }

    }
    
    private boolean validMove(int x, int y) {
        return x >= 1 && x <= 3 && y >= 1 && y <= 3;
    }

    private boolean emptyPlace(int x, int y) {
        if (!validMove(x, y))
        	throw new IllegalArgumentException("Posição não válida");

        return mapa[x - 1][y - 1] == 0;
    }


    private boolean end() {
        boolean fim = (numeroJogadas == 9);

        int i;
        for(i = 0; !fim && i < 8; i++) {
            fim = Math.abs(soma[i]) == 3;
        }

        return fim;
    }

    private int result() {
        
        byte win = 0;

        int i;
        for(i = 0; win == 0 && i < 8; i++) {
            if (soma[i] == 3) {
                win = 1;
            } else if (soma[i] == -3) {
                win = -1;
            }
        }

        return win;
    }
}