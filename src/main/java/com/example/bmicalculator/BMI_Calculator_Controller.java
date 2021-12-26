/*
Name Project: BMI Calculator
Author: Nunzio Emanuele Sgroi

Description
The Java code below runs a BMI Calculator application.
The application asks the user to enter Weight(kg) and Height(m) and use a mathematical formula to generate an output.
The output will be the actual BMI in numbers and the category (Healthy, Underweight, Overweight and Obese).
Another output could be an error if the user enter wrong values.
Interface graphic is built with Scene Builder witch uses xml as programming languages but allows to design the graphic without coding the xml field.
 */

package com.example.bmicalculator;

//importing libraries
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

//Main class
public class BMI_Calculator_Controller {

    //Importing Target methods from fxml/scene-builder
    @FXML
    private TextField Weight_txt;

    @FXML
    private TextField Height_txt;

    @FXML
    private Label labelResult;

    @FXML
    private Label labelCategory;

    @FXML
    private Label labelError;


    //class for Calculate Button, the program runs inside this class
    public void Calculate_Button() {

        //Wrapping all the program inside try/catch method as the user may enter wrong input and this will cause and exception
        try {

            //Creating descriptive variables calling the input methods from fxml, using parseDouble as the user input is recognized as a String
            double WEIGHT = Double.parseDouble(Weight_txt.getText().trim());
            double HEIGHT = Double.parseDouble(Height_txt.getText().trim());
            double BMI = WEIGHT / (HEIGHT * HEIGHT);

            //Convert BMI in a String because the "Label" recognize outputs as a String only
            String STRING_BMI = String.format("%.2f", BMI);
            labelResult.setText(STRING_BMI);

            //if statement that tells the programs what is the output based on user input
            if (BMI <= 18.5) {
                    labelCategory.setText("Underweight");
                    labelCategory.setTextFill(Color.rgb(66, 148, 255));
                    labelResult.setTextFill(Color.rgb(66, 148, 255));
                    labelError.setText(null);
            }
            else if (BMI <= 24.9) {
                    labelCategory.setText("Healthy");
                    labelCategory.setTextFill(Color.rgb(0, 255, 0));
                    labelResult.setTextFill(Color.rgb(0, 255, 0));
                    labelError.setText(null);
            }
            else if (BMI <= 29.9) {
                    labelCategory.setText("Overweight");
                    labelCategory.setTextFill(Color.rgb(249, 142, 1));
                    labelResult.setTextFill(Color.rgb(249, 142, 1));
                    labelError.setText(null);
            }
            else if (BMI > 29.9) {
                    labelCategory.setText("Obese");
                    labelCategory.setTextFill(Color.rgb(255, 0, 0));
                    labelResult.setTextFill(Color.rgb(255, 0, 0));
                    labelError.setText(null);
            }
        }
        catch (Exception e){
            labelError.setText("⚠ OOPS! Something went wrong. Please enter correct values!!! ⚠");
            labelError.setTextFill(Color.rgb(255, 0, 0));
            Weight_txt.setText(null);
            Height_txt.setText(null);
            labelResult.setText(null);
            labelCategory.setText(null);
        }
    }

    //Class for the Reset Button, set targets from fxml to null
    public void Reset_Button () {
        Weight_txt.setText(null);
        Height_txt.setText(null);
        labelResult.setText(null);
        labelCategory.setText(null);
        labelError.setText(null);
    }
}







