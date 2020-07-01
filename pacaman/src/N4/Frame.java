/**
 * @author Eduardo, Milson, Rafael
 *
 */
//Acadêmicos: Eduardo Gehrke, Milson Antonio, Rafael Bertoldi
package N4;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Frame extends JFrame {

    private static final long serialVersionUID = 1L;
    private Main renderer = new Main();

    private int janelaLargura = 900, janelaAltura = 900;

    public Frame() {
        // Cria o frame.
        super("CG-N3_Trasnformacao");
        setBounds(300, 250, janelaLargura + 8, janelaAltura + 27);  // 400 + 22 da borda do t’tulo da janela
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        /* Cria um objeto GLCapabilities para especificar 
		 * o numero de bits por pixel para RGBA
         */
        GLCapabilities glCaps = new GLCapabilities();
        glCaps.setRedBits(8);
        glCaps.setBlueBits(8);
        glCaps.setGreenBits(8);
        glCaps.setAlphaBits(8);

        /* Cria um canvas, adiciona ao frame e objeto "ouvinte" 
		 * para os eventos Gl, de mouse e teclado
         */
        GLCanvas canvas = new GLCanvas(glCaps);
        add(canvas, BorderLayout.CENTER);
        canvas.addGLEventListener(renderer);
        canvas.addMouseListener(renderer);
        canvas.addMouseMotionListener(renderer);
        canvas.addKeyListener(renderer);
        canvas.requestFocus();
    }

    /*
    Cria-se o Frame do jogo; um objeto Robot simula um clique no centro do Frame,
    para 'ativar' a tela logo de início (habilitando os botões)
    */
    public static void main(String[] args) throws AWTException {
        Frame f = new Frame();
        f.setVisible(true);
        Robot bot = new Robot();
        bot.mouseMove((int)f.getLocationOnScreen().getX()+(int)f.getWidth()/2, 
                (int)f.getLocationOnScreen().getY()+(int)f.getHeight()/2);
        bot.mousePress(InputEvent.BUTTON1_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

}
