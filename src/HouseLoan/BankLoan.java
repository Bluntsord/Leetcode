package HouseLoan;

public class BankLoan {

    int loan;
    int interestPaid;
    int counter;

    public BankLoan(int loanAmount) {
        this.counter = 0;
        this.loan = loanAmount;
    }

    public void payPrincipal(int amountPaid) {
        this.loan -= amountPaid;
    }

    public void interestMonth(int monthlyInterest) {
        double interest = monthlyInterest/100 + 1;
        this.loan = (int) ((int) this.loan * interest);
    }

    public void interestYear(int yearInterest) {
        double interest = yearInterest/100 + 1;
        this.loan = (int) ((int) this.loan * interest);
    }
}
