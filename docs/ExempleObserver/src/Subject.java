public interface Subject {
    public void attach(BlogObserver o);
    public void detach(BlogObserver o);
    public void notifyUsers();
}
