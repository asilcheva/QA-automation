import com.jayway.restassured.RestAssured;
import model.MainApi;
import org.junit.Assert;
import org.junit.Test;

public class RestApiEmample {
    public static void main(String [] args){
        RestAssured.get("https://swapi.co/api/").body().prettyPrint();
    }
    @Test
    public void verifyMainApi()
    {
        MainApi expectedApi = new MainApi.MainApiBuilder()
                .setFilms("https://swapi.co/api/films/")
                .setPeople("https://swapi.co/api/people/")
                .setPlanets("https://swapi.co/api/planets/")
                .setSpecies("https://swapi.co/api/species/")
                .setStarships("https://swapi.co/api/starships/")
                .setVehicles("https://swapi.co/api/vehicles/")
                .createMainApi();
        String actualmainApi = RestAssured.get("https://swapi.co/api/").as(MainApi.class).getFilms();
        Assert.assertEquals(expectedApi.getFilms(), actualmainApi);
    }
}
