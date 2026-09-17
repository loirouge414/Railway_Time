package model;

import java.util.ArrayList;
import java.util.List;

public class Region {
    private final String name;
    private final List<Line> lines = new ArrayList<>();

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

    @Override
    public String toString() {
        return name;
    }
}
