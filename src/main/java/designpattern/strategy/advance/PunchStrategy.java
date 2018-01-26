package designpattern.strategy.advance;

public class PunchStrategy implements AttackStrategy{
    @Override
    public void attack() {
        System.out.println("펀치공격");
    }
}
