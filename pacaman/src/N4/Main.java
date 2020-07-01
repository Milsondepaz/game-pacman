/**
 * @author Eduardo, Milson, Rafael
 *
 */
//Acadêmicos: Eduardo Gehrke, Milson Antonio, Rafael Bertoldi
package N4;

import com.sun.javafx.collections.MapAdapterChange;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.media.opengl.DebugGL;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

import com.sun.opengl.util.GLUT;

public class Main implements GLEventListener, KeyListener, MouseListener, MouseMotionListener, ActionListener {

    private GL gl;
    private GLU glu;
    private GLAutoDrawable glDrawable;
    private GLUT glut;
    private int level = 1;

    //Matriz "invertida" - colunas representam X, e linhas Y
    //0 = 'Comida'
    //1 = Parede
    //2 = Apenas chão (no início, a célula onde o PacMan se encontra)
    private float corRed[] = {1.0f, 0.0f, 0.0f, 1.0f};
    private float corGreen[] = {0.0f, 1.0f, 0.0f, 1.0f};
    private float corYellow[] = {1.0f, 1.0f, 0.0f, 1.0f};
    private float corBlue[] = {0.0f, 0.0f, 1.0f, 1.0f};

    private int[] posicao = {1, 1};
    private int[] posInimigo = {8, 8};
    private int ultimoMov = 2;
    /*
    direita = 1
    baixo = 2
    esquerda = 3
    cima = 4
     */

    Timer t;

    Fantasma fantasma1;
    Fantasma fantasma2;

    PacMan pacman;

    Mapa m = Mapa.getInstance();

    private double xEye, yEye, zEye;
    private double xCenter, yCenter, zCenter;

    private boolean eHMaterial = true;

    private boolean perdeu = false;
    private boolean venceu = false;

    public Main() {
        t = new Timer(200, this);
    }

    public void init(GLAutoDrawable drawable) {
        glDrawable = drawable;
        gl = drawable.getGL();
        glu = new GLU();
        glut = new GLUT();
        glDrawable.setGL(new DebugGL(gl));

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        xEye = 8.0f;
        yEye = 8.0f;
        zEye = 20.0f;
        xCenter = 10.0f;
        yCenter = 10.0f;
        zCenter = -20.0f;

        fantasma1 = new Fantasma(m.getMapa(level), 8, 8);
        ligarLuz();

        gl.glEnable(GL.GL_CULL_FACE);
        gl.glEnable(GL.GL_DEPTH_TEST);

        t.start();
    }

    public void display(GLAutoDrawable arg0) {
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
        glu.gluLookAt(xEye, yEye, zEye, xCenter, yCenter, zCenter, 0.0f, 1.0f, 0.0f);

        SRU();

        if (perdeu) {
            t.stop();
            System.out.println("Você perdeu");
            return;
        }

        if (venceu) {
            t.stop();
            System.out.println("Você venceu");
            System.out.println("Você vai para o proximo level");
            return;
        }

        pacman = new PacMan(m.getMapa(level), posicao[0], posicao[1]);
        drawCube(pacman.getTranslacao(), pacman.getEscala(), corYellow);

        //Quando o PacMan é movimentado, faz a verificação se venceu o jogo
        verificaVitoria();

        //Desenho do inimigo (verde)
        drawCube(fantasma1.getPosicao(), fantasma1.getEscala(), corGreen);

        //Se as posições do PacMan e do inimigo colidirem, perde o jogo
        if ((int) fantasma1.getPosicao()[0] == posicao[0] && (int) fantasma1.getPosicao()[1] == posicao[1]) {
            perdeu = true;
        }
        gl.glFlush();
    }

    private void drawCube(float translacao[], float escala[], float cor[]) {
        if (eHMaterial) {
            gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT_AND_DIFFUSE, cor, 0);
            gl.glEnable(GL.GL_LIGHTING);
        }

        gl.glPushMatrix();
        gl.glScalef(escala[0], escala[1], escala[2]);
        gl.glTranslated(translacao[0], translacao[1], translacao[2]);
        glut.glutSolidCube(1.0f);
        gl.glPopMatrix();

        if (eHMaterial) {
            gl.glDisable(GL.GL_LIGHTING);
        }
    }

    private void ligarLuz() {
        if (eHMaterial) {
            float posLight[] = {5.0f, 5.0f, 10.0f, 0.0f};
            gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, posLight, 0);
            gl.glEnable(GL.GL_LIGHT0);
        } else {
            gl.glDisable(GL.GL_LIGHT0);
        }
    }

    //Desenho do labirinto, azul enquanto joga, vermelho quando perde
    public void SRU() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (m.getMapa(level)[i][j] == 1) {
                    float[] translacao = {i, j, 0f};
                    float[] escala = {2f, 2f, 2f};
                    if (perdeu) {
                        drawCube(translacao, escala, corRed);
                    } else {
                        if (venceu) {
                            drawCube(translacao, escala, corGreen);
                        } else {
                            drawCube(translacao, escala, corBlue);
                        }
                    }
                } else if (m.getMapa(level)[i][j] == 0) {
                    float[] translacao1 = {i * 4f, j * 4f, 0f};
                    float[] escala1 = {0.5f, 0.5f, 0.5f};
                    drawCube(translacao1, escala1, corRed);
                }
            }
        }
    }

    public void verificaVitoria() {
        boolean b = true;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (m.getMapa(level)[i][j] == 0) {
                    b = false;
                    break;
                }
            }
        }
        venceu = b;
    }

    //Botões para controlar o PacMan (setas)
    public void keyPressed(KeyEvent e) {
        if (perdeu || venceu) {
            return;
        }
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                if (m.getMapa(level)[posicao[0] + 1][posicao[1]] != 1) {
                    posicao[0]++;
                    if (m.getMapa(level)[posicao[0]][posicao[1]] == 0) {
                        m.getMapa(level)[posicao[0]][posicao[1]] = 2;
                    }
                }
                break;
            case KeyEvent.VK_LEFT:
                if (m.getMapa(level)[posicao[0] - 1][posicao[1]] != 1) {
                    posicao[0]--;
                    if (m.getMapa(level)[posicao[0]][posicao[1]] == 0) {
                        m.getMapa(level)[posicao[0]][posicao[1]] = 2;
                    }
                }
                break;
            case KeyEvent.VK_DOWN:
                if (m.getMapa(level)[posicao[0]][posicao[1] - 1] != 1) {
                    posicao[1]--;
                    if (m.getMapa(level)[posicao[0]][posicao[1]] == 0) {
                        m.getMapa(level)[posicao[0]][posicao[1]] = 2;
                    }
                }
                break;
            case KeyEvent.VK_UP:
                if (m.getMapa(level)[posicao[0]][posicao[1] + 1] != 1) {
                    posicao[1]++;
                    if (m.getMapa(level)[posicao[0]][posicao[1]] == 0) {
                        m.getMapa(level)[posicao[0]][posicao[1]] = 2;
                    }
                }
                break;
        }
        glDrawable.display();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glViewport(0, 0, width, height);
        glu.gluPerspective(60, width / height, 0.1, 100);
    }

    public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
    }

    public void keyReleased(KeyEvent arg0) {
    }

    public void keyTyped(KeyEvent arg0) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    /*
    Mecanismo para a movimentação do inimigo: a cada 0,2s, ele executa
    um movimento randômico.
    Porém, há um tratamento que garante que este movimento não seja 'contrário' 
    ao que ele acabou de efetuar.
    Por exemplo: se o último movimento foi para cima (Up), na próxima vez ele não
    irá para baixo (Down); se o último movimento foi para a esquerda (Left), na 
    próxima vez ele não irá para a direita (Right) e assim por diante.
    Evita-se, assim, que o inimigo fique em um 'loop' infinito (por exemplo, indo 
    o tempo todo para frente e para trás)
    Enquanto o random for escolhendo movimentos 'proibidos', novas tentativas são
    feitas, até garantir um movimento 'permitido'
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        fantasma1.movimenta();
        glDrawable.display();
    }

}
