
public class Main {
    public static void main(String[] args) {
       Graph testGraph = new Graph(10);
       testGraph.addVertex(new Vertex("Москва"));
        testGraph.addVertex(new Vertex("Санкт Петербург"));
        testGraph.addVertex(new Vertex("Стамбул"));
        testGraph.addVertex(new Vertex("Анталия"));
        testGraph.addVertex(new Vertex("Мадрид"));
        testGraph.addVertex(new Vertex("Салоу"));
        testGraph.addVertex(new Vertex("Воронеж"));
        testGraph.addVertex(new Vertex("Сочи"));
        testGraph.addVertex(new Vertex("Гавана"));
        testGraph.addVertex(new Vertex("Новгород"));

        testGraph.addEdges("Москва", "Анталия", "Санкт Петербург", "Воронеж", "Гавана");
        testGraph.addEdges("Санкт Петербург", "Москва", "Стамбул", "Салоу", "Новгород");
        testGraph.addEdges("Стамбул", "Санкт Петербург", "Мадрид");
        testGraph.addEdges("Анталия", "Гавана","Москва");
        testGraph.addEdges("Сочи", "Новгород");


        System.out.println(testGraph.toString());

        System.out.println("\n ***** \n");
        System.out.println(testGraph.depthBestWay("Стамбул", "Гавана"));
        System.out.println("\n ***** \n");
        System.out.println(testGraph.diyksraBestWay("Стамбул", "Гавана"));
        System.out.println("\n ***** \n");
        System.out.println(testGraph.widthBestWay("Стамбул", "Гавана"));
    }
}
