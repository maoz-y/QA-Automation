package workflows;

import extenssion.APIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class ApiFlows extends CommonOps {

    @Step("Business Flow: Get Student Property")
    public static String getStudentProperty(String jPath) {
        response = APIActions.get("/student/list/");
        return APIActions.extractFromJson(response, jPath);
    }

    @Step("Business Flow: Create New Student")
    public static void postStudent(String fName, String lName, String email, String programme) {
        params.put("firstName", fName);
        params.put("lastName", lName);
        params.put("email", email);
        params.put("programme", programme);
        APIActions.post(params,"/student/");
    }

    @Step("Business Flow: Update Existing Student")
    public static void updateStudent(String fName, String lName, String email, String programme, String id) {
        params.put("firstName", fName);
        params.put("lastName", lName);
        params.put("email", email);
        params.put("programme", programme);
        APIActions.put(params,"/student/" + id);
    }

    @Step("Business Flow: Delete Student From list")
    public static void delete(String id) {
        APIActions.delete(id);
    }

}
