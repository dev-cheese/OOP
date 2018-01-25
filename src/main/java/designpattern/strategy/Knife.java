package designpattern.strategy;

public class Knife implements Weapon {

    private String username;
    private String job;

    public Knife(String username, String job) {
        this.username = username;
        this.job = job;
    }

    @Override
    public void attack() {
        System.out.println("칼 공격");
    }
}
