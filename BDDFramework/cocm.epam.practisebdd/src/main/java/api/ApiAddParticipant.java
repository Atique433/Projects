package api;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static constant.PortalPageConstant.Base_URI;

public class ApiAddParticipant
{
    Logger logger = LogManager.getLogger(ApiAddParticipant.class);
    public Response getParticipantDetails(String verify) {
        RestAssured.baseURI =Base_URI;
        RequestSpecification httpRequest = RestAssured.given();
        Response httpResponse = httpRequest.request(Method.GET, "/participants/email/"+verify);
        logger.info(httpResponse.prettyPrint());
        return httpResponse;
    }
}
