import java.text.DecimalFormat;
import java.util.Scanner;
import org.json.JSONObject;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CurrencyConverter {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean play = true;


        do {

            String convertCurrencyFrom = convertfrom(input);
            String convertCurrencyTo = convertTo( input);

            double exchangeRate = getExchangeRate(convertCurrencyFrom, convertCurrencyTo);
            Display(exchangeRate, convertCurrencyFrom, convertCurrencyTo, input);

            System.out.println("Would you like to convert again:  ");
            System.out.println("You can exit by pressing any number and 1 to play again ");
            if (input.nextInt() != 1){
                play = false;
            }
        } while (play);
        input.close();
        System.out.println("Thank you for using Currency converter ");
    }

    private static double getExchangeRate(String convertCurrencyFrom, String convertCurrencyTo) {
        try {
            URL url = new URL("https://api.exchangerate-api.com/v4/latest/" + convertCurrencyFrom);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONObject jsonObject = new JSONObject(response.toString());
                JSONObject rates = jsonObject.getJSONObject("rates");
                return rates.getDouble(convertCurrencyTo);
            } else {
                System.out.println("Failed to fetch exchange rates. Response code: " + responseCode);
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static void Display(double exchangeRate,String convertCurrencyFrom, String convertCurrencyTo,Scanner input){

        if (exchangeRate == -1) {
            System.out.println("Failed to fetch exchange rates.");
            return;
        }

        System.out.print("Enter the amount to convert: ");
        double amount = input.nextDouble();

        double convertedAmount = amount * exchangeRate;

        System.out.printf("%.2f %s is equal to %.2f %s%n", amount, convertCurrencyFrom, convertedAmount, convertCurrencyTo);

    }

    private static String convertfrom(Scanner input){

        System.out.print("Enter the currency you want to covert from (e.g USD (US dollar) : EUR (Euro) : CNY (Yun) : ZAR (SA Rand) : INR (india dollar)) ");
        return input.next().toUpperCase();
    }
    private static String convertTo(Scanner input){
        System.out.print("Enter the currency you want to convert to see (e.g., USD (US dollar) : EUR (Euro) : CNY (Yun) : ZAR (SA Rand) : INR (india dollar)): ");
        return input.next().toUpperCase();

    }
}
