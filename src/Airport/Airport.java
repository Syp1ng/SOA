package Airport;

public class Airport {
    public String name;
    public Tower tower = new Tower();
    private ApronControl apronControl = new ApronControl();
    public Gate[] gate;

    public Airport(String name) {
        this.name = name;

        for(int i = 0; i<10; i++){
            gate[i] = new Gate();
        }
    }
}
