public enum BookCategory {

    TITLE(new Title()), AUTHOR(new Author()), GENRE(new Genre());

    private final BookInterface strategy;

    BookCategory(BookInterface strategy){
        this.strategy = strategy;
    }

    public BookInterface getStrategy() {
        return strategy;
    }
}


