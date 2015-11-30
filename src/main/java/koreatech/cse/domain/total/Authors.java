package koreatech.cse.domain.total;

import java.util.List;

/**
 * Created by kth on 2015. 11. 30..
 */
public class Authors {
    private List<Author> authors;

    public Authors(List<Author> authors) {
        this.authors = authors;
    }

    public Authors() {
        this.authors = null;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authors=" + authors +
                '}';
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
