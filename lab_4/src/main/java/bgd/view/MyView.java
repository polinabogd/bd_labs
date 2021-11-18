package bgd.view;

import bgd.controller.implementations.*;
import bgd.model.entity.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MyView {

    private final Map<String, Printable> menu = new LinkedHashMap<>();
    private static final Scanner SCANNER = new Scanner(System.in);

    private final SecurityController securityController = new SecurityController();
    private final AddressController addressController = new AddressController();
    private final UserController userController = new UserController();
    private final TripController tripController = new TripController();
    private final RatingController ratingController = new RatingController();
    private final ReviewController reviewController = new ReviewController();

    public MyView() {
        menu.put("11", this::getAllAddresses);
        menu.put("12", this::getAddressById);
        menu.put("13", this::createAddress);
        menu.put("14", this::updateAddress);
        menu.put("15", this::deleteAddress);

        menu.put("21", this::getAllSecurityInfo);
        menu.put("22", this::getSecurityByLogin);
        menu.put("23", this::createSecurity);
        menu.put("24", this::updateSecurity);
        menu.put("25", this::deleteSecurity);

        menu.put("31", this::getAllTrips);
        menu.put("32", this::getTripById);
        menu.put("33", this::createTrip);
        menu.put("34", this::updateTrip);
        menu.put("35", this::deleteTrip);

        menu.put("41", this::getAllRatings);
        menu.put("42", this::getRatingByID);
        menu.put("43", this::createRating);
        menu.put("44", this::updateRating);
        menu.put("45", this::deleteRating);

        menu.put("51", this::getAllReviews);
        menu.put("52", this::getReviewByID);
        menu.put("53", this::createReview);
        menu.put("54", this::updateReview);
        menu.put("55", this::deleteReview);

        menu.put("61", this::getAllUsers);
        menu.put("62", this::getUserById);
        menu.put("63", this::createUser);
        menu.put("64", this::updateUser);
        menu.put("65", this::deleteUser);

    }


    //#########################################################################

    public final void show() {
        String input;
        Menu showMenu = new Menu();
        showMenu.displayMenu();
        System.out.println("\nEnter numbers:\n");
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (SCANNER.hasNext());
    }

    //#########################################################################

    private void getAllSecurityInfo() throws SQLException {
        System.out.println("\n" + securityController.findAll() + "\n");
    }

    private void getSecurityByLogin() throws SQLException {
        System.out.println("\nEnter login: ");
        String login = SCANNER.next();
        System.out.println(securityController.findByLogin(login) + "\n");
    }

    private Security getSecurityInputs() {
        System.out.println("\nEnter login: ");
        String login = SCANNER.next();
        System.out.println("Enter password: ");
        String password = SCANNER.next();
        return new Security(login, password);
    }

    private void createSecurity() throws SQLException {
        System.out.println("\n");
        Security security = getSecurityInputs();
        securityController.create(security);
        System.out.println("Security was successfully created!\n");
    }

    private void updateSecurity() throws SQLException {
        System.out.println("\nEnter login to update: ");
        String login = SCANNER.next();
        System.out.println("Enter password: ");
        String password = SCANNER.next();
        Security security = new Security(login, password);
        security.setLogin(login);
        securityController.update(security.getLogin(), security);
        System.out.println("Security with login: " + login + " was updated\n");
    }

    private void deleteSecurity() throws SQLException {
        System.out.println("\nEnter login to delete account: ");
        String login = SCANNER.next();
        securityController.delete(login);
        System.out.println("Account with login: " + login + " was deleted\n");
    }

    //##################################################################################

    private void getAllAddresses() throws SQLException {
        System.out.println(addressController.findAll() + "\n");
    }

    private void getAddressById() throws SQLException {
        System.out.println("Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(addressController.findById(id) + "\n");
    }

    private Address getAddressInputs() {
        System.out.println("\nEnter country: ");
        String country = SCANNER.next();
        System.out.println("Enter region: ");
        String region = SCANNER.next();
        System.out.println("Enter settlement: ");
        String settlement = SCANNER.next();
        System.out.println("Enter street: ");
        String street = SCANNER.next();
        System.out.println("Enter house: ");
        Integer house = SCANNER.nextInt();
        return new Address(country, region, settlement, street, house);
    }

    private void createAddress() throws SQLException {
        Address address = getAddressInputs();
        addressController.create(address);
        System.out.println("Address was successfully created!\n");
    }

    private void updateAddress() throws SQLException {
        System.out.println("\nEnter ID to update: ");
        Integer id = SCANNER.nextInt();
        Address address = getAddressInputs();
        address.setId(id);
        addressController.update(address.getId(), address);
        System.out.println("Address with ID = " + id + " was updated\n");
    }

    private void deleteAddress() throws SQLException {
        System.out.println("\nEnter ID to delete address: ");
        Integer id = SCANNER.nextInt();
        addressController.delete(id);
        System.out.println("Address with ID = " + id + " was deleted\n");
    }

    //########################################################################

    private void getAllUsers() throws SQLException {
        System.out.println("\n" + userController.findAll() + "\n");
    }

    private void getUserById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(userController.findById(id) + "\n");
    }

    private User getUserInputs() {
        System.out.println("\nEnter surname: ");
        String surname = SCANNER.next();
        System.out.println("Enter name: ");
        String name = SCANNER.next();
        System.out.println("Enter email: ");
        String email = SCANNER.next();
        System.out.println("Enter securityLogin: ");
        String securityLogin = SCANNER.next();
        return new User(surname, name, email, securityLogin);
    }

    private void createUser() throws SQLException {
        System.out.println("\n");
        User user = getUserInputs();
        userController.create(user);
        System.out.println("User was successfully created!\n");
    }

    private void updateUser() throws SQLException {
        System.out.println("\nEnter ID to update: ");
        Integer id = SCANNER.nextInt();
        User user = getUserInputs();
        user.setId(id);
        userController.update(user.getId(), user);
        System.out.println("User with ID = " + id + " was updated\n");
    }

    private void deleteUser() throws SQLException {
        System.out.println("\nEnter ID to delete user: ");
        Integer id = SCANNER.nextInt();
        userController.delete(id);
        System.out.println("User with ID = " + id + " was deleted\n");
    }

    //##############################################################################

    private void getAllTrips() throws SQLException {
        System.out.println("\n" + tripController.findAll() + "\n");
    }

    private void getTripById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(tripController.findById(id) + "\n");
    }

    private Trip getTripInputs() {
        System.out.println("\nEnter a type: ");
        String type = SCANNER.next();
        System.out.println("\nEnter a name: ");
        String name = SCANNER.next();
        System.out.println("Enter an addressID: ");
        Integer addressID = SCANNER.nextInt();
        return new Trip(type, name, addressID);
    }

    private void createTrip() throws SQLException {
        System.out.println("\n");
        Trip trip = getTripInputs();
        tripController.create(trip);
        System.out.println("Trip was successfully created!\n");
    }

    private void updateTrip() throws SQLException {
        System.out.println("\nEnter ID of the trip to update: ");
        Integer id = SCANNER.nextInt();
        Trip trip = getTripInputs();
        trip.setId(id);
        tripController.update(trip.getId(), trip);
        System.out.println("Trip with ID = " + id + " was updated\n");
    }

    private void deleteTrip() throws SQLException {
        System.out.println("\nEnter trip ID to delete: ");
        Integer id = SCANNER.nextInt();
        tripController.delete(id);
        System.out.println("Trip with ID = " + id + " was deleted\n");
    }

    //#############################################################################

    private void getAllRatings() throws SQLException {
        System.out.println("\n" + ratingController.findAll() + "\n");
    }

    private void getRatingByID() throws SQLException {
        System.out.println("\nEnter ID of rating: ");
        Integer id = SCANNER.nextInt();
        System.out.println(ratingController.findById(id) + "\n");
    }

    private Rating getRatingInputs() {
        System.out.println("\nEnter starsForPlacement: ");
        Integer starsForPlacement = SCANNER.nextInt();
        System.out.println("Enter starsForPrices: ");
        Integer starsForPrices = SCANNER.nextInt();
        System.out.println("Enter starsInGeneral: ");
        Integer starsInGeneral = SCANNER.nextInt();
        System.out.println("Enter itemID: ");
        Integer itemID = SCANNER.nextInt();
        return new Rating(starsForPlacement, starsForPrices, starsInGeneral, itemID);
    }

    private void createRating() throws SQLException {
        System.out.println("\n");
        Rating rating = getRatingInputs();
        ratingController.create(rating);
        System.out.println("Rating was successfully created!\n");
    }

    private void updateRating() throws SQLException {
        System.out.println("\nEnter ID to update: ");
        Integer id = SCANNER.nextInt();
        Rating rating = getRatingInputs();
        rating.setId(id);
        ratingController.update(rating.getId(), rating);
        System.out.println("Rating with ID = " + id + " was updated\n");
    }

    private void deleteRating() throws SQLException {
        System.out.println("\nEnter ID to delete rating: ");
        Integer id = SCANNER.nextInt();
        ratingController.delete(id);
        System.out.println("Rating with ID = " + id + " was deleted\n");
    }

    //#######################################################################################

    private void getAllReviews() throws SQLException {
        System.out.println("\n" + reviewController.findAll() + "\n");
    }

    private void getReviewByID() throws SQLException {
        System.out.println("\nEnter ID of a review: ");
        Integer id = SCANNER.nextInt();
        System.out.println(reviewController.findById(id) + "\n");
    }

    private Review getReviewInputs() {
        System.out.println("\nEnter comment: ");
        String  comment = SCANNER.next();
        System.out.println("Enter itemID: ");
        Integer itemID = SCANNER.nextInt();
        System.out.println("Enter userID: ");
        Integer userID = SCANNER.nextInt();
        return new Review(comment, itemID, userID);
    }

    private void createReview() throws SQLException {
        System.out.println("\n");
        Review review = getReviewInputs();
        reviewController.create(review);
        System.out.println("Review was successfully created!\n");
    }

    private void updateReview() throws SQLException {
        System.out.println("\nEnter ID to update: ");
        Integer id = SCANNER.nextInt();
        Review review = getReviewInputs();
        review.setId(id);
        reviewController.update(review.getId(), review);
        System.out.println("Review with ID = " + id + " was updated\n");
    }

    private void deleteReview() throws SQLException {
        System.out.println("\nEnter ID to delete review: ");
        Integer id = SCANNER.nextInt();
        reviewController.delete(id);
        System.out.println("Review with ID = " + id + " was deleted\n");
    }
}