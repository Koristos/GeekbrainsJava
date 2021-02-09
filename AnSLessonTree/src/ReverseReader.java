public class ReverseReader {
    private MyStack<Character> stringToReverse;

    public void loadString (String toLoad){
        this.stringToReverse = new MyStack<>(toLoad.length());
        for (int i = 0; i < toLoad.length(); i++) {
            this.stringToReverse.push(toLoad.charAt(i));
        }
    }

    public String getReversedString (){
        if(this.stringToReverse==null) return null;
        StringBuilder sb = new StringBuilder("");
        int size=this.stringToReverse.getSize();
        for (int i = 0; i <size; i++) {
            sb.append(stringToReverse.pop());
        }
        return sb.toString();
    }
}
