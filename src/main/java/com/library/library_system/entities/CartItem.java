package com.library.library_system.entities;



import jakarta.persistence.*;

@Entity

@Table(name = "cart_item")

public class CartItem {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "book")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "cart")
    private Cart cart;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CheckedOutStatus status;

    public CartItem(){

    }


    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
}



