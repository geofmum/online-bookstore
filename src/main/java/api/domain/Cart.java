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
    User user;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
    List<CartItem> cart_items;

    boolean status;
    double total;

    public void setCart_items(List<CartItem> cart_items) {
        this.cart_items = cart_items;
    }

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
        CartItem _cartItem = getCartItemById(cart_item.getId());

        if (_cartItem != null) {
            _cartItem.inrementQuantity(cart_item.getQuantity());
            _cartItem.save();
        } else {
            cart_items.add(cart_item);
        }

        computeCartTotal();
    }

    protected void computeCartTotal(){
         total = cart_items.stream().mapToDouble(item -> item.getQuantity() * item.book.getPrice()).sum();
//         try {
//             save();
//         } catch (Exception e){}
    }

    protected CartItem getCartItemById(long cartItemId) {
        return cart_items
                .stream()
                .filter(item -> item.getId() == cartItemId)
                .findFirst().orElse(null);
    }

    protected boolean hasCartItem(long id) {
        for (CartItem item : cart_items) {
            if (item.getId() == id) return true;
        }

        return false;
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
