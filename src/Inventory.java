import java.util.ArrayList;

public class Inventory{
        ArrayList<Item> inventory = new ArrayList<>();

        public void addItem(Item item){
            if(getStorage()+ item.size > 20){
                System.out.println("Inventory full");
            }else{
                inventory.add(item);
            }
        }

        public void showItems(){
            if (inventory.isEmpty()){
                System.out.println("Inventory is Empty");
            }else{
                for (int i=0; i<inventory.size(); i++) {
                    System.out.print(i + ". ");
                    System.out.println(inventory.get(i));
                }
                System.out.println();
            }
        }

        public boolean foundItem(String itemName){
            for (int i=0; i<inventory.size(); i++){
                if (itemName.equalsIgnoreCase(inventory.get(i).name)){
                    return true;
                }
            }
            return false;
    }
        public void dropItems(Item item){
                inventory.remove(item);
        }

        public int getStorage(){
            int count=0;
            for (Item item : inventory) {
                count += item.size;
            }
            return count;
    }
}