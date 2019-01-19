package kvl.school.ivh11.utils;

import kvl.school.ivh11.domain.*;
import kvl.school.ivh11.repository.CustomerRepo;
import kvl.school.ivh11.repository.EmployeeRepo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;

@Getter
public class CinemaData {
    private final long id = 0;
    private final String location = "Chasséveld 15, 4811 DH Breda";
    private final String name = "Pathé Breda";

    private final int screenOneMaxSeats = 180;
    private final int screenOneSize = 48;
    private final int screenTwoMaxSeats = 380;
    private final int screenTwoSize = 64;

    private final Cinema cinema;

    private final Screen screenOne;
    private final Screen screenTwo;

    private final Seat seatOne;
    private final Seat seatTwo;
    private final Seat seatThree;
    private final Seat seatFour;
    private final Seat seatFive;
    private final Seat seatSix;
    private final Seat seatSeven;
    private final Seat seatEight;
    private final Seat seatNine;
    private final Seat seatTen;

    private final Film filmOne;
    private final Film filmTwo;
    private final Film filmThree;

    private final String filmOneTitle = "The Lord of the Rings: The Return of the King";
    private final int filmOneDuration = 263;
    private final String filmOneDescription = "Gandalf and Aragorn lead the World of Men against Saurons army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.";

    private final String filmTwoTitle = "Johnny English Strikes Again";
    private final int filmTwoDuration = 89;
    private final String filmTwoDescription = "After a cyber-attack reveals the identity of all of the active undercover agents in Britain, Johnny English is forced to come out of retirement to find the mastermind hacker.";

    private final String filmThreeTitle = "Hot Fuzz";
    private final int filmThreeDuration = 121;
    private final String filmThreeDescription = "A skilled London police officer is transferred to a small town with a dark secret.";

    private final Screening screeningOne;
    private final Screening screeningTwo;
    private final Screening screeningThree;

    private final LocalDateTime screeningOneStartTime = LocalDateTime.of(2019, 1, 26, 19, 20);
    private final LocalDateTime screeningOneEndTime = LocalDateTime.of(2019, 1, 26, 23, 25);

    private final LocalDateTime screeningTwoStartTime = LocalDateTime.of(2019, 1, 26, 19, 10);
    private final LocalDateTime screeningTwoEndTime = LocalDateTime.of(2019, 1, 26, 23, 45);

    private final LocalDateTime screeningThreeStartTime = LocalDateTime.of(2019, 1, 28, 20, 30);
    private final LocalDateTime screeningThreeEndTime = LocalDateTime.of(2019, 1, 28, 22, 10);

    private final Order orderOne;
    private final Order orderTwo;

    private final OrderState orderOneOrderState = OrderState.PAID;
    private final LocalDateTime orderOneOrderTime = LocalDateTime.of(2019, 1, 12, 16, 51, 31);

    private final OrderState orderTwoOrderState = OrderState.PENDING;
    private final LocalDateTime orderTwoOrderTime = LocalDateTime.of(2019, 1, 12, 22, 10, 49);

    private final Ticket ticketOne;
    private final Ticket ticketTwo;
    private final Ticket ticketThree;

    private final BigDecimal ticketOnePrice = new BigDecimal(8.90);
    private final BigDecimal ticketTwoPrice = new BigDecimal(8.90);
    private final BigDecimal ticketThreePrice = new BigDecimal(12.60);

    private final CustomerRepo customerRepo;

    private final EmployeeRepo employeeRepo;

    private final Employee employeeOne;
    private final Customer customerOne;
    private final Customer customerTwo;

    @Autowired
    public CinemaData(CustomerRepo customerRepo, EmployeeRepo employeeRepo) {
        this.customerRepo = customerRepo;
        this.employeeRepo = employeeRepo;

        this.customerOne = customerRepo.findById((long) 2).get();
        this.customerTwo = customerRepo.findById((long) 3).get();
        this.employeeOne = employeeRepo.findById((long) 1).get();

        this.cinema = new Cinema(name, location);
        this.cinema.setScreens(new HashSet<>());

        //-----SCREEN ONE-----
        this.screenOne = new Screen(screenOneMaxSeats, screenOneSize, cinema);
        this.seatOne = new Seat(10, false, screenOne);
        this.seatTwo = new Seat(11, false, screenOne);
        this.seatThree = new Seat(12, false, screenOne);
        this.seatFour = new Seat(20, true, screenOne);
        this.seatFive = new Seat(21, true, screenOne);

        this.screenOne.setSeats(new HashSet<>());
        this.screenOne.getSeats().add(seatOne);
        this.screenOne.getSeats().add(seatTwo);
        this.screenOne.getSeats().add(seatThree);
        this.screenOne.getSeats().add(seatFour);
        this.screenOne.getSeats().add(seatFive);
        //-----SCREEN ONE-----

        //-----SCREEN TWO-----
        screenTwo = new Screen(screenTwoMaxSeats, screenTwoSize, cinema);
        seatSix = new Seat(10, false, screenTwo);
        seatSeven = new Seat(11, false, screenTwo);
        seatEight = new Seat(12, false, screenTwo);
        seatNine = new Seat(40, true, screenTwo);
        seatTen = new Seat(41, true, screenTwo);

        this.screenTwo.setSeats(new HashSet<>());
        screenTwo.getSeats().add(seatSix);
        screenTwo.getSeats().add(seatSeven);
        screenTwo.getSeats().add(seatEight);
        screenTwo.getSeats().add(seatNine);
        screenTwo.getSeats().add(seatTen);
        //-----SCREEN TWO-----

        this.cinema.getScreens().add(screenOne);
        this.cinema.getScreens().add(screenTwo);

        //-------FILMS--------
        this.filmOne = new Film(filmOneTitle, filmOneDuration);
        this.filmOne.setDescription(filmOneDescription);
        this.filmTwo = new Film(filmTwoTitle, filmTwoDuration);
        this.filmTwo.setDescription(filmTwoDescription);
        this.filmThree = new Film(filmThreeTitle, filmThreeDuration);
        this.filmThree.setDescription(filmThreeDescription);
        //-------FILMS--------

        //-----SCREENINGS-----
        this.screeningOne = new Screening(screeningOneStartTime, screeningOneEndTime, filmOne, screenOne);
        this.screeningTwo = new Screening(screeningTwoStartTime, screeningTwoEndTime, filmOne, screenTwo);
        this.screeningThree = new Screening(screeningThreeStartTime, screeningThreeEndTime, filmTwo, screenOne);
        //-----SCREENINGS-----

        //-------ORDERS-------
        this.orderOne = new Order(this.orderOneOrderState, this.customerOne, this.orderOneOrderTime);
        this.orderTwo = new Order(this.orderTwoOrderState, this.customerTwo, this.orderTwoOrderTime);
        //-------ORDERS-------

        //-------TICKETS------
        this.ticketOne = new Ticket(this.ticketOnePrice, this.orderOne, this.screeningOne, this.seatOne);
        this.ticketTwo = new Ticket(this.ticketTwoPrice, this.orderOne, this.screeningOne, this.seatTwo);
        this.ticketThree = new Ticket(this.ticketThreePrice, this.orderTwo, this.screeningThree, this.seatTen);
        //-------TICKETS------
    }
}
