import com.google.firebase.crashlytics.FirebaseCrashlytics;

public class FirebaseCrashlyticsAutomaticOptInRuleCheck {

    public FirebaseCrashlyticsAutomaticOptInRuleCheck() {
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(false);
    }
}