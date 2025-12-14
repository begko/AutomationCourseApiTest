import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Pet;
import model.Pet.Category;
import model.Pet.Tag;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ApiTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void testPostCreatePet() {

        // 1. Given : Request data
        Category category = new Category(10, "dog");
        Tag tag = new Tag(0, "string");
        Pet requestPetInfo = new Pet(
                1,
                "white",
                "available",
                category,
                // Creates a list because API expects photoUrls as an array
                Arrays.asList("https://pxhere.com/tr/photo/1264875"),
                // Creates a list because API expects tags as an array
                Arrays.asList(tag)

        );

        // 2. When : Send request
        Response postPetResponse = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestPetInfo)
                .when()
                .post("/pet");

        // 3. Then : Verify response
        Pet responsePetInfo = postPetResponse.as(Pet.class);
        postPetResponse.then().statusCode(200);

        Assert.assertEquals(responsePetInfo.getId(), requestPetInfo.getId(), "Pet ID mismatch!");
        Assert.assertEquals(responsePetInfo.getName(), requestPetInfo.getName(), "Pet Name mismatch!");
        Assert.assertEquals(responsePetInfo.getCategory().getId(), requestPetInfo.getCategory().getId(), "Category ID mismatch!");
        Assert.assertEquals(responsePetInfo.getCategory().getName(), requestPetInfo.getCategory().getName(), "Category Name mismatch!");
        Assert.assertEquals(responsePetInfo.getPhotoUrls(), requestPetInfo.getPhotoUrls(), "Photo URL mismatch!");
        Assert.assertEquals(responsePetInfo.getTags().get(0).getId(), requestPetInfo.getTags().get(0).getId(), "Tag ID mismatch!");
        Assert.assertEquals(responsePetInfo.getTags().get(0).getName(), requestPetInfo.getTags().get(0).getName(), "Tag Name mismatch!");
        Assert.assertEquals(responsePetInfo.getStatus(), requestPetInfo.getStatus(), "Status mismatch!");

        System.out.println("Response Verification");
        System.out.println("Response Pet ID           : " + responsePetInfo.getId());
        System.out.println("Response Pet Name         : " + responsePetInfo.getName());
        System.out.println("Response Category ID      : " + responsePetInfo.getCategory().getId());
        System.out.println("Response Category Name    : " + responsePetInfo.getCategory().getName());
        System.out.println("Response Photo URL        : " + responsePetInfo.getPhotoUrls());
        System.out.println("Response Tag ID           : " + responsePetInfo.getTags().get(0).getId());
        System.out.println("Response Tag Name         : " + responsePetInfo.getTags().get(0).getName());
        System.out.println("Response Pet Status       : " + responsePetInfo.getStatus());
    }
}
