package designpattern.strategy.coupon;

public class ThankCoupon implements PublicationStrategy {

    @Override
    public boolean isIssued() {
        return true;
    }

    @Override
    public void issue() {

    }
}
