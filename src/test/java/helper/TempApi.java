package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TempApi {

    RequestSpecification httpRequest;
    Response response;
    String url = "http://localhost:9000";

    @Test
    public void testing() {

        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();

        //get Request
        //response = httpRequest.get("/student/list/");

        //Post Request
        JSONObject params = new JSONObject();
        params.put("firstName", "Maoz");
        params.put("lastName", "Yehuda");
        params.put("email", "maoz@gmail.com");
        params.put("programme", "QA");

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post("student/list");

        response.prettyPrint();
    }
}
