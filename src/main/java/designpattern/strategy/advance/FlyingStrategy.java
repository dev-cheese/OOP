package designpattern.strategy.advance;

public class FlyingStrategy implements MovingStrategy{


    @Override
    public void movie() {
        System.out.println("날아서 이동");
    }
}
