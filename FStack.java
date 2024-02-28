public class FStack<T> {
    public IStack<T> getStack(String stackType) {
        if (stackType == null || (!stackType.equalsIgnoreCase("ARRAYLIST") && !stackType.equalsIgnoreCase("VECTOR"))) {
            throw new IllegalArgumentException("Invalid stack type.");
        }
        if (stackType.equalsIgnoreCase("ARRAYLIST")) {
            return new Stack_ArrayList<T>();
        } else if (stackType.equalsIgnoreCase("VECTOR")) {
            return new Stack_Vector<T>();
        }
        return null;
    }
}