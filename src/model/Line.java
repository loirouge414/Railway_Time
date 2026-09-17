package model;

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

    public String getRouteString() {
        StringBuilder sb = new StringBuilder(name).append(" 노선도\n");
        for (int i = 0; i < stations.size(); i++) {
            sb.append(stations.get(i));
            if (i < stations.size() - 1) {
                sb.append(" - ");
            }
        }
        return sb.toString();
    }

    public void printRoute() {
        System.out.println(getRouteString());
    }

    @Override
    public String toString() {
        return name;
    }
}
