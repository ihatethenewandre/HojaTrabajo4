public class FList<T> {
    public IList<T> getList(String listType) {
        if (listType == null || (!listType.equalsIgnoreCase("SINGLYLINKEDLIST") && !listType.equalsIgnoreCase("DOUBLYLINKEDLIST"))) {
            throw new IllegalArgumentException("Invalid list type.");
        }
        if (listType.equalsIgnoreCase("SINGLYLINKEDLIST")) {
            return new List_SinglyLinked<T>();
        } else if (listType.equalsIgnoreCase("DOUBLYLINKEDLIST")) {
            return new List_DoublyLinked<T>();
        }
        return null;
    }
}