JExpCalculator
==============

EBNF Arithmetic Expression Interpreter

Simple Java implementation of an EBNF Arithmetic Expression calculator. 
Using the following Software Design Patterns:
  - Interpreter Pattern: in order to build the Syntax Tree as a Composite Structure and evaluate recursively the Expression value
  - Visito Pattern: in order to allow different Tree Traversal on the Syntax Tree: Postfix, Infix, etc.

A Parser, able to build the Syntax Tree from a plain input String, is still missing and it will be added later.
