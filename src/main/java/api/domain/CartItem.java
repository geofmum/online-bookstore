package api.domain;

import api.domain.query.QBook;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem extends BaseModel {
    int quantity;
    String delivery;
    String packageType;

    @OneToOne
    @JsonIgnoreProperties
    Book book;

    @OneToOne
    @JsonIgnoreProperties
    User user;

    @ManyToOne
    @JsonIgnoreProperties
    Cart cart;

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBook_id(long book_id) {
        Book book = new QBook().id.eq(book_id).findOne();

        if (book != null)
            setBook(book);
    }

    public long getBook_id() {
        if (book == null)
            return 0;

        return book.getId();
    }
}
