package by.iba.management.model.entity;

import org.apache.commons.lang3.StringUtils;

public class Testing {
    private boolean manual;
    private boolean automation;
    private boolean testingDeskTopApplications;
    private boolean testingMobileApplications;

    public Testing() {
    }

    public Testing(boolean manual, boolean automation, boolean testingDeskTopApplications, boolean testingMobileApplications) {
        this.manual = manual;
        this.automation = automation;
        this.testingDeskTopApplications = testingDeskTopApplications;
        this.testingMobileApplications = testingMobileApplications;
    }

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }

    public boolean isAutomation() {
        return automation;
    }

    public void setAutomation(boolean automation) {
        this.automation = automation;
    }

    public boolean isTestingDeskTopApplications() {
        return testingDeskTopApplications;
    }

    public void setTestingDeskTopApplications(boolean testingDeskTopApplications) {
        this.testingDeskTopApplications = testingDeskTopApplications;
    }

    public boolean isTestingMobileApplications() {
        return testingMobileApplications;
    }

    public void setTestingMobileApplications(boolean testingMobileApplications) {
        this.testingMobileApplications = testingMobileApplications;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isManual()) {
            sb.append("Manual,");
        }
        if (isAutomation()) {
            sb.append(" Automation,");
        }
        if (isTestingDeskTopApplications()) {
            sb.append(" Testing DeskTop Applications,");
        }
        if (isTestingMobileApplications()) {
            sb.append(" Testing Mobile Applications,");
        }
        return StringUtils.chop(sb.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Testing testing = (Testing) o;

        if (manual != testing.manual) {
            return false;
        }
        if (automation != testing.automation) {
            return false;
        }
        if (testingDeskTopApplications != testing.testingDeskTopApplications) {
            return false;
        }
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
