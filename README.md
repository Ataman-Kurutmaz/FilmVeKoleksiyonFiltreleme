Bu Java kodu, bir **film koleksiyonu** üzerinde çeşitli işlemler gerçekleştiren bir programın temel yapısını sunmaktadır. Film koleksiyonu `Movie` sınıfındaki nesnelerden oluşuyor. Bu nesneler, film adı, çıkış yılı, türü ve IMDB puanı gibi özelliklere sahip. Kodun amacı, bu film koleksiyonu üzerinde sıralama ve filtreleme işlemleri yapmaktır.

### Kodun Genel Yapısı ve Amaçları

1. **Film Koleksiyonu Oluşturma**: İlk olarak, 5 adet film nesnesi (`Movie`) oluşturuluyor ve bunlar bir `ArrayList` (film koleksiyonu) içine ekleniyor.

2. **Film Koleksiyonu Üzerinde Sıralama İşlemleri**:
    - **IMDB Puanına Göre Azalan Sıralama**: Filmler, IMDB puanlarına göre büyükten küçüğe doğru sıralanır.
    - **Yıla Göre Artan Sıralama**: Filmler, çıkış yılına göre artan sırayla sıralanır.

3. **Film Koleksiyonundan Filtreleme İşlemi**:
    - Belirli bir **film türüne göre filtreleme** yapılır. Örneğin, türü "Epic" olan filmler seçilir.

### Detaylı Açıklamalar:

#### 1. **Film Nesneleri ve Film Koleksiyonu**
- Kodda ilk olarak 5 adet `Movie` nesnesi oluşturulmuş ve `filmCollection` adlı listeye eklenmiştir. Her bir `Movie` nesnesi, film adı, çıkış yılı, türü ve IMDB puanı gibi özellikler taşır.

   ```java
   Movie film1 = new Movie("The Dark Knight", 2008, "Action", 9.0);
   Movie film2 = new Movie("Forest Gump", 1994, "Epic", 8.8);
   Movie film3 = new Movie("The Shawshank Redemption", 1994, "Epic", 9.3);
   Movie film4 = new Movie("The Lord of The Rings", 2003, "Action Epic", 9.0);
   Movie film5 = new Movie("Fight Club", 1999, "Drama", 8.8);
   ```

#### 2. **IMDB Puanına Göre Sıralama**
- `sortByIMDBPointDescending()` metodunda, filmler IMDB puanlarına göre azalan sırayla sıralanır. Bunun için `Collections.sort()` metodu kullanılmıştır ve burada `Comparator` arayüzü ile film nesneleri karşılaştırılır.
- `Double.compare()` fonksiyonu ile iki film arasındaki IMDB puanları karşılaştırılır.

   ```java
   public static void sortByIMDBPointDescending(List<Movie> films) {
       Collections.sort(films, new Comparator<Movie>() {
           @Override
           public int compare(Movie film1, Movie film2) {
               return Double.compare(film2.getIMDBScore(), film1.getIMDBScore());
           }
       });
   }
   ```

#### 3. **Çıkış Yılına Göre Sıralama**
- `sortByPublicationYear()` metodunda, filmler çıkış yıllarına göre artan sırayla sıralanır. Burada da `Comparator` kullanılarak `Integer.compare()` fonksiyonu ile iki film arasındaki çıkış yılı karşılaştırılır.

   ```java
   public static void sortByPublicationYear(List<Movie> films) {
       Collections.sort(films, new Comparator<Movie>() {
           @Override
           public int compare(Movie film1, Movie film2) {
               return Integer.compare(film1.getReleaseYear(), film2.getReleaseYear());
           }
       });
   }
   ```

#### 4. **Filmlerin Türlerine Göre Filtrelenmesi**
- `moviesFilteredByGenre()` metodu, bir film türü (genre) parametresi alır ve verilen türle eşleşen tüm filmleri bir liste olarak döner. Bu işlem, Java 8 ile gelen `Streams API` kullanılarak gerçekleştirilir.
- `equalsIgnoreCase()` metodu, film türlerini karşılaştırırken büyük/küçük harf duyarsız bir eşleşme yapar.

   ```java
   public static List<Movie> moviesFilteredByGenre(List<Movie> films, String genre) {
       return films.stream()
               .filter(film -> film.getMovieGenre().equalsIgnoreCase(genre))
               .collect(Collectors.toList());
   }
   ```

#### 5. **Çıktılar**
Kodun sonunda, önce filmler IMDB puanlarına göre sıralanır, sonra çıkış yılına göre sıralanır ve son olarak türüne göre "Epic" olan filmler filtrelenir.

**Örnek Çıktılar**:
- IMDB puanına göre sıralanmış filmler:
  ```
  Films sorted by IMDB point (Descending): 
  The Shawshank Redemption
  The Dark Knight
  The Lord of The Rings
  Forest Gump
  Fight Club
  ```

- Çıkış yılına göre sıralanmış filmler:
  ```
  Films sorted by Publication Year: 
  Forest Gump
  Fight Club
  The Lord of The Rings
  The Dark Knight
  The Shawshank Redemption
  ```

- "Epic" türüne göre filtrelenmiş filmler:
  ```
  Films filtered by Genre-> Epic : 
  Forest Gump
  The Shawshank Redemption
  The Lord of The Rings
  ```

### Özet
Bu program, film koleksiyonu üzerinde sıralama ve filtreleme işlemleri yapar. Filmleri:
- IMDB puanına göre azalan sırayla sıralar.
- Çıkış yılına göre artan sırayla sıralar.
- Belirli bir türe (örneğin "Epic") göre filtreler.

Kodda kullanılan **Streams API** ve **Comparator** yapıları, Java'nın fonksiyonel programlama ve nesne yönelimli programlama özelliklerini kullanarak daha okunabilir ve verimli bir şekilde işlemleri gerçekleştirmektedir.