class Box<T> {
    T t;
    public void put(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}