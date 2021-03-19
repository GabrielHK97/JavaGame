/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Gabriel
 */
public class Fase extends JPanel implements ActionListener{
    
    private Image fundo;
    private Nave nave;
    private Timer timer;
    private boolean emJogo;
    private int[][] coordenadas = { { 2380, 29 }, { 2600, 59 }, { 1380, 89 },
{ 780, 109 }, { 580, 139 }, { 880, 239 }, { 790, 259 },
{ 760, 50 }, { 790, 150 }, { 1980, 209 }, { 560, 45 }, { 510, 70 },
{ 930, 159 }, { 590, 80 }, { 530, 60 }, { 940, 59 }, { 990, 30 },
{ 920, 200 }, { 900, 259 }, { 660, 50 }, { 540, 90 }, { 810, 220 },
{ 860, 20 }, { 740, 180 }, { 820, 128 }, { 490, 170 }, { 700, 30 },
{ 920, 300 }, { 856, 328 }, { 456, 320 } };
    // parte 8.1 3:09
    public Fase(){
        
        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(new TecladoAdapter());
        ImageIcon referencia = new ImageIcon("res\\fundo.png");
        fundo = referencia.getImage();
        nave = new Nave();
        Timer timer = new Timer(5,this);
        timer.start();
    }
    
    public void paint(Graphics g){
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo,0,0,null);
        graficos.drawImage(nave.getImagem(),nave.getX(),nave.getY(),this);
        List<Missel> misseis = nave.getMisseis();
        for(int i = 0; i < misseis.size(); i++){
            Missel m = (Missel)misseis.get(i);
            graficos.drawImage(m.getImagem(),m.getX(),m.getY(),this);
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        List<Missel> misseis = nave.getMisseis();
        for(int i = 0; i < misseis.size(); i++){
            Missel m = (Missel)misseis.get(i);
            if(m.isIsVisible()){
                m.mexer();
            } else {
                misseis.remove(i);
            }
        }
        nave.mexer();
        repaint();
    }

    private class TecladoAdapter extends KeyAdapter{
        
        @Override
    public void keyPressed(KeyEvent e) {
        nave.keyPressed(e);
    }
        @Override
    public void keyReleased(KeyEvent e) {
        nave.keyReleased(e);
    }
        
    }
    
}
