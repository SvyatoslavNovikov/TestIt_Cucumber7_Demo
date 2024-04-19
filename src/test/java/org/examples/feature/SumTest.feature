Feature: сколько будет 2+2

  @Title="Сколько_будет_2+2"
  @WorkItemIds=9462
  @ExternalId=sumTest
  Scenario Outline: Тест на сложение
    When сложение <left> + <right>
    Then сумма = <result>

    Examples:
      | left | right | result |
      | 1    | 1     | 2      |
      | 9    | 9     | 18     |