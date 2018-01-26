package designpattern.strategy.advance;

public class MissileStrategy implements AttackStrategy{
    @Override
    public void attack() {
        System.out.println("미사일 공격");
    }
}
