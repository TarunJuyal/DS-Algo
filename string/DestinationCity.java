/*
You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. 
Return the destination city, that is, the city without any path outgoing to another city.
It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
Example:
Input: paths = [["B","C"],["D","B"],["C","A"]]
Output: "A"
Explanation: All possible trips are: 
"D" -> "B" -> "C" -> "A". 
"B" -> "C" -> "A". 
"C" -> "A". 
"A". 
Clearly the destination city is "A".
*/

class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> pathfrom = new HashSet<>();
        for(List<String> path : paths) pathfrom.add(path.get(0));
        for(List<String> path : paths){
            if(!pathfrom.contains(path.get(1))) return path.get(1);
        }
        return null;
    }
}
