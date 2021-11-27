import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import stepDefinition.APIUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Here the resource to get the jsonpath in one line  = https://jsonpathfinder.com/

public class GetRequest extends APIUtils {

    Map<String, String> hashMap = new HashMap<>();
    JSONObject jsonObject;
    String manifestId;

    @Test
    public void getRequestTest() throws ParseException {
        RestAssured.baseURI = "https://reqres.in/api/users?page=2";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.get("");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(response.asString());
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        JSONObject jsonObject1 = (JSONObject) jsonArray.get(5);
        String empFirstName = jsonObject1.get("first_name").toString();
        System.out.println("last index of emp first name " + empFirstName);
    }

    @Test
    public void postRequestTest() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String requestBody = "{\n" +
                " \"title\":\"foo\", \n" + "\"body\":\"bar\", \n" + "\"userId\":\"1\" \n} ";
        Response response = given().header("Content-Type", "application/json").and().body(requestBody).when().post("/posts").then().extract().response();
        Assert.assertEquals(201, response.getStatusCode());
        Assert.assertEquals("101", response.jsonPath().getString("id"));

    }

    @Test
    public void abc() {
        List<Header> headerList = new ArrayList<>();
        headerList.add(new Header("abc", "qwerty"));
        headerList.add(new Header("sdf", "erty"));
        Headers headers = new Headers(headerList);
        Response response = given().headers(headers).get("");

        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("asd", "xzcv");
        headerMap.put("qwdc", "thgcf");
        Response response1 = given().headers(headerMap).get("");
    }

//    public  Response cde(HashMap<String, String> body, Map<String, String> headers){
//        given().header(body.put())
//
//              Response  response;
//    }

    @Test
    public void getRequestEmpTest() throws ParseException {
        RestAssured.baseURI = "https://reqres.in/api/users?page=2";
        Response response = given().get("").then().extract().response();
        System.out.println(response.jsonPath().get("data[5].first_name").toString());
        Assert.assertEquals(200, response.getStatusCode());
    }

    // if this dummy api put request response throws 429 expected change the query paramenter data to new test data which it's not updated.

    @Test
    public void putRequest() {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "xyz");
        jsonObject.put("age", "28");
        jsonObject.put("salary", "10000");
        Response response = given().body(jsonObject.toJSONString()).when().put("/update/1542").then().extract().response();
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals("Successfully! Record has been updated.", response.jsonPath().getString("message"));
    }

    // /delete/15410
    @Test
    public void deleteRequest() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        Response response = given().when().get("/posts/4").then().extract().response();
        System.out.println(response.asString());
        Assert.assertEquals(200, response.statusCode());
    }

    @Test
    public void postRequestWithBodyFromJsonFile() throws IOException {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\e678332\\JavaRestAassuredPproject\\src\\test\\java\\postrquestbody"));
        StringBuilder stringBuilder = new StringBuilder();
        String readDataFromFile = "";
        while ((readDataFromFile = bufferedReader.readLine()) != null) {
            stringBuilder.append(readDataFromFile);
        }
        String jsonData = stringBuilder.toString();
        Response response = given().header("Content-Type", "application/json").and().body(jsonData).when().post("/posts").then().extract().response();
        System.out.println(response.asString());
        Assert.assertEquals(201, response.statusCode());
    }

    @Test
    public void postRequestWithParameterizedBody() throws IOException {
        RestAssured.baseURI = "";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(""));
        StringBuilder stringBuilder = new StringBuilder();
        String stringReadFile = "";
        stringReadFile = bufferedReader.readLine();
        while (stringReadFile != null) {
            stringBuilder = stringBuilder.append(stringReadFile);
        }

        String jsonData = stringBuilder.toString();
        HashMap<String, String> hm = new HashMap<>();
    }

    // n no.of query paramerers can ba pass via queryParams with Hashmap param
    @Test
    public void getRequestExampleWithQueryParameter() {
        RestAssured.baseURI = "https://www.google.com";
        // q=automation+testing
        hashMap.put("q", "automation+testing");
        Response response = RestAssured.given().header("Content-Type", "application/json").when().queryParams(hashMap).get("/search").then().extract().response();
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void serializationAndDeserialization() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        CustomerDetails customerDetails = new CustomerDetails("java", "lang", "6");
        Response response = given().header("Content-Type", "application/json").and().body(customerDetails).when().post("/posts").then().extract().response();
        CustomerDetails customerDetailsResponse = response.as(CustomerDetails.class);
        System.out.println(response.asString());
        System.out.println(customerDetailsResponse.getId());
    }


    public String postSaveManifestRequest() throws IOException, ParseException {
        RestAssured.baseURI = "https://apiuat1.ace.aaa.com";
        FileReader fr = new FileReader("C:/Users/e678332/JavaRestAassuredPproject/src/test/java/stepDefinition/savemanifest.txt");
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(fr);
        System.out.println(jsonObject);
        Response response = given().header("Content-Type", "application/json").header("Accept", "*/*").header("x-api-key","nksbSlayuPyt6aXnE4FgusHmYnc23s").body(jsonObject).when().post("/payment/v1/manifests").then().extract().response();
        System.out.println(response.asString());
        if(response.getStatusCode() ==200){
           manifestId = response.jsonPath().get("id");
            System.out.println(manifestId);
        }
        return manifestId;
    }

    public String postSaveManifestRequestWithUtility() throws IOException, ParseException {
        String baseUrl = "https://apiuat1.ace.aaa.com";
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept", "*/*");
        hashMap.put("x-api-key","nksbSlayuPyt6aXnE4FgusHmYnc23s");
        jsonObject = readBodyFromTheFile("C:/Users/e678332/JavaRestAassuredPproject/src/test/java/stepDefinition/savemanifest.txt");
        Response response = postRequest(baseUrl,"/payment/v1/manifests", hashMap,jsonObject);
        if(response.getStatusCode() ==200){
            manifestId = getJsonValue("id");
            System.out.println(manifestId);
        }
        return manifestId;
    }

    @Test
    public void getManifest() throws IOException, ParseException {
        String maniFestID = postSaveManifestRequest();
        RestAssured.baseURI ="https://apiuat1.ace.aaa.com/payment/v1";
        Response response = given().header("Content-Type", "application/json").header("Accept", "*/*").header("client_id","nksbSlayuPyt6aXnE4FgusHmYnc23s").param(maniFestID).get("/manifests").then().extract().response();
        if(response.getStatusCode()==200){
       //  Assert.assertEquals("membership", response.jsonPath().get("/products/productType"));
            Assert.assertEquals("membership", getJsonValue("/products/productType"));
        }
    }
}
