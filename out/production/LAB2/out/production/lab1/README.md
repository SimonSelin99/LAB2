# oopd-gu-chalmers Lab 1
Lab assignment 1 in the course Object-oriented Programming and Design, GU/Chalmers

See Canvas for instructions.

#Bör ni använda implementationsarv (subclassing) eller specifikationsarv (interfaces)? Varför? Kan båda användas? Vilka för- och nackdelar ser ni?
Vi använder oss av implementationsarv för att bilarna har gemensamma variabler och metoder
som kan läggas i den abstrakta superklassen istället. Detta eftersom ett interface bara implementerar metoder 
och inga variabler/fält, ett interface hade inneburit mer kodduplicering.

#Vilken synlighet bör ni använda för de olika metoder och variabler som klasserna innehåller? Vilket gränssnitt bör ni exponera?
Vi tycker att det är bäst att ha private på alla variabler och använder oss av getter och setters 
för att ändra och använda oss av dem värderna. Sen har vi gjort alla metoder
till protected så att endast subclasser till Car kan använda metoderna.
Men på grund av testclasserna gjorde vi om dem till public istället.
Vi vill exponera bilarnas värden utan att Car ändras.