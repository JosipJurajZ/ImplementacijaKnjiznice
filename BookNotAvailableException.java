class BookNotAvailableException extends Exception {

    public BookNotAvailableException(String info){
        super(info);
    }

    public BookNotAvailableException(){}

}

class ExceededBorrowedBookLimitException extends Exception {

    public ExceededBorrowedBookLimitException(String info){
        super(info);
    }

    public  ExceededBorrowedBookLimitException(){}
}