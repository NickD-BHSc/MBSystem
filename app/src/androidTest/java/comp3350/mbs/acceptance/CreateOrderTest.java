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
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.is;
import comp3350.mbs.R;
import comp3350.mbs.presentation.MenuActivity;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class CreateOrderTest {
    @Rule
    public ActivityTestRule<MenuActivity> menuActivity = new ActivityTestRule<>(MenuActivity.class);

    @Test
    public void testMenuScreen(){
        onView(withText("Welcome to the Movie Booking System")).check(matches(isDisplayed()));
        onView(withId(R.id.buyTicketsButton)).check(matches(isDisplayed())).check(matches((isEnabled())));
        onView(withId(R.id.viewTicketsButton)).check(matches(isDisplayed())).check(matches((isEnabled())));
    }//end testMenuScreen

    @Test
    public void testOrderForTheatre1Avengers(){
        //Scotiabank Theatre
        onView(withText("Buy Tickets")).perform(click());

        //select Scotiabank Theatre
        onView(withText("Scotiabank Theatre")).check(matches(isDisplayed()));
        onView(withText("Scotiabank Theatre")).check(matches(isDisplayed())).perform(click());

        //select Avengers Endgame movie
        onView(withText("Avengers Endgame")).check(matches(isDisplayed()));
        onView(withText("Avengers Endgame")).check(matches(isDisplayed())).perform(click());

        //select a viewing time
        onView(withText("1:00 to 4:00 PM\nJune 11, 2020, Tuesday")).check(matches(isDisplayed()));
        onView(withText("1:00 to 4:00 PM\nJune 11, 2020, Tuesday")).check(matches(isDisplayed())).perform(click());

        //select a seat
        onView(withText("#0")).check(matches(isDisplayed()));
        onView(withText("#0")).check(matches(isDisplayed())).perform(click());
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

        //check if the seat #0 was updated. i.e. seat is not clickable.
        onView(withText("Buy Tickets")).perform(click());

        //select Scotiabank Theatre
        onView(withText("Scotiabank Theatre")).check(matches(isDisplayed()));
        onView(withText("Scotiabank Theatre")).check(matches(isDisplayed())).perform(click());

        //select Avengers Endgame movie
        onView(withText("Avengers Endgame")).check(matches(isDisplayed()));
        onView(withText("Avengers Endgame")).check(matches(isDisplayed())).perform(click());

        //select the same viewing time
        onView(withText("1:00 to 4:00 PM\nJune 11, 2020, Tuesday")).check(matches(isDisplayed()));
        onView(withText("1:00 to 4:00 PM\nJune 11, 2020, Tuesday")).check(matches(isDisplayed())).perform(click());

        //check seat #0 if its not clickable
        onView(withText("#0")).check(matches(isDisplayed()));
        onView(withText("#0")).check(matches(isDisplayed())).check(matches(not(isClickable())));

    }//end testOrderForTheatre1Avengers

    @Test
    public void testOrderForTheatre2Incredibles(){
        //Cinema City Northgate Theatre
        onView(withText("Buy Tickets")).perform(click());

        //select Scotiabank Theatre
        onView(withText("Cinema City Northgate")).check(matches(isDisplayed()));
        onView(withText("Cinema City Northgate")).check(matches(isDisplayed())).perform(click());

        //select The Incredibles movie
        onView(withText("The Incredibles")).check(matches(isDisplayed()));
        onView(withText("The Incredibles")).check(matches(isDisplayed())).perform(click());

        //select a viewing time
        onView(withText("1:00 to 3:00 PM\nJune 12, 2020, Wednesday")).check(matches(isDisplayed()));
        onView(withText("1:00 to 3:00 PM\nJune 12, 2020, Wednesday")).check(matches(isDisplayed())).perform(click());

        //select all seats
        for(int i = 0; i < 32; i++){
            onView(withText("#" +i)).check(matches(isDisplayed()));
            onView(withText("#" +i)).check(matches(isDisplayed())).perform(click());
        }

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

        //check if all seats were updated. i.e. seats are not clickable.
        onView(withText("Buy Tickets")).perform(click());

        //select Cinema City Northgate
        onView(withText("Cinema City Northgate")).check(matches(isDisplayed()));
        onView(withText("Cinema City Northgate")).check(matches(isDisplayed())).perform(click());

        //select The Incredibles movie
        onView(withText("The Incredibles")).check(matches(isDisplayed()));
        onView(withText("The Incredibles")).check(matches(isDisplayed())).perform(click());

        //select the same viewing time
        onView(withText("1:00 to 3:00 PM\nJune 12, 2020, Wednesday")).check(matches(isDisplayed()));
        onView(withText("1:00 to 3:00 PM\nJune 12, 2020, Wednesday")).check(matches(isDisplayed())).perform(click());

        //select all seats
        for(int i = 0; i < 32; i++){
            onView(withText("#" +i)).check(matches(isDisplayed()));
            onView(withText("#" +i)).check(matches(isDisplayed())).check(matches(not(isClickable())));
        }

    }//end testOrderForTheatre2Incredibles

    @Test
    public void testNoSeatOrderForTheatre3StarWars(){
        //Silver City St.Vital Cinemas Theatre
        onView(withText("Buy Tickets")).perform(click());

        //select Silver City St.Vital Cinemas Theatre
        onView(withText("Silver City St.Vital Cinemas")).check(matches(isDisplayed()));
        onView(withText("Silver City St.Vital Cinemas")).check(matches(isDisplayed())).perform(click());

        //select Star Wars movie
        onView(ViewMatchers.withId(R.id.movieRecyclerView)).perform(ViewActions.swipeUp()); //need to scroll down so that it can see the textview for star wars
        onView(withText("Star Wars")).check(matches(isDisplayed()));
        onView(withText("Star Wars")).check(matches(isDisplayed())).perform(click());

        //select a viewing time
        onView(withText("7:00 to 9:30 PM\nJune 11, 2020, Tuesday")).check(matches(isDisplayed()));
        onView(withText("7:00 to 9:30 PM\nJune 11, 2020, Tuesday")).check(matches(isDisplayed())).perform(click());

        onView(withText("Next")).check(matches(isDisplayed())).perform(click());

        //this checks the toast message
        onView(withText("Please select a seat.")).
                inRoot(withDecorView(not(is(menuActivity.getActivity().getWindow().getDecorView())))).
                check(matches(isDisplayed()));

    }//end testNoSeatOrderForTheatre3StarWars

    @Test
    public void testInvalidCardOrderForTheatre3LionKing(){
        //Silver City St.Vital Cinemas Theatre
        onView(withText("Buy Tickets")).perform(click());

        //select Silver City St.Vital Cinemas Theatre
        onView(withText("Silver City St.Vital Cinemas")).check(matches(isDisplayed()));
        onView(withText("Silver City St.Vital Cinemas")).check(matches(isDisplayed())).perform(click());

        //select The Lion King movie
        onView(withText("The Lion King")).check(matches(isDisplayed()));
        onView(withText("The Lion King")).check(matches(isDisplayed())).perform(click());

        //select a viewing time
        onView(withText("7:00 to 9:00 PM\nJune 11, 2020, Tuesday")).check(matches(isDisplayed()));
        onView(withText("7:00 to 9:00 PM\nJune 11, 2020, Tuesday")).check(matches(isDisplayed())).perform(click());

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

        //input  invalid card information
        onView(withId(R.id.cardInput)).perform(clearText(), typeText("1111"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.expiryInput)).perform(clearText(), typeText("0000"));
        Espresso.closeSoftKeyboard();
        onView(withText("Submit Order")).check(matches(isDisplayed())).perform(click());

        //this checks the toast message
        onView(withText("Please enter a valid credit card.")).
                inRoot(withDecorView(not(is(menuActivity.getActivity().getWindow().getDecorView())))).
                check(matches(isDisplayed()));

    }//end testInvalidCardOrderForTheatre3LionKing

}//end CreateOrderTest