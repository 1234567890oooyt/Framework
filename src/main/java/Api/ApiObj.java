package Api;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ApiObj {
    private static String renameListRequestBody = "{\n" +
            "  \"name\": \"ListNewName\" \n}";
    private static String closeListRequestBody = "{\n" +
            "  \"value\": \"true\" \n}";
    private static String createCardRequestBody = "{\n" +
            "  \"name\": \"NewCard\" \n}";

    private static String createCheckListRequestBody = "{\n" +
            "  \"name\": \"NewCheckList\" \n}";

    private static String updateCheckListRequestBody = "{\n" +
            "  \"name\": \"updatedCheckList\" \n}";
    private static String updateCardRequestBody = "{\n" +
            "  \"name\": \"updatedCard\" \n}";
    protected static String board_id;
    protected static String list_id;
    protected static String card_id;
    protected static String checkList_id;
    public Response createBoard(){
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .when()
                .post("/1/boards/?name=NewBoardTest1&key=1e166e6bb1ca9d215203a0d66d771f8e&token=ATTAa9181d91daad8f88c8d5ec34e261775611b7a7ae8f26f72bc6d49335743613d7EEC813F8")
                .then()
                .extract().response();
        board_id = response.jsonPath().getString("id");
        return response;
    }
    public Response deleteBoard(){
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .when()
                .delete("/1/boards/"+board_id+"?key=1e166e6bb1ca9d215203a0d66d771f8e&token=ATTAa9181d91daad8f88c8d5ec34e261775611b7a7ae8f26f72bc6d49335743613d7EEC813F8")
                .then()
                .extract().response();
        return response;
    }
    public Response createList(){
        Response response = given()
                .header("Content-type", "application/json")
                .queryParam("name","ListName")
                .queryParam("key", "1e166e6bb1ca9d215203a0d66d771f8e")
                .queryParam("token", "ATTAa9181d91daad8f88c8d5ec34e261775611b7a7ae8f26f72bc6d49335743613d7EEC813F8")
                .and()
                .when()
                .post("/1/boards/"+board_id+"/lists")
                .then()
                .extract().response();

        list_id = response.jsonPath().getString("id");
        return response;
    }
    public Response renameList(){
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(renameListRequestBody)
                .when()
                .put("/1/lists/"+list_id+"?key=1e166e6bb1ca9d215203a0d66d771f8e&token=ATTAa9181d91daad8f88c8d5ec34e261775611b7a7ae8f26f72bc6d49335743613d7EEC813F8")
                .then()
                .extract().response();
        return response;
    }
    public Response closeList(){
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(closeListRequestBody)
                .when()
                .put("/1/lists/"+list_id+"/closed?key=1e166e6bb1ca9d215203a0d66d771f8e&token=ATTAa9181d91daad8f88c8d5ec34e261775611b7a7ae8f26f72bc6d49335743613d7EEC813F8")
                .then()
                .extract().response();
        return response;
    }
    public Response createCard(){
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(createCardRequestBody)
                .when()
                .post("/1/cards?idList="+list_id+"&key=1e166e6bb1ca9d215203a0d66d771f8e&token=ATTAa9181d91daad8f88c8d5ec34e261775611b7a7ae8f26f72bc6d49335743613d7EEC813F8")
                .then()
                .extract().response();
        card_id = response.jsonPath().getString("id");
        return response;
    }
    public Response updateCard(){
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(updateCardRequestBody)
                .when()
                .put("/1/cards/"+card_id+"?key=1e166e6bb1ca9d215203a0d66d771f8e&token=ATTAa9181d91daad8f88c8d5ec34e261775611b7a7ae8f26f72bc6d49335743613d7EEC813F8")
                .then()
                .extract().response();
        return response;
    }
    public Response deleteCard(){
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .when()
                .delete("/1/cards/"+card_id+"?key=1e166e6bb1ca9d215203a0d66d771f8e&token=ATTAa9181d91daad8f88c8d5ec34e261775611b7a7ae8f26f72bc6d49335743613d7EEC813F8")
                .then()
                .extract().response();
        return response;
    }




    public Response createCheckList(){
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(createCheckListRequestBody)
                .when()
                .post("/1/checklists?idCard="+card_id+"&key=1e166e6bb1ca9d215203a0d66d771f8e&token=ATTAa9181d91daad8f88c8d5ec34e261775611b7a7ae8f26f72bc6d49335743613d7EEC813F8")
                .then()
                .extract().response();
        checkList_id = response.jsonPath().getString("id");
        return response;
    }
    public Response updateCheckList(){
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(updateCheckListRequestBody)
                .when()
                .put("/1/checklists/"+checkList_id+"?key=1e166e6bb1ca9d215203a0d66d771f8e&token=ATTAa9181d91daad8f88c8d5ec34e261775611b7a7ae8f26f72bc6d49335743613d7EEC813F8")
                .then()
                .extract().response();
        return response;
    }
    public Response deleteCheckList(){
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .when()
                .delete("/1/checklists/"+checkList_id+"?key=1e166e6bb1ca9d215203a0d66d771f8e&token=ATTAa9181d91daad8f88c8d5ec34e261775611b7a7ae8f26f72bc6d49335743613d7EEC813F8")
                .then()
                .extract().response();
        return response;
    }
}
