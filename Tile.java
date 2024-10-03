
/**
 * This class will represent the individual tiles
 *
 * @author Lina y Sebastian
 * @version 1.0
 */

public class Tile {
    private String color; 
    private boolean glued;  
    private Rectangle rectangle;

    /**
     * Constructor to create a tile with a specific color
     */
    public Tile(String color, int xPosition, int yPosition){
        this.color = color;
        this.glued = false;  
        rectangle = new Rectangle();
        rectangle.moveHorizontal(xPosition);
        rectangle.moveVertical(yPosition);
        rectangle.makeVisible();
    }

    /**
     * Assigns color based on character
     */
    public void setColorBasedOnChar(char c){
        switch (c) {
            case 'r': rectangle.changeColor("red"); break;
            case 'g': rectangle.changeColor("green"); break;
            case 'b': rectangle.changeColor("blue"); break;
            case 'y': rectangle.changeColor("yellow"); break;
            case '.': rectangle.changeColor("black"); break;  
        }
        if (c != '.') {
            rectangle.makeVisible();
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     */
    public char getColorChar() {
        String currentColor = rectangle.getColor();
        switch (currentColor) {
            case "red": return 'r';
            case "green": return 'g';
            case "blue": return 'b';
            case "yellow": return 'y';
            default: return '.';
        }
    }

    /**
     * Gets the tile state
     */
    public String getColor(){
        return color;
    }

    /**
     * Apply glue
     */
    public void applyGlue(){
        if (this.glued == false){
            this.glued = true;
        }
        else{
            throw new IllegalArgumentException("La ficha ya tiene pegante");
        }

    }

    /**
     * Remove glue
     */
    public void removeGlue(){
        if (this.glued){
            this.glued = false;

        }
        else{
            throw new IllegalArgumentException("La ficha no tiene pegante");
        }

    }

    /**
     * Move the tile
     */
    public void move(String direction){
        switch (direction) {
            case "up": rectangle.moveUp(); break;
            case "down": rectangle.moveDown(); break;
            case "left": rectangle.moveLeft(); break;
            case "right": rectangle.moveRight(); break;
            default:
                System.out.println("Dirección no válida");
        }
    }

    /**
     * Determine if a tile is glued
     */
    public boolean isGlued(){
        return glued;
    }

    /**
     * Gets an object of type Rectangle
     */
    public Rectangle getRectangle(){
        return rectangle;
    }

    /**
     * Make this rectangle visible.
     *
     */
    public void makeTileVisible()
    {
        this.rectangle.makeVisible();
    }

    /**
     * Make this rectangle invisible.
     *
     */
    public void makeTileInvisible()
    {
        this.rectangle.makeInvisible();
    }


}

