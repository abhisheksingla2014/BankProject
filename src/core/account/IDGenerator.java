package core.account;

public class IDGenerator {
    public static String generateID(String name){
        final String BankName = "HDFC";
        Double randomNumber = Math.random();
        return BankName + name + randomNumber;
    }
}
