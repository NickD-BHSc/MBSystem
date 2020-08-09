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
public class ViewTicketTest {
    

}//end ViewTicketTest
