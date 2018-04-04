package designpattern.strategy.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
class Dto {

    private Paging paging;
    private List<Results> results;

    @Getter
    public static class Paging {
        @JsonProperty("total_count")
        private int totalCount;
    }

    @Getter
    public static class Branches {
        private String name;
        private String address;
        private String city;
        private int id;
    }

    @Getter
    public static class Results {
        private List<Branches> branches;
        private String country;
        private String name;
        private int id;
    }
}
