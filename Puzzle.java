
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
    private boolean[][] glueMap;
    private Canvas canvas;
    private boolean[][] holeMap;

    /**
     * Constructor 1. Create a puzzle of size h x w
     */
    public Puzzle(int h, int w){
        this.canvas = Canvas.getCanvas(); // Obtener la instancia de Canvas
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
                this.startingConfig[i][j] = new Tile("black", j*25, i*25);
            }
        }
        // Mapa de pegamento
        this.glueMap = new boolean[h][w];
    }

    /**
     * Constructor 2. Create a puzzle with the given final configuration
     */
    public Puzzle(char[][] ending){
        // Creacion del tablero
        this.boardB = new Rectangle();
        this.boardB.changeSize(5 +(25 * ending.length), 5 + (25 * ending[0].length));
        this.boardB.moveVertical(-5);
        this.boardB.moveHorizontal(-5);
        this.boardB.makeVisible();
        // Matriz de Tiles
        this.endingConfig = new Tile[ending.length][ending[0].length];
        for (int i = 0; i < ending.length; i++) {
            for (int j = 0; j < ending[0].length; j++) {
                String color;
                switch (ending[i][j]) {
                    case 'r': color = "red"; break;
                    case 'g': color = "green"; break;
                    case 'b': color = "blue"; break;
                    case 'y': color = "yellow"; break;
                    case '.': color = "black"; break;
                    default: color = "black";
                }
                this.endingConfig[i][j] = new Tile(color, j*25, i*25);
            }
        }
    }

    /**
     * Constructor 3. Create a puzzle with the initial and final configuration
     */
    public Puzzle(char[][] starting, char[][] ending) {
        // Verificar que ambas matrices tienen el mismo tamaño
        if (starting.length != ending.length || starting[0].length != ending[0].length) {
            throw new IllegalArgumentException("Las matrices de inicio y final deben tener el mismo tamaño.");
        }
        else{
            this.startingConfig = new Tile[starting.length][starting[0].length];
            this.endingConfig = new Tile[ending.length][ending[0].length];
            // Tablero Inicial
            for (int i = 0; i < starting.length; i++) {
                for (int j = 0; j < starting[0].length; j++) {
                    String color;
                    switch (starting[i][j]) {
                        case 'r': color = "red";
                        case 'g': color = "green";
                        case 'b': color = "blue";
                        case 'y': color = "yellow";
                        case '.': color = "black";
                        default: color = "black"; break;
                    }
                    this.startingConfig[i][j] = new Tile(color, j * 25, i * 25);
                }
            }
            // Tablero Final
            for (int i = 0; i < ending.length; i++) {
                for (int j = 0; j < ending[0].length; j++) {
                    String color;
                    switch (ending[i][j]) {
                        case 'r': color = "red";
                        case 'g': color = "green";
                        case 'b': color = "blue";
                        case 'y': color = "yellow";
                        case '.': color = "black";
                        default: color = "black"; break;
                    }
                    this.endingConfig[i][j] = new Tile(color, (starting[0].length * 25 + 50) + j * 25, i * 25);
                }
            }
        }
    }

    /**
     * Add a tile at a specific position
     * 
     * @param row
     * @param column
     * @param color
     */
    public void addTile(int row, int column, String color) {
        // Validar que row y column están dentro de los límites de la matriz
        if (row < 0 || row >= startingConfig.length || column < 0 || column >= startingConfig[0].length) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites de la matriz.");
        }
        // Comprobar el color de la ficha en la posición dada
        if (startingConfig[row][column].getColor().equals("black")) {
            startingConfig[row][column].setColor(color);
            ok();
        } else {
            throw new IllegalArgumentException("Ya existe una ficha en el lugar");
        }
    }

    /**
     * Remove a tile from a specific position
     *
     * @param   row 
     * @param   column
     */
    public void deleteTile(int row, int column) {
        // Validar que row y column están dentro de los límites de la matriz
        if (row < 0 || row >= startingConfig.length || column < 0 || column >= startingConfig[0].length) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites de la matriz.");
        }
        // Comprobar el color de la ficha en la posición dada
        if (!startingConfig[row][column].getColor().equals("black")) {
            startingConfig[row][column].setColor("black");
            ok();
        } else {
            throw new IllegalArgumentException("No existe una ficha en el lugar");
        }
    }

    /**
     * Change the position of a tile
     *
     * @param   row 
     * @param   column
     */
    public void relocateTile(int[] from, int[] to) {
        int fromRow = from[0], fromCol = from[1];
        int toRow = to[0], toCol = to[1];
        // Verificar que los índices estén dentro de los límites de la matriz
        if (fromRow >= 0 && fromRow < height && fromCol >= 0 && fromCol < width && toRow >= 0 && toRow < height && toCol >= 0 && toCol < width) {
            if (startingConfig[fromRow][fromCol].getColor().equals("black")) {
                throw new IllegalArgumentException("No existe una ficha en el lugar");
            }
            else if (!startingConfig[toRow][toCol].getColor().equals("black")) {
                throw new IllegalArgumentException("Ya existe una ficha en el espacio a cambiar");
            }
            else{
                // Realizar el movimiento de la ficha
                addTile(toRow, toCol, startingConfig[fromRow][fromCol].getColor());
                deleteTile(from[0], from[1]);
                // Cambios en el mapa de pegamento
                glueMap[fromRow][fromCol] = false;
                glueMap[toRow][toCol] = true;    
            }
        }
        else {
            throw new IllegalArgumentException("Índices fuera de los límites de la matriz");
        }
    }


    /**
     * Add the glue from the specific tile
     *
     * @param    row
     * @param    column
     */
    public void addGlue(int row, int column)
    {
        if (glueMap[row][column]) {
            throw new IllegalArgumentException("El tile ya tiene pegamento");
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
            throw new IllegalArgumentException("El tile no tiene pegamento");
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void makeHole(int row, int column)
    {
        // put your code here

    }

    /**
     * Calculates the number of consecutive tiles to the right of a specified position in the puzzle that are glued together.
     *
     * @param row    The row index of the starting tile.
     * @param column The column index of the starting tile.
     * @return     The number of consecutive glued tiles to the right of the specified tile.
     */
    public int gluedGroupRight(int row, int column)
    {
        int tiles = column;
        int gluedTiles = 0;
        while (tiles < this.width){
            if (glueMap[row][tiles] || (tiles + 1 < this.width && glueMap[row][tiles + 1])){// Verifica si la ficha actual tiene pegamento o si la siguiente también tiene pegamento
                gluedTiles ++;
                tiles++;
            }
            else{ //No hay ficha siguiente o ninguna de las dos tiene pegamento (no estan pegada)
                break;
            }
        }
        System.out.print((gluedTiles));
        return gluedTiles;
    }

    /**
     * Checks if a group of glued tiles at the given position can move upwards
     *
     * @param row    The row index of the starting tile.
     * @param column The column index of the starting tile
     * @return     true if the group of glued tiles can move upwards, false otherwise
     */
    public boolean groupCanMoveUp(int row, int column)
    {
        int gluedCount = gluedGroupRight(row, column);
        // Verificar que el grupo de fichas pegadas no se salga de los límites
        for (int i = 0; i < gluedCount; i++) {
            // Comprobar si hay espacio arriba de cada ficha pegada
            if (row - 1 < 0 || !startingConfig[row - 1][column + i].getColor().equals("black")) {
                return false; // Hay una ficha arriba o está fuera de límites
            }
        }
        return true; // Puede mover hacia arriba
    }
    
    /**
     * Calculates the number of consecutive tiles to the down of a specified position in the puzzle that are glued together.
     *
     * @param row    The row index of the starting tile.
     * @param column The column index of the starting tile.
     * @return     The number of consecutive glued tiles to the down of the specified tile.
     */
    public int gluedGroupDown(int row, int column)
    {
        int tiles = row;
        int gluedTiles = 0;
        while (tiles < this.height) {
            // Verifica si la ficha actual tiene pegamento o si la siguiente también tiene pegamento
            if (glueMap[tiles][column]) { // La ficha actual tiene pegamento
                gluedTiles++; 
                tiles++;
            } else if (tiles + 1 < this.height && glueMap[tiles + 1][column]) { // Verifica si la siguiente tiene pegamento
                gluedTiles++;
                tiles++;
            } else { // Si ninguna tiene pegamento
                break;
            }
        }
        return gluedTiles;
    }

    /**
     * Checks if a group of glued tiles at the given position can move upwards
     *
     * @param row    The row index of the starting tile.
     * @param column The column index of the starting tile
     * @return     true if the group of glued tiles can move upwards, false otherwise
     */
    /*public boolean groupCanMoveUp(int row, int column)
    {
        int gluedCount = gluedGroupRight(row, column);
        // Verificar que el grupo de fichas pegadas no se salga de los límites
        for (int i = 0; i < gluedCount; i++) {
            // Comprobar si hay espacio arriba de cada ficha pegada
            if (!startingConfig[row - 1][column + i].getColor().equals("black")) {
                return false; // Hay una ficha arriba o está fuera de límites
            }
        }
        return true; // Puede mover hacia arriba
    }*/
    
    /**
     * Calculates the number of consecutive tiles to the up of a specified position in the puzzle that are glued together.
     *
     * @param row    The row index of the starting tile.
     * @param column The column index of the starting tile.
     * @return     The number of consecutive glued tiles to the up of the specified tile.
     */
    public int gluedGroupUp(int row, int column)
    {
        int tiles = row;
        int gluedTiles = 0;
        while (tiles >= 0) {
            // Verifica si la ficha actual tiene pegamento o si la siguiente también tiene pegamento
            if (glueMap[tiles][column]) { // La ficha actual tiene pegamento
                gluedTiles++; 
                tiles--;
            } else if (tiles - 1 > 0 && glueMap[tiles - 1][column]) { // Verifica si la siguiente tiene pegamento
                gluedTiles++;
                tiles--;
            } else { // Si ninguna tiene pegamento
                break;
            }
        }
        return gluedTiles;
    }

    /**
     * Checks if a group of glued tiles at the given position can move upwards
     *
     * @param row    The row index of the starting tile.
     * @param column The column index of the starting tile
     * @return     true if the group of glued tiles can move upwards, false otherwise
     */
    /*public boolean groupCanMoveLeft(int row, int column)
    {
        int gluedCount = gluedGroupRight(row, column);
        // Verificar que el grupo de fichas pegadas no se salga de los límites
        for (int i = 0; i < gluedCount; i++) {
            // Comprobar si hay espacio arriba de cada ficha pegada
            if (!startingConfig[row - 1][column + i].getColor().equals("black")) {
                return false; // Hay una ficha arriba o está fuera de límites
            }
        }
        return true; // Puede mover hacia arriba
    }*/
    
    /**
     * Calculates the number of consecutive tiles to the left of a specified position in the puzzle that are glued together.
     *
     * @param row    The row index of the starting tile.
     * @param column The column index of the starting tile.
     * @return     The number of consecutive glued tiles to the left of the specified tile.
     */
    public int gluedGroupLeft(int row, int column)
    {
        int tiles = column;
        int gluedTiles = 0;
        while (tiles > 0){
            if (glueMap[row][tiles] || (tiles - 1 >= 0 && glueMap[row][tiles - 1])){// Verifica si la ficha actual tiene pegamento o si la siguiente también tiene pegamento
                gluedTiles ++;
                tiles--;
            }
            else{ //No hay ficha siguiente o ninguna de las dos tiene pegamento (no estan pegada)
                break;
            }
        }
        return gluedTiles;
    }

    /**
     * Checks if a group of glued tiles at the given position can move upwards
     *
     * @param row    The row index of the starting tile.
     * @param column The column index of the starting tile
     * @return     true if the group of glued tiles can move upwards, false otherwise
     */
    /*public boolean groupCanMoveUp(int row, int column)
    {
        int gluedCount = gluedGroupRight(row, column);
        // Verificar que el grupo de fichas pegadas no se salga de los límites
        for (int i = 0; i < gluedCount; i++) {
            // Comprobar si hay espacio arriba de cada ficha pegada
            if (!startingConfig[row - 1][column + i].getColor().equals("black")) {
                return false; // Hay una ficha arriba o está fuera de límites
            }
        }
        return true; // Puede mover hacia arriba
    }*/
    
    /**
     * Tilt of the board
     *
     * @param  direction
     */
    public void tilt(char direction)
    {
        //Up
        if (direction == 'u'){
            for (int row = 1; row < height; row++) {
                for (int column = 0; column < width; column++) { 
                    if(!startingConfig[row][column].getColor().equals("black")){ // Existe ficha
                        int group = gluedGroupRight(row, column);
                        int rowMove = row;
                        if (group > 0){ //Evalua si hay Tiles pegados
                            while (groupCanMoveUp(rowMove, column)){
                                for(int i = 0; i <= group; i++){
                                    int[] from = {rowMove , column + i};
                                    int[] to = {rowMove - 1, column + i};
                                    relocateTile(from, to);
                                }
                                rowMove--;
                            }
                            column = column + (group - 1);
                        }
                        else{
                            while(rowMove > 0 && startingConfig[rowMove - 1][column].getColor().equals("black")){
                                int[] from = {rowMove, column};
                                int[] to = {rowMove - 1, column};
                                relocateTile(from, to);
                                rowMove--;
                            }
                        }
                    } 
                }
            }
            ok();
        }
        // Down
        else if (direction == 'd') {
            for (int row = height - 2; row >= 0; row--) {  // Empezar desde la penúltima fila
                for (int column = 0; column < width; column++) {
                    
                }
            }  
            ok();
        }
        // Right (hacia la derecha)
        else if (direction == 'r') {
            for (int row = 0; row < height; row++) {
                for (int column = width - 2; column >= 0; column--) {  // Empezar desde la penúltima columna
                    
                }
            }
            ok();
        }
        // Left
        else if(direction == 'l'){
            for(int row = 0; row < height; row++){
                for (int column = 0; column < width; column++){
                    
                }
            }
            ok();
        }
        else{
            throw new IllegalArgumentException("Marcacion errada");
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void tild()
    {
        // put your code here

    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void exchange()
    {
        // put your code here

    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @return   
     */
    public boolean isGoald()
    {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (startingConfig[i][j] != endingConfig[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Displays the current state of the game in matrix form
     *
     * @return
     */
    public char[][] actualArrangement()
    {
        char[][] configurationChar = new char[startingConfig.length][startingConfig[0].length];
        for (int row = 0; row < startingConfig.length; row++) {
            for (int column = 0; column < startingConfig[row].length; column++) {
                // Obtener el color en formato char y asignarlo a la nueva matriz
                configurationChar[row][column] = startingConfig[row][column].getColorChar();
            }
        }
        for (int row = 0; row < configurationChar.length; row++) {
            for (int column = 0; column < configurationChar[row].length; column++) {
                System.out.print(configurationChar[row][column] + " ");
            }
            System.out.println();
        }
        return configurationChar;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    /*public int[][] fixedTiles()
    {
    // put your code here
    return y;
    }*/

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    /*public int missPlacedTiles()
    {
    // put your code here
    return y;
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
        canvas.setVisible(false);
    }

    /**
     * The last action could be performed
     *
     */
    public boolean ok()
    {
        return true; 
    }

}
