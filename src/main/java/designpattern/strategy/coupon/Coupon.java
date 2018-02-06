package designpattern.strategy.coupon;

public abstract class Coupon {
    private PublicationStrategy publicationStrategy;

    public void issue(){
        publicationStrategy.issue();
    }

    public void setPublicationStrategy(PublicationStrategy publicationStrategy){
        this.publicationStrategy = publicationStrategy;
    }
}
