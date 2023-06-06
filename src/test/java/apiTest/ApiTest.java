package apiTest;


import Api.ApiObj;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.testng.annotations.DataProvider;

import static hibernate.HibernateMain.*;
import static io.restassured.RestAssured.given;
public class ApiTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api.trello.com";
    }


    @Test
    public void CreateBoardListUpdateClose() {
        ApiObj apiObj = new ApiObj();
        Response response = apiObj.createBoard();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("NewBoardTest1",response.jsonPath().getString("name"));
        System.out.println(response.getBody().asString());


        Response response2 = apiObj.createList();

        Assertions.assertEquals(200, response2.statusCode());
        Assertions.assertEquals("ListName",response2.jsonPath().getString("name"));
        System.out.println(response2.getBody().asString());


        Response response3 = apiObj.renameList();

        Assertions.assertEquals(200, response3.statusCode());
        Assertions.assertEquals("ListNewName", response3.jsonPath().getString("name"));
        System.out.println(response3.getBody().asString());

        Response response4 = apiObj.closeList();

        Assertions.assertEquals(200, response4.statusCode());
        Assertions.assertEquals("true", response4.jsonPath().getString("closed"));
        System.out.println(response4.getBody().asString());
        beginTrans();
        saveToApiLogs(response.getBody().asString(),response.statusCode());
        saveToApiLogs(response2.getBody().asString(),response2.statusCode());
        closeSession();

        Response response5 = apiObj.deleteBoard();

        Assertions.assertEquals(200, response5.statusCode());
        System.out.println(response5.getBody().asString());
    }
    @Test
    public void CreateBoardListCardUpdateDelete() {
        ApiObj apiObj = new ApiObj();
        Response response = apiObj.createBoard();
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("NewBoardTest1",response.jsonPath().getString("name"));
        System.out.println(response.getBody().asString());
        Response response2 = apiObj.createList();

        Assertions.assertEquals(200, response2.statusCode());
        Assertions.assertEquals("ListName",response2.jsonPath().getString("name"));
        System.out.println(response2.getBody().asString());

        Response response3 = apiObj.createCard();
        Assertions.assertEquals(200, response3.statusCode());
        Assertions.assertEquals("NewCard",response3.jsonPath().getString("name"));
        System.out.println(response3.getBody().asString());

        Response response4 = apiObj.updateCard();
        Assertions.assertEquals(200, response4.statusCode());
        Assertions.assertEquals("updatedCard",response4.jsonPath().getString("name"));
        System.out.println(response4.getBody().asString());

        Response response5 = apiObj.deleteCard();
        Assertions.assertEquals(200, response5.statusCode());
        System.out.println(response5.getBody().asString());

        beginTrans();
        saveToApiLogs(response3.getBody().asString(),response3.statusCode());
        saveToApiLogs(response4.getBody().asString(),response4.statusCode());
        saveToApiLogs(response5.getBody().asString(),response5.statusCode());
        closeSession();

        Response response6 = apiObj.deleteBoard();
        Assertions.assertEquals(200, response6.statusCode());
        System.out.println(response6.getBody().asString());

    }

    @Test
    public void CreateBoardListCardCheckListUpdateDelete() {
        ApiObj apiObj = new ApiObj();
        Response response = apiObj.createBoard();
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("NewBoardTest1",response.jsonPath().getString("name"));
        System.out.println(response.getBody().asString());
        Response response2 = apiObj.createList();

        Assertions.assertEquals(200, response2.statusCode());
        Assertions.assertEquals("ListName",response2.jsonPath().getString("name"));
        System.out.println(response2.getBody().asString());

        Response response3 = apiObj.createCard();
        Assertions.assertEquals(200, response3.statusCode());
        Assertions.assertEquals("NewCard",response3.jsonPath().getString("name"));
        System.out.println(response3.getBody().asString());

        Response response4 = apiObj.updateCard();
        Assertions.assertEquals(200, response4.statusCode());
        Assertions.assertEquals("updatedCard",response4.jsonPath().getString("name"));
        System.out.println(response4.getBody().asString());

        Response response6 = apiObj.createCheckList();
        Assertions.assertEquals(200, response6.statusCode());
        Assertions.assertEquals("NewCheckList",response6.jsonPath().getString("name"));
        System.out.println(response6.getBody().asString());

        Response response7 = apiObj.updateCheckList();
        Assertions.assertEquals(200, response7.statusCode());
        Assertions.assertEquals("updatedCheckList",response7.jsonPath().getString("name"));
        System.out.println(response7.getBody().asString());

        Response response8 = apiObj.deleteCheckList();
        Assertions.assertEquals(200, response8.statusCode());
        System.out.println(response8.getBody().asString());

        beginTrans();
        saveToApiLogs(response6.getBody().asString(),response6.statusCode());
        saveToApiLogs(response7.getBody().asString(),response7.statusCode());
        saveToApiLogs(response8.getBody().asString(),response8.statusCode());
        closeSession();

        Response response9 = apiObj.deleteBoard();
        Assertions.assertEquals(200, response9.statusCode());
        System.out.println(response9.getBody().asString());
    }
}
