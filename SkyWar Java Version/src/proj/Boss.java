package proj;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Boss  extends  Enemy implements  Shootter{

    public int xSpeed=1;
    public BossBullet[] mybullets=new BossBullet[5];

    /**
     * boss����ӵ�����һ��5��boss�ӵ�������
     * ���е������ӵ��ĳ�ʼ�˶������� or �ң��������
     */
    public EnemyBullet[] shoot(){
        int x1 = this.getX()+this.getWeidth()/6;
        int x2 = this.getX()+this.getWeidth()*2/6;
        int x3=this.getX()+this.getWeidth()*1/2;
        int x4=this.getX()+this.getWeidth()*4/6;
        int x5=this.getX()+this.getWeidth()*5/6;
        int y = this.getY()+this.getHeight()-20;
        int z=1;
        double d=Math.random();
        if(d<0.5){
            z=2;
        }
        BossBullet b1 = new BossBullet(x1,y,1);
        BossBullet b2 = new BossBullet(x2,y,2);
        BossBullet b3 = new BossBullet(x3,y,z);
        BossBullet b4 = new BossBullet(x4, y,2);
        BossBullet b5 = new BossBullet(x5,y,1);
        this.mybullets[0]=b1; this.mybullets[1]=b2;
        this.mybullets[2]=b3; this.mybullets[3]=b4;
        this.mybullets[4]=b5;
        return mybullets;

    }

    public Boss(int life){
        super(life);
        // �����speed��ָ��ֱ�����ϵ�speed
        this.setSpeed(1);
    }

    /**
     * boss�ƶ�����
     * ���bossû�ﵽָ���߶� ������ֱ�����ƶ�
     * ���boss�ﵽ�ƶ��߶� ��ʼˮƽ�����ƶ�  ���״̬Ϊtrue
     */
    @Override
    public void step(){
        if(this.getY()<=this.getHeight()-220){
            int y=this.getY();
            this.setY(y+this.getSpeed());
        }else{
            this.canShoot=true;
            int x=this.getX();
            this.setX(x+xSpeed);
            if(this.getX()+this.getWeidth() >= 512 || this.getX()<=0 ){
                this.xSpeed= - this.xSpeed;
            }

        }

    }



    static BufferedImage[] myImages =new BufferedImage[13];
    static {
        try {
            for(int i=0; i<13;i++) {
                myImages[i] = ImageIO.read(Boss.class.getResourceAsStream("/images/boss"+(i+1)+".png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ����Ч��
     * �����������ͨ���  �������ʱ��  �����Ķ���Ч��
     */

    int dieCount=0;
    int biHitedCount=0;
    @Override
    public BufferedImage getImage() {
        if(this.getLife()>0 &&this.beHited==true){
            biHitedCount++;
            if (biHitedCount >=60){
                System.out.println(biHitedCount);
                this.beHited = false;
                biHitedCount=0;
            }
            if(biHitedCount<=20) {
                return myImages[1];
            }else if(biHitedCount <= 40){
                return myImages[2];
            }else {
                return myImages[3];
            }

        }

        if(this.getLife()<=0){
            this.canShoot=false;
            dieCount++;
            if (dieCount==550){
                // ******************�������Ч��������� canClearΪtrue ����ɾ����
                this.canClear=true;
                dieCount=549;
            }
            if(dieCount<=50){
                return myImages[2];
            }else if(dieCount <= 100){
                return myImages[3];
            }else if(dieCount <= 150){
                return myImages[4];
            }else if(dieCount <=200) {
                return myImages[5];
            }else if(dieCount <=250){
                return myImages[6];
            }else if(dieCount <=300){
                return myImages[7];
            }else if(dieCount <=350){
                return myImages[8];
            }else if(dieCount <=400){
                return  myImages[9];
            }else if(dieCount <=450){
                return  myImages[10];
            }else if(dieCount <=500){
                return myImages[11];
            }
            else return myImages[12];
        }else {
            return myImages[0];
        }
    }


}
