package N4;

import java.util.Random;

public class Fantasma {

    private int[] posicao = new int[3];
    private float[] escala = {2f,2f,2f};
    private int mapa [] [];

    private int ultimoMov = 2;

    public Fantasma(int[][] mapa, int x, int y) {
        this.posicao[0] = x;
        this.posicao[1] = y;
        this.mapa = mapa;
    }

    public float[] getPosicao() {
        float[] f = new float[3];
        f[0] = (float)posicao[0];
        f[1] = (float)posicao[1];
        f[2] = 0f;
        return f;
    }

    public void setPosicao(int[] posicao) {
        this.posicao = posicao;
    }

    public float[] getEscala() {
        return escala;
    }

    public void setEscala(float[] escala) {
        this.escala = escala;
    }

    
    
    public void movimenta() {

        Random r = new Random();
        int i = r.nextInt(4);
        switch (i) {
            case 0: //direita
                
                
                if (mapa[posicao[0] + 1][posicao[1]] != 1 && ultimoMov != 3) {
                    posicao[0]++;
                    ultimoMov = 1;
                    break;
                }
            case 1: //esquerda
                if (mapa[posicao[0] - 1][posicao[1]] != 1 && ultimoMov != 1) {
                    posicao[0]--;
                    ultimoMov = 3;
                    break;
                }
            case 2: //sobe
                if (mapa[posicao[0]][posicao[1] - 1] != 1 && ultimoMov != 2) {
                    posicao[1]--;
                    ultimoMov = 4;
                    break;
                }
            case 3: //desce
                if (mapa[posicao[0]][posicao[1] + 1] != 1 && ultimoMov != 4) {
                    posicao[1]++;
                    ultimoMov = 2;
                    break;
                }
            default:
                while (true) {
                    if (mapa[posicao[0] + 1][posicao[1]] != 1 && ultimoMov != 3) { //direita
                        posicao[0]++;
                        ultimoMov = 1;
                        break;
                    } else if (mapa[posicao[0] - 1][posicao[1]] != 1 && ultimoMov != 1) { //esquerda
                        posicao[0]--;
                        ultimoMov = 3;
                        break;
                    } else if (mapa[posicao[0]][posicao[1] - 1] != 1 && ultimoMov != 2) { //sobe
                        posicao[1]--;
                        ultimoMov = 4;
                        break;
                    } else if (mapa[posicao[0]][posicao[1] + 1] != 1 && ultimoMov != 4) { //desce
                        posicao[1]++;
                        ultimoMov = 2;
                        break;
                    }
                }
        }
    }
}
