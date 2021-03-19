/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.List;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Gabriel
 */
public class Nave {
    
    private int x,y;
    private int dx,dy;
    private int altura,largura;
    private boolean isVisible;
    private Image imagem;
    private List<Missel> misseis;
        
    public Nave(){
        ImageIcon referencia = new ImageIcon("res\\nave.png");
        imagem = referencia.getImage();
        altura = imagem.getHeight(null);
        largura = imagem.getWidth(null);
        misseis = new ArrayList<Missel>();
        this.x = 100;
        this.y = 100;
    }
    
    public void mexer(){
        x += dx;//1 e 363
        y += dy;//1 e 463
        
        if(this.x < 1){
            x = 1;
        }
        if(this.x > 455){
            x = 455;
        }
        if(this.y < 1){
            y = 1;
        }
        if(this.y > 333){
            y = 333;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagem() {
        return imagem;
    }
    
    public void atira(){
        this.misseis.add(new Missel(x + largura/40,y - altura/8));
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x,y,largura,altura);
    }
    
    public void keyPressed(KeyEvent tecla){
        int codigo = tecla.getKeyCode();
        if(codigo == KeyEvent.VK_SPACE){
            atira();
        }
        if(codigo == KeyEvent.VK_UP){
            dy = -1;            
        }
        if(codigo == KeyEvent.VK_DOWN){
            dy = 1;
        }
        if(codigo == KeyEvent.VK_LEFT){
            dx = -1;
        }
        if(codigo == KeyEvent.VK_RIGHT){
            dx = 1;
        }
    }
    
    public void keyReleased(KeyEvent tecla){
        int codigo = tecla.getKeyCode();
        if(codigo == KeyEvent.VK_UP){
            dy = 0;            
        }
        if(codigo == KeyEvent.VK_DOWN){
            dy =0;
        }
        if(codigo == KeyEvent.VK_LEFT){
            dx = 0;
        }
        if(codigo == KeyEvent.VK_RIGHT){
            dx =0;
        }
    }
    public List<Missel> getMisseis() {
        return misseis;
    }

    /**
     * @return the isVisible
     */
    public boolean isIsVisible() {
        return isVisible;
    }

    /**
     * @param isVisible the isVisible to set
     */
    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
    
}
