package designpattern.strategy.advance;

public class Main {
    public static void main(String[] args) {

        Robot atom = new Atom("아톰");
        atom.setAttackStrategy(new PunchStrategy());
        atom.setMovingStrategy(new FlyingStrategy());

        atom.attack();
        atom.movie();

    }
}
