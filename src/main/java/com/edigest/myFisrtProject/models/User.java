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

    @OneToMany(mappedBy = "user")
    @Builder.Default
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
    private Set<Tag> tags = new HashSet<>();

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
}
