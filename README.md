
# Harvard-computer-architecture-simulator

a Java-based simulation of the Harvard computer architecture to execute assembly code


## Acknowledgements

 - [Read about harvard architecture](https://www.geeksforgeeks.org/harvard-architecture/)


## Assembly Reference

| Name             | format                                                                |
| ----------------- | ------------------------------------------------------------------ |
| ADD | ADD R1 R2 |
| Subtract | SUB R1 R2 |
| Multiply | MUL R1 R2 |
| Immediate | LDI R1 IMM |
| Branch if Equal Zero | BEQZ R1 IMM |
|And| AND R1 R2|
|OR| OR R1 R2|
|Jump Register| JR R1 R2|
|Shift Left Circular| SLC R1 IMM|
|Shift Right Circular| SRC R1 IMM |
|Load Byte |LB R1 ADDRESS|
|Store Byte |SB R1 ADDRESS|


## Run Locally

1-Clone the project

```bash
  git clone https://github.com/abdulrhman500/Harvard-computer-architecture-simulator.git
```

2-Go to the project directory


3- Build the project using Maven

```bash
  mvn clear
```

4- Run Javafx project using Maven

```bash
  mvn javafx:run
```


## Screenshots

![App Screenshot](https://github.com/abdulrhman500/Harvard-computer-architecture-simulator/blob/main/images/Screenshot%20(118).png)


## Notes

#### Note 1

You should enter the assembly code line by line in the GUI

#### Note 2

To execute the code enter (run) and to clear the terminal enter (clear)

#### Note 3
Our terminal is space sensitive, so be careful not to add extra spaces

## Related

Here are some related project

[OS simulator](https://github.com/malekelkssas/OS_simulator)      


## Authors

- [Malek Elkssas](https://github.com/malekelkssas)
- [Abdulrahman Fahmy](https://github.com/abdulrhman500)
- [Mohamed Khaled](https://github.com/Mohamed-Khaled308)
- [Ibrahim-Soltan](https://github.com/Ibrahim-Soltan)
- [Omar Mohammad](https://github.com/OmarMUhammed03)

