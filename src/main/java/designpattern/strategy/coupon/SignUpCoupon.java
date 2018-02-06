package designpattern.strategy.coupon;

public class SignUpCoupon implements PublicationStrategy{

    @Override
    public boolean isIssued() {
        return false;
    }

    @Override
    public void issue() {
        // TODO: 2018. 2. 6. 쿠폰 발행.... -yun
    }


}
