package by.iba.management.model.entity;

public class ProgrammingLanguage {
    private boolean java;
    private boolean cPlusPlus;
    private boolean cSharp;
    private boolean php;
    private boolean dotNet;

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

    public boolean iscPlusPlus() {
        return cPlusPlus;
    }

    public boolean iscSharp() {
        return cSharp;
    }

    public boolean isPhp() {
        return php;
    }

    public boolean isDotNet() {
        return dotNet;
    }

    @Override
    public String toString() {
        return "ProgrammingLanguage: " + "java " + java + ", cPlusPlus " + cPlusPlus + ", cSharp " + cSharp
                + ", php " + php + ", dotNet " + dotNet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProgrammingLanguage that = (ProgrammingLanguage) o;

        if (java != that.java) return false;
        if (cPlusPlus != that.cPlusPlus) return false;
        if (cSharp != that.cSharp) return false;
        if (php != that.php) return false;
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
