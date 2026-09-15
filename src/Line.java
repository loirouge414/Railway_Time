import java.util.ArrayList;
import java.util.List;

public class Line {
    private final String name;
    private final List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public List<Station> getStations() {
        return stations;
    }

    public void printRoute() {
        System.out.println(name + " 노선도");
        for (int i = 0; i < stations.size(); i++) {
            System.out.print(stations.get(i));
            if (i < stations.size() - 1) {
                System.out.print(" - ");
            }
        }
        System.out.println();
    }
}
