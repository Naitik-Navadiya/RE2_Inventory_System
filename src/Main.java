import java.util.ArrayList;
import java.util.Scanner;

class Main{
    static void printMenu(){
        System.out.println("1. Pick Item");
        System.out.println("2. Drop Item");
        System.out.println("3. View Items");
        System.out.println("4. Exit");
        System.out.print("Enter your Choice: ");
    }
    static void printItems(ArrayList<Item> items){
        System.out.println();
        for (int i=0; i<items.size(); i++){
            System.out.print(i + ". ");
            System.out.println(items.get(i).name);
        }
        System.out.println();
    }
    public static void main(String[] args){
        Pistol pistol = new Pistol("Pistol", 1);
        Shotgun shotgun = new Shotgun("Shotgun", 2);
        OfficeKey officeKey = new OfficeKey("OfficeKey", 1);
        ClubKey clubKey = new ClubKey("ClubKey", 1);
        BlueHerb blueHerb = new BlueHerb("BlueHerb", 1);
        GreenHerb greenHerb = new GreenHerb("GreenHerb", 1);

        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        ArrayList<Item> items = new ArrayList<>();
        items.add(pistol);
        items.add(shotgun);
        items.add(officeKey);
        items.add(clubKey);
        items.add(blueHerb);
        items.add(greenHerb);


        while (true){
            printMenu();
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    printItems(items);
                    System.out.print("Enter Item(0-5): ");
                    int itemChoice = scanner.nextInt();
                    switch (itemChoice){
                        case 0:
                            inventory.addItem(items.getFirst());
                            break;
                        case 1:
                            inventory.addItem(items.get(1));
                            break;
                        case 2:
                            inventory.addItem(items.get(2));
                            break;
                        case 3:
                            inventory.addItem(items.get(3));
                            break;
                        case 4:
                            inventory.addItem(items.get(4));
                            break;
                        case 5:
                            inventory.addItem(items.get(5));
                            break;
                        default:
                            System.out.println("Invalid Choice");
                    }
                    break;
                case 2:
                    if (inventory.inventory.isEmpty()){
                        System.out.println("Inventory is empty");
                    }else{
                        System.out.print("Enter Item Name: ");
                        scanner.nextLine();
                        String itemName = scanner.nextLine();
                        if (inventory.foundItem(itemName)){
                            for (int i=0; i<inventory.inventory.size(); i++){
                                if (itemName.equalsIgnoreCase(inventory.inventory.get(i).name)){
                                    inventory.dropItems(inventory.inventory.get(i));
                                    System.out.println("Item removed");
                                    break;
                                }
                            }
                        }else {
                            System.out.println("Item not Found");
                            break;
                        }
                    }

                case 3:
                    inventory.showItems();
                    break;
                case 4:
                    System.out.print("Exiting...");
                    return;

            }
        }
    }
}