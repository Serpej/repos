public class phone_number {

    public static void main(String[] args) {
        String firstName = "Jesper";
        String lastName = "Hagerman Borgström";

        int areaCode = 0;
        int phoneNumber = 0;
        areaCode = 76;
        phoneNumber = 2625922;

        System.out.printf("%s %s%n", firstName, lastName);
        System.out.printf("0%d-%d%n", areaCode, phoneNumber);
    }
}