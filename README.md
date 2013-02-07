JExpCalculator
==============

EBNF Arithmetic Expression Interpreter

Simple Java implementation of an EBNF Arithmetic Expression calculator. 
The following Software Design Patterns were used:
  - Interpreter Pattern: in order to build the Syntax Tree as a Composite Structure and evaluate recursively the Expression value
  - Visitor Pattern: in order to allow different Tree Traversals over the Syntax Tree: Postfix, Infix, etc.

A Parser, able to build the Syntax Tree from a plain input String, is still missing and it will be added later.
