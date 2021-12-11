import java.nio.file.Paths;

import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

import static spark.Spark.*;

public class Server {

  public static void main(String[] args) {

    port(4242);

    // This is a sample test API key. Sign in to see examples pre-filled with your key.
    Stripe.apiKey = "sk_test_1YMyz3phMdCvwWgXjVBdTAi0001ZvknJmk";

    staticFiles.externalLocation(
        Paths.get("public").toAbsolutePath().toString());
    options("/*", (request,response)->{
      String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
      if (accessControlRequestHeaders != null) {
        response.header("Access-Control-Allow-Headers", "Content-Type");
      }
      String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
      if(accessControlRequestMethod != null){
        response.header("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
      }
      response.header("Access-Control-Allow-Origin", "*");

      return "OK";
    });
    post("/create-checkout-session", (request, response) -> {
        String YOUR_DOMAIN = "http://localhost:4242";
        SessionCreateParams params =
          SessionCreateParams.builder()
            .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
            .setMode(SessionCreateParams.Mode.PAYMENT)
            .setSuccessUrl(YOUR_DOMAIN + "/success.html")
            .setCancelUrl(YOUR_DOMAIN + "/cancel.html")
            .addLineItem(
              SessionCreateParams.LineItem.builder()
                .setQuantity(1L)
                // Provide the exact Price ID (e.g. pr_1234) of the product you want to sell
                .setPrice("price_1JEuNwH8eh00DPhbcfyFTDC6")
                .build())
            .build();
      Session session = Session.create(params);

      response.redirect(session.getUrl(), 303);
      return "";
    });
  }
}