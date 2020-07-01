/**
 * @author Eduardo, Milson, Rafael
 *
 */
package N4;

import java.util.ArrayList;

public class Mapa {

    public static Mapa uniqueMundo = null;

    
    //Matriz "invertida" - colunas representam X, e linhas Y
    //0 = 'Comida'
    //1 = Parede
    //2 = Apenas chão (no início, a célula onde o PacMan se encontra)

    
    private int[][] mapaUm
            = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 2, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

    private int[][] mapaDois
            = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 2, 1, 1, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

    private Mapa() {
    }

    /**
     * Padrão Singleton para que se tenha apenas um objeto de Mapa
     *
     * @return
     */
    public static Mapa getInstance() {
        if (uniqueMundo == null) {
            uniqueMundo = new Mapa();
        }
        return uniqueMundo;
    }

    public int[][] getMapaUm() {
        return mapaUm;
    }

    public int[][] getMapaDois() {
        return mapaDois;
    }

    public int[][] getMapa(int level) {
        if (level == 1) {
            return mapaUm;
        } else {
            return mapaDois;
        }
    }

}
