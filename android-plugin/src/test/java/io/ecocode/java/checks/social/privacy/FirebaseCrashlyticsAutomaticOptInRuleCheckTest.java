package io.ecocode.java.checks.social.privacy;

import org.junit.Test;
import org.sonar.java.checks.verifier.CheckVerifier;

public class FirebaseCrashlyticsAutomaticOptInRuleCheckTest {
    @Test
    public void verify() {

        CheckVerifier.newVerifier().onFile("src/test/files/social/privacy/FirebaseCrashlyticsAutomaticOptInRuleCheck.java")
                .withCheck(new FirebaseCrashlyticsAutomaticOptInRule())
                .verifyIssues();

    }

}
