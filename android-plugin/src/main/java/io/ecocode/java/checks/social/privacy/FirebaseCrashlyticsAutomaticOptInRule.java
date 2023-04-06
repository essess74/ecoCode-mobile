package io.ecocode.java.checks.social.privacy;

import com.google.common.collect.ImmutableList;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.semantic.MethodMatchers;
import org.sonar.plugins.java.api.tree.MethodInvocationTree;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.List;


@Rule(key = "XXXXX", name = "ecoCodeCrashlyticsAutomaticOptIn")
public class FirebaseCrashlyticsAutomaticOptInRule extends IssuableSubscriptionVisitor {
    private final MethodMatchers firebaseCrashlyticsAutomaticOptIn = MethodMatchers.create()
            .ofTypes("com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()")
            .names("setCrashlyticsCollectionEnabled")
            .addParametersMatcher("false")
            .build();

    @Override
    public List<Tree.Kind> nodesToVisit() {
        return ImmutableList.of(Tree.Kind.METHOD_INVOCATION);
    }

    @Override
    public void visitNode(Tree tree) {
        if (tree.is(Tree.Kind.METHOD_INVOCATION)) {
            MethodInvocationTree mit = (MethodInvocationTree) tree;
            if (firebaseCrashlyticsAutomaticOptIn.matches(mit)) {
                reportIssue(mit, "Prefer using a reported latency on your SensorManager to reduce the power consumption of the app");
            }
        }
    }
}
