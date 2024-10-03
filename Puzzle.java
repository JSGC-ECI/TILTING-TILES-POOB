
/**
 * This class will represent the puzzle that contains the tiles
 *
 * @author Lina y Sebbastian
 * @version 1.0
 */

public class Puzzle {
    private int height;  
    private int width;   
    private Tile[][] startingConfig;  
    private Tile[][] endingConfig;
    private Rectangle boardA;
    private Rectangle boardB;
    private char[][] configurationChar;
    private boolean[][] glueMap;

    /**
     * Constructor 1. Create a puzzle of size h x w
     */
    public Puzzle(int h, int w){
        this.height = h;
        this.width = w;
        // Creacion de tablero
        this.boardA = new Rectangle();
        this.boardA.changeSize(5+(25*h), 5+(25*w));
        this.boardA.moveVertical(-5);
        this.boardA.moveHorizontal(-5);
        this.boardA.makeVisible();
        // Matriz de Tiles
        this.startingConfig = new Tile[height][width];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                this.startingConfig[i][j] = new Tile('.', j*25, i*25);
            }
        }
        // Mapa de pegamento
        this.glueMap = new boolean[h][w];
        // Mapa char color
        this.configurationChar = new char[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                this.configurationChar[i][j] = '.'; 
            }
        }
    }

    /**
     * Constructor 2. Create a puzzle with the given final configuration
     */
    public Puzzle(char[][] ending){
        // Creacion del tablero
        this.endingConfig = new Tile[height][width];
        this.boardB = new Rectangle();
        this.boardB.changeSize(5 +(25 * this.height), +(5 * this.width));
        this.boardB.moveVertical(5 + this.boardA.getWidth());
        this.boardB.moveHorizontal(-5);
        this.boardB.makeVisible();
        // Matriz de Tiles
        this.endingConfig = new Tile[height][width];
    }

    /**
     * Constructor 3. Create a puzzle with the initial and final configuration
     */
    public Puzzle(char[][] starting, char[][] ending){
        if (starting.length != ending.length || starting[0].length != ending[0].length){
            throw new IllegalArgumentException("Las matrices de inicio y final deben tener el mismo tamaño.");
        }
        else{
            this.height = starting.length;
            this.width = starting[0].length;
            Puzzle(this.height, this.height);
            Puzzle(ending);
        }
    }

    /**
     * Add specific tile
     *
     * @param  row and column
     */
    public  void addTile (int row, int column, String color)
    {
        if (startingConfig[row][column].getColor().equals("black")){
            startingConfig[row][column].setColor(color);
            ok();
        }
        else{
            throw new IllegalArgumentException("Ya existe una ficha en el lugar");
        }
    }

    /**
     * Delete specific tile
     *
     * @param  row and column    
     */
    public void deleteTile(int row, int column)
    {
        if (!startingConfig[row][column].getColor().equals("black")){
            startingConfig[row][column].setColor("black");
            ok();
        }
        else{
            throw new IllegalArgumentException("No existe una ficha en el lugar");
        }
    }

    /**
     * Change the position of a tile
     *
     * @param  from and to
     */
    public void relocateTile(int[] from,int[] to)
    {
        if(from.length == 2 && to.length == 2){
            if(startingConfig[row][column].getColor().equals("black")){
                throw new IllegalArgumentException("No existe una ficha en el lugar");
            }
            else if(!startingConfig[row][column].getColor().equals("black")){
                throw new IllegalArgumentException("Ya existe una ficha en el espacio a cambiar");
            }
            else{
                addTile(to[0], to[1], startingConfig[from[0]][from[1]].getColor());
                deleteTile(from[0], from[1]);
            }
        }
    }
    
    /**
    * Add the glue from the specific tile
    *
    * @param    row     the row of the tile
    * @param    column  the column of the tile
    */
    public void addGlue(int row, int column)
    {
        if (glueMap[row][column]) {
            
        }
        else{
            glueMap[row][column] = true; 
            System.out.println("Pegamento aplicado en la posición [" + row + ", " + column + "]");
            ok();
        }
    }

    /**
     * Delete the glue from the specific tile
     *
     * @param   row
     * @param   column
     */
    public void deleteGlue(int row, int column)
    {
        if (glueMap[row][column]) {
            glueMap[row][column] = true; 
            System.out.println("Pegamento removido en la posición [" + row + ", " + column + "]");
            ok();
        }
        else{
            
        }
    }

    /**
     * Tilt of the board
     *
     * @param  direction
     */
     public void tilt(char direction)
    {
        //Up
        if (direction == 'u'){
            for (int row = 0; row < height; row++) {
                for (int column = 1; column < width; column++) {
                    int[] from = {row, column};
                    int[] to = {row - 1, column};
                    relocateTile(from, to);
                }
            }
        ok();
        }
        // Down
        else if (direction == 'd') {
            for (int row = height - 2; row >= 0; row--) {  // Empezar desde la penúltima fila
                for (int column = 0; column < width; column++) {
                    int[] from = {row, column};
                    int[] to = {row + 1, column};
                    relocateTile(from, to);
                }
            }
        ok();
        }
        // Right (hacia la derecha)
        else if (direction == 'r') {
            for (int row = 0; row < height; row++) {
                for (int column = width - 2; column >= 0; column--) {  // Empezar desde la penúltima columna
                    int[] from = {row, column};
                    int[] to = {row, column + 1};
                    relocateTile(from, to);
                }
            }
        ok();
        }
        // Left
        else if(direction == 'l'){
            for(int row = 0; row < height; row++){
                for (int column = 0; column < width; column++){
                    int[] from = {row, column};
                    int[] to = {row, column + 1};
                    relocateTile(from, to);
                }
            }
        ok();
        }
        else{
            
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return   
     */
    public boolean isGoald()
    {
        if (startingConfig == endingConfig){
            return true;
        }
        return false;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @return 
     */
    /*public char[][] actualArrangement()
    {

    }*/

    /**
     * Makes the game visible
     *
     */
    public void makeVisible()
    {
        if (this.boardA.isVisible == false){
            this.boardA.makeVisible();
            for (int i = 0; i < startingConfig.length; i++) {
                for (int j = 0; j < startingConfig[0].length; j++) {
                    startingConfig[i][j].makeTileVisible(); 
                }
            }
        ok();
        }
        else{
            throw new IllegalArgumentException("El juego ya es visible");
        }

    }

    /**
     * Makes the game Invisible
     *
     */
    public void makeInvisible()
    {
        if (this.boardA.isVisible){
            this.boardA.makeInvisible();
            for (int i = 0; i < startingConfig.length; i++) {
                for (int j = 0; j < startingConfig[0].length; j++) {
                    startingConfig[i][j].makeTileInvisible(); 
                }
            }
        ok();
        }
        else{
            throw new IllegalArgumentException("El juego ya es invisible");
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     */
    public void finish()
    {
        System.out.println("Fin del simulador");
    }

    /**
     * The last action could be performed or not
     *
     */
    public boolean ok()
    {
        return true; 
    }
}
