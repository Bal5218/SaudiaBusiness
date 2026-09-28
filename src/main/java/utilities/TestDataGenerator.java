package utilities;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.openqa.selenium.WebElement;

public final class TestDataGenerator {

    private static final AtomicInteger counter = new AtomicInteger(1);

    private TestDataGenerator() {
    }

    
    // Common 2-digit number
    private static final Random random = new Random();

    private static String getTwoDigitNumber() {

        int number = 10 + random.nextInt(90);

        return String.valueOf(number);
    }
  

    private static String generateAlphaNumericCode() {

        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";

        char letter = letters.charAt(random.nextInt(letters.length()));
        char digit1 = numbers.charAt(random.nextInt(numbers.length()));
        char digit2 = numbers.charAt(random.nextInt(numbers.length()));

        return "" + letter + digit1 + digit2;
    }
    // Company Name
  
    public static String generateCompanyName(String baseName) {

        return baseName + getTwoDigitNumber();
    }
    
    public static String generateEmail(String email) {

        String[] parts = email.split("@", 2);

        return parts[0] + getTwoDigitNumber() + "@" + parts[1];
    }

    public static String generateEmployeeNumber(String employeeNumber) {

        return employeeNumber + getTwoDigitNumber();
    }
   
    // Company Registration ID
   
    public static String generateCompanyRegistrationId() {

        return "GTM256417" + getTwoDigitNumber();
    }

    // Tax Identification Number
   
    public static String generateTaxIdentificationNumberNumeric() {

        int number = 10000000 + counter.getAndIncrement();

        return String.valueOf(number);
    }

    // Building Number
   
    public static String generateBuildingNumber() {

        int number = 100 + counter.getAndIncrement();

        return String.valueOf(number);
    }

    // Company Email
     public static String generateCompanyEmail() {

        return "company" + getTwoDigitNumber() + "@quadlabs.com";
    }

    // Project Name
   
     public static String generateProjectName(String baseName) {

    	    return baseName + System.currentTimeMillis();
    	}

    // Project Code
   
     public static String generateProjectCode(String baseCode) {

    	    return baseCode + System.currentTimeMillis();
    	}
    //ofiice Location
    public static String generateOfficeLocation(String officeLocation) {

        return officeLocation + generateAlphaNumericCode();
    }
    public static String generateOfficeLocationcode(String officeLocationCode) {

        return officeLocationCode + generateAlphaNumericCode();
    }
    
    public static String generateDepartment_Name(String DepartmentName) {

        return DepartmentName + generateAlphaNumericCode();
    }
    
    public static String generateCostCenterName(String baseName) {
        return baseName + "_" + System.currentTimeMillis();
    }
    
    public static String generateCostCenterCode(String baseCode) {
        return baseCode + "_" + System.currentTimeMillis();
    }
    public static String generateDesignation(String Designation) {

        return Designation + generateAlphaNumericCode();
    }
    public static String generateCategoryCode(String CategoryCode) {

        return CategoryCode + generateAlphaNumericCode();
    }
    public static String generateCategoryName(String CategoryName) {

        return CategoryName + generateAlphaNumericCode();
    }
    public static String generateTravelCategory(String TravelCategory) {

        return TravelCategory + generateAlphaNumericCode();
    }
    private static final String UPPERCASE =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final String LOWERCASE =
            "abcdefghijklmnopqrstuvwxyz";

    private static final String NUMBERS =
            "0123456789";

    private static final String SPECIAL =
            "@#$%!";

   


    public static String generatePassword(String basePassword) {

        basePassword = basePassword.trim();

        StringBuilder password =
                new StringBuilder();

        // ==========================================
        // 1. One uppercase
        // ==========================================

        password.append(
                UPPERCASE.charAt(
                        random.nextInt(UPPERCASE.length())
                )
        );


        // ==========================================
        // 2. One lowercase
        // ==========================================

        password.append(
                LOWERCASE.charAt(
                        random.nextInt(LOWERCASE.length())
                )
        );


        // ==========================================
        // 3. One number
        // ==========================================

        password.append(
                NUMBERS.charAt(
                        random.nextInt(NUMBERS.length())
                )
        );


        // ==========================================
        // 4. One special character
        // ==========================================

        password.append(
                SPECIAL.charAt(
                        random.nextInt(SPECIAL.length())
                )
        );


        // ==========================================
        // 5. Add base value from Excel
        // ==========================================

        password.append(basePassword);


        // ==========================================
        // 6. Make sure minimum length is 8
        // ==========================================

        String allCharacters =
                UPPERCASE + LOWERCASE + NUMBERS + SPECIAL;

        while (password.length() < 8) {

            password.append(
                    allCharacters.charAt(
                            random.nextInt(
                                    allCharacters.length()
                            )
                    )
            );
        }


        // ==========================================
        // 7. Convert to String
        // ==========================================

        return password.toString();
    }
}