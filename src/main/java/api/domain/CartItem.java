package api.domain;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem extends BaseModel {
    int quantity;

    @OneToOne
    Book book;

    @OneToOne
    User user;

    @ManyToOne
    Cart cart;

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
}
