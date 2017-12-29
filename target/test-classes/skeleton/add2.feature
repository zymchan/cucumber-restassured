Feature: add2

  Scenario Outline: test multy21
    Given Protocol is "<string1>" BaseUrl is "<string2>" and Port is "<string3>"
    When set  request "<requestType>" to the path "<path>"
    Then the out put should be "<result>"
    Examples:
      | string1  | string2 | string3 | requestType | path |
      | http    |www.baidu.com   |      |       get         |      |

