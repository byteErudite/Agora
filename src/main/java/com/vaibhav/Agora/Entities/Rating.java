package com.vaibhav.Agora.Entities;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Component
@Table(name = "rating")
public class Rating extends BaseEntity implements Serializable {


    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private UUID ratingId;

    @Column(name = "rating")
    private Integer rating;

    private UUID userId;
    private UUID bookId;

    public Rating() {
    }

    public UUID getRatingId() {
        return ratingId;
    }

    public void setRatingId(UUID ratingId) {
        this.ratingId = ratingId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }
}
