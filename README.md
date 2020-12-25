# Base Converter:
## How it works:
The base for each converter is passed in as a 'lookup table' that contains each character in the number base. for example, base 2's lut would be: "01", and base 10's lut would be: "0123456789". Each converter has methods to convert two and from base ten, and two converters can be passed into the static 'convertBetween' method to convert a number (but in a string) from the first to the second.
## examples:
to convert from base 10 to binary:
```
Converter binary = new Converter("01");
System.out.println(binary.convert(10)); //output: "1010"
```
to convert from binary to hexadecimal:
```
Converter binary = new Converter("01");
Converter hex = new Converter("0123456789abcdef");
System.out.println(Converter.convertBetween("1010", binary, hex)); //output: "a"
```
## How to use:
after importing the library, create your Converters using the constructor: "new Converter(\<lookup table>);"
then, each converter has two methods:
convert: convert a base ten number to the converters base
deConvert: convert the converters base to base ten

Additionally, use the Converter.convertBetween method to change between who converters bases as
"Converter.convertBetween(\<input number>, \<input converter>, \<output converter>)"