package comp3350.mbs.acceptance;

import org.junit.*;
import org.junit.runner.RunWith;

import androidx.test.espresso.Espresso;
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
public class CreateReviewTest {

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
    public void testCreateReviewInBuyTicketSection(){
        //Silver City St.Vital Cinemas Theatre
        onView(withText("Buy Tickets")).perform(click());

        //select Silver City St.Vital Cinemas Theatre
        onView(withText("Silver City St.Vital Cinemas")).check(matches(isDisplayed()));
        onView(withText("Silver City St.Vital Cinemas")).check(matches(isDisplayed())).perform(click());

        //select Superman movie
        onView(withText("Superman")).check(matches(isDisplayed()));
        onView(withText("Superman")).check(matches(isDisplayed())).perform(click());

        //select a viewing time
        onView(withText("8:00 to 10:00 PM\nJune 11, 2021, Tuesday")).check(matches(isDisplayed()));
        onView(withText("8:00 to 10:00 PM\nJune 11, 2021, Tuesday")).check(matches(isDisplayed())).perform(click());

        //select seats
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
        onView(withText("#22")).check(matches(isDisplayed()));
        onView(withText("#22")).check(matches(isDisplayed())).perform(click());
        onView(withText("#23")).check(matches(isDisplayed()));
        onView(withText("#23")).check(matches(isDisplayed())).perform(click());

        onView(withText("Next")).check(matches(isDisplayed())).perform(click());

        //input a valid card information
        onView(withId(R.id.cardInput)).perform(clearText(), typeText("1234123412341234"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.expiryInput)).perform(clearText(), typeText("1120"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.codeInput)).perform(clearText(), typeText("123"));
        Espresso.closeSoftKeyboard();
        onView(withText("Submit Order")).check(matches(isDisplayed())).perform(click());

        //add a review
        onView(withText("Add Review")).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.yourNameInput)).perform(clearText(), typeText("Clark Kent"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.ratingInput)).perform(clearText(), typeText("3"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.commentsInput)).perform(clearText(), typeText("This show is okay."));
        Espresso.closeSoftKeyboard();

        //submit the review
        onView(withText("Submit")).check(matches(isDisplayed())).perform(click());
        //go back to main menu
        onView(withText("BACK TO MAIN")).check(matches(isDisplayed())).perform(click());

        //check the review
        onView(withText("View Reviews")).perform(click());
        onView(withId(R.id.movieNameSpinner)).perform(click());
        onView(withText("Superman")).check(matches(isDisplayed())).perform(click());
        onView(withText("This show is okay.")).check(matches(isDisplayed()));
        onView(withText("Review From: Clark Kent")).check(matches(isDisplayed()));

    }//end testCreateReviewInBuyTicketSection

    @Test
    public void testCreateReviewInViewMyTicketsSection(){

        //Cinema City Northgate Theatre
        onView(withText("Buy Tickets")).perform(click());

        //select Cinema City Northgate Theatre
        onView(withText("Cinema City Northgate")).check(matches(isDisplayed()));
        onView(withText("Cinema City Northgate")).check(matches(isDisplayed())).perform(click());

        //select The Incredibles movie
        onView(withText("The Incredibles")).check(matches(isDisplayed()));
        onView(withText("The Incredibles")).check(matches(isDisplayed())).perform(click());

        //select a viewing time
        onView(withText("4:00 to 6:00 PM\nJune 11, 2021, Tuesday")).check(matches(isDisplayed()));
        onView(withText("4:00 to 6:00 PM\nJune 11, 2021, Tuesday")).check(matches(isDisplayed())).perform(click());

        //select seats
        onView(withText("#4")).check(matches(isDisplayed()));
        onView(withText("#4")).check(matches(isDisplayed())).perform(click());
        onView(withText("#5")).check(matches(isDisplayed()));
        onView(withText("#5")).check(matches(isDisplayed())).perform(click());
        onView(withText("#12")).check(matches(isDisplayed()));
        onView(withText("#12")).check(matches(isDisplayed())).perform(click());
        onView(withText("#20")).check(matches(isDisplayed()));
        onView(withText("#20")).check(matches(isDisplayed())).perform(click());
        onView(withText("#28")).check(matches(isDisplayed()));
        onView(withText("#28")).check(matches(isDisplayed())).perform(click());
        onView(withText("#29")).check(matches(isDisplayed()));
        onView(withText("#29")).check(matches(isDisplayed())).perform(click());

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
        onView(withText("Tickets: 6")).check(matches(isDisplayed()));
        onView(withText("Tickets: 6")).perform(click());

        //add a review
        onView(withText("Add Review")).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.yourNameInput)).perform(clearText(), typeText("Frozone"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.ratingInput)).perform(clearText(), typeText("5"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.commentsInput)).perform(clearText(), typeText("This movie is fire!"));
        Espresso.closeSoftKeyboard();

        //submit the review
        onView(withText("Submit")).check(matches(isDisplayed())).perform(click());
        //go back to main menu
        onView(withText("BACK TO MAIN")).check(matches(isDisplayed())).perform(click());

        //check the review
        onView(withText("View Reviews")).perform(click());
        onView(withId(R.id.movieNameSpinner)).perform(click());
        onView(withText("The Incredibles")).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.ratingsSpinner)).perform(click());
        onView(withText("5")).check(matches(isDisplayed())).perform(click());
        onView(withText("This movie is fire!")).check(matches(isDisplayed()));
        onView(withText("Review From: Frozone")).check(matches(isDisplayed()));

    }//end testCreateReviewInViewMyTicketsSection

    @Test
    public void testViewReviewForTheLionKing(){
        //This review has not been added so there should be no reviews for the lion king movie.
        onView(withText("View Reviews")).perform(click());
        onView(withId(R.id.movieNameSpinner)).perform(click());
        onView(withText("The Lion King")).check(matches(isDisplayed())).perform(click());
        onView(withText("There are no reviews to view.")).check(matches(isDisplayed()));

    }//end testViewReviewForTheLionKing

}//end CreateReviewTest
