package comp3350.mbs.acceptance;

import org.junit.*;
import org.junit.runner.RunWith;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.runner.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;

import comp3350.mbs.R;
import comp3350.mbs.presentation.MenuActivity;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class ViewTicketTest {

    @Rule
    public ActivityTestRule<MenuActivity> menuActivity = new ActivityTestRule<>(MenuActivity.class);

    @Test
    public void testMenuScreen(){
        onView(withText("Welcome to the Movie Booking System")).check(matches(isDisplayed()));
        onView(withId(R.id.buyTicketsButton)).check(matches(isDisplayed())).check(matches((isEnabled())));
        onView(withId(R.id.viewTicketsButton)).check(matches(isDisplayed())).check(matches((isEnabled())));
        onView(withId(R.id.viewReviewsButton)).check(matches(isDisplayed())).check(matches((isEnabled())));
    }//end testMenuScreen

    @Test
    public void testViewBoughtOneTicket(){
        //First is to buy a ticket
        //Scotiabank Theatre
        onView(withText("Buy Tickets")).perform(click());

        //select Scotiabank Theatre
        onView(withText("Scotiabank Theatre")).check(matches(isDisplayed()));
        onView(withText("Scotiabank Theatre")).check(matches(isDisplayed())).perform(click());

        //select The Lion King movie
        onView(ViewMatchers.withId(R.id.movieRecyclerView)).perform(ViewActions.swipeUp()); //need to scroll down so that it can see the textview for The Lion King
        onView(withText("The Lion King")).check(matches(isDisplayed()));
        onView(withText("The Lion King")).check(matches(isDisplayed())).perform(click());

        //select a viewing time
        onView(withText("4:00 to 6:30 PM\nJune 13, 2020, Thursday")).check(matches(isDisplayed()));
        onView(withText("4:00 to 6:30 PM\nJune 13, 2020, Thursday")).check(matches(isDisplayed())).perform(click());

        //select a seat
        onView(withText("#12")).check(matches(isDisplayed()));
        onView(withText("#12")).check(matches(isDisplayed())).perform(click());
        onView(withText("#13")).check(matches(isDisplayed()));
        onView(withText("#13")).check(matches(isDisplayed())).perform(click());
        onView(withText("#14")).check(matches(isDisplayed()));
        onView(withText("#14")).check(matches(isDisplayed())).perform(click());
        onView(withText("#15")).check(matches(isDisplayed()));
        onView(withText("#15")).check(matches(isDisplayed())).perform(click());
        onView(withText("#16")).check(matches(isDisplayed()));
        onView(withText("#16")).check(matches(isDisplayed())).perform(click());
        onView(withText("#17")).check(matches(isDisplayed()));
        onView(withText("#17")).check(matches(isDisplayed())).perform(click());
        onView(withText("#18")).check(matches(isDisplayed()));
        onView(withText("#18")).check(matches(isDisplayed())).perform(click());
        onView(withText("#19")).check(matches(isDisplayed()));
        onView(withText("#19")).check(matches(isDisplayed())).perform(click());
        onView(withText("#20")).check(matches(isDisplayed()));
        onView(withText("#20")).check(matches(isDisplayed())).perform(click());
        onView(withText("#21")).check(matches(isDisplayed()));
        onView(withText("#21")).check(matches(isDisplayed())).perform(click());

        onView(withText("Next")).check(matches(isDisplayed())).perform(click());

        //input a valid card information
        onView(withId(R.id.cardInput)).perform(clearText(), typeText("1234123412341234"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.expiryInput)).perform(clearText(), typeText("1120"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.codeInput)).perform(clearText(), typeText("123"));
        Espresso.closeSoftKeyboard();
        onView(withText("Submit Order")).check(matches(isDisplayed())).perform(click());

        //go back to main menu
        onView(withText("BACK TO MAIN")).check(matches(isDisplayed())).perform(click());

        //Check the ticket that has been purchased by clicking the View My Tickets button
        onView(withText("View my Tickets")).perform(click());
        onView(withText("Tickets: 10")).check(matches(isDisplayed()));

    }//end testViewBoughtTicket

    @Test
    public void testViewBoughtMultipleTickets(){
        //Buy multiple tickets
        //Cinema City Northgate Theatre
        onView(withText("Buy Tickets")).perform(click());

        //select Cinema City Northgate Theatre
        onView(withText("Cinema City Northgate")).check(matches(isDisplayed()));
        onView(withText("Cinema City Northgate")).check(matches(isDisplayed())).perform(click());

        //select Avengers Endgame movie
        onView(withText("Avengers Endgame")).check(matches(isDisplayed()));
        onView(withText("Avengers Endgame")).check(matches(isDisplayed())).perform(click());

        //select a viewing time
        onView(withText("5:00 to 8:00 PM\nJune 12, 2020, Wednesday")).check(matches(isDisplayed()));
        onView(withText("5:00 to 8:00 PM\nJune 12, 2020, Wednesday")).check(matches(isDisplayed())).perform(click());

        //Select seats
        onView(withText("#0")).check(matches(isDisplayed()));
        onView(withText("#0")).check(matches(isDisplayed())).perform(click());
        onView(withText("#7")).check(matches(isDisplayed()));
        onView(withText("#7")).check(matches(isDisplayed())).perform(click());
        onView(withText("#24")).check(matches(isDisplayed()));
        onView(withText("#24")).check(matches(isDisplayed())).perform(click());
        onView(withText("#31")).check(matches(isDisplayed()));
        onView(withText("#31")).check(matches(isDisplayed())).perform(click());

        onView(withText("Next")).check(matches(isDisplayed())).perform(click());

        //input a valid card information
        onView(withId(R.id.cardInput)).perform(clearText(), typeText("1234123412341234"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.expiryInput)).perform(clearText(), typeText("1120"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.codeInput)).perform(clearText(), typeText("123"));
        Espresso.closeSoftKeyboard();
        onView(withText("Submit Order")).check(matches(isDisplayed())).perform(click());

        //go back to main menu
        onView(withText("BACK TO MAIN")).check(matches(isDisplayed())).perform(click());

        //buy more tickets at the same theatre, same movie but different viewing time.
        //Silver City St.Vital Cinemas Theatre
        onView(withText("Buy Tickets")).perform(click());

        //select Silver City St.Vital Cinemas Theatre
        onView(withText("Silver City St.Vital Cinemas")).check(matches(isDisplayed()));
        onView(withText("Silver City St.Vital Cinemas")).check(matches(isDisplayed())).perform(click());

        //select Superman movie
        onView(withText("Superman")).check(matches(isDisplayed()));
        onView(withText("Superman")).check(matches(isDisplayed())).perform(click());

        //select a viewing time
        onView(withText("1:00 to 3:00 PM\nJune 11, 2020, Tuesday")).check(matches(isDisplayed()));
        onView(withText("1:00 to 3:00 PM\nJune 11, 2020, Tuesday")).check(matches(isDisplayed())).perform(click());

        //select seats
        onView(withText("#18")).check(matches(isDisplayed()));
        onView(withText("#18")).check(matches(isDisplayed())).perform(click());
        onView(withText("#21")).check(matches(isDisplayed()));
        onView(withText("#21")).check(matches(isDisplayed())).perform(click());
        onView(withText("#30")).check(matches(isDisplayed()));
        onView(withText("#30")).check(matches(isDisplayed())).perform(click());

        onView(withText("Next")).check(matches(isDisplayed())).perform(click());

        //input a valid card information
        onView(withId(R.id.cardInput)).perform(clearText(), typeText("1234123412341234"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.expiryInput)).perform(clearText(), typeText("1120"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.codeInput)).perform(clearText(), typeText("123"));
        Espresso.closeSoftKeyboard();
        onView(withText("Submit Order")).check(matches(isDisplayed())).perform(click());

        //go back to main menu
        onView(withText("BACK TO MAIN")).check(matches(isDisplayed())).perform(click());

        //Check the ticket information that have been purchased by clicking the View My Tickets button
        onView(withText("View my Tickets")).perform(click());
        //first ticket
        onView(withText("Tickets: 4")).check(matches(isDisplayed()));
        //second ticket
        onView(withText("Tickets: 3")).check(matches(isDisplayed()));

    }//end testViewBoughtMultipleTickets



}//end ViewTicketTest
