import java.util.List;

public class RailwayData {
    public static List<Country> sampleData() {
        Country korea = new Country("대한민국");

        Line line1 = new Line("1호선");
        line1.addStation(new Station("서울역"));
        line1.addStation(new Station("시청"));
        line1.addStation(new Station("종각"));
        korea.addLine(line1);

        Line line2 = new Line("2호선");
        line2.addStation(new Station("강남"));
        line2.addStation(new Station("역삼"));
        line2.addStation(new Station("삼성"));
        korea.addLine(line2);

        Country japan = new Country("일본");

        Line yamanote = new Line("야마노테선");
        yamanote.addStation(new Station("도쿄"));
        yamanote.addStation(new Station("신주쿠"));
        yamanote.addStation(new Station("시부야"));
        japan.addLine(yamanote);

        return List.of(korea, japan);
    }
}
