# Exercise 1

The aim of this exercise is to create a temperature converter containing:

  - **Two labels** "Celsius" and "Fahrenheit"
  - **Two text boxes** to enter and display the temperature values
  - **Two buttons** to reset the text boxes and close the window


<p align="center"><img src="/img/tempconvH.jpg" width="300"></p>

1) Download the **TemperatureConverter.java** file.
2) Complete the function `initGUI()` in the file **TemperatureConverter.java** by using the class `FlowPane` and layout panes of your choice to make the resulting window look like the pictured above.
3) Make sure the widgets are aligned and that their location remains consistent while resizing the window as in the following picture:


<p align="center"><img src="/img/tempconvV.jpg" width="150" align="middle"></p>

4) The `textFieldCListener` reads a floating value in the Celsius text box when the user press "enter", converts it from Celsius to Fahrenheit, and writes the result in the Fahrenheit text box. Associate this event handler to the text box of the Celsius value.
5) Fill in the `textFieldFListener` in order to do the conversion from Fahrenheit to Celsius. Associate it with the text box of the Fahrenheit value.
6) The `buttonCloseListener` closes the window. Associate it to the close button.
7) The `buttonResetListener` empties both text boxes. Associate it to the reset button.
8) The temperature conversion occurs when the user presses enter. Use a `EventHandler<KeyEvent>()` (that you attach with `TextField.setOnKeyPressed`). The `EventHandler<KeyEvent>()` will be notified at each key press.
