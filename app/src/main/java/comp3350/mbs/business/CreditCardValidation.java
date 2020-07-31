package comp3350.mbs.business;


public class CreditCardValidation {

    private static boolean isValidExpiryDate(String date){

        boolean isValid = false;

        if(date.length() == 4)
        {
            String month = date.substring(0, 2);
            String year = date.substring(2);
            if(Integer.valueOf(year) == 20)
            {
                if(Integer.valueOf(month) >= 8 && Integer.valueOf(month) <= 12)
                {
                    isValid = true;
                }
            }
            else if(Integer.valueOf(year) > 20)
            {
                if(Integer.valueOf(month) >= 1 && Integer.valueOf(month) <= 12)
                {
                    isValid = true;
                }
            }
        }

        return isValid;
    }

    private static boolean isCardNumberValid(String cardNumber){

        return cardNumber.length() == 16;
    }

    private static boolean isSecurityCodeValid(String securityCode)
    {
        return securityCode.length() == 3;
    }

    public static boolean isCardValid(String cardNumber, String expiryDate, String securityCode)
    {
        if(isCardNumberValid(cardNumber) && isValidExpiryDate(expiryDate) && isSecurityCodeValid(securityCode))
            return true;

        return false;
    }
    
}
