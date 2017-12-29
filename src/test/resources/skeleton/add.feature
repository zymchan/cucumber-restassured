Feature: add

  Scenario Outline: test multy11
    Given i input "<input1>" and "<input2>"
    When the calculator is run
    Then the out put should be "<result>"
    Examples:
      | input1 | input2 | result |
      | 2      | 3      | 5      |
      | 2      | 4      | 6      |
      | 3      | 3      | 6      |

