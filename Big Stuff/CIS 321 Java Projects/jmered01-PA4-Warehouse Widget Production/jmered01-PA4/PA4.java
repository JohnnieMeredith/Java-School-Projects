
public class PA4 {

    private static Warehouse wh;
    private static Widget w;
    private static Delivery d;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            usage("you need to specify test case number to run");
        }
        int tc = Integer.parseInt(args[0]);
        if (tc < 1 || tc > 9) {
            usage(String.format("%s: %d", "invalid test case", tc));
        }
        // create a Warehouse
        wh = new Warehouse();
        switch (tc) {
            case 1:
                TC_1();
                break;
            case 2:
                TC_2();
                break;
            case 3:
                TC_3();
                break;
            case 4:
                TC_4();
                break;
            case 5:
                TC_5();
                break;
            case 6:
                TC_6();
                break;
            case 7:
                TC_7();
                break;
            case 8:
                TC_8();
                break;
            case 9:
                TC_9();
                break;
        }

        int count = wh.widgetsOnHand();
        System.out.println("widgets on hand: " + count);

        System.out.println("*****************");

    }

    public static void usage(String msg) {
        System.err.println(msg);
        System.exit(-1);
    }

    /**
     * scenario: 1. widgets-s is empty; order-q is empty 2. receive order = 100
     * 3.
     */
    public static void TC_1() {
        System.out.println("TC_1: *****************");
        // widgets-s is empty, we receive an order
        // receive an order
        w = new Widget(35.0);
        Order o = new Order(w, 100);
        wh.receiveOrder(o);
        d = new Delivery(100, w, 100, "03/04/2019");
        // receive delivery
        wh.receiveDelivery(d);

    }

    /**
     * new delivery = 100 widgets receive order 50 results: order filled
     * completely; widgets = 50 process multiple orders
     */
    public static void TC_2() {
        System.out.println("TC_2: *****************");

        // widgets-s is empty, we receive an order
        // receive an order
        Order o = new Order(w, 50);
        wh.receiveOrder(o);
        // receive delivery
        // simulate a new widget delivery
        w = new Widget(5.0);
        d = new Delivery(101, w, 100, "03/04/2019");
        // System.out.println(d);
        wh.receiveDelivery(d);

    }

    /**
     * widgets = 100 order = 150 results: partial filled ordered TBD: this TC
     * has a problem calculating full price from 2 different deliveries REVIST
     */
    public static void TC_3() {
        System.out.println("TC_3: *****************");
        // simulate a new widget delivery
        w = new Widget(5.0);
        d = new Delivery(101, w, 100, "03/04/2019");
        //System.out.println(d);

        // widgets-s is empty, we receive an order
        // receive an order
        Order o = new Order(w, 150);
        wh.receiveOrder(o);
        // receive delivery
        wh.receiveDelivery(d);

        // at this time, we have partially filled order with a balance -50
        w = new Widget(1.0);
        d = new Delivery(102, w, 100, "03/05/2019");
        wh.receiveDelivery(d);

    }

    /**
     * receive delivery when order stack is empty; then receive order receive a
     * delivery, we have enough to fill order
     */
    public static void TC_4() {
        System.out.println("TC_4: *****************");
        // widgets-s is empty, we receive an order
        // receive an order
        w = new Widget(1.0);
        d = new Delivery(102, w, 100, "03/05/2019");
        // receive delivery
        wh.receiveDelivery(d);

        Order o = new Order(w, 100);
        wh.receiveOrder(o);

    }

    /**
     * receive delivery when order stack is empty; then receive order receive a
     * delivery, we don't have enough to fill order
     */
    public static void TC_5() {
        System.out.println("TC_5: *****************");
        // widgets-s is empty, we receive an order
        // receive an order
        w = new Widget(1.0);
        d = new Delivery(102, w, 100, "03/05/2019");
        // receive delivery
        wh.receiveDelivery(d);

        Order o = new Order(w, 150);
        wh.receiveOrder(o);
        //System.out.println("*****************");

    }

    /**
     * same as TC_5 except have enough widgets from two deliveries to fill one
     * order
     */
    public static void TC_6() {
        System.out.println("TC_6: *****************");
        // widgets-s is empty, we receive an order
        // receive an order
        w = new Widget(5.0);
        d = new Delivery(101, w, 100, "03/05/2019");
        wh.receiveDelivery(d);

        w = new Widget(15.0);
        d = new Delivery(102, w, 50, "03/06/2019");
        wh.receiveDelivery(d);

        Order o = new Order(w, 150);
        wh.receiveOrder(o);

    }

    /**
     * new delivery = 100 widgets receive order 50 results: order filled
     * completely; widgets = 50 process multiple orders
     */
    public static void TC_7() {
        System.out.println("TC_7: *****************");
        // simulate a new widget delivery
        w = new Widget(5.0);
        d = new Delivery(101, w, 100, "03/04/2019");
        // System.out.println(d);

        // widgets-s is empty, we receive an order
        // receive an order
        Order o = new Order(w, 50);
        wh.receiveOrder(o);

        o = new Order(w, 50);
        wh.receiveOrder(o);
        o = new Order(w, 50);
        wh.receiveOrder(o);

        // receive delivery
        wh.receiveDelivery(d);

    }

    // this test case just receives delivery but orders are on the books
    public static void TC_8() {
        System.out.println("TC_8: *****************");
        w = new Widget(5.0);
        d = new Delivery(101, w, 100, "03/10/2019");
         // receive delivery
        wh.receiveDelivery(d);
    }
        // this test case just receives delivery but orders are on the books
    public static void TC_9() {
        System.out.println("TC_9: *****************");
        Order o = new Order(w, 50);
        wh.receiveOrder(o);
    }
}
