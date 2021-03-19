/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Gabriel
 */
public class Inimigo {
    
    private Image imagem;
    private int x,y;
    private int largura,altura;
    private boolean isVisible;
    private static final int LARGURA_TELA = 500;
    private static final int VELOCIDADE = 1;
    
    public Inimigo(int x,int y){
        this.x = x;
        this.y = y;
        ImageIcon referencia = new ImageIcon("res\\inimigo_1.png");
        imagem = referencia.getImage();
        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
        isVisible = true;
    }
    
    public void mexer(){
        if(this.x < 0){
            this.x = LARGURA_TELA;
        }else{
            this.x -= VELOCIDADE;
        }
    }

    /**
     * @return the imagem
     */
    public Image getImagem() {
        return imagem;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x,y,largura,altura);
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
