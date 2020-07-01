/**
 * @author Eduardo, Milson, Rafael
 * 
 */
package N4;

public class BBox {
    
    private Ponto4D[] pontos = new Ponto4D[4];
    //pontos[0]     pontos[3]
    //pontos[1]     pontos[2]
    
    public BBox(){
        
    }
    
    /**
     * método set para definir os pontos da Bbox
     * @param novosPontos 
     */
    public void setPontos(Ponto4D[] novosPontos){
        this.pontos = novosPontos;
    }
    
    /**
     * Método get para retornar os pontos da BBox
     * @return 
     */
    public Ponto4D[] getPontos(){
        return pontos;
    }
    
}
