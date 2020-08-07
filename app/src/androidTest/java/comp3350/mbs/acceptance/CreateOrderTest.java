package comp3350.mbs.acceptance;


import org.junit.*;
import org.junit.runner.RunWith;

import androidx.test.espresso.Espresso;
import androidx.test.runner.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;

import static org.hamcrest.Matchers.not;

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

        //select a seat(s)
        onView(withText("#0")).check(matches(isDisplayed()));
        onView(withText("#0")).check(matches(isDisplayed())).perform(click());
        onView(withText("#0")).check(matches(isDisplayed())).check(matches((isEnabled())));

    }//end testOrderForTheatre1
}