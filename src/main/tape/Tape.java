package main.tape;
public class Tape {

    public static void main(String[] args){
    }

    //  Points to current cell
    public Cell currentCell;

    //  Constructor for creating a blank tape with a single cell
    public Tape(){
        Cell newCell = new Cell();
        newCell.content = ' ';
        newCell.prev = null;
        newCell.next = null;
        currentCell = newCell;
    }

    //  Getter for content for current cell
    public char getContent() {
        return currentCell.content;
    }

    //  Setter for characters in current cell
    public void setContent(char character){
        currentCell.content = character;
    }

    //  Getter for current cell pointer
    public Cell getCurrentCell() {
        return currentCell;
    }

    // Moving current cell to one position left
    public void moveLeft() {
        if(currentCell.prev == null) {
            Cell newCell = new Cell();
            newCell.content = ' ';
            newCell.prev = null;
            newCell.next = currentCell;
            currentCell.prev = newCell;
        }
        currentCell = currentCell.prev;
    }

    // Moving current cell to one position right
    public void moveRight() {
        if (currentCell.next == null) {
            Cell newCell = new Cell();
            newCell.content = ' ';
            newCell.next = null;
            newCell.prev = currentCell;
            currentCell.next = newCell;
        }
        currentCell = currentCell.next;
    }

    // Returning characters from all cells
    public String getTapeContents() {
        Cell pointer = currentCell;
        while(pointer.prev != null)
            pointer = pointer.prev;
        String strContent = " ";
        while (pointer != null) {
            strContent += pointer.next;
        }
        strContent = strContent.trim();
        return strContent;
    }
}
