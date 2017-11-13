package il.co.sears.autoplayground;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityTests {
    @Rule
    public IntentsTestRule<MainActivity> mActivityRule = new IntentsTestRule<>(
            MainActivity.class);

    @Test
    public void mainActivity_WhenClickMeButtonIsClicked_ChangeTextAccordingToClickCount() {
        clickOnClickMeButton();
        clickOnClickMeButton();

        onView(withId(R.id.hello_text))
                .check(matches(withText("Hello. I've been clicked 2 times")));
    }

    @Test
    public void mainActivity_WhenClickingNext_MoveToNextPageWithClickCount() {
        clickOnClickMeButton();
        
        clickOnNextButton();

        intended(allOf(
                hasExtra("counter", 1),
                hasComponent("il.co.sears.autoplayground.SecondPageActivity")));
    }

    private void clickOnNextButton() {
        onView(withId(R.id.next_button)).perform(click());
    }

    private void clickOnClickMeButton() {
        ViewInteraction clickMeButton =  onView(withId(R.id.click_me_button));

        clickMeButton.perform(click());
    }
}