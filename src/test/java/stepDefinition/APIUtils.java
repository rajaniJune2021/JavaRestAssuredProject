package stepDefinition;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class APIUtils {

    Response response;
    public Response postRequest(String baseURi, String url, Map<String, String> headersMap, JSONObject body) {
      RestAssured.baseURI = baseURi;
      response  = RestAssured.given().headers(headersMap).body(body).when().post(url).then().extract().response();
        return response;

    }

    public JSONObject readBodyFromTheFile(String fileLocation) {
        JSONObject jsonObject = null;
        try {
            FileReader fr = new FileReader(fileLocation);
            JSONParser jsonParser = new JSONParser();
             jsonObject = (JSONObject) jsonParser.parse(fr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public String getJsonValue(String jsonPath){
        return   response.getBody().jsonPath().get(jsonPath);

    }

}
