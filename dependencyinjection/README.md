# Dependency Injection

## Introduction

The dependency injection is a concept that aims to decouple components of your
software and ease integration and testing.

It does so by giving the control of what is instantiated to the block of code
using your class instead of letting the class control what it want to use.

This concept is commonly used along with Inversion of Control to avoid asking for
_Implementations_ but rather _Interfaces_ while injecting dependencies.
This way, your code will rely on contract and you will have to extract all the
behavior to an abstract component.

# About the example

The example in this module presents a weather service that relies on a thermometer
to show its representation of the temperature.

Because you won't always have an actual temperature sensor on your computer, you
may want to allow your weather service to work with multiple data sources
(e.g. a weather API sending you the current temperature in your area).

With those requirements, dependency injection is a good way to choose which
kind of thermometer you want in your program.
