package movieticket;

import java.util.Scanner;

public class MovieTicketBookingSystem {

    static boolean[][] seats = new boolean[5][5];
    static Scanner sc = new Scanner(System.in);

    static String movieName = "Avengers";
    static double ticketPrice = 200;

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== MOVIE TICKET BOOKING SYSTEM =====");
            System.out.println("1. Show Available Seats");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Discount Coupon");
            System.out.println("5. Weekend Pricing");
            System.out.println("6. Movie Rating");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    showSeats();
                    break;

                case 2:
                    bookTicket();
                    break;

                case 3:
                    cancelTicket();
                    break;

                case 4:
                    applyCoupon();
                    break;

                case 5:
                    weekendPricing();
                    break;

                case 6:
                    movieRating();
                    break;

                case 7:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);
    }

    static void showSeats() {

        System.out.println("\n--- Seat Availability ---");

        for (int i = 0; i < seats.length; i++) {

            for (int j = 0; j < seats[i].length; j++) {

                if (seats[i][j] == false) {
                    System.out.print("[O] ");
                } else {
                    System.out.print("[X] ");
                }
            }

            System.out.println();
        }

        System.out.println("O = Available");
        System.out.println("X = Booked");
    }

    static void bookTicket() {

        showSeats();

        System.out.print("\nEnter row (1-5): ");
        int row = sc.nextInt();

        System.out.print("Enter seat (1-5): ");
        int seat = sc.nextInt();

        if (row < 1 || row > 5 || seat < 1 || seat > 5) {

            System.out.println("Invalid seat number!");

        } else if (seats[row - 1][seat - 1] == true) {

            System.out.println("Seat is already booked!");

        } else {

            seats[row - 1][seat - 1] = true;

            System.out.println("Ticket booked successfully!");
            System.out.println("Movie: " + movieName);
            System.out.println("Seat: Row " + row + ", Seat " + seat);
            System.out.println("Price: ₹" + ticketPrice);
        }
    }

    static void cancelTicket() {

        System.out.print("\nEnter row (1-5): ");
        int row = sc.nextInt();

        System.out.print("Enter seat (1-5): ");
        int seat = sc.nextInt();

        if (row < 1 || row > 5 || seat < 1 || seat > 5) {

            System.out.println("Invalid seat number!");

        } else if (seats[row - 1][seat - 1] == false) {

            System.out.println("This seat is not booked!");

        } else {

            seats[row - 1][seat - 1] = false;

            System.out.println("Ticket cancelled successfully!");
        }
    }

    static void applyCoupon() {

        System.out.print("\nEnter coupon code: ");
        String coupon = sc.next();

        if (coupon.equalsIgnoreCase("MOVIE10")) {

            double discount = ticketPrice * 0.10;
            double finalPrice = ticketPrice - discount;

            System.out.println("10% discount applied!");
            System.out.println("Original Price: ₹" + ticketPrice);
            System.out.println("Discount: ₹" + discount);
            System.out.println("Final Price: ₹" + finalPrice);

        } else {

            System.out.println("Invalid coupon code!");
        }
    }

    static void weekendPricing() {

        double weekendPrice = ticketPrice + 50;

        System.out.println("\n--- Weekend Pricing ---");
        System.out.println("Normal Price: ₹" + ticketPrice);
        System.out.println("Weekend Price: ₹" + weekendPrice);
    }

    static void movieRating() {

        System.out.print("\nEnter movie rating (1-5): ");
        int rating = sc.nextInt();

        if (rating >= 1 && rating <= 5) {

            System.out.println("You rated " + movieName + " " + rating + "/5");

        } else {

            System.out.println("Rating must be between 1 and 5!");
        }
    }
}