package koreatech.cse.domain.total;

import java.util.List;
import koreatech.cse.domain.total.Author;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Authors {
    private List<Author> authors;

    public Authors(List<Author> authors) {
        this.authors = authors;
    }

    public Authors() {
        this.authors = null;
    }

    public String toString() {
        return "Author{authors=" + this.authors + '}';
    }

    public List<Author> getAuthors() {
        return this.authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}