Feature: To validate user is able to add any item to card and checkout the item
  Scenario: user adds item to cart and checkout the item from cart
    Given user is navigated to the website
    And user navigates to the computer section
    And user clicks on the notebooks
    And user sort the items by price (low to high) and display filter to maximum 9
    And  results listed with name and price
    And user adds a product to cart
    Then the confirmation for the product added is displayed
    And user navigates to the shopping cart page
    Then the product added is verified
    And user clicks on the checkout button
    And user clicks on the register button
    And user registers himself
