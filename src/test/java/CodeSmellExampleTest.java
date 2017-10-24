import cucumber.api.java.en.Then;
import org.assertj.core.api.Assertions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CodeSmellExampleTest {

    @Then("^Out of Plan badge is (|not )displayed for result \"([^\"]*)\"$")
    public void outOfPlanBadgeDisplayed(String not, String number) {
        //bad
        if (not.contains("not")) {
            //should not be displayed
            assertFalse(false, "Out of Plan badge is present for result " + number);
        } else {
            //should be displayed
            assertTrue(true, "Out of Plan badge is missing for result " + number);
        }

        boolean isSuccess = true;
        //good
        Assertions.assertThat("not".equals(not)).isEqualTo(!isSuccess)
                .overridingErrorMessage("Out of Plan badge is " + not + " present for result");

        //Another good one is to use KeyphraseState enum
//        @Then("^the user verifies that sort options selector is (present|absent)$")
//        public void checkDateSortingOptionPresence(KeyphraseState presence) throws Throwable {
//            assertThat(legalUpdatesResultsPage.isSortDropDownDisplayed())
//                    .overridingErrorMessage("Sort options selector should be: " + presence.getPhrase())
//                    .isEqualTo(presence.isTrue());
//        }
    }
}
