package com.edigest.myFisrtProject.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// lombok use to remove getter and setter manually in the pojo class
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder // another way to initialize the objects
@Entity
@ToString
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
//    @OneToMany(mappedBy = "user")
    @Builder.Default
    @ToString.Exclude
    private List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address) {
        addresses.add(address);
        address.setUser(this);
    }

    public void removeAddress(Address address) {
        addresses.remove(address);
        address.setUser(null);
    }

    @ManyToMany
    @JoinTable(name = "user_tags", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @Builder.Default
    @ToString.Exclude
    private Set<Tag> tags = new HashSet<>();

    @OneToOne(mappedBy = "user", cascade = {CascadeType.REMOVE})
    private Profile profile;

    @ManyToMany
    @JoinTable(
            name = "wishlist",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @ToString.Exclude
    private Set<Product> products = new HashSet<>();

    public void addTag(String tagName) {
        var tag = new Tag(tagName);
        tags.add(tag);
        tag.getUsers().add(this);
    }

    public void removeTag(String tagName) {
        Tag tagToRemove = null;
        for (Tag tag : tags) {
            if (tag.getName().equals(tagName)) {
                tagToRemove = tag;
                break;
            }
        }
        if (tagToRemove != null) {
            tags.remove(tagToRemove);
            tagToRemove.getUsers().remove(this);
        }
    }

    public void updateTag(String tagName) {
        Tag tagToUpdate = null;
        for (Tag tag : tags) {
            if (tag.getName().equals(tagName)) {
                tagToUpdate = tag;
                break;
            }
        }
        if (tagToUpdate != null) {
            tags.remove(tagToUpdate);
            tags.add(tagToUpdate);
            tagToUpdate.getUsers().remove(this);
        }
    }

    public void addProducts(Product product) {
        products.add(product);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
