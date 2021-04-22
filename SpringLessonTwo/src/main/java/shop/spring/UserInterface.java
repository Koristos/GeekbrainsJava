package shop.spring;

import java.util.Arrays;
import java.util.Scanner;

public class UserInterface implements Runnable {
    Scanner scan;
    PurchaseController controller;

    UserInterface() {
        this.scan = new Scanner(System.in);
        //this.controller = new shop.spring.PurchaseControllerImpl(new shop.spring.ProductCart(),new shop.spring.ProductRepository());
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Введите команду:");
            execute(scan.nextLine().split(" "));
        }
    }

    private void execute(String[] command) {
        if (Arrays.stream(CommandList.values()).anyMatch(n -> (n.name()).equals(command[0]))) {
            switch (CommandList.valueOf(command[0])) {
                case showCart:
                    this.controller.viewCartContent();
                    break;
                case showStorage:
                    this.controller.viewProductList();
                    break;
                case addItem:
                    this.controller.addProduct(Integer.parseInt(command[1]));
                    break;
                case removeItem:
                    this.controller.removeProduct(Integer.parseInt(command[1]));
                    break;
                case confirm:
                    this.controller.confirmPurchase();
                    break;
                case exit:
                    System.exit(0);
                    break;

            }
        } else {
            System.out.println("Команда не распознана.");
        }

    }

    public void setController(PurchaseController controller) {
        this.controller = controller;
    }
}
