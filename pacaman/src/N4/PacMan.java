/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package N4;

/**
 *
 * @author Jogo
 */
public class PacMan {

    private float[] translacao = new float[3];
    private float[] escala = {2f, 2f, 2f};
    private int mapa[][];

    public PacMan(int[][] mapa, int x, int y) {
        this.translacao[0] = x;
        this.translacao[1] = y;
        this.mapa = mapa;
    }

    public float[] getTranslacao() {
        return translacao;
    }

    public void setTranslacao(float[] translacao) {
        this.translacao = translacao;
    }

    public float[] getEscala() {
        return escala;
    }

    public void setEscala(float[] escala) {
        this.escala = escala;
    }
    
    
}
