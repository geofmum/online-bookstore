package api.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "publisher")
public class Publisher extends BaseModel {
    String name;

    @ManyToMany
    List<Book> book;

    public List<Book> getBook() {
        return book;
    }

    public void addBooks(Book book) {
        this.book.add(book);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
