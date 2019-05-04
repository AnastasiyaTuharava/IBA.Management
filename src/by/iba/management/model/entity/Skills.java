package by.iba.management.model.entity;

public class Skills {
    private boolean sql;
    private boolean javaScript;
    private boolean html;
    private boolean css;
    private boolean jQuery;

    public Skills(boolean sql, boolean javaScript, boolean html, boolean css, boolean jQuery) {
        this.sql = sql;
        this.javaScript = javaScript;
        this.html = html;
        this.css = css;
        this.jQuery = jQuery;
    }

    public boolean isSql() {
        return sql;
    }

    public boolean isJavaScript() {
        return javaScript;
    }

    public boolean isHtml() {
        return html;
    }

    public boolean isCss() {
        return css;
    }

    public boolean isjQuery() {
        return jQuery;
    }

    @Override
    public String toString() {
        return "Skills: " +
                "sql " + sql +
                ", javaScript " + javaScript +
                ", html " + html +
                ", css " + css +
                ", jQuery " + jQuery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skills skills = (Skills) o;

        if (sql != skills.sql) return false;
        if (javaScript != skills.javaScript) return false;
        if (html != skills.html) return false;
        if (css != skills.css) return false;
        return jQuery == skills.jQuery;
    }

    @Override
    public int hashCode() {
        int result = (sql ? 1 : 0);
        result = 31 * result + (javaScript ? 1 : 0);
        result = 31 * result + (html ? 1 : 0);
        result = 31 * result + (css ? 1 : 0);
        result = 31 * result + (jQuery ? 1 : 0);
        return result;
    }
}
