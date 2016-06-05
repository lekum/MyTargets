package de.dreier.mytargets.managers;

import android.content.SharedPreferences;

import de.dreier.mytargets.ApplicationInstance;
import de.dreier.mytargets.shared.models.Diameter;
import de.dreier.mytargets.shared.models.Distance;
import de.dreier.mytargets.shared.models.Target;

public class SettingsManager {
    private static final String KEY_STANDARD_ROUND = "standard_round";
    private static final String KEY_ARROW = "arrow";
    private static final String KEY_BOW = "bow";
    private static final String KEY_DISTANCE_VALUE = "distance";
    private static final String KEY_DISTANCE_UNIT = "unit";
    private static final String KEY_ARROWS_PER_PASSE = "ppp";
    private static final String KEY_TARGET = "target";
    private static final String KEY_SCORING_STYLE = "scoring_style";
    private static final String KEY_TARGET_DIAMETER_VALUE = "size_target";
    private static final String KEY_TARGET_DIAMETER_UNIT = "unit_target";
    private static final String KEY_TIMER = "timer";
    private static final String KEY_NUMBERING_ENABLED = "numbering";
    private static final String KEY_TIMER_SHOOT_TIME = "timer_shoot_time";
    private static final String KEY_SCORES_ONLY = "scores_only";
    private static final String KEY_INDOOR = "indoor";
    private static final String KEY_PASSES = "rounds";
    private static final String KEY_TRANSLATION_DIALOG_SHOWN = "translation_dialog_shown";
    private static final String KEY_FILTER_CLUB = "filter_club";
    private static final String KEY_INPUT_MODE = "target_mode";

    private static SharedPreferences preferences = ApplicationInstance.getLastSharedPreferences();

    public static int getStandardRound() {
        return preferences.getInt(KEY_STANDARD_ROUND, 32);
    }

    public static void setStandardRound(long id) {
        preferences.edit()
                .putInt(KEY_STANDARD_ROUND, (int) id)
                .apply();
    }

    public static int getArrow() {
        return preferences.getInt(KEY_ARROW, -1);
    }

    public static void setArrow(long id) {
        preferences.edit()
                .putInt(KEY_ARROW, (int) id)
                .apply();
    }

    public static int getBow() {
        return preferences.getInt(KEY_BOW, -1);
    }

    public static void setBow(long id) {
        preferences.edit()
                .putInt(KEY_BOW, (int) id)
                .apply();
    }

    public static Distance getDistance() {
        int distance = preferences.getInt(KEY_DISTANCE_VALUE, 10);
        String unit = preferences.getString(KEY_DISTANCE_UNIT, "m");
        return new Distance(distance, unit);
    }

    public static void setDistance(Distance distance) {
        preferences.edit()
                .putInt(KEY_DISTANCE_VALUE, distance.value)
                .putString(KEY_DISTANCE_UNIT, distance.unit)
                .apply();
    }

    public static int getArrowsPerPasse() {
        return preferences.getInt(KEY_ARROWS_PER_PASSE, 3);
    }

    public static void setArrowsPerPasse(int arrowsPerPasse) {
        preferences.edit()
                .putInt(KEY_ARROWS_PER_PASSE, arrowsPerPasse)
                .apply();
    }

    public static Target getTarget() {
        final int targetId = preferences.getInt(KEY_TARGET, 0);
        final int scoringStyle = preferences.getInt(KEY_SCORING_STYLE, 0);
        final int diameterValue = preferences.getInt(KEY_TARGET_DIAMETER_VALUE, 60);
        final String diameterUnit = preferences.getString(KEY_TARGET_DIAMETER_UNIT, Diameter.CENTIMETER);
        final Diameter diameter = new Diameter(diameterValue, diameterUnit);
        return new Target(targetId, scoringStyle, diameter);
    }

    public static void setTarget(Target target) {
        preferences.edit()
                .putInt(KEY_TARGET, (int) target.getId())
                .putInt(KEY_SCORING_STYLE, target.scoringStyle)
                .putInt(KEY_TARGET_DIAMETER_VALUE, target.size.value)
                .putString(KEY_TARGET_DIAMETER_UNIT, target.size.unit)
                .apply();
    }

    public static boolean getTimerEnabled() {
        return preferences.getBoolean(KEY_TIMER, false);
    }

    public static void setTimerEnabled(boolean enabled) {
        preferences.edit()
                .putBoolean(KEY_TIMER, enabled)
                .apply();
    }

    public static boolean getArrowNumbersEnabled() {
        return preferences.getBoolean(KEY_NUMBERING_ENABLED, false);
    }

    public static void setArrowNumbersEnabled(boolean enabled) {
        preferences.edit()
                .putBoolean(KEY_NUMBERING_ENABLED, enabled)
                .apply();
    }

    public static boolean getIndoor() {
        return preferences.getBoolean(KEY_INDOOR, false);
    }

    public static void setIndoor(boolean indoor) {
        preferences.edit()
                .putBoolean(KEY_INDOOR, indoor)
                .apply();
    }

    public static boolean getScoresOnly() {
        return preferences.getBoolean(KEY_SCORES_ONLY, false);
    }

    public static void setScoresOnly(boolean scoresOnly) {
        preferences.edit()
                .putBoolean(KEY_SCORES_ONLY, scoresOnly)
                .apply();
    }

    public static int getShootTime() {
        try {
            SharedPreferences prefs = ApplicationInstance.getSharedPreferences();
            return Integer.parseInt(prefs.getString(KEY_TIMER_SHOOT_TIME, "120"));
        } catch (NumberFormatException ignored) {
        }
        return 120;
    }

    public static int getPasses() {
        return preferences.getInt(KEY_PASSES, 10);
    }

    public static void setPasses(int passes) {
        preferences.edit()
                .putInt(KEY_PASSES, passes)
                .apply();
    }

    public static boolean getTranslationDialogWasShown() {
        SharedPreferences prefs = ApplicationInstance.getSharedPreferences();
        return prefs.getBoolean(KEY_TRANSLATION_DIALOG_SHOWN, false);
    }

    public static void setTranslationDialogWasShown(boolean shown) {
        ApplicationInstance.getSharedPreferences()
                .edit()
                .putBoolean(KEY_TRANSLATION_DIALOG_SHOWN, shown)
                .apply();
    }

    public static int getClubFilter() {
        return ApplicationInstance.getSharedPreferences().getInt(KEY_FILTER_CLUB, 0x1FF);
    }

    public static void setClubFilter(int filter) {
        ApplicationInstance.getSharedPreferences()
                .edit()
                .putInt(KEY_FILTER_CLUB, filter)
                .apply();
    }

    public static boolean getInputMode() {
        return ApplicationInstance.getSharedPreferences()
                .getBoolean(KEY_INPUT_MODE, false);
    }

    public static void setInputMode(boolean inputMode) {
        ApplicationInstance.getSharedPreferences()
                .edit()
                .putBoolean(KEY_INPUT_MODE, inputMode)
                .apply();
    }
}
