/**
 * Created by henry on 5/25/17.
 */
public class Main
{
    public static void main(String[] args){

        GraphDisplay display = new GraphDisplay(0, 0, 600, 600);

        GraphDetails details = new GraphDetails(display);

        Graph graph = new Graph(details);
    }

}
