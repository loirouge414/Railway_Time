public class Main {
    public static void main(String[] args) {
        Line line = new Line("1호선");
        line.addStation(new Station("서울역"));
        line.addStation(new Station("시청"));
        line.addStation(new Station("종각"));

        line.printRoute();
    }
}
