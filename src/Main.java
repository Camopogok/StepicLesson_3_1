import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;

public class Main extends JComponent {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Рисунок");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLocation(380,84);
        frame.setVisible(true);
        frame.getContentPane().add(new Main());
    }

    public void paint (Graphics g) {
        int x = 150; //150
        int y = 20; //20
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.lightGray);
        g2.fill(new Rectangle(0,0,600,600));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.darkGray);

        g2.fillRoundRect(x+92, y+60, 100, 290, 20, 20);
        g2.fillRoundRect(x+120, y+354, 44, 50, 10, 10);

        BasicStroke pen = new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2.setStroke(pen);
        GeneralPath upper = new GeneralPath();
        upper.append(new Arc2D.Double(x+110, y+42, 64, 22, 0, 180, Arc2D.PIE), true);
        g2.draw(upper);
        g2.fill(upper);

        roundedTriangle(g2, 10, x+40,y+90, x+80, y+90, x + 80, y+130, true);
        roundedTriangle(g2, 10, x+40,y+180, x+80, y+180, x + 80, y+220, true);
        roundedTriangle(g2, 10, x+40,y+270, x+80, y+270, x + 80, y+310, true);
        roundedTriangle(g2, 10, x+202,y+90, x+242, y+90, x + 202, y+130, true);
        roundedTriangle(g2, 10, x+202,y+180, x+242, y+180, x + 202, y+220, true);
        roundedTriangle(g2, 10, x+202,y+270, x+242, y+270, x + 202, y+310, true);

        g2.setColor(Color.WHITE);
        g2.fillArc(x+102, y+70, 80, 80, 0, 180);
        g2.fillArc(x+102, y+160, 80, 80, 0, 180);
        g2.fillArc(x+102, y+250, 80, 80, 0, 180);

        g2.setColor(Color.DARK_GRAY);
        g2.fillArc(x+102, y+80, 80, 70, 0, 180);
        g2.fillArc(x+102, y+170, 80, 70, 0, 180);
        g2.fillArc(x+102, y+260, 80, 70, 0, 180);

        g2.setColor(Color.RED);
        g2.fillOval(x+107, y+85, 70,70);

        g2.setColor(Color.YELLOW);
        g2.fillOval(x+107, y+175, 70,70);

        g2.setColor(Color.GREEN);
        g2.fillOval(x+107, y+265, 70,70);
    }




    public void roundedTriangle (Graphics2D g, int diameter, int startX, int startY, int x1, int y1, int x2, int y2, boolean fill) {
        BasicStroke pen2 = new BasicStroke(diameter, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g.setStroke(pen2);
        GeneralPath path = new GeneralPath();
        path.moveTo(startX, startY);
        path.lineTo(x1, y1);
        path.lineTo(x2, y2);
        path.lineTo(startX, startY);
        g.draw(path);
        if (fill)
            g.fill(path);
    }


}
