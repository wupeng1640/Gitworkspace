package TANK_Project;


import java.util.Vector;

/**
 * Created by Administrator on 2016/1/17.
 */
class Tank {

    int x, y;//坦克坐标
    int direction;//方向
    int speed = 20;//速度
    boolean life = true;//生命

    public int getX() {
        return x;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class My_Tank extends Tank {
    Vector<Zidan> zidans = new Vector<Zidan>();
    Zidan zd = null;

    public My_Tank(int x, int y) {
        super(x, y);
    }

    public void up() {
        if (y > 20)
            y -= speed;
    }

    public void down() {
        if (y < 580)
            y += speed;
    }

    public void left() {
        if (x > 20)
            x -= speed;
    }

    public void right() {
        if (x < 780)
            x += speed;
    }

    public void firezidan() {
        switch (this.direction) {
            case 0:
                zd = new Zidan(x, y - 25, direction);
                zidans.add(zd);
                break;
            case 1:
                zd = new Zidan(x, y + 25, direction);
                zidans.add(zd);
                break;
            case 2:
                zd = new Zidan(x - 25, y, direction);
                zidans.add(zd);
                break;
            case 3:
                zd = new Zidan(x + 25, y, direction);
                zidans.add(zd);
                break;
        }
        Thread t = new Thread(zd);
        t.start();
    }

}

class Eemy_Tank extends Tank implements Runnable {
    int speed = 40;
    int time = 0;
    Vector<Zidan> ezidans = new Vector<Zidan>();

    public Eemy_Tank(int x, int y) {
        super(x, y);
    }

    public void run() {
        while (true) {
            switch (this.direction) {
                case 0:
                    if (y <= 20)
                        break;
                    for (int i = 0; i < 4; i++) {
                        if (y > 20)
                            y -= speed;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                    }
                    break;
                case 1:
                    if (y >= 580)
                        break;
                    for (int i = 0; i < 4; i++) {
                        if (y < 580)
                            y += speed;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                    }
                    break;
                case 2:
                    if (x <= 20)
                        break;
                    for (int i = 0; i < 4; i++) {
                        if (x > 20)
                            x -= speed;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                    }
                    break;
                case 3:
                    if (x >= 760)
                        break;
                    for (int i = 0; i < 4; i++) {
                        if (x < 760)
                            x += speed;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                    }
                    break;
            }
            this.direction = (int) (Math.random() * 4);

            if (this.life == false)
                break;
        }
        this.time++;
        if (time % 2 == 0) {
            if (life) {
                if (ezidans.size() < 5) {
                    Zidan zd = null;
                    switch (direction) {
                        case 0:
                            zd = new Zidan(x, y - 25, direction);
                            ezidans.add(zd);
                            break;
                        case 1:
                            zd = new Zidan(x, y + 25, direction);
                            ezidans.add(zd);
                            break;
                        case 2:
                            zd = new Zidan(x - 25, y, direction);
                            ezidans.add(zd);
                            break;
                        case 3:
                            zd = new Zidan(x + 25, y, direction);
                            ezidans.add(zd);
                            break;
                    }
                    Thread t2 = new Thread(zd);
                    t2.start();
                }
            }
        }
    }
}


class Zidan implements Runnable {
    int x;
    int y;
    int sd = 20;
    boolean life = true;
    int direction;

    public Zidan(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void run() {
        while (true) {//凡是线程下面的死循环都要有个休眠
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direction) {
                case 0:
                    y -= sd;
                    break;
                case 1:
                    y += sd;
                    break;
                case 2:
                    x -= sd;
                    break;
                case 3:
                    x += sd;
                    break;
            }
            if (x < 0 || x > 800 || y < 0 || y > 600) {
                this.life = false;
                break;
            }
        }
    }
}