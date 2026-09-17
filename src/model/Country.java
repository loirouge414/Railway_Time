package model;

import java.util.ArrayList;
import java.util.List;

public class Country {
    private final String name;
    private final List<Region> regions = new ArrayList<>();

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRegion(Region region) {
        regions.add(region);
    }

    public List<Region> getRegions() {
        return regions;
    }

    @Override
    public String toString() {
        return name;
    }
}
