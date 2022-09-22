package proj;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BossBullet extends  EnemyBullet{

    private int xSpeed=1;
    static BufferedImage bulletImage;

    static{
        try{
            bulletImage = ImageIO.read(HeroBullet.class.getResourceAsStream("/images/bossBullet.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     *  x,y �Ǻ�������
     *  z��ʾ��ʼ�ƶ����� �����2�������� ������������
     */
    public BossBullet(int x, int y,int z){
        super(x,y);
        if(z==2){
            this.xSpeed=-this.xSpeed;
        }
    }

    @Override
    public void step(){
        int x=this.getX();
        int y=this.getY();
        this.setX(x+xSpeed);
        this.setY(y+1);
        if(this.getX()+this.getWeidth() >= 513 || this.getX()<=0 ){
            this.xSpeed= - this.xSpeed;
        }
    }

    @Override
    public BufferedImage getImage() {
        return this.bulletImage;
    }

}
