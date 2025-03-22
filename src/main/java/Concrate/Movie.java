package Concrate;

public class Movie {
    protected String movieName;

    protected int releaseYear;

    protected String movieGenre;

    protected double IMDBScore;

    public Movie(String movieName, int releaseYear, String movieGenre, double IMDBScore){
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.movieGenre = movieGenre;
        this.IMDBScore = IMDBScore;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public double getIMDBScore() {
        return IMDBScore;
    }

    public void setIMDBScore(double IMDBScore) {
        this.IMDBScore = IMDBScore;
    }
}
