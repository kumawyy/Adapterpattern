interface Bank {
    void processPayment(double amount);
}

class KaspiBank {
    public void kaspiPay(double sum) {
        System.out.println("KaspiBank: payment of " + sum + " KZT completed successfully.");
    }
}

class HalykBank {
    public void halykTransfer(double money) {
        System.out.println("HalykBank: transfer of " + money + " KZT executed.");
    }
}

class KaspiBankAdapter implements Bank {
    private KaspiBank kaspiBank;

    public KaspiBankAdapter(KaspiBank kaspiBank) {
        this.kaspiBank = kaspiBank;
    }

    @Override
    public void processPayment(double amount) {
        kaspiBank.kaspiPay(amount); 
    }
}

class HalykBankAdapter implements Bank {
    private HalykBank halykBank;

    public HalykBankAdapter(HalykBank halykBank) {
        this.halykBank = halykBank;
    }

    @Override
    public void processPayment(double amount) {
        halykBank.halykTransfer(amount); 
    }
}

public class Main {
    public static void main(String[] args) {
        Bank kaspi = new KaspiBankAdapter(new KaspiBank());
        kaspi.processPayment(15000);

        Bank halyk = new HalykBankAdapter(new HalykBank());
        halyk.processPayment(25000);
    }
}
