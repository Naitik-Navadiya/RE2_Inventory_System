abstract public class Item {
    String name;
    int size;
    Item(String name, int size){
        this.name = name;
        this.size = size;
    }
    public String toString(){
        return name;
    }
}