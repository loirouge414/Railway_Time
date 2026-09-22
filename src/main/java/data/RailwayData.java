package data;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Country;
import model.Line;
import model.Region;
import model.Station;

/**
 * 노선/역 데이터를 JSON 파일(data/railway-data.json)에서 읽고 쓰는 저장소.
 * 코드에는 화면과 흐름(틀)만 두고, 실제 데이터는 이 파일 하나에 둔다.
 */
public class RailwayData {
    private static final Path DATA_FILE = Path.of("data", "railway-data.json");

    private static final List<Country> COUNTRIES = load();

    public static List<Country> getCountries() {
        return COUNTRIES;
    }

    // 현재는 대한민국-수도권만 구현되어 있어 임시로 기본 지역을 바로 가져온다.
    public static Region getDefaultRegion() {
        return COUNTRIES.get(0).getRegions().get(0);
    }

    // 화면에서 노선/역을 추가한 뒤 호출하여 변경 내용을 파일에 반영한다.
    public static void save() {
        JSONObject root = new JSONObject();
        JSONArray countriesJson = new JSONArray();

        for (Country country : COUNTRIES) {
            JSONObject countryJson = new JSONObject();
            countryJson.put("name", country.getName());

            JSONArray regionsJson = new JSONArray();
            for (Region region : country.getRegions()) {
                JSONObject regionJson = new JSONObject();
                regionJson.put("name", region.getName());

                JSONArray linesJson = new JSONArray();
                for (Line line : region.getLines()) {
                    JSONObject lineJson = new JSONObject();
                    lineJson.put("name", line.getName());
                    lineJson.put("company", nullToEmpty(line.getCompany()));
                    lineJson.put("startStation", nullToEmpty(line.getStartStation()));
                    lineJson.put("endStation", nullToEmpty(line.getEndStation()));
                    lineJson.put("operationType", nullToEmpty(line.getOperationType()));

                    JSONArray lineStationsJson = new JSONArray();
                    for (Station station : line.getStations()) {
                        lineStationsJson.put(station.getName());
                    }
                    lineJson.put("stations", lineStationsJson);

                    linesJson.put(lineJson);
                }
                regionJson.put("lines", linesJson);

                JSONArray stationsJson = new JSONArray();
                for (Station station : region.getStations()) {
                    stationsJson.put(station.getName());
                }
                regionJson.put("stations", stationsJson);

                regionsJson.put(regionJson);
            }
            countryJson.put("regions", regionsJson);

            countriesJson.put(countryJson);
        }
        root.put("countries", countriesJson);

        try {
            Files.createDirectories(DATA_FILE.getParent());
            Files.writeString(DATA_FILE, root.toString(2), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("데이터 파일을 저장하지 못했습니다: " + DATA_FILE, e);
        }
    }

    private static List<Country> load() {
        try {
            String content = Files.readString(DATA_FILE, StandardCharsets.UTF_8);
            return parse(new JSONObject(content));
        } catch (IOException e) {
            throw new RuntimeException("데이터 파일을 읽지 못했습니다: " + DATA_FILE, e);
        }
    }

    private static List<Country> parse(JSONObject root) {
        List<Country> countries = new ArrayList<>();

        for (Object countryObj : root.getJSONArray("countries")) {
            JSONObject countryJson = (JSONObject) countryObj;
            Country country = new Country(countryJson.getString("name"));

            for (Object regionObj : countryJson.getJSONArray("regions")) {
                JSONObject regionJson = (JSONObject) regionObj;
                Region region = new Region(regionJson.getString("name"));

                for (Object lineObj : regionJson.getJSONArray("lines")) {
                    JSONObject lineJson = (JSONObject) lineObj;
                    Line line = new Line(lineJson.getString("name"));
                    line.setCompany(lineJson.optString("company", ""));
                    line.setStartStation(lineJson.optString("startStation", ""));
                    line.setEndStation(lineJson.optString("endStation", ""));
                    line.setOperationType(lineJson.optString("operationType", ""));

                    for (Object stationName : lineJson.getJSONArray("stations")) {
                        line.addStation(new Station((String) stationName));
                    }
                    region.addLine(line);
                }

                for (Object stationName : regionJson.getJSONArray("stations")) {
                    region.addStation(new Station((String) stationName));
                }

                country.addRegion(region);
            }

            countries.add(country);
        }

        return countries;
    }

    private static String nullToEmpty(String value) {
        return value == null ? "" : value;
    }
}
