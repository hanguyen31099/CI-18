import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Program {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        GamePannel panel = new GamePannel();
        // tạo size cho panel
        panel.setPreferredSize(new Dimension(800,600));
        window.add(panel);
        //cho win dow tu dieu chinh size phu hop

        window.pack();
        window.setTitle("Game Touhou");


        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // tạo nhận W A S D từ user
        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W){
                    KeyEnvenPress.isUpPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    KeyEnvenPress.isDOWPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    KeyEnvenPress.isLeftPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_D){
                    KeyEnvenPress.isRightPress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W){
                    KeyEnvenPress.isUpPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    KeyEnvenPress.isDOWPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    KeyEnvenPress.isLeftPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_D){
                    KeyEnvenPress.isRightPress = false;
                }
            }
        };
        window.addKeyListener(keyAdapter);
        window.setLocation(400,150);
        window.setVisible(true);
        window.setResizable(false);
        panel.GameLoop();
        // shift F6 : doi ten
        // alt Enter : sua loi
        // alt + ctrl + l :format code;
    }
}
