package by.iba.management.model.entity;

public class Testing {
    private boolean manual;
    private boolean automation;
    private boolean testingDeskTopApplications;
    private boolean testingMobileApplications;

    public Testing(boolean manual, boolean automation, boolean testingDeskTopApplications, boolean testingMobileApplications) {
        this.manual = manual;
        this.automation = automation;
        this.testingDeskTopApplications = testingDeskTopApplications;
        this.testingMobileApplications = testingMobileApplications;
    }

    public boolean isManual() {
        return manual;
    }

    public boolean isAutomation() {
        return automation;
    }

    public boolean isTestingDeskTopApplications() {
        return testingDeskTopApplications;
    }

    public boolean isTestingMobileApplications() {
        return testingMobileApplications;
    }

    @Override
    public String toString() {
        return "manual " + manual + ", automation " + automation + ", testing DeskTop Applications "
                + testingDeskTopApplications + ", testing Mobile Applications " + testingMobileApplications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Testing testing = (Testing) o;

        if (manual != testing.manual) return false;
        if (automation != testing.automation) return false;
        if (testingDeskTopApplications != testing.testingDeskTopApplications) return false;
        return testingMobileApplications == testing.testingMobileApplications;
    }

    @Override
    public int hashCode() {
        int result = (manual ? 1 : 0);
        result = 31 * result + (automation ? 1 : 0);
        result = 31 * result + (testingDeskTopApplications ? 1 : 0);
        result = 31 * result + (testingMobileApplications ? 1 : 0);
        return result;
    }
}
