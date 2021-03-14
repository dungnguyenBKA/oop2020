public class Aims {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "ok", "cate1", "Slayder", 17, 2020
        );

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "ok2", "cate1", "Slayder", 17, 2020
        );

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                "ok3", "cate1", "Slayder", 17, 2020
        );

        DigitalVideoDisc dvd4 = new DigitalVideoDisc(
                "ok4", "cate1", "Slayder", 17, 2020
        );

        Order order = new Order();
        order.addDigitalVideoDisc(dvd1);
        order.addDigitalVideoDisc(dvd2);
        order.addDigitalVideoDisc(dvd3);

        order.removeDigitalVideoDisc(dvd1);

        System.out.println("Total cost: " + order.totalCost() + "$");
    }
}
