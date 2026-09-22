package model;

import java.util.ArrayList;
import java.util.List;

public class Region {
    private final String name;
    private final List<Line> lines = new ArrayList<>();
    private final List<Station> stations = new ArrayList<>();

    public Region(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public List<Line> getLines() {
        return lines;
    }

    // 노선과 무관하게 지역 전체의 역 목록을 공유한다. 이름이 같은 역은 중복 추가하지 않는다.
    public void addStation(Station station) {
        boolean exists = stations.stream()
                .anyMatch(s -> s.getName().equals(station.getName()));
        if (!exists) {
            stations.add(station);
        }
    }

    public List<Station> getStations() {
        return stations;
    }

    @Override
    public String toString() {
        return name;
    }
}
