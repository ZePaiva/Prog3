package aula8.e1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Button
extends JToggleButton
implements ActionListener
{
    protected Board tabuleiro;
    protected int lines;
    protected int columns;
    protected static boolean jogadorX;

    public Button(int x, int y, Board player) 
    {
        super();
        this.addActionListener(this);
        lines = x;
        columns = y;
        tabuleiro = player;
        this.setFont(new Font("Arial" , 1, 30));
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (jogadorX) 
            this.setText("X");
        else
            this.setText("O");
        

        this.setEnabled(false);
        tabuleiro.joga(lines, columns, jogadorX);
        jogadorX = !jogadorX;
    }

    public static void iniciaJogadorX(boolean player) 
    {
        jogadorX = player;
    }
}
