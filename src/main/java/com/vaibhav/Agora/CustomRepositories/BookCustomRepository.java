package com.vaibhav.Agora.CustomRepositories;

import com.vaibhav.Agora.Common.Utils.Utilities;
import com.vaibhav.Agora.DTOEntities.BookDTO;
import com.vaibhav.Agora.Entities.Book;
import com.vaibhav.Agora.Entities.BookUnit;
import com.vaibhav.Agora.RequestEntities.BookSearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Component
public class BookCustomRepository {

    @Autowired
    BasicCustomRepository basicCustomRepository;

    private String BOOK_RETRIVEL_QUERY = "Select distinct new com.vaibhav.Agora.DTOEntities.BookDTO " +
            "( b.bookId as bookId, " +
            "b.title as title, " +
            "b.authorId as authorId, " +
            "b.category as category, " +
            "b.genre as genre, " +
            "b.publicationId as publicationId, " +
            "b.edition as edition, " +
            "b.language as language, " +
            "(Select count(*) from BookUnit bu where bu.isAvailable = true and bu.bookId = b.bookId ) as availableCount , " +
            "(Select avg(r.rating) from Rating r where r.bookId = b.bookId )   as averageRating ) ";

    private String BOOK_FROM_CLAUSE = "from Book b  ";



    public List<BookDTO> getBooks(BookSearchRequest bookSearchRequest) {
        Map<String, Object> parameters = new HashMap<>();
        final String whereQuery = generateWhereQueryForBookSearch(bookSearchRequest, parameters);
        List<BookDTO> books = basicCustomRepository.getQueryResult(BOOK_RETRIVEL_QUERY + BOOK_FROM_CLAUSE + whereQuery, parameters, 1, 100, BookDTO.class);
        return books;
    }

//    public List<BookUnit> getBookUnits(BookSearchRequest bookSearchRequest) {
//
//    }

    private String generateWhereQueryForBookSearch(BookSearchRequest bookSearchRequest, Map<String, Object> parameters) {
        StringBuilder whereQuery = new StringBuilder(" where ");
        if (Utilities.isNotEmpty(bookSearchRequest.getBookIds())) {
            parameters.put("bookIds", bookSearchRequest.getBookIds());
            whereQuery.append(" bookId in (:bookIds) and ");
        }

        if (Utilities.isNotEmpty(bookSearchRequest.getAuthorIds())) {
            parameters.put("authorIds", bookSearchRequest.getAuthorIds());
            whereQuery.append(" authorId in (:authorIds) and ");
        }

        if (Utilities.isNotEmpty(bookSearchRequest.getBookUnitIds())) {
            parameters.put("bookUnitIds", bookSearchRequest.getBookUnitIds());
            whereQuery.append(" bookUnitId in (:bookUnitIds) and ");
        }

        if (Utilities.isNotEmpty(bookSearchRequest.getCategories())) {
            parameters.put("categories", bookSearchRequest.getCategories());
            whereQuery.append(" category in (:categories) and ");
        }

        if (Utilities.isNotEmpty(bookSearchRequest.getGenres())) {
            parameters.put("genres", bookSearchRequest.getGenres());
            whereQuery.append(" genre in (:genres) and ");
        }

        if (Utilities.isNotEmpty(bookSearchRequest.getEditions())) {
            parameters.put("editions", bookSearchRequest.getEditions());
            whereQuery.append(" edition in (:editions) and ");
        }

        if (Utilities.isNotEmpty(bookSearchRequest.getPublications())) {
            parameters.put("publications", bookSearchRequest.getBookUnitIds());
            whereQuery.append(" publication in (:publications) and  ");
        }

        if (Utilities.isNotEmpty(bookSearchRequest.getTitles())) {
            parameters.put("titles", bookSearchRequest.getTitles());
            whereQuery.append(" titles in (:titles) and ");
        }

        if (Objects.nonNull(bookSearchRequest.getRating())) {
            parameters.put("rating", bookSearchRequest.getRating());
            whereQuery.append(" averageRating > :rating and ");
        }

        if (Objects.nonNull(bookSearchRequest.getRating())) {
            parameters.put("addedDate", bookSearchRequest.getAddedDate());
            whereQuery.append(" added_date > :addedDate and ");
        }
        if(whereQuery.length() < 8) {
            return " ";
        }
        return whereQuery.substring(0, whereQuery.length()-4);
    }
}
