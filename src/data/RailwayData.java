package data;

import java.util.List;

import model.Country;
import model.Line;
import model.Region;
import model.Station;

public class RailwayData {
    public static List<Country> sampleData() {
        Country korea = new Country("대한민국");

        Region seoul = new Region("수도권");

        Line line1 = new Line("1호선");
        line1.addStation(new Station("서울역"));
        line1.addStation(new Station("시청"));
        line1.addStation(new Station("종각"));
        seoul.addLine(line1);

        Line line2 = new Line("2호선");
        line2.addStation(new Station("강남"));
        line2.addStation(new Station("역삼"));
        line2.addStation(new Station("삼성"));
        seoul.addLine(line2);

        korea.addRegion(seoul);

        Country japan = new Country("일본");

        Region tokyo = new Region("도쿄권");

        Line yamanote = new Line("야마노테선");
        yamanote.addStation(new Station("도쿄"));
        yamanote.addStation(new Station("신주쿠"));
        yamanote.addStation(new Station("시부야"));
        tokyo.addLine(yamanote);

        japan.addRegion(tokyo);

        return List.of(korea, japan);
    }
}
