package extenssion;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

public class APIActions extends CommonOps {


    @Step("Get Data From Server")
    public static Response get (String paramVaues) {
        response = httpRequest.get(paramVaues);
        response.prettyPrint();
        return response;
    }

    @Step("Extract Value From Json")
    public static String extractFromJson(Response response, String path) {
        jp = response.jsonPath();
        return jp.get(path).toString();
    }

    @Step("Post Data to Server")
    public static void post(JSONObject params, String resource) {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(resource);
        response.prettyPrint();
    }

    @Step("Update Data in Server")
    public static void put(JSONObject params, String resource) {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put(resource);
        response.prettyPrint();
    }

    @Step("Delete Data in Server")
    public static void delete(String id) {
        response = httpRequest.delete("/student/" + id);
        response = httpRequest.delete("/student/" + id);
    }
}
