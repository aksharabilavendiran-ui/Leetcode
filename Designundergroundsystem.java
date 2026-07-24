import java.util.*;

class UndergroundSystem {
    Map<Integer, CheckIn> checkIns;   // stores passenger check-in info
    Map<String, Route> routes;        // stores route statistics

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn in = checkIns.get(id);
        checkIns.remove(id);

        String routeKey = in.station + "-" + stationName;
        int travelTime = t - in.time;

        routes.putIfAbsent(routeKey, new Route());
        Route route = routes.get(routeKey);
        route.totalTime += travelTime;
        route.count++;
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "-" + endStation;
        Route route = routes.get(routeKey);
        return (double) route.totalTime / route.count;
    }

    // Helper classes
    static class CheckIn {
        String station;
        int time;
        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    static class Route {
        int totalTime = 0;
        int count = 0;
    }
}
