# SPLIT-WISE 
### Low-level design.
Design pattern used-
- factory pattern
- strategy pattern
<br/>

Design principle used-
- SRP (note: we can create a separate user service to separate logic which operates on user model)
- OCP (If in future we like to add another split type we can do by just adding a new enum type under `SplitType`.
  - Create a Validator class for the respective splitType.
  - Update `ExpenseValidatorFactory` 
- Liskov's substitution principle
  - If in future we want to print the balance sheet in some other format we can easily do by just substituting with another variant of `BalancePrinter` interface
- Interface Segregation principle
  - Classes are not forced to implement methods which they dont need
- Dependency Inversion principle
  - Classes are dependent upon interfaces instead of concrete class
  - Expense service depends on `ExpenseValidator` which is an interface.
  - Our orchestrator `ExpenseManager` (high-level module) depends on `BalancePrinter` abstraction rather than on its concrete implementation. And low-level modules (`ConsolePrinter`) depends on abstract `BalancePrinter`

NOTE: Obviously there's a room for improvement. But given 1-2hrs for a typical design/machine round.
I think this implementation is enough to pass the interview.

Rough diagram- https://1drv.ms/u/s!Aib6QqfAcsr5xX1xCgQy14zWjxaM