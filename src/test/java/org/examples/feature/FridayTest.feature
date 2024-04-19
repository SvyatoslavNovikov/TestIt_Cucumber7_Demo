Feature: сегодня пятница?

  @Title="Сегодня_пятница?"
  @WorkItemIds=9460
  @ExternalId=fridayTest
  Scenario: воскресение не пятница
    Given сегодня воскресенье
    When я спрашиваю, "сегодня пятница?"
    Then мне следует сказать "нет"