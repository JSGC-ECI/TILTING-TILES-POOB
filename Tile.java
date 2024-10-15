
/**
 * This class will represent the individual tiles
 *
 * @author Lina y Sebastian
 * @version 1.0
 */

public class Tile {
    private String color; 
    private Rectangle rectangle;

    /**
     * Constructor to create a tile with a specific color
     */
    public Tile(String color, int xPosition, int yPosition){
        this.color = color; 
        rectangle = new Rectangle();
        rectangle.moveHorizontal(xPosition);
        rectangle.moveVertical(yPosition);
        setColor(color);
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
     * Asigna el color basado en el carácter y actualiza el color del rectángulo.
     */
    public void setColor(String c) {
        switch (c) {
            case "red":
                color = "red";
                rectangle.changeColor("red");
                break;
            case "green":
                color = "green";
                rectangle.changeColor("green");
                break;
            case "blue":
                color = "blue";
                rectangle.changeColor("blue");
                break;
            case "yellow":
                color = "yellow";
                rectangle.changeColor("yellow");
                break;
            case "black":
                color = "black";
                rectangle.changeColor("black");
                break;
            default:
                throw new IllegalArgumentException("Color no válido: " + c);
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
            case "black": return '.';
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

