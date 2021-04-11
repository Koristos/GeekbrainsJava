
import sun.misc.Queue;

import java.util.ArrayList;
import java.util.Stack;

public class Graph {
    private final boolean [][] map;
    private final Vertex[] vertexList;
    private final int maxCapacity;
    private final int safeCount;

    Graph (int maxCapacity){
        this.map=new boolean [maxCapacity][maxCapacity];
        this.vertexList=new Vertex[maxCapacity];
        this.maxCapacity=maxCapacity;
        safeCount=maxCapacity*maxCapacity;
    }

    public boolean addVertex (Vertex toAdd){
        for (Vertex a: vertexList) {
            if (a!=null) {
                if (a.equals(toAdd)) {
                    System.out.println("This vertex already exists");
                    return false;
                }
            }
        }
        for (int i = 0; i < this.map.length; i++) {
            if (!this.map[i][i]) {
                map[i][i]=true;
                this.vertexList[i]=toAdd;
                return true;
            }
        }
        System.out.println("Graph is full");
        return false;

    }

    public Vertex getVertex (String name){
        for (Vertex a: vertexList) {
            if(a.getName().equals(name)){
                return a;
            }
        }
        System.out.println("Vertex not found");
        return null;
    }

    public boolean removeVertex (String name) {
        Vertex toRemove=getVertex(name);
        if (toRemove==null) return false;
        int index = getVertexIndex(toRemove);
        for (int i = 0; i < this.map.length; i++) {
            if (this.map[i][index]) this.map[i][index]=false;
            if (this.map[index][i]) this.map[i][index]=false;
        }
        this.vertexList[getVertexIndex(toRemove)]=null;
        return true;
    }

    public void addEdges(String origin, String destination, String ... others) {
        editEdge(getVertex(origin),getVertex(destination),true);
        for (String other: others) {
            editEdge(getVertex(origin),getVertex(other),true);
        }
    }

    public String depthBestWay (String from, String to){
        System.out.println("Поиск кратчайшего пути в губину:");
        if(getVertex(from)==null||getVertex(to)==null) {
            System.out.println("Invalid vertex supplied");
            return null;
        }

        int originIndex = getVertexIndex(this.getVertex(from));
        Stack<Vertex> path = depthSearch(originIndex,new ArrayList<Vertex>(),getVertex(to));
        if(path.isEmpty()) return "Путь не найден!";
        return pathToString(path);
    }

    public String diyksraBestWay (String from, String to){
        System.out.println("Алгоритм Дийкстры:");
        if(getVertex(from)==null||getVertex(to)==null) {
            System.out.println("Invalid vertex supplied");
            return null;
        }
        clearValue();
        int originIndex = getVertexIndex(this.getVertex(from));
        int destinationIndex = getVertexIndex(this.getVertex(to));
        this.vertexList[originIndex].setPosition(0);
        vertexAssessment(originIndex,0);
        if(this.vertexList[destinationIndex].getPosition()==this.safeCount) return "Путь не найден!";
        Stack<Vertex> path = reversePath(diyksraWaySearch(destinationIndex));
        return pathToString(path);
    }

    public String widthBestWay (String from, String to){
        System.out.println("Поиск кратчайшего пути в ширину:");
        if(getVertex(from)==null||getVertex(to)==null) {
            System.out.println("Invalid vertex supplied");
            return null;
        }
        Queue <LinkedPath> possibleWays = new Queue<LinkedPath>();
        ArrayList<Vertex> visited = new ArrayList<Vertex>();
        possibleWays.enqueue(new LinkedPath(new ArrayList<Integer>(), getVertexIndex(getVertex(from))));
        Stack <Vertex> path = new Stack<Vertex>();

        do{
            LinkedPath current;
            try {
               current = possibleWays.dequeue();
            } catch (InterruptedException e) {
                throw new RuntimeException("SWW with Queue");
            }
            visited.add(this.vertexList[current.getIndex()]);
            if (this.vertexList[current.getIndex()].equals(getVertex(to))){
                for (int a: current.getPath()) {
                    path.add(this.vertexList[a]);
                }
                break;
            }else {
                for (int i = 0; i < this.map.length; i++) {
                    if (this.map[current.getIndex()][i] && !visited.contains(this.vertexList[i])){
                        possibleWays.enqueue(new LinkedPath(current.getPath(),i));
                    }
                }
            }
        }while (!possibleWays.isEmpty());
        if(path.isEmpty()) System.out.println("Путь не найден!");
        return pathToString(path);
    }

    public void removeEdges (String origin, String destination, String ... others) {
        editEdge(getVertex(origin),getVertex(destination),false);
        for (String other: others) {
            editEdge(getVertex(origin),getVertex(other),false);
        }
    }

    private void editEdge (Vertex origin, Vertex destination, boolean trueIfAdd){
        if (origin==null||destination==null) throw new RuntimeException("Invalid vertex name");
        int firstIndex=getVertexIndex(origin);
        int secondIndex=getVertexIndex(destination);
        this.map[firstIndex][secondIndex]=trueIfAdd;
        this.map[secondIndex][firstIndex]=trueIfAdd;

    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.map.length; i++) {
            if (!this.map[i][i]) {
                sb.append("\nEmpty cell");
            }else {
                sb.append("\n"+this.vertexList[i].getName()+"->");
                boolean hasEdges=false;
                for (int j = 0; j < this.map.length; j++) {
                    if (this.map[i][j]&& i!=j) {
                        sb.append(this.vertexList[j].getName()+"; ");
                        hasEdges=true;
                    }
                }
                if (!hasEdges) sb.append(" no edges)");
            }
        }
        return sb.toString();
    }

    private int getVertexIndex (Vertex toFind) {
        for (int i = 0; i < vertexList.length; i++) {
            if(vertexList[i].equals(toFind)) return i;
        }
        return -1;
    }


    private Stack <Vertex> depthSearch (int originIndex, ArrayList<Vertex> visited, Vertex destination){
        visited.add(this.vertexList[originIndex]);
        Stack <Vertex> bestWay = new Stack<Vertex>();

        for (int i = 0; i < this.map.length; i++) {
            if(this.map[originIndex][i] && !visited.contains(this.vertexList[i])){
                if (this.vertexList[i].equals(destination)){
                    bestWay.clear();
                    bestWay.add(this.vertexList[originIndex]);
                    bestWay.add(destination);
                    return bestWay;
                }
                Stack <Vertex> furtherWay = depthSearch(i,visited,destination);
                if(!furtherWay.isEmpty() && (bestWay.isEmpty()||bestWay.size()>furtherWay.size())) {
                    bestWay.clear();
                    bestWay.add(this.vertexList[originIndex]);
                    bestWay.addAll(furtherWay);

                }
            }

        }
        return bestWay;
    }

    private void vertexAssessment(int origin, int step){
        for (int i = 0; i < this.map.length; i++) {
            if (vertexList[i]!=null) {
                if (this.map[i][origin]) {
                    if (this.vertexList[i].getPosition() > (step + 1)) {
                        this.vertexList[i].setPosition((step + 1));
                        vertexAssessment(i, step + 1);
                    }
                }
            }
        }
    }

    private void clearValue(){
        for (Vertex a:this.vertexList) {
            if(a!=null){
                a.setPosition(this.maxCapacity);
            }
        }
    }

    private Stack<Vertex> diyksraWaySearch (int destination){
        Stack<Vertex> path = new Stack<Vertex>();
        path.add(this.vertexList[destination]);
        if (this.vertexList[destination].getPosition()==0)return path;
        int nextStepValue=this.safeCount;
        int nextStepIndex=-1;
        for (int i = 0; i < this.map.length; i++) {
            if (this.map[destination][i]){
                if (this.vertexList[i]!=null){
                    if (this.vertexList[i].getPosition()<nextStepValue){
                        nextStepValue=this.vertexList[i].getPosition();
                        nextStepIndex=i;
                    }
                }
            }
        }
        path.addAll(diyksraWaySearch(nextStepIndex));
        return path;
    }

    private String pathToString (Stack<Vertex>path){
        StringBuilder sb = new StringBuilder("");
        for (Vertex a: path) {
            sb.append(a.getName()+"->");
        }
        sb.replace(sb.length()-2,sb.length(),";");
        return sb.toString();
    }

    private Stack<Vertex> reversePath (Stack<Vertex> pathToReverse){
        Stack<Vertex> path = new Stack<Vertex>();
        int size=pathToReverse.size();
        for (int i = 0; i <size; i++) {
            path.add(pathToReverse.pop());
        }
        return path;
    }



}


class LinkedPath{
    private ArrayList <Integer> path;
    private int index;

    LinkedPath (ArrayList<Integer> history, int index){
        this.path=new ArrayList<Integer>();
        this.path= (ArrayList<Integer>) history.clone();
        this.path.add(index);
        this.index=index;
    }

    public ArrayList<Integer> getPath() {
        return path;
    }

    public int getIndex() {
        return index;
    }
}