package designpattern.strategy.advance;

public class WalkingStrategy implements MovingStrategy{

    @Override
    public void movie() {
        System.out.println("걸어서 이동");
    }
}
