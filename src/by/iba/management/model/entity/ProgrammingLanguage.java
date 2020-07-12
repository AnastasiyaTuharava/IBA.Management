package by.iba.management.model.entity;

public class ProgrammingLanguage {
    private boolean java;
    private boolean cPlusPlus;
    private boolean cSharp;
    private boolean php;
    private boolean dotNet;

    public ProgrammingLanguage() {
    }

    public ProgrammingLanguage(boolean java, boolean cPlusPlus, boolean cSharp, boolean php, boolean dotNet) {
        this.java = java;
        this.cPlusPlus = cPlusPlus;
        this.cSharp = cSharp;
        this.php = php;
        this.dotNet = dotNet;
    }

    public boolean isJava() {
        return java;
    }

    public void setJava(boolean java) {
        this.java = java;
    }

    public boolean iscPlusPlus() {
        return cPlusPlus;
    }

    public void setcPlusPlus(boolean cPlusPlus) {
        this.cPlusPlus = cPlusPlus;
    }

    public boolean iscSharp() {
        return cSharp;
    }

    public void setcSharp(boolean cSharp) {
        this.cSharp = cSharp;
    }

    public boolean isPhp() {
        return php;
    }

    public void setPhp(boolean php) {
        this.php = php;
    }

    public boolean isDotNet() {
        return dotNet;
    }

    public void setDotNet(boolean dotNet) {
        this.dotNet = dotNet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isJava()) {
            sb.append("Java, ");
        }
        if (iscPlusPlus()) {
            sb.append("C++, ");
        }
        if (iscSharp()) {
            sb.append("C#, ");
        }
        if (isPhp()) {
            sb.append("PHP, ");
        }
        if (isDotNet()) {
            sb.append(".NET ");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProgrammingLanguage that = (ProgrammingLanguage) o;

        if (java != that.java) {
            return false;
        }
        if (cPlusPlus != that.cPlusPlus) {
            return false;
        }
        if (cSharp != that.cSharp) {
            return false;
        }
        if (php != that.php) {
            return false;
        }
        return dotNet == that.dotNet;
    }

    @Override
    public int hashCode() {
        int result = (java ? 1 : 0);
        result = 31 * result + (cPlusPlus ? 1 : 0);
        result = 31 * result + (cSharp ? 1 : 0);
        result = 31 * result + (php ? 1 : 0);
        result = 31 * result + (dotNet ? 1 : 0);
        return result;
    }
}
