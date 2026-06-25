Feature: Data tables

  Scenario: Single steps
    Given a User "Michael Jackson" born on August 29, 1958
    And a User "Elvis" born on January 8, 1935
    And a User "Jonh Lennon" born on October 9, 1940

    # We can collect those steps together into a single step that uses a table to express the data
  Given these Users:
    | name            | date of birth   |
    | Michael Jackson | August 29, 1958 |
    | Elvis           | January 8, 1935 |
    | John Lennon     | October 9, 1940 |
 # You have the freedom to specify data in different ways, such as putting the headings down the side:
  Then I should see a vehicle that mathces the following description:
    | Wheels      | 2                       |
    | Max Speed   | 60 mph                  |
    | Accessories | lights, shopping basket |
    # Or just ti specify a list:
  Then my shopping list should contain:
    | Onions   |
    | Potatoes |
    | Sausages |
    | Apples   |
    | Relish   |

