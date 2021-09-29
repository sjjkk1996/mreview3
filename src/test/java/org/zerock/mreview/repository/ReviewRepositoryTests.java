package org.zerock.mreview.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.mreview.entity.Member;
import org.zerock.mreview.entity.Movie;
import org.zerock.mreview.entity.Review;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

@SpringBootTest
public class ReviewRepositoryTests {
    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void insertMovieReviews(){
        IntStream.rangeClosed(1,200).forEach(new IntConsumer() {
            @Override
            public void accept(int i) {
                Long mno = (long) (Math.random() * 100) + 1; //무비 번호
                Long mid = (long) (Math.random() * 100) + 1; //리뷰어 번호
                Member member = Member.builder().mid(mid).build();
                Review movieReview = Review.builder()
                        .member(member)
                        .movie(Movie.builder().mno(mno).build())
                        .grade((int)(Math.random()*5)+1)
                        .text("이 영화는 과연..." + i)
                        .build();
                reviewRepository.save(movieReview);
            }
        });
    }

//    @Test
//    public void testGetMovieReviews(){
//        Movie movie = Movie.builder().mno(92L).build();
//        List<Review> result = reviewRespository.findByMovie(movie);
//        result.forEach(new Consumer<Review>() {
//            @Override
//            public void accept(Review review) {
//                System.out.println(review.getReviewnum());
//                System.out.println("\t"+review.getGrade());
//                System.out.println("\t"+review.getText());
//                System.out.println("\t"+review.getMember().getEmail());
//            }
//        });
//    }
}