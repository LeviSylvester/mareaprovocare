package doors;

class Door {

    private boolean closed;

    Door(boolean closed) {
        this.closed = closed;
    }

    boolean isClosed() {
        return closed;
    }

    void open() {
        this.closed = false;
    }

    void close() {
        this.closed = true;
    }
}