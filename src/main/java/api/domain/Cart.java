package api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart extends BaseModel {
    @OneToOne
    @JsonIgnoreProperties
    User user;

    @OneToMany(mappedBy = "cart")
    @JsonIgnoreProperties
    List<CartItem> cart_items;

    boolean status;
    double total;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getCart_items() {
        return cart_items;
    }

    public void addCart_items(CartItem cart_item) {
        this.cart_items.add(cart_item);
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
