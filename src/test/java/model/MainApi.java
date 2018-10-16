package model;

        import java.util.HashMap;
        import java.util.Map;
        import java.util.Objects;

        import com.fasterxml.jackson.annotation.JsonAnyGetter;
        import com.fasterxml.jackson.annotation.JsonAnySetter;
        import com.fasterxml.jackson.annotation.JsonIgnore;
        import com.fasterxml.jackson.annotation.JsonInclude;
        import com.fasterxml.jackson.annotation.JsonProperty;
        import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "people",
        "planets",
        "films",
        "species",
        "vehicles",
        "starships"
})
public class MainApi {

    @JsonProperty("people")
    private String people;
    @JsonProperty("planets")
    private String planets;
    @JsonProperty("films")
    private String films;
    @JsonProperty("species")
    private String species;
    @JsonProperty("vehicles")
    private String vehicles;
    @JsonProperty("starships")
    private String starships;


    public MainApi() {}
    public MainApi(String people, String planets, String films, String species, String vehicles, String starships) {
        this.people = people;
        this.planets = planets;
        this.films = films;
        this.species = species;
        this.vehicles = vehicles;
        this.starships = starships;

    }

    @JsonProperty("people")
    public String getPeople() {
        return people;
    }

    @JsonProperty("people")
    public void setPeople(String people) {
        this.people = people;
    }

    @JsonProperty("planets")
    public String getPlanets() {
        return planets;
    }

    @JsonProperty("planets")
    public void setPlanets(String planets) {
        this.planets = planets;
    }

    @JsonProperty("films")
    public String getFilms() {
        return films;
    }

    @JsonProperty("films")
    public void setFilms(String films) {
        this.films = films;
    }

    @JsonProperty("species")
    public String getSpecies() {
        return species;
    }

    @JsonProperty("species")
    public void setSpecies(String species) {
        this.species = species;
    }

    @JsonProperty("vehicles")
    public String getVehicles() {
        return vehicles;
    }

    @JsonProperty("vehicles")
    public void setVehicles(String vehicles) {
        this.vehicles = vehicles;
    }

    @JsonProperty("starships")
    public String getStarships() {
        return starships;
    }

    @JsonProperty("starships")
    public void setStarships(String starships) {
        this.starships = starships;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MainApi)) return false;

        MainApi mainApi = (MainApi) o;

        if (getPeople() != null ? !getPeople().equals(mainApi.getPeople()) : mainApi.getPeople() != null) return false;
        if (getPlanets() != null ? !getPlanets().equals(mainApi.getPlanets()) : mainApi.getPlanets() != null)
            return false;
        if (getFilms() != null ? !getFilms().equals(mainApi.getFilms()) : mainApi.getFilms() != null) return false;
        if (getSpecies() != null ? !getSpecies().equals(mainApi.getSpecies()) : mainApi.getSpecies() != null)
            return false;
        if (getVehicles() != null ? !getVehicles().equals(mainApi.getVehicles()) : mainApi.getVehicles() != null)
            return false;
        return getStarships() != null ? getStarships().equals(mainApi.getStarships()) : mainApi.getStarships() == null;
    }

    @Override
    public int hashCode() {
        int result = getPeople() != null ? getPeople().hashCode() : 0;
        result = 31 * result + (getPlanets() != null ? getPlanets().hashCode() : 0);
        result = 31 * result + (getFilms() != null ? getFilms().hashCode() : 0);
        result = 31 * result + (getSpecies() != null ? getSpecies().hashCode() : 0);
        result = 31 * result + (getVehicles() != null ? getVehicles().hashCode() : 0);
        result = 31 * result + (getStarships() != null ? getStarships().hashCode() : 0);
        return result;
    }

    public static class MainApiBuilder {
        private String people;
        private String planets;
        private String films;
        private String species;
        private String vehicles;
        private String starships;

        public MainApiBuilder setPeople(String people) {
            this.people = people;
            return this;
        }

        public MainApiBuilder setPlanets(String planets) {
            this.planets = planets;
            return this;
        }

        public MainApiBuilder setFilms(String films) {
            this.films = films;
            return this;
        }

        public MainApiBuilder setSpecies(String species) {
            this.species = species;
            return this;
        }

        public MainApiBuilder setVehicles(String vehicles) {
            this.vehicles = vehicles;
            return this;
        }

        public MainApiBuilder setStarships(String starships) {
            this.starships = starships;
            return this;
        }


        public MainApi createMainApi() {
            return new MainApi(people, planets, films, species, vehicles, starships);
        }
    }
}
