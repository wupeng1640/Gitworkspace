package TANK_Project;

import com.sun.xml.internal.stream.util.ThreadLocalBufferAllocator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class TANK_Fight extends JFrame  implements ActionListener{

    GuanKaPanel gkpanel=new GuanKaPanel();
    JMenuBar jmBar = null;
    JMenu jm = null, jm1;
    JMenuItem jmi1, jmi2, jmi3, jmi4;

    public static void main(String[] args) {
        TANK_Fight ma = new TANK_Fight();
    }

    public TANK_Fight() {
        jmBar = new JMenuBar();
        jm = new JMenu("游戏(G)");
        jm1 = new JMenu("退出(D)");
        jmi1 = new JMenuItem("开始游戏");
        jmi2 = new JMenuItem("继续游戏");
        jmi3 = new JMenuItem("保存退出");
        jmi4 = new JMenuItem("退出游戏");
        jm.add(jmi1);
        jm.add(jmi2);
        jm1.add(jmi3);
        jm1.add(jmi4);
        jmBar.add(jm);
        jmBar.add(jm1);

        this.setJMenuBar(jmBar);

        this.add(gkpanel);
        Thread tt4=new Thread(gkpanel);
        tt4.start();

        jmi1.addActionListener(this);
        jmi1.setActionCommand("开始游戏");




        this.setTitle("坦克大战");
        this.setIconImage((new ImageIcon("image/tanklogo.jpg")).getImage());
        this.setSize(900, 650);
        this.setLocation(200, 50);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("开始游戏")){
            this.remove(gkpanel);
            MyPanel panel = new MyPanel();
            panel.setBackground(Color.WHITE);
            this.add(panel);
            Thread t = new Thread(panel);
            t.start();
            this.addKeyListener(panel);
            this.setVisible(true);
        }

    }
}
class GuanKaPanel extends JPanel implements Runnable{
    int time=0;
   public void paint(Graphics g){
         super.paint(g);
       g.fillRect(0,0,800,600);
       if(time%2==0){
           g.setColor(Color.yellow);
           Font myfont=new Font("华文行楷",Font.BOLD,50);
           g.setFont(myfont);
           g.drawString("第一关",300,300);
       }
   }
    @Override
    public void run() {
        while(true){
            try {

                Thread.sleep(500);
                time++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();

        }

    }
}
class MyPanel extends JPanel implements KeyListener, Runnable {
    My_Tank my_tank = null;
    Vector<Eemy_Tank> eemy_tanks = new Vector<Eemy_Tank>();
    int shu = 3;//敌方坦克数量
    Image bm1 = null;
    Image bm2 = null;
    Image bm3 = null;

    public MyPanel() {
        my_tank = new My_Tank(400, 580);
        for (int i = 0; i < shu; i++) {
            Eemy_Tank eemy_tank = new Eemy_Tank(20 + i * 380, 20);
            Thread tt1 = new Thread(eemy_tank);
            tt1.start();
            Zidan zd = new Zidan(eemy_tank.x, eemy_tank.y + 25, 1);
            eemy_tank.ezidans.add(zd);
            eemy_tanks.add(eemy_tank);
            Thread t3 = new Thread(zd);
            t3.start();

        }
        // bm1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/boom1.gif"));
        // bm2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/boom2.gif"));
        // bm3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/boom3.gif"));
      //  Vector<Tank> tanks = null;
       // tanks.add(my_tank);
      //  for (int i = 0; i < eemy_tanks.size(); i++) {
       //     tanks.add(eemy_tanks.get(i));
      //  }
    }

    public void paint(Graphics g) {
        super.paint(g);
        // System.out.print("01  ");

        g.fillRect(0, 0, 800, 600);
        if (my_tank.life) {
            this.drawTank(my_tank.getX(), my_tank.getY(), g, my_tank.direction, 0);
        }
        for (int i = 0; i < eemy_tanks.size(); i++) {
            Eemy_Tank eemy_tank = eemy_tanks.get(i);
            if (eemy_tank.life == false) {
                eemy_tanks.remove(eemy_tank);

            }
            if (eemy_tank.life == true) {
                this.drawTank(eemy_tank.getX(), eemy_tank.getY(), g, eemy_tank.direction, 1);
            }
        }
        for (int i = 0; i < my_tank.zidans.size(); i++) {
            Zidan zd = my_tank.zidans.get(i);
            if (zd != null && zd.life == true) {
                g.setColor(Color.white);
                g.fill3DRect(zd.x - 2, zd.y - 2, 4, 4, false);
            }
            if (zd.life == false) {
                my_tank.zidans.remove(zd);
            }
        }

        for (int j = 0; j < eemy_tanks.size(); j++) {
            for (int i = 0; i < eemy_tanks.get(j).ezidans.size(); i++) {
                Zidan zd = eemy_tanks.get(j).ezidans.get(i);
                if (zd != null && zd.life == true) {
                    g.setColor(Color.white);
                    g.fill3DRect(zd.x - 2, zd.y - 2, 4, 4, false);
                }
                if (zd.life == false) {
                    eemy_tanks.get(j).ezidans.remove(zd);
                }
            }
        }
    }

//    public void boombit(Graphics g, int x, int y) throws InterruptedException {
//
//        g.drawImage(bm1, x, y, 40, 40, this);
//        Thread.sleep(100);
//        g.drawImage(bm2, x, y, 40, 40, this);
//        Thread.sleep(100);
//        g.drawImage(bm3, x, y, 40, 40, this);
//        Thread.sleep(100);
//        g.drawRect(x, y, 40, 40);
//
//    }

    public void drawTank(int x, int y, Graphics g, int direction, int clas) {
        switch (clas) {
            case 0://我的坦克
                g.setColor(Color.yellow);
                break;
            case 1://敌方坦克
                g.setColor(Color.green);
                break;
        }
        switch (direction) {
            case 0: {//方向向上
                g.fill3DRect(x - 20, y - 20, 13, 40, false);
                g.fill3DRect(x + 7, y - 20, 13, 40, false);
                g.fill3DRect(x - 7, y - 12, 14, 24, false);
                g.fillOval(x - 7, y - 6, 12, 12);
                g.fillRect(x - 1, y - 23, 2, 23);
                break;
            }
            case 2: {//方向向左
                g.fill3DRect(x - 20, y - 20, 40, 13, false);
                g.fill3DRect(x - 20, y + 7, 40, 13, false);
                g.fill3DRect(x - 12, y - 7, 24, 14, false);
                g.fillOval(x - 6, y - 7, 12, 12);
                g.fillRect(x - 23, y - 1, 23, 2);
                break;
            }
            case 1://方向向下
            {
                g.fill3DRect(x - 20, y - 20, 13, 40, false);
                g.fill3DRect(x + 7, y - 20, 13, 40, false);
                g.fill3DRect(x - 7, y - 12, 14, 24, false);
                g.fillOval(x - 7, y - 6, 12, 12);
                g.fillRect(x - 1, y, 2, 23);
                break;
            }
            case 3: {//方向向右
                g.fill3DRect(x - 20, y - 20, 40, 13, false);
                g.fill3DRect(x - 20, y + 7, 40, 13, false);
                g.fill3DRect(x - 12, y - 7, 24, 14, false);
                g.fillOval(x - 6, y - 7, 12, 12);
                g.fillRect(x, y - 1, 23, 2);
                break;
            }
        }
        this.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            this.my_tank.setDirection(0);
            this.my_tank.up();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            this.my_tank.setDirection(1);
            this.my_tank.down();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            this.my_tank.setDirection(2);
            this.my_tank.left();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            this.my_tank.setDirection(3);
            this.my_tank.right();
        }
        if (e.getExtendedKeyCode() == KeyEvent.VK_J) {
            if (this.my_tank.zidans.size() < 8) {
                this.my_tank.firezidan();
            }
        }
    }

    public void fireEvemyTank(Zidan zd, Eemy_Tank eemy_tank) {
        if (zd.x <= eemy_tank.x + 20 && zd.x >= eemy_tank.x - 20 && zd.y <= eemy_tank.y + 20 && zd.y > eemy_tank.y - 20) {
            zd.life = false;
            eemy_tank.life = false;

        }
    }

    public void fireMyTank(Zidan zd, My_Tank my_tank) {
        if (zd.x <= my_tank.x + 20 && zd.x >= my_tank.x - 20 && zd.y <= my_tank.y + 20 && zd.y > my_tank.y - 20) {
            zd.life = false;
            my_tank.life = false;
        }
    }

//    public boolean crash(Vector<Tank> tanks) {
//        for (int i = 0; i < tanks.size(); i++) {
//            for (int j = 0; j < tanks.size(); j++) {
//                if (i != j) {
//                    float distance2;
//                    distance2 = ((tanks.get(i).getX() - tanks.get(j).getX()) * (tanks.get(i).getX() - tanks.get(j).getX())) + ((tanks.get(i).getY() - tanks.get(j).getY()) * (tanks.get(i).getY() - tanks.get(j).getY()));
//                    if (distance2 < 2500){//半段两个坦克之间的距离平方，
//                        if(tanks.get(i).direction==0)
//                        return true;
//                    }
//                    else return false;
//                }
//            }
//        }
//    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < my_tank.zidans.size(); i++) {
                Zidan zd = my_tank.zidans.get(i);
                if (zd.life) {
                    for (int j = 0; j < eemy_tanks.size(); j++) {
                        Eemy_Tank eemy_tank = eemy_tanks.get(j);
                        if (eemy_tank.life) {
                            this.fireEvemyTank(zd, eemy_tank);
                        }
                    }
                }
            }
            for (int i = 0; i < eemy_tanks.size(); i++) {
                for (int j = 0; j < eemy_tanks.get(i).ezidans.size(); j++) {
                    if (my_tank.life) {
                        this.fireMyTank(eemy_tanks.get(i).ezidans.get(j), my_tank);
                    }
                }
            }
            this.repaint();
        }
    }
}

