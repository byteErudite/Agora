package com.vaibhav.Agora.Entities;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "Author")
public class Author extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private UUID authorId;
    private String name;
    private String penName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "authorId", nullable = true)
    private List<Book> books;

    public Author() {
        super();
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getListOfBooks() {
        return books;
    }

    public void setListOfBooks(List<Book> listOfBooks) {
        this.books = listOfBooks;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getPenName() {
        return penName;
    }

    public void setPenName(String penName) {
        this.penName = penName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Author{");
        sb.append("authorId=").append(authorId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", penName='").append(penName).append('\'');
        sb.append(", books=").append(books);
        sb.append(", penName=").append(penName);
        sb.append('}');
        return sb.toString();
    }
}
