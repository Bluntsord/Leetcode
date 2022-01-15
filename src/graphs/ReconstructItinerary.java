package graphs;

import java.util.*;

public class ReconstructItinerary {


    public static void main(String[] args) {
        String[][] tempArr = new String[][] {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        String[][] tempArr2 = new String[][] {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
        String[][] tempArr3 = new String[][] {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        String[][] tempArr4 = new String[][] {{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},{"TIA","ANU"},{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}};

        List<List<String>> temp = new ArrayList<>();
        List<List<String>> temp2 = new ArrayList<>();
        List<List<String>> temp3 = new ArrayList<>();
        List<List<String>> temp4 = new ArrayList<>();

        Arrays.stream(tempArr).forEach(x -> temp.add(Arrays.stream(x).toList()));
        Arrays.stream(tempArr2).forEach(x -> temp2.add(Arrays.stream(x).toList()));
        Arrays.stream(tempArr3).forEach(x -> temp3.add(Arrays.stream(x).toList()));
        Arrays.stream(tempArr4).forEach(x -> temp4.add(Arrays.stream(x).toList()));

        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
//        reconstructItinerary.findItinerary(temp);
//        System.out.println(reconstructItinerary.answer);

        reconstructItinerary.findItinerary(temp4);
        System.out.println(reconstructItinerary.result);
    }



    // origin -> list of destinations
    HashMap<String, List<String>> flightMap = new HashMap<>();
    HashMap<String, boolean[]> visitBitmap = new HashMap<>();
    int flights = 0;
    List<String> result = null;


    public List<String> findItinerary(List<List<String>> tickets) {
        // Step 1). build the graph first
        for (List<String> ticket : tickets) {
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            if (this.flightMap.containsKey(origin)) {
                List<String> destList = this.flightMap.get(origin);
                destList.add(dest);
            } else {
                List<String> destList = new LinkedList<String>();
                destList.add(dest);
                this.flightMap.put(origin, destList);
            }
        }

        // Step 2). order the destinations and init the visit bitmap
        for (Map.Entry<String, List<String>> entry : this.flightMap.entrySet()) {
            Collections.sort(entry.getValue());
            this.visitBitmap.put(entry.getKey(), new boolean[entry.getValue().size()]);
        }

        this.flights = tickets.size();
        LinkedList<String> route = new LinkedList<String>();
        route.add("JFK");

        // Step 3). backtracking
        this.backtracking("JFK", route);
        return this.result;
    }

    protected boolean backtracking(String origin, LinkedList<String> route) {
        if (route.size() == this.flights + 1) {
            this.result = (List<String>) route.clone();
            return true;
        }

        if (!this.flightMap.containsKey(origin))
            return false;

        int i = 0;
        boolean[] bitmap = this.visitBitmap.get(origin);

        for (String dest : this.flightMap.get(origin)) {
            if (!bitmap[i]) {
                bitmap[i] = true;
                route.add(dest);
                boolean ret = this.backtracking(dest, route);
                route.pollLast();
                bitmap[i] = false;

                if (ret)
                    return true;
            }
            ++i;
        }

        return false;
    }
}
