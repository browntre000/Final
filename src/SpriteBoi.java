import java.awt.*;
import java.util.Random;

public class SpriteBoi {
    //OBJECTS
    private Random random = new Random();

    //VARIABLES
    private int elementType;
    private String color, element;

    //CONSTRUCTOR
    public SpriteBoi(){
        this.elementType = random.nextInt(8);
        if(elementType == 0){
            this.element = "spark";
            this.color = "green";
        }
        if(elementType == 1){
            this.element = "water";
            this.color = "blue";
        }
        if(elementType == 2){
            this.element = "fire";
            this.color = "red";
        }
        if(elementType == 3){
            this.element = "ice";
            this.color = "light blue";
        }
        if(elementType == 4){
            this.element = "speedy";
            this.color = "orange";
        }
        if(elementType == 5){
            this.element = "sturdy";
            this.color = "brown";
        }
        if(elementType == 6){
            this.element = "archer";
            this.color = "gray";
        }
        if(elementType == 7){
            this.element = "flier";
            this.color = "white";
        }
    }

    //METHODS... no?


    //GETTERS / SETTERS

    public void setElement(String element) {
        this.element = element;
        if(element.equals("spark")){
            this.color = "green";
            this.elementType = 0;
        }
        if(element.equals("water")){
            this.color = "blue";
            this.elementType = 1;
        }
        if(element.equals("fire")){
            this.color = "red";
            this.elementType = 2;
        }
        if(element.equals("ice")){
            this.color = "light blue";
            this.elementType = 3;
        }
        if(element.equals("speed")){
            this.color = "orange";
            this.elementType = 4;
        }
        if(element.equals("sturdy")){
            this.color = "brown";
            this.elementType = 5;
        }
        if(element.equals("archer")){
            this.color = "gray";
            this.elementType = 6;
        }
        if(element.equals("flier")){
            this.color = "white";
            this.elementType = 7;
        }
    }
    public Color returnColor(){
        if(color.equals("red")){
            return Color.red;
        }
        else if(color.equals("green")){
            return Color.green;
        }
        else if(color.equals("blue")){
            return Color.blue;
        }
        else if(color.equals("light blue")){
            return new Color(0,191,255);
        }
        else if(color.equals("orange")){
            return Color.ORANGE;
        }
        else if(color.equals("brown")){
            return new Color(139,69,19);
        }
        else if(color.equals("gray")){
            return new Color(105,105,105);
        }
        else if(color.equals("white")){
            return Color.WHITE;
        }
        else{
            return Color.magenta;
        }
    }

    public int getElementType() {
        return this.elementType;
    }

    public String getColor() {
        return this.color;
    }

    public String getElement() {
        return this.element;
    }
    public boolean isInBounds(int y1, int y2, int xSize) {
        if(y1 < y2+xSize/2 && y1 > y2-xSize/2){
            return true;
        }
        else{
            return false;
        }
    }
}
