package api.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book extends BaseModel {
    String category;
    String ISBN;
    String title;
    String year;
    double price;

    @ManyToMany(mappedBy = "book")
    List<Author> authors;

    @ManyToMany(mappedBy = "book")
    List<Publisher> publishers;

    @OneToOne(mappedBy = "book")
    CartItem cart_item;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void addAuthors(Author author) {
        this.authors.add(author);
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void addPublishers(Publisher publisher) {
        this.publishers.add(publisher);
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
