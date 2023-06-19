public class Bill {
    Integer value;
    BillStatus billStatus;

    Payment payment;

    public Bill(Integer value,BillStatus billStatus,Payment payment)
    {
        this.value = value;
        this.billStatus = billStatus;
        this.payment = payment;
    }
}
