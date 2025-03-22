import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import Concrate.*;

public class Main {
    public static void main(String[] args){
        List<Movie> filmCollection = new ArrayList<>();

        Movie film1 = new Movie("The Dark Knight", 2008, "Action", 9.0);
        Movie film2 = new Movie("Forest Gump", 1994, "Epic", 8.8);
        Movie film3 = new Movie("The Shawshank Redemption", 1994, "Epic", 9.3);
        Movie film4 = new Movie("The Lord of The Rings", 2003, "Action Epic", 9.0);
        Movie film5 = new Movie("Fight Club", 1999, "Drama", 8.8);

        filmCollection.add(film1);
        filmCollection.add(film2);
        filmCollection.add(film3);
        filmCollection.add(film4);
        filmCollection.add(film5);

        //Sorting films by IMDB score descending
        sortByIMDBPointDescending(filmCollection);
        System.out.println("Films sorted by IMDB point (Descending): ");
        filmCollection.forEach(movie -> System.out.println(movie.getMovieName()));

        System.out.println("------------------");

        //Sorting films by Publication Year
        sortByPublicationYear(filmCollection);
        System.out.println("Films sorted by Publication Year: ");
        filmCollection.forEach(movie -> System.out.println(movie.getMovieName()));

        System.out.println("------------------");

        //Filtering films according to type
        List<Movie> filtredMovies = moviesFilteredByGenre(filmCollection, "Epic");
        System.out.println("Films filtered by Genre-> Epic : ");
        filtredMovies.forEach(movie -> System.out.println(movie.getMovieName()));

    }

    //Method for sorting films by IMDB score descending
    public static void sortByIMDBPointDescending(List<Movie> films) {
        Collections.sort(films, new Comparator<Movie>() {
            @Override
            public int compare(Movie film1, Movie film2) {
                return Double.compare(film2.getIMDBScore(), film1.getIMDBScore());
            }
        });
        //Collections.sort(films, (film1, film2) -> Double.compare(film2.getIMDBPoint(), film1.getIMDBPoint()));
    }

    //Method for sorting films by public year
    public static void sortByPublicationYear(List<Movie> films) {
        Collections.sort(films, new Comparator<Movie>() {
            @Override
            public int compare(Movie film1, Movie film2) {
                return Integer.compare(film1.getReleaseYear(), film2.getReleaseYear());
            }
        });
        //Collections.sort(films, (film1, film2) -> Integer.compare(film1.getPublicationYear(), film2.getPublicationYear()));
    }

    //Method for filtering films by type
    public static List<Movie> moviesFilteredByGenre(List<Movie> films, String genre) {
        return films.stream()
                .filter(film -> film.getMovieGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }
}
