package designpattern.strategy;

public class Main {

    public static void main(String[] args) {
        GameCharacter gameCharacter = new GameCharacter();

        gameCharacter.attack();

        gameCharacter.setWeapon(new Knife("111", "222"));
        gameCharacter.attack();

        gameCharacter.setWeapon(new Sword());
        gameCharacter.attack();
    }
}
