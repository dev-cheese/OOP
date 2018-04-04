package mock;

import lombok.*;
import org.modelmapper.ModelMapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockTest {

    public static void main(String[] args) {


        ModelMapper modelMapper = new ModelMapper();

        TransferDto transferDto = new TransferDto();

        TransferData test =modelMapper.map(transferDto, TransferData.class);

        System.out.println(test);

    }

    @Getter
    @Setter
    public static class TransferDto {
        private MockTest.SodaUser sodaUser;

        private Currency srcCurrency;
        private Currency dstCurrency;
        private double srcMoney;
        private double dstMoney;
        private double exchangeRate;

        private double fee;
        private double savedMoney;
        private double averageFees;
        private double reducedFee;
        private String transferId;
        private String note;

        private TransferPurposeEnum purpose;
        private int mode;
        private String paymentPassword;

        private MockTest.CreationTransfer transferDataInbound;
        private MockTest.CreationUsTransfer recipient;


        private MockTest.CreationTransfer sender;

    }


    //
    @Getter
    @Setter
    @NoArgsConstructor
    public static class CreationTransfer {
        private MockTest.CreationTransfer corridor;
        private String bankCode;
        private String bankName;

        @Builder
        public CreationTransfer(MockTest.CreationTransfer corridor, String bankCode, String bankName) {
            this.corridor = corridor;
            this.bankCode = bankCode;
            this.bankName = bankName;
        }
    }

    @Getter
    @Setter
    public static class CreationUsTransfer {
        private Long id;
        public SenderRelationshipEnum relationship;
        private String vendorMemberId;
        private RemittanceUser sender;
        private String firstName;
        private String lastName;
        private String bankName;
        private String bankCode;
        private String accountNumber;
        private String country;
        private String city;
        private String addressEn;
        private String address;
        private String state;
        private String zip;
        private String email;
        private String mobile;
        private Date dob;

        @Builder
        public CreationUsTransfer(Long id, String vendorMemberId, RemittanceUser sender, String firstName, String lastName, String bankName, String bankCode, String accountNumber, String country, String city, String addressEn, String address, String state, String zip, String email, String mobile, Date dob, SenderRelationshipEnum relationship) {
            this.id = id;
            this.vendorMemberId = vendorMemberId;
            this.sender = sender;
            this.firstName = firstName;
            this.lastName = lastName;
            this.bankName = bankName;
            this.bankCode = bankCode;
            this.accountNumber = accountNumber;
            this.country = country;
            this.city = city;
            this.addressEn = addressEn;
            this.address = address;
            this.state = state;
            this.zip = zip;
            this.email = email;
            this.mobile = mobile;
            this.dob = dob;
            this.relationship = relationship;
        }
    }


//


    @Getter
    @Setter
    @NoArgsConstructor
    public static class SodaUser {
        private String username;
        private String email;
        private String lastName;
        private String firstName;
        private String country;
        private String lang;
        private String hostId;
        private boolean kycVerification;
        private String timezone;
        private int paymentPasswordCount; // 보류
        private String paymentPassword;
        private boolean isPaymentPassword;
        private String state;
        private String ip;

        @Builder
        public SodaUser(String username, String email, String lastName, String firstName, String country, String lang, String hostId, boolean kycVerification, String timezone, int paymentPasswordCount, String paymentPassword, boolean isPaymentPassword, String state, String ip) {
            this.username = username;
            this.email = email;
            this.lastName = lastName;
            this.firstName = firstName;
            this.country = country;
            this.lang = lang;
            this.hostId = hostId;
            this.kycVerification = kycVerification;
            this.timezone = timezone;
            this.paymentPasswordCount = paymentPasswordCount;
            this.paymentPassword = paymentPassword;
            this.isPaymentPassword = isPaymentPassword;
            this.state = state;
            this.ip = ip;
        }
    }
}

enum Currency {

    KRW,
    USD,
    CNY

}

enum TransferPurposeEnum {

    LAND_PURCHASE("Land Purchase"),
    HOUSE_PURCHASE("House Purchase"),
    HOUSE_BUILDING("House Building"),
    LOAN_REPAYMENT("Loan Repayment"),
    EDUCATION_EXPENSES("Education Expenses"),
    MEDICAL_EXPENSES("Medical Expenses"),
    FAMILY_EXPENSES("Family Expenses"),
    SAVINGS_DEPOSITS("Savings Deposits"),
    MARRIAGE_EXPENSES("Marriage Expenses"),
    TRAVELLING_EXPENSES("Travelling Expenses"),
    GIFTS("Gifts"),
    FIRST_SEMESTER("第一学期"),
    SECOND_SEMESTER("第二学期"),
    SPRING("春季"),
    SUMMER("夏季"),
    FALL("秋季"),
    WINTER("冬季");

    private String name;

    TransferPurposeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

enum SenderRelationshipEnum {
    AUNT("Aunt"),
    BROTHER("Brother"),
    BROTHER_IN_LAW("Brother in Law"),
    COUSIN("Cousin"),
    DAUGHTER("Daughter"),
    FATHER("Father"),
    FATHER_IN_LAW("Father in Law"),
    FRIENDS("Friends"),
    GRAND_FATHER("Grand Father"),
    GRAND_MOTHER("Grand Mother"),
    HUSBAND("Husband"),
    MOTHER("Mother"),
    MOTHER_IN_LAW("Mother in Law"),
    NEPHEW("Nephew"),
    NIECE("Niece"),
    SELF("Self"),
    SISTER("Sister"),
    SISTER_IN_LAW("Sister in law"),
    SON("Son"),
    UNCLE("Uncle"),
    WIFE("Wife");

    private String name;

    SenderRelationshipEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


@Getter
@Setter
class RemittanceUser {

    private static final long serialVersionUID = 1L;


    private boolean credentialsNonExpired;

    private String country;

    private Timestamp emailConfirmDate;

    private String lang;

    private String referralCode;

    private String hostId;

    private boolean kycVerification;

    private String timezone;

    private int paymentPasswordCount;

    private boolean beNotification;

    private String paymentPassword;

    private String fxrateEmailRefusal;

    private String mktEmailRefusal;

    private boolean isPaymentPassword;

    private String state;

    private Timestamp lastVisitAt;

    private long visitCnt = 0;

    private List<TransferData> transfers;


    @Builder
    public RemittanceUser(boolean credentialsNonExpired, String country, Timestamp emailConfirmDate, String lang, String referralCode, String hostId, boolean kycVerification, String timezone, int paymentPasswordCount, boolean beNotification, String paymentPassword, String fxrateEmailRefusal, String mktEmailRefusal, boolean isPaymentPassword, String state, Timestamp lastVisitAt, long visitCnt, List<TransferData> transfers, String email, String firstName, String lastName, String password) {
        this.credentialsNonExpired = credentialsNonExpired;
        this.country = country;
        this.emailConfirmDate = emailConfirmDate;
        this.lang = lang;
        this.referralCode = referralCode;
        this.hostId = hostId;
        this.kycVerification = kycVerification;
        this.timezone = timezone;
        this.paymentPasswordCount = paymentPasswordCount;
        this.beNotification = beNotification;
        this.paymentPassword = paymentPassword;
        this.fxrateEmailRefusal = fxrateEmailRefusal;
        this.mktEmailRefusal = mktEmailRefusal;
        this.isPaymentPassword = isPaymentPassword;
        this.state = state;
        this.lastVisitAt = lastVisitAt;
        this.visitCnt = visitCnt;
        this.transfers = transfers;
    }
}


/**
 * @author jake.kim
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class TransferData {

    private long id;


    private Currency srcCurrency;

    private Currency dstCurrency;

    private double srcMoney;

    private double dstMoney;

    private double exchangeRate;


    private long predictionDate;


    private double fee;

    private double savedMoney;

    private double averageFees;

    private double reducedFee;

    private String transferId;

    private String note;

    private long updatedDate;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private String createdBy;

    private String updatedBy;

    private TransferPurposeEnum purpose;

    private String tuitionNoticeImgUrl;


    // TODO: 2018. 3. 9. 쿠폰 객체 매핑할것 -yun
//    @OneToOne(mappedBy = "transfer", fetch = FetchType.LAZY)
//    private Coupon coupon;

    @Builder
    public TransferData(Currency srcCurrency, Currency dstCurrency, double srcMoney, double dstMoney, double exchangeRate, long predictionDate, double fee, double savedMoney, double averageFees, double reducedFee, String transferId, String note, long updatedDate, Timestamp createdAt, Timestamp updatedAt, String createdBy, String updatedBy, TransferPurposeEnum purpose, String tuitionNoticeImgUrl, int mode, String paymentPassword) {
        this.srcCurrency = srcCurrency;
        this.dstCurrency = dstCurrency;
        this.srcMoney = srcMoney;
        this.dstMoney = dstMoney;
        this.exchangeRate = exchangeRate;
        this.predictionDate = predictionDate;
        this.fee = fee;
        this.savedMoney = savedMoney;
        this.averageFees = averageFees;
        this.reducedFee = reducedFee;
        this.transferId = transferId;
        this.note = note;
        this.updatedDate = updatedDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.purpose = purpose;
        this.tuitionNoticeImgUrl = tuitionNoticeImgUrl;
    }
}



