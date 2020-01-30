Program zaliczeniowy (I rok, 1 semester) o studentach.
Virtual Dean's office

Program jest wykonany za pomocą JavaFX. 

### Użytkowanie Programu:
Okno programu składa się z pięciu rubryk z których każda odpowiada osobnemu obiektowi: Student(Student.java), Nauczyciel(Teacher.java), Wydział(Faculty), Kierunek(CourseOfStudy.java), Przedmiot (Subject.java). 

Każda klasa posiada metody odpowiadające za wyszukiwanie obiektów pokrewnych i ich dodawanie. Aby dodać obiekt do bazy danych (pliku tekstowego) należy wybrać odpowiednią rubrykę i wypełnić następujące pola. (Pola z * są nieobowiązkowe). Z tym, że id musi być liczbą całkowitą, a daty wypełniamy w formacie(dd.MM.yyyy)

* *Wydział* (id;nazwa)
* *Kierunek* (id;nazwa;wydzial)
* *Przedmiot* (id;nazwa;wydzial;kierunek)
* *Student* (indeks; nazwisko; imie; drugieImie*; dataUrodzenia; wydzial; kierunek; semestr)
* *Nauczyciel* (id;tytul;nazwisko;imie;dataUrodzenia)

Po wypełnieniu nacisnąć przycisk „*+*”. Jeśli dane zostały wypełnione niepoprawnie wyświetli się okno ostrzegające o błędzie.<br>
Aby wyszukać obiekt z bazy danych należy wypełnić odpowiadające mu pole kryterium żądaną frazą a następnie kliknąć przycisk "*szukaj*".
Fraza jest wyszukiwana na wszystkich własnościach obiektu. Odpowiadające im dane będą wyświetlane w rubryce poniżej.
Aby dodać oceny danemu studentowi w polu wyboru wybieramy indeks interesującego nas studenta a następnie przedmiot i ocenę.

### Klasy:
1. Alertbox - klasa okna ostrzeżeń i błędów
    * display(tytuł,widomosc) – wyświetla okno z podanymi parametrami. Okno jest nadżędne.
2. Controller - klasa zajmująca się inputami i polami związanymi z oknem.
    * …AddButtonAction() – Odczytuje dane z okna, sprawdza je, czyści okno i wywołuje metodę dodawanie odpowiedniego obiektu
    * …SearchButtonAction() – Odczytuje dane z okna i wywołuje metodę filtrującą i wyświetla jej wyniki.
3. CourseOfStudy, Faculty, Subject, Person, Teacher, Student - klasy obiektów
    - Person: 
      * zawiera prywatne pola: id (int), imię (string), nazwisko (string), drugie imię (string), data urodzenia (Data) oraz odpowiedne gettery i settery;
      * przeciąża toString()
    - Student:
      * dziedziczy po klasie Person
      * zawiera własne prywatne pola: faculty, course, semester oraz odpowiedne gettery i settery
      * przeciąża toString()
    - Teacher:
	    * dziedziczy po klasie Person
	    * zawiera własne prywatne pole: title oraz odpowiedne gettery i settery
	    * przeciąża toString()
    - CourseOfStudy, Faculty, Subject:
	    * zawiera prywatne pole: id, nazwa oraz odpowiedne gettery i settery
      * przeciąża toString()
4. dataAnalyzer - klasa zajmująca się plikami:
	  * loadObject – dodaje studentów i nauczycieli w porządku leksograficznym.
	  * loadUnit – dodaje wydział, kierunek i przedmiot.
	  * filterString – filtruje plik zgodnie z kryteriami.
5. Main - klasa uruchomieniowa, pośrednik między controllerem a obiektami i ich plikami
	  * organizuje dane wprowadzanie w oknie, i wywołuje odpowiednie metowy z klasy DataAnalyzer, tworzy odpowiednie pliki i foldery.
Plik sample.fxml - plik zawierający wygląd okna

### Chierarchia bazy danych:
1. student.txt – zawiera dane wszystkich studentów.
1. teacher.txt – zawiera dane wszystkich nauczycieli.
1. faculty.txt – zawiera dane wszystkich wydziałów.
1. Faculties.dir – zawiera foldery odpowiadające wszystkim wydziałom.
    1. A.dir – folder wydziału A.
		  1. course.txt - zawiera dane wszystkich kursów wydziału A.
      2. student.txt – zawiera dane wszystkich studentów wydziału A.
	    3. Courses.dir -  zawiera foldery odpowiadające wszystkim kursom wydziału A.
	      1. B.dir
		       1. student.txt - zawiera dane wszystkich studentów wydziału A kursu B.
		       2. subject.txt - zawiera dane wszystkich przedmiotów wydziału A kursu B.
           3. Subjects.dir - zawiera foldery odpowiadające wszystkim kursom wydziału A kursu B.
             1.dir – zawiera pliki z ocenami każdego studenta uczęszczającego na wydział A, kurs B. Nazwa tego pliku to jego indeks.
