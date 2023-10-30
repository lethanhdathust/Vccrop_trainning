package exercise2_2.bank;

public abstract class Payment {
    private Payment next;
    private float balance;

    public Payment getNext() {
        return next;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Payment(float balance) {
        this.balance=balance;
    }

    public Payment setNext(Payment next){
        this.next = next;
        return next;
    }
    public void pay(float amount){
        if(canPaid(amount)){
            System.out.println("The payment has been paid");
        }
        else if(this.next!=null){
            System.out.printf("Can not use %s method, Processing to ... %s \n", this.getClass().getSimpleName(), this.next.getClass().getSimpleName());
            this.next.pay(amount);
        }
        else{
            System.out.println("Do not have enough balance");
        }
    }
    public boolean canPaid(float amount){
        return balance >= amount;
    }
    public static class Bank extends Payment{

        public Bank(float balance) {
            super(balance);
        }

    }
    public static class Stripe extends Payment{

        public Stripe(float balance) {
            super(balance);
        }


    }
    public static void main(String[] args) {
        Bank bank = new Bank(100);
        System.out.println(bank.getBalance());
        Stripe stripe  = new Stripe(200);
        bank.setNext(stripe);
        bank.pay(150);
    }
}
