import java.awt.*;
import java.util.Random;

public class SpriteBoi {
    //OBJECTS
    Random random = new Random();

    //VARIABLES
    int elementType;
    String color, element;

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
            this.element = "speed";
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

    public int getElementType() {
        return this.elementType;
    }

    public String getColor() {
        return this.color;
    }

    public String getElement() {
        return this.element;
    }
}
